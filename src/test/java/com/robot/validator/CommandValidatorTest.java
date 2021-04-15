package com.robot.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandValidatorTest {

	@Test
	public void testValidMoveInstruction() {
		assertTrue(CommandValidator.isValidCommand("MOVE"));
	}

	@Test
	public void testInvalidMoveInstruction() {
		assertFalse(CommandValidator.isValidCommand("MOVE 1"));
	}

	@Test
	public void testValidLeftInstruction() {
		assertTrue(CommandValidator.isValidCommand("LEFT"));
	}

	@Test
	public void testInvalidLeftInstruction() {
		assertFalse(CommandValidator.isValidCommand("1 LEFT"));
	}

	@Test
	public void testValidRightInstruction() {
		assertTrue(CommandValidator.isValidCommand("RIGHT"));
	}

	@Test
	public void testInvalidRightInstruction() {
		assertFalse(CommandValidator.isValidCommand("RIGHT 3"));
	}

	@Test
	public void testValidPlaceInstruction() {
		assertTrue(CommandValidator.isValidCommand("PLACE 1,1,NORTH"));
	}

	@Test
	public void testInvalidPlaceInstruction() {
		assertFalse(CommandValidator.isValidCommand("PLACE 1,1,RIGHT"));
	}

	@Test
	public void testInvalidPlaceInstructionWithNoInfo() {
		assertFalse(CommandValidator.isValidCommand("PLACE"));
	}
}
