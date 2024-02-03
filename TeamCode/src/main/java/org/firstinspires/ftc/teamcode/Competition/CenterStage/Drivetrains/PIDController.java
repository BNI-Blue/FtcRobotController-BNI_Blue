package org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains;

public class PIDController {
    private double kp, ki, kd;
    private double previousError, integralSum;
    private double setpoint;

    public PIDController(double kp, double ki, double kd) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
        reset();
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public double calculate(double actual, double deltaTime) {
        double error = setpoint - actual;
        integralSum += error * deltaTime;
        double derivative = (error - previousError) / deltaTime;
        previousError = error;
        return kp * error + ki * integralSum + kd * derivative;
    }

    public void reset() {
        previousError = 0;
        integralSum = 0;
    }

}
