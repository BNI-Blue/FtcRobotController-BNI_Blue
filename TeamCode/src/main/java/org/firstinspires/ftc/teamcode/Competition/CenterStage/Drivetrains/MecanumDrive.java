package org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

public class MecanumDrive extends OpMode {
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;


    public LinearOpMode LinearOp = null;

    public static final double TICKS_PER_ROTATION = 386.3;

    public IMU imu = null;
    public double headingTolerance = 0.5;
    public double currentHeading = 0;


    public MecanumDrive() {

    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }

    public void setLinearOp(LinearOpMode LinearOp) {this.LinearOp = LinearOp;}


    public void gyroCorrection(double speed, double targetAngle) {
        imu.resetYaw();
        currentHeading = getHeading();
        if (currentHeading >= targetAngle + headingTolerance && LinearOp.opModeIsActive()) {
            while (currentHeading >= targetAngle + headingTolerance && LinearOp.opModeIsActive()) {
                rotateRight(speed);

                currentHeading = getHeading();
                LinearOp.telemetry.addData("Current Angle: ", currentHeading);
                LinearOp.telemetry.addData("Target Angle: ", targetAngle);
                LinearOp.telemetry.update();
            }
        } else if (currentHeading <= targetAngle - headingTolerance && LinearOp.opModeIsActive()) ;
        {
            while (currentHeading <= targetAngle - headingTolerance && LinearOp.opModeIsActive()) {
                rotateLeft(speed);

                currentHeading = getHeading();
                LinearOp.telemetry.addData("Current Angle: ", currentHeading);
                LinearOp.telemetry.addData("Target Angle: ", targetAngle);
                LinearOp.telemetry.update();
            }
        }

        stopMotors();
        currentHeading = getHeading();
    }


    public double getHeading() {
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        return orientation.getYaw(AngleUnit.DEGREES);
    }


    public void driveGyroStraight (int encoders, double power, String direction) throws InterruptedException {
        imu.resetYaw();
        currentHeading = getHeading();

        double target = getHeading();
        double currentPos = 0;
        double leftSideSpeed;
        double rightSideSpeed;

        double startPosition = frontLeftMotor.getCurrentPosition();
        LinearOp.sleep(100);
        while (currentPos < encoders + startPosition && LinearOp.opModeIsActive()) {
            currentHeading = getHeading();
            currentPos = Math.abs(frontLeftMotor.getCurrentPosition());

            switch (direction) {
                case "FORWARD":
                    leftSideSpeed = power + (currentHeading - target) / 100;            // they need to be different
                    rightSideSpeed = power - (currentHeading - target) / 100;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    frontLeftMotor.setPower(leftSideSpeed);
                    rearLeftMotor.setPower(leftSideSpeed);

                    frontRightMotor.setPower(rightSideSpeed);
                    rearRightMotor.setPower(rightSideSpeed);
                    break;
                case "BACK":
                    leftSideSpeed = power - (currentHeading - target) / 100;            // they need to be different
                    rightSideSpeed = power + (currentHeading - target) / 100;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    frontLeftMotor.setPower(-leftSideSpeed);
                    rearLeftMotor.setPower(-leftSideSpeed);

                    frontRightMotor.setPower(-rightSideSpeed);
                    rearRightMotor.setPower(-rightSideSpeed);
                    break;
            }

            LinearOp.telemetry.addData("Left Speed", frontLeftMotor.getPower());
            LinearOp.telemetry.addData("Right Speed", frontRightMotor.getPower());
            LinearOp.telemetry.addData("Distance till destination ", encoders + startPosition - frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("Current Position", currentPos);
            LinearOp.telemetry.addData("Target Position", target);
            LinearOp.telemetry.addData("Current Headig: ", currentHeading);
            LinearOp.telemetry.update();

            LinearOp.idle();
        }

        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);

        LinearOp.idle();

    }


    public void setMotorRunModes(DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    public void stopMotors() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
    }

    public void driveForward(double speed) {
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(speed);
    }

    public void driveBack(double speed) {
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(-speed);
    }

    public void strafeLeft(double speed) {
       //old strafe left
//        frontLeftMotor.setPower(-speed);
//        frontRightMotor.setPower(speed);
//        rearLeftMotor.setPower(speed);
//        rearRightMotor.setPower(-speed);
        //new strafe left
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(speed);
    }

    public void strafeRight(double speed) {
        //old strafe right
//        frontLeftMotor.setPower(speed);
//        frontRightMotor.setPower(-speed);
//        rearLeftMotor.setPower(-speed);
//        rearRightMotor.setPower(speed);
        //new strafe right
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(-speed);
    }

    public void rotateLeft(double speed) {
        //old rotate left
//        frontLeftMotor.setPower(-speed);
//        frontRightMotor.setPower(speed);
//        rearLeftMotor.setPower(-speed);
//        rearRightMotor.setPower(speed);
        //new rotate left
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(-speed);
    }

    public void rotateRight(double speed) {
        //old rotate right
//        frontLeftMotor.setPower(speed);
//        frontRightMotor.setPower(-speed);
//        rearLeftMotor.setPower(speed);
//        rearRightMotor.setPower(-speed);
        //new rotate right
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(speed);
    }

    public void diagonalLeftForward(double speed) {
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(speed);
    }

    public void diagonalRightForward(double speed) {
        frontLeftMotor.setPower(speed);
        rearRightMotor.setPower(speed);
    }
    public void diagonalLeftBack(double speed) {
        frontLeftMotor.setPower(-speed);
        rearRightMotor.setPower(-speed);
    }

    public void diagonalRightBack(double speed) {
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(-speed);
    }



    public void driveForward(double speed, double rotations) {

        double ticks = rotations  * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
            driveForward(speed);
            LinearOp.telemetry.addData("FL tickes", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR tickes", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL tickes", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR tickes", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
        stopMotors();
    }

    public void driveBack (double speed, double rotations) {
        double ticks = rotations  * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive() ) ){
            driveBack(speed);
            LinearOp.telemetry.addData("FL tickes", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR tickes", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL tickes", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR tickes", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
        stopMotors();

    }

    public void rotateLeft(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ){
            rotateLeft(speed);
            LinearOp.telemetry.addData("FL tickes", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR tickes", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL tickes", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR tickes", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
        stopMotors();
    }

    public void rotateRight(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
            rotateRight(speed);
            LinearOp.telemetry.addData("FL tickes", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR tickes", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL tickes", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR tickes", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
        stopMotors();

    }

    public void strafeRight(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks) && LinearOp.opModeIsActive()) {
            strafeRight(speed);
            LinearOp.telemetry.addData("FL tickes", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR tickes", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL tickes", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR tickes", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
        stopMotors();
    }

    public void strafeLeft(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks ) && LinearOp.opModeIsActive()) {
            strafeLeft(speed);
            LinearOp.telemetry.addData("FL tickes", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR tickes", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL tickes", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR tickes", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
        stopMotors();


    }




    public void diagonalLeftForward(double speed, double rotations) {

        double ticks = rotations  * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
            diagonalLeftForward(speed);
        }
        stopMotors();
    }

    public void diagonalRightForward(double speed, double rotations) {

        double ticks = rotations  * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
            diagonalRightForward(speed);
        }
        stopMotors();
    }

    public void diagonalLeftBack(double speed, double rotations) {

        double ticks = rotations  * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
            diagonalLeftBack(speed);
        }
        stopMotors();
    }

    public void diagonalRightBack (double speed, double rotations) {

        double ticks = rotations  * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
            diagonalRightBack(speed);
        }
        stopMotors();
    }


    // Drive Using to Run To Position
    public void driveForwardToPosition (double speed, double rotations) {

        int targetPosition = (int) (rotations * TICKS_PER_ROTATION);


        // Reset Encoder Counts.
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Set motor run modes to RUN_TO_POSITION
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Set target positions for all motors
        frontLeftMotor.setTargetPosition(targetPosition);
        frontRightMotor.setTargetPosition(targetPosition);
        rearLeftMotor.setTargetPosition(targetPosition);
        rearRightMotor.setTargetPosition(targetPosition);

        // Set motor power to move forward
        double power = speed; // Example power level, adjust as needed
        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(power);
        rearLeftMotor.setPower(power);
        rearRightMotor.setPower(power);

        // Loop until all motors reach their target positions
        while (LinearOp.opModeIsActive() && frontLeftMotor.isBusy() && frontRightMotor.isBusy()
                && rearLeftMotor.isBusy() && rearRightMotor.isBusy()) {
            // You can add additional logic here if needed
            LinearOp.telemetry.addData("Status", "Driving to position");
            LinearOp.telemetry.update();
        }

        // Stop all motors
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);

        // Set motor run modes back to RUN_USING_ENCODER
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Display a message when the movement is complete
        LinearOp.telemetry.addData("Status", "Movement complete");
        LinearOp.telemetry.update();
    }



}
