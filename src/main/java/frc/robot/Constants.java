// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    // The port number for the controller
    public static final int kDriverControllerPort_A = 0;
    public static final int kDriverControllerPort_B = 1;
    /* Binding */
    public static final int kLeft_Trigger = 1;
    public static final int kRight_Trigger = 2;
    public static final int kX_Button = 3;
    public static final int kCircle_Button = 4;
    public static final int kTriangle_Button = 5;
    public static final int kSquare_button = 6;
  }

  public static class AutoConstants {
    /* How far the robot will drive out the starting zone for autonomous */
    public static final double kAutoLeaveDistance = .5;
    public static final double kAutoLeaveSpeed = .5;
    public static final double kAutoLeaveTimeout = 5;
  }

  public static class DriveConstants {
    /* The side with the battery is the front */
    /*
     * Spark Numbers
     * 1 - Back Left BL
     * 2 - Front Left FL
     * 3 - Front Right FR
     * 4 - Back Right BR
     */
    public static final int kPortPWM_Drivetrain_BL = 0;
    public static final int kPortPWM_Drivetrain_FL = 1;
    public static final int kPortPWM_Drivetrain_FR = 4;
    public static final int kPortPWM_Drivetrain_BR = 5;
    // sets up the encoder on the drivetrain
    public static final int kEncoderPorts_Left[] = { 0, 1 };
    public static final boolean kEncoderReversed_Left = false;
    // cycles per revolution (see encoder spec)
    public static final int kEncoderResolution = 2048;
    public static final double kWheelRadiusMeters = 0.0762;
    // Encoders directly on the wheel shaft
    // Calculate the rolling distance corresponding to a single encoder pulse
    // (also called a cycle)
    public static final double kEncoderDistancePerPulse = 2 * Math.PI * kWheelRadiusMeters / kEncoderResolution;
    public static boolean revDrive = false;
  }

  public static class ArmConstants {
    /* Can id For the main arm lift */
    public static final int kCanid_ArmLift = 1;
    public static final double kArmSpeed = 0.5; // sets the speed for the arm
  }

  public static class AlgaeArmConstants {
    /* Can id for the algae intake mechanism */
    public static final int kCanid_AlgaeIntakeArm = 2;
    public static final double kAlgaeArmSpeed = 0.4; // sets the speed of the arm
    public static final int kCanid_ArmIntake = 3;
    public static final int kPortPWM_ArmShooter = 2;
    public static final double kAlgaeIntakeSpeed = .5; // sets the speed of the intake of the motor
    public static final double kAlgaeShooterSpeed = 0.8; // sets the speed of the shooter motor
  }

  public static class DealgefierConstants  {
    public static final int kPortPwm_WinchMotor = 3; // pwm port for the winch motor
    public static final int kPortPwm_SwingMotor = 2; // pwm port for the swing motor

    public static final double kWinchSpeed = 0.5;
    public static final double kSwingArmSpeed = 0.4;
  }
}
