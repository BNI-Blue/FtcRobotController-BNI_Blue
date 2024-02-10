package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;


public class Calibration_Wheels extends OpMode {

    public enum driveStates {
        STOP,
        CALIBRATE_FORWARD, CALIBRATE_BACK, CALIBRATE_LEFT, CALIBRATE_RIGHT,
        NORMALIZED_FORWARD, NORMALIZED_BACK, NORMALIZED_LEFT, NORMALIZED_RIGHT
    }

    driveStates driveState = driveStates.STOP;

    public double encoderAvg = 0;

    public double targetCalibrationTicks = 10000;

    public double speedCalibration = 0.5;

    public double FLM_error = 0;
    public double FRM_error = 0;
    public double RLM_error = 0;
    public double RRM_error = 0;
    public double FLM_normalized_speed = 0;
    public double FRM_normalized_speed = 0;
    public double RLM_normalized_speed = 0;
    public double RRM_normalized_speed = 0;
    public boolean[] Calibrated = {false, false, false, false};


    double leftStickYVal;
    double leftStickXVal;
    double rightStickXVal;
    double rightStickYVal;

    double frontLeftSpeed;
    double frontRightSpeed;
    double rearLeftSpeed;
    double rearRightSpeed;

    double powerThreshold = 0;
    double speedMultiply = 1;

    public double pixelArmRotatorPower = 0.95;
    public double pixelArmPower = 0.7;
    public double endGameArmPower = 1;
    public double endGameUpPosition = 1;
    public double endGameDownPosition = 0;

    // Construct the physical robot object
    public org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot Bot = new BlueBot();



    /**
     * User-defined init method
     * <p>
     * This method will be called once, when the INIT button is pressed.
     */
    @Override
    public void init() {

        /*

        Was considering this to be a true standalone Calibration TeleOp.

        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("rear_left_motor");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("rear_right_motor");

         */

        Bot.initRobot(hardwareMap);

        setMotorModes();
    }

    public void init_loop() {}

    public void start() {}

    /**
     * User-defined loop method
     * <p>
     * This method will be called repeatedly during the period between when
     * the play button is pressed and when the OpMode is stopped.
     */
    @Override
    public void loop() {
        motorNormalization();
        driveChoice();
        driveMotorsMove();
        displayTelemetry();
    }

    private void driveChoice () {
//           Drive Forward
        if (gamepad1.y) {
            setMotorModes ();
            driveState = driveStates.CALIBRATE_FORWARD;
        }
//            Drive Backward
        if (gamepad1.a) {
            setMotorModes ();
            driveState = driveStates.CALIBRATE_BACK;
        }
//            Strafe Left
        if (gamepad1.x) {
            setMotorModes ();
            driveState = driveStates.CALIBRATE_LEFT;
        }
//            Strafe Right
        if (gamepad1.b) {
            setMotorModes ();
            driveState = driveStates.CALIBRATE_RIGHT;
        }

//            Test Normalized Drive Forward
        if (gamepad2.y && Calibrated[0]) {
            setMotorModes ();
            driveState = driveStates.NORMALIZED_FORWARD;
        }
//            Test Normalized Drive Backward
        if (gamepad2.a && Calibrated[1]) {
            setMotorModes ();
            driveState = driveStates.NORMALIZED_BACK;
        }
//            Test Normalized Strafe Left
        if (gamepad2.x && Calibrated[2]) {
            setMotorModes ();
            driveState = driveStates.NORMALIZED_LEFT;
        }
//            Test Normalized Strafe Right
        if (gamepad2.b && Calibrated[3]) {
            setMotorModes ();
            driveState = driveStates.NORMALIZED_RIGHT;
        }
    }

    private void driveMotorsMove () {
//        Switch will dictate which way motors move.
//         Calibrate_DRIVE == running motors for "targetCalibrationTicks" ticks
//        Goal to to see how each motor moves in relation to the Average.
        switch (driveState) {
            case STOP:
                Bot.stopMotors();
                break;
            case CALIBRATE_FORWARD:
                telemetry.addData("Calibrating: ", driveState);
                if (encoderAvg < targetCalibrationTicks) {
                    Bot.driveForward(speedCalibration);
                }
                else {
                    Calibrated[0] = true;
                    driveState = driveStates.STOP;
                }
                break;
            case CALIBRATE_BACK:
                telemetry.addData("Calibrating: ", driveState);
                if (encoderAvg < targetCalibrationTicks) {
                    Bot.driveBack(speedCalibration);
                }
                else {
                    Calibrated[1] = true;
                    driveState = driveStates.STOP;
                }
                break;
            case CALIBRATE_LEFT:
                telemetry.addData("Calibrating: ", driveState);
                if (encoderAvg < targetCalibrationTicks) {
                    Bot.strafeLeft(speedCalibration);
                }
                else {
                    Calibrated[2] = true;
                    driveState = driveStates.STOP;
                }
                break;
            case CALIBRATE_RIGHT:
                telemetry.addData("Calibrating: ", driveState);
                if (encoderAvg < targetCalibrationTicks) {
                    Bot.strafeRight(speedCalibration);
                }
                else {
                    Calibrated[3] = true;
                    driveState = driveStates.STOP;
                }
                break;
            case NORMALIZED_FORWARD:
                telemetry.addData("Testing Normalized Motors: ", driveState);
                if (encoderAvg < targetCalibrationTicks) {
                    driveForward_Normalized();

                }
                else {
                    driveState = driveStates.STOP;
                }
                break;
            case NORMALIZED_BACK:
                telemetry.addData("Testing Normalized Motors: ", driveState);
                if (encoderAvg < targetCalibrationTicks) {
                    driveBack_Normalized();
                }
                else {
                    driveState = driveStates.STOP;
                }
                break;
            case NORMALIZED_LEFT:
                telemetry.addData("Testing Normalized Motors: ", driveState);
                if (encoderAvg < targetCalibrationTicks) {
                    strafeLeft_Normalized();
                }
                else {
                    driveState = driveStates.STOP;
                }
                break;
            case NORMALIZED_RIGHT:
                telemetry.addData("Testing Normalized Motors: ", driveState);
                if (encoderAvg < targetCalibrationTicks) {
                    strafeRight_Normalized();
                }
                else {
                    driveState = driveStates.STOP;
                }
                break;
            default:
                telemetry.addLine("MAKE SURE YOUR CASE HAS 'BREAK'");
                break;
        }
    }

    //    NOT USED, for future consideration of passing parameters to consolidate code.
    private void drive (double encoderAvg, driveStates driveState) {
        if (encoderAvg < targetCalibrationTicks) {
            Bot.driveForward(speedCalibration);
        }
        else {
            driveState = driveStates.STOP;
        }
    }

    private void setMotorModes () {
        Bot.setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Bot.setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private void motorNormalization () {
//        What is our average encoder ticks?
//        Each motor must have an Encoder Wire hooked up to work!
        encoderAvg = (double)(
                Math.abs(Bot.frontLeftMotor.getCurrentPosition()) +
                        Math.abs(Bot.frontRightMotor.getCurrentPosition()) +
                        Math.abs(Bot.rearLeftMotor.getCurrentPosition()) +
                        Math.abs(Bot.rearLeftMotor.getCurrentPosition()))
                / 4;
//        We want to know how far a motor has gone in relation to all the encoders.
//        Closer to 1 == closer to average
//        > 1 == motor is moving FASTER in relation to other motors
//        < 1 == motor is moving SLOWER in relation to other motors.
        FLM_error = (Bot.frontLeftMotor.getCurrentPosition() / encoderAvg);
        FRM_error = (Bot.frontRightMotor.getCurrentPosition() / encoderAvg);
        RLM_error = (Bot.rearLeftMotor.getCurrentPosition()/ encoderAvg);
        RRM_error = (Bot.rearRightMotor.getCurrentPosition() / encoderAvg);
//        ###_normalized_speed == what power our motors should run at based on the ###_Error found above.
        FLM_normalized_speed = (targetCalibrationTicks / FLM_error) * speedCalibration;
        FRM_normalized_speed = (targetCalibrationTicks / FRM_error) * speedCalibration;;
        RLM_normalized_speed = (targetCalibrationTicks / RLM_error) * speedCalibration;;
        RRM_normalized_speed = (targetCalibrationTicks / RRM_error) * speedCalibration;;
    }


    //    Set each motor speed independently.
    public void driveForward_Normalized () {
        Bot.frontLeftMotor.setPower(FLM_normalized_speed);
        Bot.frontRightMotor.setPower(FRM_normalized_speed);
        Bot.rearLeftMotor.setPower(RLM_normalized_speed);
        Bot.rearRightMotor.setPower(RRM_normalized_speed);
    }

    public void driveBack_Normalized () {
        Bot.frontLeftMotor.setPower(-FLM_normalized_speed);
        Bot.frontRightMotor.setPower(-FRM_normalized_speed);
        Bot.rearLeftMotor.setPower(-RLM_normalized_speed);
        Bot.rearRightMotor.setPower(-RRM_normalized_speed);
    }

    public void strafeLeft_Normalized () {
        Bot.frontLeftMotor.setPower(-FLM_normalized_speed);
        Bot.frontRightMotor.setPower(FRM_normalized_speed);
        Bot.rearLeftMotor.setPower(RLM_normalized_speed);
        Bot.rearRightMotor.setPower(-RRM_normalized_speed);
    }

    public void strafeRight_Normalized () {
        Bot.frontLeftMotor.setPower(FLM_normalized_speed);
        Bot.frontRightMotor.setPower(-FRM_normalized_speed);
        Bot.rearLeftMotor.setPower(-RLM_normalized_speed);
        Bot.rearRightMotor.setPower(RRM_normalized_speed);
    }

    private void displayTelemetry () {
        telemetry.addData("Encoder Average", encoderAvg);
        telemetry.addData("TARGET SPEED (use in relation to Speeds below)", speedCalibration);
        telemetry.addData("Front_Left_Wheel + Speed", Bot.frontLeftMotor.getCurrentPosition() + " - " + FLM_error);
        telemetry.addData("Front_Right_Wheel + Speed", Bot.frontRightMotor.getCurrentPosition() + " - " + FRM_error);
        telemetry.addData("Rear_Left_Wheel + Speed", Bot.rearLeftMotor.getCurrentPosition()  + " - " + RLM_error);
        telemetry.addData("Rear_Right_Wheel + Speed", Bot.rearRightMotor.getCurrentPosition() + " - " + RRM_error);
        telemetry.addData("Have any Calibrations finished?", Calibrated[0] + ", " + Calibrated[1] + " " + Calibrated[2] + " " + Calibrated[3]);
    }
}
