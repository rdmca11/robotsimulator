package com.robot.commands;

import com.robot.model.Robot;

public class RightCommand implements RobotCommand {

	@Override
	public void execute(Robot robot) {
		robot.turnRight();
	}
}
