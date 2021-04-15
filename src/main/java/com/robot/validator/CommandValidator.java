package com.robot.validator;

/**
 * Validator class for Robot Commands represented as string values.
 */
public class CommandValidator {
	public static String COMMAND_REGEX = "(?i)(MOVE|LEFT|RIGHT|REPORT|PLACE [\\d],[\\d],(NORTH|EAST|WEST|SOUTH))";

	/**
	 * Validates robot command.
	 *
	 * @param command Robot Instruction
	 * @return true if valid command, else false.
	 */
	public static boolean isValidCommand(String command) {
		if (command == null || command.isEmpty()) {
			return false;
		}
		return command.matches(COMMAND_REGEX);
	}
}
