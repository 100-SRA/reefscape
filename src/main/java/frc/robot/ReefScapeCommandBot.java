package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.AlgaeArmSubsystem;
import frc.robot.subsystems.LiftArmSubsystem;
import frc.robot.subsystems.WinchSubsystem;
import frc.robot.subsystems.DropboxSubsystem;

public class ReefScapeCommandBot {
  // Robot subsystems
  private final Drive m_drive = new Drive();
  private final LiftArmSubsystem m_liftArm = new LiftArmSubsystem();
  private final AlgaeArmSubsystem m_AlgaeArm = new AlgaeArmSubsystem();
  private final WinchSubsystem m_Winch = new WinchSubsystem();

  // Driver's controller
  private final CommandPS4Controller m_driverControllerA = new CommandPS4Controller(
      OperatorConstants.kDriverControllerPort_A);
  private final CommandPS4Controller m_driverControllerB = new CommandPS4Controller(
      OperatorConstants.kDriverControllerPort_B); 

  // Map robot and controller conditions to commands
  public void configureBindings() {
    // Set control of drive subsystem -> 1 stick arcade drive
    m_drive.setDefaultCommand(
    // uses left stick to drive
    m_drive.arcadeDriveCommand(() -> m_driverControllerA.getLeftY(), () -> -m_driverControllerA.getLeftX())); 

    // Set control of lift arm -> up and down on the d-pad
    m_driverControllerB.povUp().whileTrue(m_liftArm.moveArmCommand(true));
    m_driverControllerB.povDown().whileTrue(m_liftArm.moveArmCommand(false));

    m_driverControllerA.cross().whileTrue(m_AlgaeArm.MoveAlgaeArm(true)); // When X is pressed it will make the arm go up
    m_driverControllerA.circle().whileTrue(m_AlgaeArm.MoveAlgaeArm(false)); // When circle is pressed it will make the arm go down
    
    // Algae controls:
    // Use L1, L2 for intake motor and R1, R2 for shooter motor
    m_driverControllerA.L1().whileTrue(m_AlgaeArm.IntakeAlgae());
    m_driverControllerA.L2().whileTrue(m_AlgaeArm.DropAlgae());
    m_driverControllerA.R1().whileTrue(m_AlgaeArm.ShootAlgae());
    m_driverControllerA.R2().whileTrue(m_AlgaeArm.ReverseShootAlgae());

    // Dropbox controls::
    // Use triangle to open and square to close
    //m_driverControllerB.triangle().whileTrue(m_Dropbox.OpenDropbox());
    //m_driverControllerB.square().whileTrue(m_Dropbox.CloseDropbox());

    // Winch controls:
    m_driverControllerB.povUp().whileTrue(m_Winch.moveWinchCommand(true));
    m_driverControllerB.povUp().whileTrue(m_Winch.moveWinchCommand(false));
  }


  // Basic autonomous command to drive forward and stop
  public Command getAutonomousCommand() {
      return m_drive.driveStraightCommand(AutoConstants.kAutoLeaveSpeed)
          .withTimeout(AutoConstants.kAutoLeaveTimeout);
  }
}
