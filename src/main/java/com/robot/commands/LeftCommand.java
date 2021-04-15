package com.robot.commands;

import com.robot.model.Robot;

public class LeftCommand implements RobotCommand {

	@Override
	public void execute(Robot robot) {
		robot.turnLeft();
	}
}
