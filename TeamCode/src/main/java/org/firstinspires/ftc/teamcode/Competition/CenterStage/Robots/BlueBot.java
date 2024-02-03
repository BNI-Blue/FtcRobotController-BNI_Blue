package org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains.MecanumDrive;


    public class BlueBot extends MecanumDrive {

        // Hardware Mapping Variables
        public HardwareMap hwBot = null;

        // Pixel Arm Variables
        public DcMotor pixelArm = null;
        public DcMotor pixelArmRotator = null;
        public Servo pixelClawLeft = null;
        public Servo pixelClawRight = null;
        public Servo pixelWrist = null;

        // End Game Arm Variables
        public DcMotor endgameArm = null;
        public CRServo endGameRotator = null;


        //Airplane Launcher Variables
        public DcMotor planeLaunch = null;
        public Servo planePusher = null;

        public double airplanePusher_Rest = 1.0;
        public double airplanePusher_Launch = 0.8;

        //Gyro Variables
        public Orientation angles;
        public Acceleration gravity;
        public final double SPEED = .3;
        public final double TOLERANCE = .4;

        // LED Variables
        RevBlinkinLedDriver blinkinLedDriver;

        // Declaration of Gyro Variables
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.LEFT;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.UP;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        // Constructors
        public BlueBot(){}

        // Initialization Method
        public void initRobot(HardwareMap hwMap) {
            hwBot = hwMap;

            // Drivetrain Motors HW Mapping
            frontLeftMotor = hwBot.dcMotor.get("front_left_motor");//Port 0 - Control
            frontRightMotor = hwBot.dcMotor.get("front_right_motor");//Port 1 - Control
            rearLeftMotor = hwBot.dcMotor.get("rear_left_motor");//Port 2 - Control
            rearRightMotor = hwBot.dcMotor.get("rear_right_motor");//Port 3 - Control

            frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
            rearLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
            rearRightMotor.setDirection(DcMotor.Direction.REVERSE);

            setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            // Pixel Arm Extension Mechanism HW Mapping
            pixelArm = hwBot.dcMotor.get("pixel_arm");//Port 0 - Expansion
            pixelArm.setDirection(DcMotor.Direction.FORWARD);
            pixelArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            // Pixel Arm Rotational Mechanism HW Mapping
            //worm gear

            pixelArmRotator = hwBot.dcMotor.get("pixel_arm_rotator");//Port 2 - Expansion
            pixelArmRotator.setDirection(DcMotor.Direction.FORWARD); //check direction b/f testing
            pixelArmRotator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            pixelArmRotator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            pixelArmRotator.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


            //Pixel Claw Mechanism HW Mapping/
            pixelClawLeft = hwBot.servo.get("pixel_claw_left");//Port 0 - Expansion
            pixelClawLeft.setDirection(Servo.Direction.REVERSE);
            pixelClawRight = hwBot.servo.get("pixel_claw_right");//Port 1 - Expansion
            pixelClawRight.setDirection(Servo.Direction.FORWARD);


            //Pixel Wrist HW Mapping
            //pixelWrist = hwBot.servo.get("pixel_wrist");//Port 2 - Expansion
            //pixelWrist.setDirection(Servo.Direction.FORWARD);

            // End Game Rotational Mechanism (Servo and Motor) HW Mapping
            endGameRotator = hwBot.crservo.get("end_game_rotator");//Port 5 - Expansion
            endGameRotator.setDirection(CRServo.Direction.FORWARD);

            // End Game Arm Lifting HW Mapping
            endgameArm = hwBot.dcMotor.get("end_game_arm");//Port 1 - Expansion
            endgameArm.setDirection(DcMotorSimple.Direction.FORWARD);
            endgameArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            // End game airplane launcher
            planeLaunch = hwBot.dcMotor.get("plane_launcher");//Port 3 - Expansion
            planeLaunch.setDirection(DcMotorSimple.Direction.FORWARD);
            planeLaunch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            planePusher = hwBot.servo.get("plane_pusher");//Port 2 - Expansion
            planePusher.setDirection(Servo.Direction.REVERSE);
            //restAirPlanePusher();

            //LED Control
            blinkinLedDriver = hwBot.get(RevBlinkinLedDriver.class, "led");
            blinkinLedDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLACK);

            closePixelClaw();


            // Gyro Initiatlization
            imu = hwBot.get(IMU.class, "imu");
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

        public void extendPixelArm(double speed, double ticks) {

            pixelArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            pixelArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            while ((Math.abs(pixelArm.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
                extendPixelArm(speed);
            }
            stopPixelArm();
        }

        public void retractPixelArm(double speed, double ticks){

            pixelArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            pixelArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            while ((Math.abs(pixelArm.getCurrentPosition()) < ticks && LinearOp.opModeIsActive()) ) {
                retractPixelArm(speed);
            }
            stopPixelArm();
        }

        // ************* Pixel Claw Open & Close ********************
        public void openPixelClaw(){
            pixelClawLeft.setPosition(0.6);    //0.552233
            pixelClawRight.setPosition(0.7);   //0.586
        }
        public void closePixelClaw(){
            pixelClawLeft.setPosition(0.71);    //0.71
            pixelClawRight.setPosition(0.8);   //0.78
        }
        public void openPixelClawLeft(){
            pixelClawLeft.setPosition(0.55);
        }
        public void openPixelClawRight(){ pixelClawRight.setPosition(0.65);
        }
        public void closePixelClawLeft(){
            pixelClawLeft.setPosition(0.70);
        }
        public void closePixelClawRight(){ pixelClawRight.setPosition(0.8);
        }

//        //************** Pixel Wrist Up & Down ******************
//        public void rotatePixelWristUp(){
//            pixelWrist.setPosition(0.4);
//        }
//        public void rotatePixelWristDown(){
//            pixelWrist.setPosition(0.1);
//        }

        // **********  Pixel Arm Rotating Methods  ************

        public void rotatePixelArmUp(double power) {pixelArmRotator.setPower(Math.abs(power));
        }
        public void rotatePixelArmDown(double power) {
            pixelArmRotator.setPower(-Math.abs(power));
        }

        public void stopPixelArmRotation() {
            pixelArmRotator.setPower(0);
        }

        public void rotatePixelArmUp(double speed, double ticks) {

            pixelArmRotator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            pixelArmRotator.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            while ((Math.abs(pixelArmRotator.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
                rotatePixelArmUp(speed);
            }
            stopPixelArmRotation();
        }

        public void rotatePixelArmDown(double speed, double ticks){

            pixelArmRotator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            pixelArmRotator.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            while((Math.abs(pixelArmRotator.getCurrentPosition()) < ticks && LinearOp.opModeIsActive()) ){
                rotatePixelArmDown(speed);
            }
            stopPixelArmRotation();
        }

//        public void dropPixelBackdrop(double speed, double ticks) {
//            double power = 0.5;
//            double ticks = 749;
//
//            pixelArmRotator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            pixelArmRotator.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//
//            while ((Math.abs(pixelArmRotator.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
//                pixelArmRotator.setPower(speed);
//            }
//            pixelArmRotator.setPower(0);
//        }



        // ********** End Game Arm Rotating Methods **********
        public void rotateEndGameArmUp(double position) {
            endGameRotator.setPower(-1);

        }

        public void rotateEndGameArmDown (double position) {endGameRotator.setPower(1);
        }

        public void rotateEndGameArmStop (double position) {endGameRotator.setPower(0);
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

        // *********** Airplane Launcher Methods **************
        public void launchAirPlane(double power) {
            planeLaunch.setPower(power);
        }
        public void stopPlane(){
            planeLaunch.setPower(0);
        }

        public void launchAirPlanePusher () {
            planePusher.setPosition(airplanePusher_Launch);
        }

        public void restAirPlanePusher () {
            planePusher.setPosition(airplanePusher_Rest);
        }




    }

