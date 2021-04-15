package com.robot.commands;

import com.robot.model.Robot;

public class MoveCommand implements RobotCommand {

	@Override
	public void execute(Robot robot) {
		robot.move();
	}
}
