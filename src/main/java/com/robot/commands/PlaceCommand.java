package com.robot.commands;

import com.robot.model.Dimension;
import com.robot.model.Direction;
import com.robot.model.Robot;

public class PlaceCommand implements RobotCommand {

	private final Dimension dimension;
	private final Direction direction;

	public PlaceCommand(Dimension dimension, Direction direction) {
		this.dimension = dimension;
		this.direction = direction;
	}

	@Override
	public void execute(Robot robot) {
		robot.placeRobot(this.dimension, direction);
	}
}
