package frc.robot;

import frc.robot.commands.Arm.MoveArm;
import frc.robot.commands.Drivetrain.MoveToTarget;
import frc.robot.commands.Drivetrain.Test;
import frc.robot.commands.TorqueLift.MoveFrontAndRear;
import frc.robot.commands.TorqueLift.NormalTorqueliftWithJoysticks;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private final double UPPER_JOYSTICK_BUFFER = .07;
    private final double LOWER_JOYSTICK_BUFFER = .07;

    // Declare Joysticks
    private LogitechJoystick jLeft = new LogitechJoystick(RobotMap.leftStick);
    private LogitechJoystick jRight = new LogitechJoystick(RobotMap.rightStick);
    private LogitechJoystick jLift = new LogitechJoystick(RobotMap.liftStick);
    private LogitechJoystick jArm = new LogitechJoystick(RobotMap.armStick);

	public OI() {
        jArm.btn_7.whenPressed(new MoveArm(1));
        jArm.btn_9.whenPressed(new MoveArm(2));
        jArm.btn_11.whenPressed(new MoveArm(3));
        jRight.btn_3.whenPressed(new MoveArm(0));
        jRight.btn_1.toggleWhenPressed(new NormalTorqueliftWithJoysticks());
	}

    /** 
     * Gets the position of the jElev Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getLiftSpeed() {
		if ((jLift.getY() < UPPER_JOYSTICK_BUFFER) && (jLift.getY() > LOWER_JOYSTICK_BUFFER)) {
			return 0;
		} else {
			return (jLift.getY());
		}
	}

    /** 
     * Gets the position of the jLeft Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getLeftSpeed() {
        if ((jLeft.getY() < UPPER_JOYSTICK_BUFFER) && (jLeft.getY() > LOWER_JOYSTICK_BUFFER)) {
            return 0;
        } else {
            return (jLeft.getY());
        }
	}
	
    /** 
     * Gets the position of the jLeft Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getRightSpeed() {
        if ((jRight.getY() < UPPER_JOYSTICK_BUFFER) && (jRight.getY() > LOWER_JOYSTICK_BUFFER)) {
            return 0;
        } else {
            return (jRight.getY());
        }
	}
	
    /** 
     * Gets the position of the jClaw Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getArmSpeed() {
        if ((jArm.getY() < UPPER_JOYSTICK_BUFFER) && (jArm.getY() > LOWER_JOYSTICK_BUFFER)) {
            return 0;
        } else {
            return (jArm.getY());
        }
	}
}
