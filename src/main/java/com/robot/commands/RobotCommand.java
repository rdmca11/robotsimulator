package com.robot.commands;

import com.robot.model.Robot;

/**
 * Abstraction interface for various Robot Commands
 */
public interface RobotCommand {
	void execute(Robot robot);
}
