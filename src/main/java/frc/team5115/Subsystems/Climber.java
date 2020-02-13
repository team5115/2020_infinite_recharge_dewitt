package frc.team5115.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.team5115.Constants.SCISSOR_MOTOR_ID;
import static frc.team5115.Constants.WINCH_MOTOR_ID;

public class Climber extends SubsystemBase {
    TalonSRX winch;
    TalonSRX scissor;
    double climbspeed = -0.75;

    public Climber(){
        winch = new TalonSRX(WINCH_MOTOR_ID);
        scissor = new TalonSRX(SCISSOR_MOTOR_ID);
        setDefaultCommand(new RunCommand(this::StopClimb).perpetually());
    }
    //0.75 speed is pulling up for the winch

    public void ScissorUp(){
        scissor.set(ControlMode.PercentOutput, -1);
    }

    public void ScissorDown(){
        scissor.set(ControlMode.PercentOutput, -climbspeed);
    }

    public void WinchDown(){
        winch.set(ControlMode.PercentOutput, climbspeed);
    }

    public void StopClimb() {
        scissor.set(ControlMode.PercentOutput, 0);
        winch.set(ControlMode.PercentOutput, 0);
    }

}
