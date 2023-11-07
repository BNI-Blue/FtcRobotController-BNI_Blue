package org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains.MecanumDrive;

public class ProgramBot extends MecanumDrive {

    // Hardware Mapping Variables
    public HardwareMap hwBot = null;

    //Gyro Variables
    public BNO055IMU imu;
    public Orientation angles;
    public Acceleration gravity;
    public final double SPEED = .3;
    public final double TOLERANCE = .4;


    // Constructors
    public ProgramBot(){}

    // Initialization Method
    public void initRobot(HardwareMap hwMap) {
        hwBot = hwMap;

        // Drivetrain Motors HW Mapping
        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");//Port 0 - Control
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");//Port 1 - Control
        rearLeftMotor = hwBot.dcMotor.get("rear_left_motor");//Port 2 - Control
        rearRightMotor = hwBot.dcMotor.get("rear_right_motor");//Port 3 - Control

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    //AUTONOMOUS END GAME ARM PLACEHOLDER
    public void autoArmInitPos(){}
    public void autoArmStartPos(){}


}

