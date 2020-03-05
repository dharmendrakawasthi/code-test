package com.ge.exercise4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GE9xTest {

	GE9x testEngine;

	@Before
	public void setUp() {
		testEngine = new GE9x("0001", 10_000, 2);
	}

	@Test
	public void toStringTest() {
		assertEquals("GE9x SN: 0001", testEngine.toString());
	}

	@Test
	public void thrustToWeightRatioTest() {
		assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
	}

	@Test
	public void timeToRebuildTest() {
		assertEquals(Double.toString(20_000.0), Double.toString(testEngine.timeToRebuild()));
	}

	@Test
	public void serviceLifeLeftTest() {
		assertEquals(Double.toString(80_000.0), Double.toString(testEngine.serviceLifeLeft()));
	}

}
