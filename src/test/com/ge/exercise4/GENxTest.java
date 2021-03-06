package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GENxTest {

    GENx testEngine;

    @Before
    public void setUp() {
        testEngine = new GENx("0001", 10_000, 1);
    }

    @Test
    public void toStringTest() {
        assertEquals("GENx SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
    
    @Test
	public void timeToRebuildTest() {
		assertEquals(Double.toString(10_000.0),Double.toString(testEngine.timeToRebuild()));
	}
	
	@Test
	public void serviceLifeLeftTest() {
		assertEquals(Double.toString(50_000.0),Double.toString(testEngine.serviceLifeLeft()));
	}
}