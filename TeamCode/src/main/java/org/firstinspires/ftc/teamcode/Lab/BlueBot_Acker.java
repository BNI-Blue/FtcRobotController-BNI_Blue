package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


public class BlueBot_Acker extends MecanumDrive_Acker {

        // Hardware Mapping Variables
        public HardwareMap hwBot = null;

        // Pixel Arm Variables
        public DcMotor pixelArm = null;
        public DcMotor pixelArmRotator = null;
        public Servo pixelClaw = null;

        // End Game Arm Variables
        public DcMotor endgameArm = null;
        public Servo endGameRotator = null;

        //Gyro Variables

        public IMU imu  = null;
        public double headingError  = 0;
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

    // Now initialize the IMU with this mounting orientation
    // This sample expects the IMU to be in a REV Hub and named "imu".
    // GitHub Sync Test


        // Constructors
        public BlueBot_Acker(){}

        // Initialization Method
        public void initRobot(HardwareMap hwMap) {
            hwBot = hwMap;

            // Drivetrain Motors HW Mapping
            frontLeftMotor = hwBot.dcMotor.get("front_left_motor");
            frontRightMotor = hwBot.dcMotor.get("front_right_motor");
            rearLeftMotor = hwBot.dcMotor.get("rear_left_motor");
            rearRightMotor = hwBot.dcMotor.get("rear_right_motor");

            frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            rearLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
            rearRightMotor.setDirection(DcMotor.Direction.REVERSE);

            setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            // Pixel Arm Extension Mechanism HW Mapping
            pixelArm = hwBot.dcMotor.get("pixel_arm");
            pixelArm.setDirection(DcMotor.Direction.FORWARD);
            pixelArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            // Pixel Arm Rotational Mechanism HW Mapping
            pixelArmRotator = hwBot.dcMotor.get("pixel_arm_rotator");
            pixelArmRotator.setDirection(DcMotor.Direction.FORWARD); //check direction b/f testing
            pixelArmRotator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            //Pixel Claw Mechanism HW Mapping
            pixelClaw = hwBot.servo.get("pixel_claw");
            endGameRotator.setDirection(Servo.Direction.FORWARD);

            // End Game Rotational Mechanism (Servo and Motor) HW Mapping
            endGameRotator = hwBot.servo.get("end_game_rotator");
            endGameRotator.setDirection(Servo.Direction.FORWARD);

            // End Game Arm Lifting HW Mapping
            endgameArm = hwBot.dcMotor.get("end_game_arm");
            endgameArm.setDirection(DcMotorSimple.Direction.FORWARD);
            endgameArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            // Gyro
            imu = hwBot.get(IMU .class, "imu");
            imu.initialize(new IMU.Parameters(orientationOnRobot));

        }

        // ********** Pixel Arm Extension, Retraction, and Stoppage Methods **********
        public void extendPixelArm(double power) {
            pixelArm.setPower(-Math.abs(power));
        }

        public void retractPixelArm(double power) {
            pixelArm.setPower(Math.abs(power));
        }

        public void stopPixelArm() {
            pixelArm.setPower(0);
        }

        // **********  Pixel Arm Rotating Methods  ************

        public void rotatePixelArmUp(double power) {
            pixelArmRotator.setPower(Math.abs(power));
        }

        public void rotatePixelArmDown(double power) {
            pixelArmRotator.setPower(-Math.abs(power));
        }

        public void stopPixelArmRotation() {
            pixelArmRotator.setPower(0);
        }

        // ********** End Game Arm Rotating Methods **********
        public void rotateEndGameArmUp(double position) {
            endGameRotator.setPosition(position);
        }

        public void rotateEndGameArmDown (double position) {
          endGameRotator.setPosition(position);
        }

        // ********** End Game Arm Extension and Lifting Methods **********
        public void extendEndGameArm(double power){
            endgameArm.setPower(Math.abs(power));
        }

        public void retractEndGameArm(double power){
            endgameArm.setPower(-Math.abs(power));
        }

        public void stopEndGameArm(){
            endgameArm.setPower(0);
        }

}
