// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

public class GroundIntake extends SubsystemBase {
  /** Creates a new GroundIntake. */
CommandXboxController m_OperatorController = new CommandXboxController(Constants.OperatorConstants.kOperatorControllerPort);

/*  Motor Declaration */
Talon upperMotor = new Talon(Constants.DeviceIds.kUpperMotorId);
Talon lowerMotor = new Talon(Constants.DeviceIds.kLowerMotorId);

  public GroundIntake() {
    
    /*  Motor Configuration */

    // Motor Safety
    upperMotor.setSafetyEnabled(false);
    lowerMotor.setSafetyEnabled(false);

    /*  Motor control */
    //  Set motors Inverted
    upperMotor.setInverted(true);
    lowerMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void bufferNote(){
    //  Set motors buffer the note through constants
    upperMotor.set(Constants.GroundIntakeConstants.kStopMotor);
    lowerMotor.set(Constants.GroundIntakeConstants.kIdleConstant);
   }
  public void intakeNote(){
    //  Set motors to the intake speed from constants
    upperMotor.set(Constants.GroundIntakeConstants.kIntakeNote);
    lowerMotor.set(Constants.GroundIntakeConstants.kIntakeNote);
    }
  public void stopIntake(){
    //  Set motors to the zero constant
    upperMotor.set(Constants.GroundIntakeConstants.kStopMotor);
    upperMotor.set(Constants.GroundIntakeConstants.kStopMotor);
  }
}
