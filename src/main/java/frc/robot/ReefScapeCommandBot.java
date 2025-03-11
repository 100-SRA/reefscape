package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.AlgaeArmSubsystem;
import frc.robot.subsystems.LiftArmSubsystem;
import frc.robot.subsystems.DealgefierSubsystem;

public class ReefScapeCommandBot {
  // Robot subsystems
  private final Drive m_drive = new Drive();
  private final LiftArmSubsystem m_liftArm = new LiftArmSubsystem();
  private final AlgaeArmSubsystem m_AlgaeArm = new AlgaeArmSubsystem();
  private final DealgefierSubsystem m_Dealgefier = new DealgefierSubsystem();

  // Driver's controller
  private final CommandPS4Controller m_driverControllerA = new CommandPS4Controller(
      OperatorConstants.kDriverControllerPort_A);
  private final CommandPS4Controller m_driverControllerB = new CommandPS4Controller(
      OperatorConstants.kDriverControllerPort_B);

  // Map robot and controller conditions to commands
  public void configureBindings() {
    // Set control of drive subsystem -> 2 stick arcade drive
    m_drive.setDefaultCommand(
        // uses left stick to drive
        m_drive.arcadeDriveCommand(() -> m_driverControllerA.getLeftY(), () -> -m_driverControllerA.getRightX()));
    // Set driving reversal to the "share" button
    m_driverControllerA.share().onTrue(m_drive.toggleReversedCommand());

    // Set control of lift arm -> up and down on the d-pad
    m_driverControllerB.L1().whileTrue(m_liftArm.moveArmCommand(true)); // lift arm will go up when left stick is
                                                                        // pressed
    m_driverControllerB.R1().whileTrue(m_liftArm.moveArmCommand(false)); // lift arm will go down when right stick is
                                                                         // pressed

    m_driverControllerB.povUp().whileTrue(m_AlgaeArm.MoveAlgaeArm(false)); // When X is pressed it will make the arm go up
    m_driverControllerB.povDown().whileTrue(m_AlgaeArm.MoveAlgaeArm(true)); // When circle is pressed it will make the arm go down
    
    // Algae controls:
    // Use L1, L2 for intake motor and R1, R2 for shooter motor
    m_driverControllerB.cross().whileTrue(m_AlgaeArm.IntakeAlgae());
    m_driverControllerB.circle().whileTrue(m_AlgaeArm.DropAlgae());

    // Swing arm controls:
    m_driverControllerA.povUp().whileTrue(m_Dealgefier.moveWinchCommand(true)); // When dpad up is pressed the arm will move up
    m_driverControllerA.povDown().whileTrue(m_Dealgefier.moveWinchCommand(false)); // When dpad down is pressed the arm will move down
    m_driverControllerA.cross().whileTrue(m_Dealgefier.SpinArmCommand(true)); // dealgifer arm will spin when X is pressed 


  }

  // Basic autonomous command to drive forward and stop
  public Command getAutonomousCommand() {
    return m_drive.driveStraightCommand(AutoConstants.kAutoLeaveSpeed)
        .withTimeout(AutoConstants.kAutoLeaveTimeout);
  }
}
