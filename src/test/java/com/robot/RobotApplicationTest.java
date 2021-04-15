package com.robot;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RobotApplicationTest {

	@Test
	public void testRobotApplication_WithSampleValidFile() throws IOException {
		Path resourceDirectory = Paths.get("src", "test", "resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath() + "/SampleCommands.txt";
		RobotApplication.main(new String[]{absolutePath});
	}
}
