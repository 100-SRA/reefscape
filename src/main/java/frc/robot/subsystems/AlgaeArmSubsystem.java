package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants.AlgaeArmConstants;
import frc.robot.Constants.ArmConstants;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class AlgaeArmSubsystem {
    /* The main arm motor uses a NEO moter conected with CAN */
    private final SparkMax m_algaeArmMotor = new SparkMax(AlgaeArmConstants.kCanid_AlgaeIntakeArm,MotorType.kBrushless);

    public void MoveArm(double speed) {
        //This is the main command for moving the arm
        speed = speed * AlgaeArmConstants.kAlgaeArmSpeed; // modify speed based on max output constant
        m_algaeArmMotor.set(speed);
    }
}
