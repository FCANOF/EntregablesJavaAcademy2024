package com.autonomous.vehicle_management.battery;

import com.autonomous.vehicle_management.controller.BatteryChargeController;
import com.autonomous.vehicle_management.entity.BatteryCharge;
import com.autonomous.vehicle_management.service.BatteryChargeService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BatteryCharge_MockitoTest {

    @Mock
    private JobLauncher jobLauncher;

    @Mock
    private Job job;

    @Mock
    private BatteryChargeService batteryChargeService;

    @InjectMocks
    private BatteryChargeController batteryChargeController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    // Test for index
    @Test
    public void testIndex(){
        String response = batteryChargeController.index();
        assertEquals("Welcome to the Battery Charge Management System!", response);
    }

    // Test for getAllBatteryCharges
    @Test
    public void testGetAllBatteryCharges(){
        // Create a list of battery charges
        BatteryCharge batteryCharge1 = new BatteryCharge();
        batteryCharge1.setBatteryId("3");
        batteryCharge1.setChargeStatus("Charging");
        batteryCharge1.setChargeStartTime("2021-10-01 12:00:00");
        batteryCharge1.setChargeEndTime("2021-10-01 14:00:00");
        batteryCharge1.setChargingArea("Area 1");
        batteryCharge1.setChargerId("Charger 1");
        batteryCharge1.setIssueDetected(false);
        batteryCharge1.setIssueDescription("No issues");

        BatteryCharge batteryCharge2 = new BatteryCharge();
        batteryCharge2.setBatteryId("4");
        batteryCharge2.setChargeStatus("Charging");
        batteryCharge2.setChargeStartTime("2021-10-01 12:00:00");
        batteryCharge2.setChargeEndTime("2021-10-01 14:00:00");
        batteryCharge2.setChargingArea("Area 1");
        batteryCharge2.setChargerId("Charger 1");
        batteryCharge2.setIssueDetected(false);
        batteryCharge2.setIssueDescription("No issues");

        // Mock the getAllBatteryCharges method
        List<BatteryCharge> batteryCharges = Arrays.asList(batteryCharge1, batteryCharge2);

        when(batteryChargeService.getAllBatteryCharges()).thenReturn(batteryCharges);

        List<BatteryCharge> result = batteryChargeController.getAllBatteryCharges();

        // Check if the list of battery charges is returned
        assertEquals(2, result.size());
        verify(batteryChargeService, times(1)).getAllBatteryCharges();
    }

    // Test for getBatteryChargeById
    @Test
    public void testGetBatteryChargeById(){

        BatteryCharge batteryCharge = new BatteryCharge();
        batteryCharge.setId(5L);
        batteryCharge.setBatteryId("D");

        when(batteryChargeService.getBatteryChargeById(5L)).thenReturn(batteryCharge);

        ResponseEntity<BatteryCharge> response = batteryChargeController.getBatteryChargeById(5L);

        assertNotNull(response);
        assertEquals("D", response.getBody().getBatteryId());
        verify(batteryChargeService, times(1)).getBatteryChargeById(5L);
    }

    // Test for createBatteryCharge
    @Test
    public void testCreateBatteryCharge(){
        // Create a battery charge object
        BatteryCharge batteryCharge = new BatteryCharge();
        batteryCharge.setId(5L);
        batteryCharge.setBatteryId("D");

        // Mock the createBatteryCharge method
        when(batteryChargeService.createBatteryCharge(batteryCharge)).thenReturn(batteryCharge);

        // Call the createBatteryCharge method
        BatteryCharge  response = batteryChargeController.createBatteryCharge(batteryCharge);

        // Check if the battery charge object is created
        assertEquals("D", response.getBatteryId());
        // Verify if the createBatteryCharge method is called
        verify(batteryChargeService, times(1)).createBatteryCharge(any(BatteryCharge.class));
    }

    // Test for updateBatteryCharge
    @Test
    public void testUpdateBatteryCharge(){

        // Create a battery charge object
        BatteryCharge batteryCharge = new BatteryCharge();
        batteryCharge.setId(5L);
        batteryCharge.setBatteryId("D");

        // Update the battery charge object
        BatteryCharge updatedBatteryCharge = new BatteryCharge();
        updatedBatteryCharge.setId(5L);
        updatedBatteryCharge.setBatteryId("E");

        // Mock the updateBatteryCharge method
        when(batteryChargeService.updateBatteryCharge(anyLong(), any(BatteryCharge.class))).thenReturn(updatedBatteryCharge);

        // Call the updateBatteryCharge method
        BatteryCharge  response = batteryChargeController.updateBatteryCharge(5L, updatedBatteryCharge);

        // Check if the battery charge object is updated
        assertNotNull(response);
        // Check if the battery id is updated
        assertEquals("E", response.getBatteryId());
        // Verify if the updateBatteryCharge method is called
        verify(batteryChargeService, times(1)).updateBatteryCharge(eq(5L), any(BatteryCharge.class));
    }

    // Test for deleteBatteryCharge
    @Test
    public void testDeleteBatteryCharge(){

        doNothing().when(batteryChargeService).deleteBatteryCharge(5L);

        batteryChargeController.deleteBatteryCharge(5L);

        // Verify if the deleteBatteryCharge method is called
        verify(batteryChargeService, times(1)).deleteBatteryCharge(5L);
    }

    // Test for importCsvToDBJob
    @Test
    public void testImportCsvToDBJob() throws Exception {
        JobExecution jobExecution = mock(JobExecution.class);
        when(jobLauncher.run(any(Job.class), any(JobParameters.class))).thenReturn(jobExecution);

        batteryChargeController.importCsvToDBJob();

        verify(jobLauncher, times(1)).run(any(Job.class), any(JobParameters.class));
    }
}
