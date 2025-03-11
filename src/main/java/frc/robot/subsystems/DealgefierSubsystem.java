package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.Constants.DealgefierConstants;

public class DealgefierSubsystem extends SubsystemBase {
    //The main motor for the winch is a brushed motor using a spark on pwm port 3
    private final Spark m_winchMotor = new Spark(DealgefierConstants.kPortPwm_WinchMotor);
    private final Spark m_spinArmMotor = new Spark(DealgefierConstants.kPortPwm_SwingMotor);
    
    public DealgefierSubsystem () {
        setDefaultCommand(
            // automatically disables the motor
        runOnce(() -> {
            m_spinArmMotor.disable();
            m_winchMotor.disable();
        })
            .andThen(run(() -> {
            })));
    }
    public Command moveWinchCommand(boolean forwardDirection){
        //main command for moving the winch motor
        if (forwardDirection){
            return run(() -> m_winchMotor.set(DealgefierConstants.kWinchSpeed));
        } else {
            return run(() -> m_winchMotor.set(DealgefierConstants.kWinchSpeed * -1));
        }
    }
    public Command SpinArmCommand(boolean forwardDirection){
        //main command for moving the winch motor
        if (forwardDirection){
            return run(() -> m_spinArmMotor.set(DealgefierConstants.kSwingArmSpeed));
        } else {
            return run(() -> m_spinArmMotor.set(DealgefierConstants.kSwingArmSpeed * -1));
        }
    }
}