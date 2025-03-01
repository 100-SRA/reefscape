package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.Constants.SwingArmConstants;

public class AlgaeSwingArm extends SubsystemBase {
    //The main motor for the winch is a brushed motor using a spark on pwm port 3
    private final Spark m_winchMotor = new Spark(SwingArmConstants.kPortPwm_WinchMotor);
    private final Spark m_swingMotor = new Spark(SwingArmConstants.kPortPwm_SwingMotor);

    
    public AlgaeSwingArm() {

        setDefaultCommand(
            // automatically disables the motor
            runOnce(() -> m_winchMotor.disable()).andThen(run(() -> {})));
    }
    public Command moveWinchCommand(boolean forwardDirection){
        //main command for moving the winch motor
        if (forwardDirection){
            return run(() -> m_winchMotor.set(SwingArmConstants.kWinchSpeed));
        } else {
            return run(() -> m_winchMotor.set(SwingArmConstants.kWinchSpeed * -1));
        }
    }

    public Command swingarCommand(boolean forwardDirection){
        if (forwardDirection){
            // main command for swinging the arm
            return run(() -> m_swingMotor.set(SwingArmConstants.kWinchSpeed));
        } else {
            return run(() -> m_swingMotor.set(SwingArmConstants.kWinchSpeed * -1));
        }
    }
}
