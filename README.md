# robotsimulator

## Instructions
RobotApplication is coded to accept a file with list of commands to simulate robot movements.

The application is a simulation of a toy robot moving on a square
tabletop, of dimensions 5 units x 5 units.

There are no other obstructions on the table surface.

The robot is free to roam around the surface of the table, but must be
prevented from falling to destruction.  Any movement that would result
in the robot falling from the table must be prevented, however further
valid movement commands must still be allowed.

Create an application that can read in commands of the following form -

    PLACE X,Y,F
    MOVE
    LEFT
    RIGHT
    REPORT

Where PLACE will put the toy robot on the table in position X,Y and
facing NORTH, SOUTH, EAST or WEST.  The origin (0,0) can be considered to
be the SOUTH WEST most corner.

It is required that the first command to the robot is a PLACE command,
after that, any sequence of commands may be issued, in any order, including
another PLACE command.  The application should discard all commands in
the sequence until a valid PLACE command has been executed.

Where MOVE will move the toy robot one unit forward in the direction
it is currently facing.

Where LEFT and RIGHT will rotate the robot 90 degrees in the specified
direction without changing the position of the robot.

Where REPORT will announce the X,Y and F of the robot.  This can be
in any form, but standard output is sufficient.

A robot that is not on the table can choose the ignore the MOVE, LEFT,
RIGHT and REPORT commands.

## Tech Stack
* JDK 11
* jUnit 4
* Maven

## Building the application
Project can be build using maven commands
> mvn install or mvn package 
> Results in an executable jar **robotsimulator.jar**

## Running the application from command line
> java -jar robotsimulator.jar ___input file path with list of commands___

## Example Run 
___java -jar robotsimulator.jar c:/test/samplecommands.txt___

Output:
0,1,NORTH

##### Assumptions
- Maven, Java 11 are pre installed
