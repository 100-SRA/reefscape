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
  private final AlgaeArmSubsystem m_AlgaeArm = new AlgaeArmSubsystem();

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
    m_drive.arcadeDriveCommand(() -> m_driverControllerA.getLeftY(), () -> -m_driverControllerA.getLeftX())); 

    // uses left stick to go forward and backward and right to go left and right
    //m_drive.arcadeDriveCommand(() -> -m_driverControllerA.getLeftY(), () -> -m_driverControllerA.getRightX()));

    // Set control of lift arm -> up and down on the d-pad
    m_driverControllerB.povUp().whileTrue(m_liftArm.moveArmCommand(true));
    m_driverControllerB.povDown().whileTrue(m_liftArm.moveArmCommand(false));

    m_driverControllerB.cross().whileTrue(m_AlgaeArm.MoveAlgaeArm(true)); // When X is pressed it will make the arm go up
    m_driverControllerB.circle().whileTrue(m_AlgaeArm.MoveAlgaeArm(false)); // When circle is pressed it will make the arm go down
    
    //m_driverControllerA.cross().whileTrue(m_AlgaeArm.AlgaeArmIntake(true)); // When L1 is pressed it will actvate the intake 
    //m_driverControllerA.circle().whileTrue(m_AlgaeArm.AlgaeArmIntake(false)); // When R1 is pressed it will make the shooter push out the ball

  }
}