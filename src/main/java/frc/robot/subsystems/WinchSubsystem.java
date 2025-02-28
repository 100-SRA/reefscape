package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.Constants.WinchConstants;;

public class WinchSubsystem extends SubsystemBase {
    //The main motor for the winch is a brushed motor using a spark on pwm port 3
    private final Spark m_winchMotor = new Spark(WinchConstants.kCanid_winchMotor);
    
    public WinchSubsystem() {

        setDefaultCommand(
            // automatically disables the motor
            runOnce(() -> m_winchMotor.disable()).andThen(run(() -> {})));
    }
    public Command moveWinchCommand(boolean forwardDirection){
        //main command for moving the winch motor
        if (forwardDirection){
            return run(() -> m_winchMotor.set(WinchConstants.kWinchSpeed));
        } else {
            return run(() -> m_winchMotor.set(WinchConstants.kWinchSpeed * -1));
        }
    }
}
