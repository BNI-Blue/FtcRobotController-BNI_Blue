package org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains.MecanumDrive;

public class CompBot_Blue extends MecanumDrive {


    public HardwareMap hwBot = null;

    public DcMotor viperSlide = null;
    public DcMotor wormGear = null;
    public DcMotor hangHook = null;

    public Servo hingeHook= null;

    public ElapsedTime currentTime = new ElapsedTime();

    public ElapsedTime timer = new ElapsedTime();


    public BNO055IMU imu;
    public Orientation angles;
    public Acceleration gravity;
    public final double SPEED = .3;
    public final double TOLERANCE = .4;

    public CompBot_Blue(){}

    public void initRobot(HardwareMap hwMap) {
        hwBot = hwMap;

        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");
        rearLeftMotor = hwBot.dcMotor.get("rear_left_motor");
        rearRightMotor = hwBot.dcMotor.get("rear_right_motor");

        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotor.Direction.REVERSE);

        //Initialize Motor Run Mode for Robot
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        hingeHook = hwBot.get(Servo.class,"hinge_hook");
        hingeHook.setDirection(Servo.Direction.FORWARD); //check direction b4 testing


        viperSlide = hwBot.dcMotor.get("viper_slide");
        viperSlide.setDirection(DcMotorSimple.Direction.FORWARD);
        viperSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        wormGear = hwBot.dcMotor.get("worm_gear");
        wormGear.setDirection(DcMotor.Direction.FORWARD);  //check direction b4 testing
        wormGear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        hangHook = hwBot.dcMotor.get("linear_lift");
        hangHook.setDirection(DcMotorSimple.Direction.FORWARD); //check direction b4 testing
        hangHook.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        currentTime.reset();


//            BNO055IMU.Parameters parametersimu = new BNO055IMU.Parameters();
//            parametersimu.angleUnit = BNO055IMU.AngleUnit.DEGREES;
//            parametersimu.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
//            parametersimu.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
//
//            parametersimu.loggingEnabled = true;
//            parametersimu.loggingTag = "IMU";
//            parametersimu.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
//
//            imu = hwBot.get(BNO055IMU.class, "imu");
//            imu.initialize(parametersimu);


    }

    //methods for the pixel claw

    public void extendClaw(double power) {

        viperSlide.setPower(Math.abs(power));
    }

    public void retractClaw(double power) {

        viperSlide.setPower(-Math.abs(power));
    }

    //pixel claw
    public void extendClaw(double power, double rotations)  {
        double ticks = rotations * (1) * TICKS_PER_ROTATION;
        viperSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (Math.abs(viperSlide.getCurrentPosition()) > ticks && LinearOp.opModeIsActive()) {
            extendClaw(power);
        }
        stopClaw();
    }

    public void retractClaw(double power, double rotations) {
        double ticks = rotations * (-1) *TICKS_PER_ROTATION;
        viperSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (Math.abs(viperSlide.getCurrentPosition())< ticks && LinearOp.opModeIsActive()) {
            retractClaw(power);
        }
        stopClaw();
    }

    public void stopClaw() {
        viperSlide.setPower(0);
    }

    //methods for the worm gear/up and down for pixel claw
    public void raiseWormGear (double power) {
        wormGear.setPower(Math.abs(power));
    }

    public void lowerWormGear (double power) {
        wormGear.setPower(-Math.abs(power));
    }

    public void raiseWormGear(double power, double rotations){
        double ticks = rotations * (1) * TICKS_PER_ROTATION;
        wormGear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wormGear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (Math.abs(wormGear.getCurrentPosition()) > ticks && LinearOp.opModeIsActive()) {
            raiseWormGear(power);
        }
        stopWormGear();
    }

    public void lowerWormGear(double power, double rotations){
        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        wormGear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wormGear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (Math.abs(wormGear.getCurrentPosition()) < ticks && LinearOp.opModeIsActive()) {
            lowerWormGear(power);
        }
        stopWormGear();
    }

    public void stopWormGear() {
        wormGear.setPower(0);
    }


    //methods for the hang hook
    public void extendHangHook(double power) {
        hangHook.setPower(Math.abs(power));
    }

    public void retractHangHook(double power){
        hangHook.setPower(-Math.abs(power));
    }

    public void extendHangHook(double power, double rotations){
        double ticks = rotations * (1) * TICKS_PER_ROTATION;
        hangHook.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hangHook.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (Math.abs(hangHook.getCurrentPosition()) > ticks && LinearOp.opModeIsActive()){
            extendHangHook(power);
        }
    }

    public void retractHangHook(double power, double rotations){
        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        hangHook.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hangHook.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (Math.abs(hangHook.getCurrentPosition()) < ticks && LinearOp.opModeIsActive()){
            retractHangHook(power);
        }
    }

    public void stopHangHook() {
        hangHook.setPower(0);
    }

     public void openHook (){
        hingeHook.setPosition(0.5); //check position
     }

     public void closeHook (){
        hingeHook.setPosition(0); //check position
     }


}
