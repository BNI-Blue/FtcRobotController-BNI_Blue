package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class MecanumDrive {

    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;

    public static final double TICKS_PER_ROTATION = 386.3;

    public LinearOpMode LinearOp = null;

    //Default Constructor
    public MecanumDrive(){
    }


    //Helper Method for Linear Op
    public void setLinearOp(LinearOpMode LinearOp) { this.LinearOp = LinearOp;}

    public void setMotorRunModes(DcMotor.RunMode mode) {
        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    //Basic Drive Methods

    public void stopMotors(){
        frontLeftMotor.setPower(0);
    }
}


