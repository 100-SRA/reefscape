// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.Encoder;
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

  // Drivetrain encoder (left side)
  private final Encoder m_leftEncoder = new Encoder(
          DriveConstants.kEncoderPorts_Left[0],
          DriveConstants.kEncoderPorts_Left[1],
          DriveConstants.kEncoderReversed_Left);
  
  /** Creates a new DriveSubsystem. */
  public Drive() {
    // Invert one side to make positive voltage drive both sides forward
    m_rightLeader.setInverted(true);

    // Make secondary motors on each side follow the primary motors
    m_leftLeader.addFollower(m_leftFollower);
    m_rightLeader.addFollower(m_rightFollower);

    // Configure encoder
    m_leftEncoder.setDistancePerPulse(
            DriveConstants.kEncoderDistancePerPulse);
  }

  /**
   * Arcade drive command.
   *
   * @return a command to do arcade drive
   */
  public Command arcadeDriveCommand(DoubleSupplier fwd, DoubleSupplier rot) {
    // Read the double values from the controller for the forward motion and rotation values
    return run(() -> m_drive.arcadeDrive(fwd.getAsDouble(), rot.getAsDouble()));
  }

  /*
   * Arcade drive a set distance command
   */
  public Command driveDistanceCommand(double distanceMeters, double speed) {
      return runOnce(
              /* Reset encoder once at the beginning */
              () -> m_leftEncoder.reset())
          .andThen(
                  /* Drive straight at the set speed */
                  () -> m_drive.arcadeDrive(speed, 0.0))
          .until(
                  /* Check encoder distance against target meters */
                  () -> m_leftEncoder.getDistance() >= distanceMeters)
          .finallyDo(
                  /* Stop the drivetrain when the command ends */
                  () -> m_drive.stopMotor());
  }
}
