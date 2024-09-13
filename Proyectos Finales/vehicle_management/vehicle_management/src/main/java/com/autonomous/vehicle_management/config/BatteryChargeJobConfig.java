package com.autonomous.vehicle_management.config;

import com.autonomous.vehicle_management.entity.BatteryCharge;
import com.autonomous.vehicle_management.repository.BatteryChargeRepository;


import lombok.AllArgsConstructor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
// @EnableBatchProcessing
@AllArgsConstructor
public class BatteryChargeJobConfig {

    private JobRepository jobRepository;
    private BatteryChargeRepository batteryRepository;
    private PlatformTransactionManager transactionManager;

    // ---------------------------------- Job ----------------------------------
    @Bean
    public Job runJob(Step batteryChargeStep) {
        return new JobBuilder("importBatteriesChargeHistory", jobRepository)
                .start(batteryChargeStep)
                .build();
    }

    // ---------------------------------- Step ----------------------------------
    @Bean
    public Step runStep() {
        return new StepBuilder("csv-step", jobRepository)
                .<BatteryCharge, BatteryCharge>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }

    // ---------------------------------- ItemReader ----------------------------------
    @Bean
    public FlatFileItemReader<BatteryCharge> reader() {
        FlatFileItemReader<BatteryCharge> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/battery_charge_data.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<BatteryCharge> lineMapper() {
        DefaultLineMapper<BatteryCharge> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id","battery_id", "charge_start_time", "charge_end_time", "charging_area", "charger_id","charge_status", "issue_detected","issue_description" );

        BeanWrapperFieldSetMapper<BatteryCharge> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(BatteryCharge.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    // ---------------------------------- ItemProcessor ----------------------------------
    
    @Bean
    public BatteryChargeProcessor processor() {
        return new BatteryChargeProcessor();
    }

    // ---------------------------------- ItemWriter -------------------------------------

    @Bean
    public RepositoryItemWriter<BatteryCharge> writer() {
        RepositoryItemWriter<BatteryCharge> writer = new RepositoryItemWriter<>();
        writer.setRepository(batteryRepository);
        writer.setMethodName("save");
        return writer;
    }

    // ---------------------------------- TaskExecutor ----------------------------------
    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }
}
