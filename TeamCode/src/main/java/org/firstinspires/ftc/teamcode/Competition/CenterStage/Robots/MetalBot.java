package org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains.MecanumDrive;

public class MetalBot extends MecanumDrive {


    // Robot Hardware Constructors
    public HardwareMap hwBot  =  null;

    // Declaration of Timer Variables
    public ElapsedTime currentTime = new ElapsedTime();

    public ElapsedTime timer = new ElapsedTime();
    double waitTime = 2.0;

    // Declaration of Gyro Variables
    public BNO055IMU imu;
    public Orientation angles;
    public Acceleration gravity;
    public final double SPEED = .3;
    public final double TOLERANCE = .4;

    //MechBot Constructor
    public MetalBot() {}

    // Initializing Hardware for Robot
    public void initRobot(HardwareMap hwMap) {

        hwBot = hwMap;

        // Define Motors for Robot
        frontLeftMotor = hwMap.get(DcMotorEx.class, "front_left_motor");
        frontRightMotor = hwMap.get(DcMotorEx.class, "front_right_motor");
        rearLeftMotor = hwMap.get(DcMotorEx.class, "rear_left_motor");
        rearRightMotor = hwMap.get(DcMotorEx.class, "rear_right_motor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);


        //Initialize Motor Run Mode for Robot
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//        //Timer Reset
//        currentTime.reset();

    }


}
