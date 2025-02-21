package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.DoubleSupplier;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants.AlgaeArmConstants;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class AlgaeArmSubsystem extends SubsystemBase {
    /* The main arm motor uses a NEO moter conected with CAN */
    private final SparkMax m_algaeArmMotor = new SparkMax(AlgaeArmConstants.kCanid_AlgaeIntakeArm,MotorType.kBrushless);

    private final SparkMax m_algaeIntakeMotor = new SparkMax(AlgaeArmConstants.kCanid_ArmIntake, MotorType.kBrushless);

    private final Spark m_algaeShooterMotor = new Spark(AlgaeArmConstants.kPortPWM_ArmShooter); 

public AlgaeArmSubsystem() {
    setDefaultCommand(
        runOnce(() -> m_algaeArmMotor.disable()).andThen(run(() -> {}))); //automaticaly sets the motor to off 
} 

public Command MoveAlgaeArm(boolean forwardDirection ) {
        //This is the main command for moving the arm 
        if (forwardDirection) {
            return run(() -> m_algaeArmMotor.set(AlgaeArmConstants.kAlgaeArmSpeed));
        } else {
            return run(() -> m_algaeArmMotor.set(AlgaeArmConstants.kAlgaeArmSpeed * -1));
        }
    }

public Command AlgaeArmIntake(boolean forwardDirection){
    //This is the command for actvating 
    if (forwardDirection) {
        return run(() -> m_algaeIntakeMotor.set(AlgaeArmConstants.kAlgaeIntakeSpeed));
     } else {
            return run(() -> m_algaeIntakeMotor.set(AlgaeArmConstants.kAlgaeIntakeSpeed * -1));
        }
    } 

public Command AlgaeArmShoot(){
    {
        return run(() -> m_algaeShooterMotor.set(AlgaeArmConstants.kAlgaeArmSpeed));
    }   
}
}

