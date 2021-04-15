package com.robot.factory;

import com.robot.commands.*;
import com.robot.model.Dimension;
import com.robot.model.Direction;
import com.robot.model.Instruction;

/**
 * Factory class to get {@link RobotCommand} by parsing an instruction.
 */
public class RobotCommandFactory {
	public static RobotCommand getCommand(String robotInstruction) {

		// validate isntruction is not empty
		if (robotInstruction == null || robotInstruction.isEmpty()) {
			throw new IllegalArgumentException("Robot instruction cannot be empty or null");
		}

		robotInstruction = robotInstruction.toUpperCase();

		// split the instruction by space, multiple values for PLACE command are possible.
		String[] commandArr = robotInstruction.split(" ");

		// parse the instruction.
		Instruction instruction = Instruction.valueOf(commandArr[0]);
		switch (instruction) {
			case MOVE:
				return new MoveCommand();
			case LEFT:
				return new LeftCommand();
			case RIGHT:
				return new RightCommand();
			case PLACE:
				String[] placeInstructions = commandArr[1].split(",");
				Dimension placeLocation = Dimension.of(Integer.parseInt(placeInstructions[0]), Integer.parseInt(placeInstructions[1]));
				return new PlaceCommand(placeLocation, Direction.valueOf(placeInstructions[2]));
			case REPORT:
				return new ReportCommand();
			default:
				throw new IllegalArgumentException("Invalid Instruction :" + instruction);
		}
	}
}
