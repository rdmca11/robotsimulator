package com.robot.model;

/**
 * Enum class for directions NORTH,EAST,WEST,SOUTH with implementations for left and right directions.
 */
public enum Direction {
	NORTH {
		@Override
		public Direction left() {
			return WEST;
		}

		@Override
		public Direction right() {
			return EAST;
		}
	},
	EAST {
		@Override
		public Direction left() {
			return NORTH;
		}

		@Override
		public Direction right() {
			return SOUTH;
		}
	},
	SOUTH {
		@Override
		public Direction left() {
			return EAST;
		}

		@Override
		public Direction right() {
			return WEST;
		}
	},
	WEST {
		@Override
		public Direction left() {
			return SOUTH;
		}

		@Override
		public Direction right() {
			return NORTH;
		}
	};

	public Direction left() {
		throw new UnsupportedOperationException("Method has no default implementation, needs overriding");
	}

	public Direction right() {
		throw new UnsupportedOperationException("Method has no default implementation, needs overriding");
	}

}
