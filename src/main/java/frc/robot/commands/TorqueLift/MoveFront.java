package frc.robot.commands.TorqueLift;

import frc.robot.commands.MoveWithLimitSwitches;

import static frc.robot.subsystems.TorqueLift.frontlift;
import static frc.robot.Robot.torquelift;

public class MoveFront extends MoveWithLimitSwitches {

    public MoveFront(int destination) {
        // Use requires() here to declare subsystem dependencies
        super(destination);
        requires(torquelift); // requires has to be declared here, if declared in it's abstract class then requires will read null
        m_lslevelsubsystem = frontlift;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        torquelift.setPTOState(true);
        reachedDestination = false;
    }

}
