package com.robot.controller;

import com.robot.commands.PlaceCommand;
import com.robot.commands.RobotCommand;
import com.robot.factory.RobotCommandFactory;
import com.robot.model.Robot;
import com.robot.model.TableTop;
import com.robot.validator.CommandValidator;

public class RobotController {

	private final TableTop tableTop;
	private Robot robot;

	public RobotController(TableTop tableTop) {
		this.tableTop = tableTop;
	}

	public void perform(String command) {

		// validate incoming command for syntax check
		if (!CommandValidator.isValidCommand(command)) {
			throw new IllegalArgumentException("Invalid command, please check the syntax :" + command);
		}

		// generate Robot Command from instruction
		RobotCommand robotCommand = RobotCommandFactory.getCommand(command);

		// Robot needs to be initialized when first place command is encountered.
		if (robotCommand instanceof PlaceCommand) {
			if (this.robot == null) {
				this.robot = new Robot(tableTop);
			}
		}

		// perform robot operation, if it has been initialized by a place command.
		if (this.robot != null) {
			robotCommand.execute(this.robot);
		}
	}

	/**
	 * Visible for testing.
	 *
	 * @return Robot Location
	 */
	protected String getRobotLocation() {
		return this.robot.reportLocation();
	}

}
