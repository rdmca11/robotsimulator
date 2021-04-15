package com.robot.model;

/**
 * Used to represents TableTop information.
 */
public class TableTop {
	private final Dimension dimension;

	public TableTop(Dimension dimension) {
		this.dimension = dimension;
	}

	public Dimension getDimension() {
		return dimension;
	}
}
