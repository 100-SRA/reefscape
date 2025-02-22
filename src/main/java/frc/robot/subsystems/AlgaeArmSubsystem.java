package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants.AlgaeArmConstants;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class AlgaeArmSubsystem extends SubsystemBase {
    /* The main arm motor uses a NEO moter conected with CAN */
    private final SparkMax m_algaeArmMotor = new SparkMax(
            AlgaeArmConstants.kCanid_AlgaeIntakeArm, MotorType.kBrushless);

    private final SparkMax m_algaeIntakeMotor = new SparkMax(
            AlgaeArmConstants.kCanid_ArmIntake, MotorType.kBrushless);

    private final Spark m_algaeShooterMotor = new Spark(AlgaeArmConstants.kPortPWM_ArmShooter); 

    // Constructor: set default behavior for motors to be no movement
    public AlgaeArmSubsystem() {
        setDefaultCommand(
            runOnce(() -> {
                m_algaeArmMotor.disable();
                m_algaeIntakeMotor.disable();
                m_algaeShooterMotor.disable();
            })
            .andThen(run(() -> {}))); //automaticaly sets the motors to off 
    } 

    public Command MoveAlgaeArm(boolean forwardDirection ) {
        //This is the main command for moving the arm 
        if (forwardDirection) {
            return run(() -> m_algaeArmMotor.set(
                        AlgaeArmConstants.kAlgaeArmSpeed));
        } else {
            return run(() -> m_algaeArmMotor.set(
                        AlgaeArmConstants.kAlgaeArmSpeed * -1));
        }
    }

    // Run intake motor to grab algae
    public Command IntakeAlgae() {
        return run(() -> m_algaeIntakeMotor.set(
                    AlgaeArmConstants.kAlgaeIntakeSpeed));
    }

    // Run intake motor in reverse to drop algae
    public Command DropAlgae() {
        return run(() -> m_algaeIntakeMotor.set(
                    AlgaeArmConstants.kAlgaeIntakeSpeed * -1));
    }

    // Spin shooter motor to launch algae
    public Command ShootAlgae() {
        return run(() -> m_algaeShooterMotor.set(
                    AlgaeArmConstants.kAlgaeShooterSpeed));
    }

    // Run shooter motor in opposite direction (largely for testing)
     public Command ReverseShootAlgae() {
        return run(() -> m_algaeShooterMotor.set(
                    AlgaeArmConstants.kAlgaeShooterSpeed * -1));
    }
}

