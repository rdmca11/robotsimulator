package com.robot.commands;

import com.robot.model.Robot;

public class ReportCommand implements RobotCommand {

	@Override
	public void execute(Robot robot) {
		System.out.println(robot.reportLocation());
	}
}
