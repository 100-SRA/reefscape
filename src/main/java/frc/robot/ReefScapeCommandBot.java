package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.AlgaeArmSubsystem;
import frc.robot.subsystems.LiftArmSubsystem;



public class ReefScapeCommandBot {
  // Robot subsystems
  private final Drive m_drive = new Drive();
  private final LiftArmSubsystem m_liftArm = new LiftArmSubsystem();


  // Driver's controller
  private final CommandPS4Controller m_driverController = new CommandPS4Controller(
      OperatorConstants.kDriverControllerPort_A);

  // Map robot and controller conditions to commands
  public void configureBindings() {
    // Set control of drive subsystem -> 2 stick arcade drive
    m_drive.setDefaultCommand(
        m_drive.arcadeDriveCommand(() -> -m_driverController.getLeftY(), () -> -m_driverController.getRightX()));

    // Set control of lift arm -> up and down on the d-pad
    m_driverController.povUp().whileTrue(m_liftArm.moveArmCommand(true));
    m_driverController.povDown().whileTrue(m_liftArm.moveArmCommand(false));
  }
}
