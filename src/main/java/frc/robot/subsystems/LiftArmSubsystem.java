// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants.ArmConstants;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class LiftArmSubsystem extends SubsystemBase {
  /** Main arm motor are using a NEO motor connected with CAN */
  private SparkMax m_armLiftMotor = new SparkMax(ArmConstants.kCanid_ArmLift, MotorType.kBrushless);

  public LiftArmSubsystem() {
    // Default lift arm command is to turn off the motor and stay idle
    setDefaultCommand(
        runOnce(() -> m_armLiftMotor.disable()).andThen(run(() -> {
        })));
  }

  public Command moveArmCommand(boolean forwardDirection) {
    // main command for moving the lift arm in either direction
    if (forwardDirection) {
      return run(() -> m_armLiftMotor.set(ArmConstants.kArmSpeed));
    } else {
      return run(() -> m_armLiftMotor.set(ArmConstants.kArmSpeed * -1));
    }
  }
}
