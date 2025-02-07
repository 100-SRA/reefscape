// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    //The port number for the controller
    public static final int kDriverControllerPort = 0;

    /* Binding */
    public static final int kLeft_Trigger = 1;
    public static final int kRight_Trigger = 2;
    public static final int kX_Button = 3;
    public static final int kCircle_Button = 4;
    public static final int kTriangle_Button = 5;
    public static final int kSquare_button = 6; 
  }
  
  public static class AutoConstants {
    /*How far the robot will drive out the starting zone for autonomous*/
    public static final double kAutoLeaveDistance = 1.5;
  }

  public static class DriveConstants {
    /* The side with the battery is the front */
    /*Spark Numbers  
    * 1 - Back Left BL
    * 2 - Front Left FL
    * 3 - Front Right FR
    * 4 - Back Right BR
    */
    public static final int kPortPWM_Drivetrain_BL = 0;
    public static final int kPortPWM_Drivetrain_FL = 1;
    public static final int kPortPWM_Drivetrain_FR = 4;
    public static final int kPortPWM_Drivetrain_BR = 5;
  }

  public static class ArmConstants {
    /* Can id For the main arm lift */
    public static final int kCanid_ArmLift = 1;
  }
}
