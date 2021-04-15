package com.robot.model;

/**
 * Robot class to hold robot state and implementation for operations.
 */
public class Robot {

	private TableTop tableTop;
	private Dimension robotLocation;
	private Direction robotDirection;

	public Robot(Dimension robotLocation, Direction robotDirection) {
		this.robotLocation = robotLocation;
		this.robotDirection = robotDirection;
	}

	public Robot(TableTop tableTop) {
		this.tableTop = tableTop;
	}

	/**
	 * PLACE Operation
	 *
	 * @param dimension Co-ordinates to place robot.
	 * @param direction Direction in which robot faces.
	 */
	public void placeRobot(Dimension dimension, Direction direction) {
		if (!isOutOfBounds(dimension)) {
			this.robotLocation = dimension;
			this.robotDirection = direction;
		}
	}

	/**
	 * LEFT Operation
	 */
	public void turnLeft() {
		robotDirection = robotDirection.left();
	}

	/**
	 * RIGHT Operation
	 */
	public void turnRight() {
		robotDirection = robotDirection.right();
	}

	/**
	 * MOVE Operation, 1 unit in direction robot is facing.
	 */
	public void move() {
		switch (robotDirection) {
			case NORTH:
				moveNorth();
				break;
			case SOUTH:
				moveSouth();
				break;
			case EAST:
				moveEast();
				break;
			case WEST:
				moveWest();
				break;
		}
	}

	/**
	 * MOVE Robot North by 1 Unit
	 */
	private void moveNorth() {
		robotLocation.incrementY();
		if (isOutOfBounds(robotLocation)) {
			robotLocation.decrementY();
		}
	}

	/**
	 * MOVE Robot South by 1 Unit
	 */
	private void moveSouth() {
		robotLocation.decrementY();
		if (isOutOfBounds(robotLocation)) {
			robotLocation.incrementY();
		}
	}

	/**
	 * MOVE Robot East by 1 Unit
	 */
	private void moveEast() {
		robotLocation.incrementX();
		if (isOutOfBounds(robotLocation)) {
			robotLocation.decrementX();
		}
	}

	/**
	 * MOVE Robot West by 1 Unit
	 */
	private void moveWest() {
		robotLocation.decrementX();
		if (isOutOfBounds(robotLocation)) {
			robotLocation.incrementX();
		}
	}

	/**
	 * REPORT Operation
	 */
	public String reportLocation() {
		if (this.robotLocation == null || this.robotDirection == null) {
			return "Robot not on TableTop";
		}
		return String.format("%d,%d,%s", this.robotLocation.getX(), this.robotLocation.getY(), this.robotDirection.name());
	}

	/**
	 * Check if Robot will go beyond table top boundaries.
	 *
	 * @param robotLocation - location to verify
	 */
	public boolean isOutOfBounds(Dimension robotLocation) {
		return robotLocation.getX() > tableTop.getDimension().getX() - 1
				|| robotLocation.getY() > (tableTop.getDimension().getY() - 1)
				|| robotLocation.getX() < 0 || robotLocation.getY() < 0;
	}
}
