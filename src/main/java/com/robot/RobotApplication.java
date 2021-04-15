package com.robot;

import com.robot.controller.RobotController;
import com.robot.model.Dimension;
import com.robot.model.TableTop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Entry Point for Robot Application
 */
public class RobotApplication {

	/**
	 * Main method to trigger processing of commands by reading from a file.
	 *
	 * @param args - expects only 1 argument referring to the path of file containing robot instructions.
	 * @throws IOException              - If fails to read file
	 * @throws IllegalArgumentException - If invalid arguments or wrong number of arguments are passed.
	 */
	public static void main(String[] args) throws IOException {

		// validate application parameters.
		if (args == null || !(args.length == 1)) {
			throw new IllegalArgumentException("Invalid number of parameters passed, One parameter expected representing path of file to read");
		}

		// fetch path of file
		Path path = Paths.get(args[0]);

		// read commands from the file
		List<String> robotCommands = Files.readAllLines(path);

		// initialize table top dimensions
		Dimension tableDimensions = Dimension.of(5, 5);
		TableTop tableTop = new TableTop(tableDimensions);

		// initialize robot controller with table top details
		RobotController robotController = new RobotController(tableTop);

		// trigger processing of commands.
		robotCommands.forEach(robotController::perform);
	}
}
