// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import org.opencv.features2d.FlannBasedMatcher;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

public class GroundIntake extends SubsystemBase {
    /** Creates a new GroundIntake. */
  CommandXboxController m_OperatorController = new CommandXboxController(Constants.OperatorConstants.kOperatorControllerPort);

    /*  Motor Declaration */
  WPI_TalonSRX upperMotor = new WPI_TalonSRX(Constants.DeviceIds.kLeftGroundIntake);
  WPI_TalonSRX lowerMotor = new WPI_TalonSRX(Constants.DeviceIds.kRightGroundIntake);

  public GroundIntake() {
      /*  Motor Configuration */

        /*  Motor control */
      //  Set motors Inverted
    upperMotor.setInverted(false);
    lowerMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void bufferNote(){
    //  Set motors buffer the note through constants
    upperMotor.set(TalonSRXControlMode.PercentOutput,
      Constants.GroundIntakeConstants.kIdleConstant);

    lowerMotor.set(TalonSRXControlMode.PercentOutput,
    Constants.GroundIntakeConstants.kIntakeNote);
   }
  public void intakeNote(){
    //  Set motors to the intake speed from constants
    upperMotor.set(TalonSRXControlMode.PercentOutput,
      Constants.GroundIntakeConstants.kIntakeNote);

    lowerMotor.set(TalonSRXControlMode.PercentOutput,
    Constants.GroundIntakeConstants.kIntakeNote);
    }
  public void stopIntake(){
    //  Set motors to the zero constant
    upperMotor.set(TalonSRXControlMode.PercentOutput,
      Constants.GroundIntakeConstants.kStopMotor);

    lowerMotor.set(TalonSRXControlMode.PercentOutput,
    Constants.GroundIntakeConstants.kStopMotor);
  }
  public void feedNote(){

    upperMotor.set(TalonSRXControlMode.PercentOutput,
    Constants.GroundIntakeConstants.kFullSend);

    lowerMotor.set(TalonSRXControlMode.PercentOutput,
    Constants.GroundIntakeConstants.kFullSend);    
  }
  public void spitOutNote(){

    upperMotor.set(TalonSRXControlMode.PercentOutput,
    - Constants.GroundIntakeConstants.kFullSend);

    lowerMotor.set(TalonSRXControlMode.PercentOutput,
   -  Constants.GroundIntakeConstants.kFullSend);       
  }
}
