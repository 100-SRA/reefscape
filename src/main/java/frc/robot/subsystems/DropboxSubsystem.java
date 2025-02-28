// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;


public class DropboxSubsystem extends SubsystemBase {
    /*
     * The motor used for the dropbox is an FTC REV motor
     */
    // TODO: change this to the correct motor controller
    //private final Spark m_dropboxMotor = new Spark(DropboxConstants.kPortPWM_DropboxMotor);

    /** Creates a new DropboxSubsystem and disables the motor. 
    public DropboxSubsystem() {
        setDefaultCommand(
                runOnce(() -> m_dropboxMotor.disable())
                .andThen(run(() -> {})));
    }


    /*
     * TODO: these functions may need to swap depending on what direction the positive power drives the motor
     */
    /**
    * Command to open the dropbox
    
    public Command OpenDropbox() {
      return run(() -> m_dropboxMotor.set(
                  DropboxConstants.kDropboxSpeed));
    }

    /**
    * Command to close the dropbox
    
    public Command CloseDropbox() {
      return run(() -> m_dropboxMotor.set(
                  DropboxConstants.kDropboxSpeed * -1));
    }*/
}
