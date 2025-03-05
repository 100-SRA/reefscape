// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Drive extends SubsystemBase {
  // Motor controllers
  private final Spark m_leftLeader = new Spark(DriveConstants.kPortPWM_Drivetrain_FL);
  private final Spark m_leftFollower = new Spark(DriveConstants.kPortPWM_Drivetrain_BL);
  private final Spark m_rightLeader = new Spark(DriveConstants.kPortPWM_Drivetrain_FR);
  private final Spark m_rightFollower = new Spark(DriveConstants.kPortPWM_Drivetrain_BR);

  // Differential drive setup for arcade driving
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftLeader::set, m_rightLeader::set);
  private boolean m_isReversed = false;

  /** Creates a new DriveSubsystem. */
  public Drive() {
    // Invert one side to make positive voltage drive both sides forward
    m_rightLeader.setInverted(true);

    // Make secondary motors on each side follow the primary motors
    m_leftLeader.addFollower(m_leftFollower);
    m_rightLeader.addFollower(m_rightFollower);
  }

  /**
   * Switches subsystem's drive direction.
   */
  private void toggleReversed() {
    m_isReversed = !m_isReversed;
  }

  /**
   * Applies forward and rotation values to differential arcade drive.
   * @param forward power to apply to forward/backward motion
   * @param rotation power to apply to left/right motion
   */
  private void arcadeDrive(double forward, double rotation) {
    if (m_isReversed) {
      // modify the forward/backward motion if we're reversed
      forward *= -1;
    }
    m_drive.arcadeDrive(forward, rotation);
  }

  /**
   * Builds command to switch the driving direction.
   * 
   * @return a command to switch the drive direction
   */
  public Command toggleReversedCommand() {
    return run(() -> toggleReversed());
  }

  /**
   * Builds command to control the arcade driving.
   *
   * @return a command to do arcade drive
   */
  public Command arcadeDriveCommand(DoubleSupplier fwd, DoubleSupplier rot) {
    // Read the double values from the controller for the forward motion and
    // rotation values
    return run(() -> arcadeDrive(fwd.getAsDouble(), rot.getAsDouble()));
  }

  /*
   * Arcade drive straight indefinitely at set speed (stop when command ends);
   * Use this with a timeout for now until we have the encoder(s) on the bot.
   */
  public Command driveStraightCommand(double speed) {
    /* Drive straight at the set speed */
    /* Stop the drivetrain when the command ends */
    return run(() -> m_drive.arcadeDrive(speed, 0.0))
        .finallyDo(interrupted -> m_drive.stopMotor());
  }

}
