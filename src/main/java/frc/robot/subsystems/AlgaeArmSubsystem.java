package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.DoubleSupplier;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants.AlgaeArmConstants;
import frc.robot.Constants.ArmConstants;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class AlgaeArmSubsystem extends SubsystemBase {
    /* The main arm motor uses a NEO moter conected with CAN */
    private final SparkMax m_algaeArmMotor = new SparkMax(AlgaeArmConstants.kCanid_AlgaeIntakeArm,MotorType.kBrushless);

public AlgaeArmSubsystem() {
    setDefaultCommand(
        runOnce(() -> m_algaeArmMotor.disable()).andThen(run(() -> {}))); //automaticaly sets the motor to off 
}

    public Command MoveAlgaeArm(DoubleSupplier speed) {
        //This is the main command for moving the arm
         return run(() -> m_algaeArmMotor.set(speed.getAsDouble()));
       
    }
}
