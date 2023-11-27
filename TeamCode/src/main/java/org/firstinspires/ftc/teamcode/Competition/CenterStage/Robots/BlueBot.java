package org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
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
        public Servo endGameRotator = null;

        //Airplane Launcher Variables
        public DcMotor planeLaunch = null;

        //Gyro Variables
        public BNO055IMU imu;
        public Orientation angles;
        public Acceleration gravity;
        public final double SPEED = .3;
        public final double TOLERANCE = .4;


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

            //Pixel Claw Mechanism HW Mapping/
            pixelClawLeft = hwBot.servo.get("pixel_claw_left");//Port 0 - Expansion
            pixelClawLeft.setDirection(Servo.Direction.FORWARD);
            pixelClawRight = hwBot.servo.get("pixel_claw_right");//Port 1 - Expansion
            pixelClawRight.setDirection(Servo.Direction.FORWARD);



            //Pixel Wrist HW Mapping
            pixelWrist = hwBot.servo.get("pixel_wrist");//Port 2 - Expansion
            pixelWrist.setDirection(Servo.Direction.FORWARD);

            // End Game Rotational Mechanism (Servo and Motor) HW Mapping
            endGameRotator = hwBot.servo.get("end_game_rotator");//Port 3 - Expansion
            endGameRotator.setDirection(Servo.Direction.FORWARD);

            // End Game Arm Lifting HW Mapping
            endgameArm = hwBot.dcMotor.get("end_game_arm");//Port 1 - Expansion
            endgameArm.setDirection(DcMotorSimple.Direction.FORWARD);
            endgameArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            planeLaunch = hwBot.dcMotor.get("plane_launcher");//Port_ - ______
            planeLaunch.setDirection(DcMotorSimple.Direction.FORWARD);
            planeLaunch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

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

        // ************* Pixel Claw Open & Close ********************
        public void openPixelClaw(){
            pixelClawLeft.setPosition(0.592);    //0.592
            pixelClawRight.setPosition(0.269);   //0.269
        }
        public void closePixelClaw(){
            pixelClawLeft.setPosition(0.468);    //0.468
            pixelClawRight.setPosition(0.367);   //0.367
        }

        //************** Pixel Wrist Up & Down ******************
        public void rotatePixelWristUp(){
            pixelWrist.setPosition(0.4);
        }
        public void rotatePixelWristDown(){
            pixelWrist.setPosition(0.1);
        }

        // **********  Pixel Arm Rotating Methods  ************

        public void rotatePixelArmUp(double power) {pixelArmRotator.setPower(Math.abs(power));
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

        public void rotateEndGameArmDown (double position) {endGameRotator.setPosition(position);
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
            planeLaunch.setPower(Math.abs(power));
        }
        public void stopPlane(){
            planeLaunch.setPower(0);
        }




    }

