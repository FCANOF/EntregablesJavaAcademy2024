package com.autonomouscar.battery_management.config;

import com.autonomouscar.battery_management.entity.BatteryChargeHistory;
import com.autonomouscar.battery_management.repository.BatteryRepository;

import lombok.AllArgsConstructor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
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
    private BatteryRepository batteryRepository;
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
                .<BatteryChargeHistory, BatteryChargeHistory>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }

    // ---------------------------------- ItemReader ----------------------------------
    @Bean
    public FlatFileItemReader<BatteryChargeHistory> reader() {
        FlatFileItemReader<BatteryChargeHistory> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/battery_charge_data.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<BatteryChargeHistory> lineMapper() {
        DefaultLineMapper<BatteryChargeHistory> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id","battery_id", "charge_start_time", "charge_end_time", "charging_area", "charger_id","charge_status", "issue_detected","issue_description" );

        BeanWrapperFieldSetMapper<BatteryChargeHistory> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(BatteryChargeHistory.class);

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
    public RepositoryItemWriter<BatteryChargeHistory> writer() {
        RepositoryItemWriter<BatteryChargeHistory> writer = new RepositoryItemWriter<>();
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
