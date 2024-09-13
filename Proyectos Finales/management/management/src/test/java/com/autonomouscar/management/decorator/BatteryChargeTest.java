package com.autonomouscar.management.decorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BatteryChargeTest {

    private BatteryCharge basicCharge;
    private BatteryCharge efficientCharge;
    private BatteryCharge efficientFaultyCharge;

    @BeforeEach
    void setUp() {
        // Basic battery charge
        basicCharge = new BasicBatteryCharge();

        // Efficient battery charge with a decorator
        efficientCharge = new EfficientBatteryChargeDecorator(new BasicBatteryCharge());

        // Efficient and Faulty battery charge with both decorators
        efficientFaultyCharge = new FaultyBatteryChargeDecorator(
                new EfficientBatteryChargeDecorator(new BasicBatteryCharge()));
    }

    // --- BasicBatteryCharge tests ---
    @Test
    void testBasicBatteryCharge() {
        // Act
        basicCharge.charge();

        // Assert
        assertEquals("Battery charging... Basic charge.", basicCharge.getDetails(), 
                "The details should indicate basic battery charge.");
    }

    // --- EfficientBatteryChargeDecorator tests ---
    @Test
    void testEfficientBatteryCharge() {
        // Act
        efficientCharge.charge();

        // Assert
        assertEquals("Battery charging... Basic charge. Adding efficiency improvements.", 
                efficientCharge.getDetails(), 
                "The details should indicate efficient battery charge.");
    }

    // --- FaultyBatteryChargeDecorator tests ---
    @Test
    void testEfficientAndFaultyBatteryCharge() {
        // Act
        efficientFaultyCharge.charge();

        // Assert
        assertEquals("Battery charging... Basic charge. Adding efficiency improvements. Warning: Charger malfunction detected.", 
                efficientFaultyCharge.getDetails(), 
                "The details should indicate efficient and faulty battery charge.");
    }
}
