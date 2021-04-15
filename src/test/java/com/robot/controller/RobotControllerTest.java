package com.robot.controller;

import com.robot.model.Dimension;
import com.robot.model.TableTop;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RobotControllerTest {

	private final Dimension boardDimensions = Dimension.of(5, 5);
	private final TableTop tableTop = new TableTop(boardDimensions);
	private final RobotController controller = new RobotController(tableTop);

	@Test
	public void testValidateMoveInstruction() {
		String testCommand = "MOVE";
		controller.perform(testCommand);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidateInvalidMoveInstruction() {
		String testCommand = "MOVE 1 ";
		controller.perform(testCommand);
	}

	@Test
	public void testValidateLeftInstruction() {
		String testCommand = "LEFT";
		controller.perform(testCommand);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidateInvalidLeftInstruction() {
		String testCommand = "1 LEFT";
		controller.perform(testCommand);
	}

	@Test
	public void testValidateRightInstruction() {
		String testCommand = "RIGHT";
		controller.perform(testCommand);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidateInvalidRightInstruction() {
		String testCommand = "RIGHT 3";
		controller.perform(testCommand);
	}

	@Test
	public void testValidatePlaceInstruction() {
		String testCommand = "PLACE 1,1,NORTH";
		controller.perform(testCommand);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidateInvalidPlaceInstruction() {
		String testCommand = "PLACE 1,1,RIGHT";
		controller.perform(testCommand);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidateInvalidPlaceInstructionWithNoInfo() {
		String testCommand = "PLACE";
		controller.perform(testCommand);
	}

	@Test()
	public void testSampleCase1() {
		dataSampleCase1().forEach(controller::perform);
		assertEquals("0,1,NORTH", controller.getRobotLocation());
	}

	@Test()
	public void testSampleCase2() {
		dataSampleCase2().forEach(controller::perform);
		assertEquals("0,0,WEST", controller.getRobotLocation());
	}

	@Test()
	public void testSampleCase3() {
		dataSampleCase3().forEach(controller::perform);
		assertEquals("3,3,NORTH", controller.getRobotLocation());
	}

	private List<String> dataSampleCase1() {
		return List.of("PLACE 0,0,NORTH",
				"MOVE"
		);
	}

	private List<String> dataSampleCase2() {
		return List.of("PLACE 0,0,NORTH",
				"LEFT"
		);
	}

	private List<String> dataSampleCase3() {
		return List.of("PLACE 1,2,EAST",
				"MOVE",
				"MOVE",
				"LEFT",
				"MOVE"
		);
	}

}
