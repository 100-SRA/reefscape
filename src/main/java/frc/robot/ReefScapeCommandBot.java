package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drive;

public class ReefScapeCommandBot {
  // Robot subsystems
  private final Drive m_drive = new Drive();

  // Driver's controller
  private final CommandPS4Controller m_driverController = new CommandPS4Controller(
      OperatorConstants.kDriverControllerPort);

  // Map robot and controller conditions to commands
  public void configureBindings() {
    // Set control of drive subsystem -> 2 stick arcade drive
    m_drive.setDefaultCommand(
        m_drive.arcadeDriveCommand(() -> -m_driverController.getLeftY(), () -> -m_driverController.getRightX()));
  }
}
