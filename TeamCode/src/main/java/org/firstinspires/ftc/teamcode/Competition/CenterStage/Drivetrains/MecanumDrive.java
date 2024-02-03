package org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;


public class MecanumDrive {

    // Instance Variables for Mecanum Motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;

    public static final double TICKS_PER_ROTATION = 386.3;

    // Instance Variables for IMU
    public IMU imu = null;
    public double headingTolerance = 0.5;
    public double currentHeading = 0;

    // Instance Variables for PID Coefficients
    private double p, i, d;
    private double integralSum = 0;
    private double lastError = 0;

    // Instance Variable for Linear Op Mode
    public LinearOpMode LinearOp = null;

    // Default Constructor for Mecanum Drive Class
    public MecanumDrive() {}


    //********  Helper Methods for the Class  ************

    // Helper Method for Linear Op
    public void setLinearOp(LinearOpMode LinearOp) {
        this.LinearOp = LinearOp;
    }

    // Helper method to set the run modes for all motors at the same
    public void setMotorRunModes(DcMotor.RunMode mode) {
        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    //******  Methods using IMU / Gyro  **************

    // Helper Method to Get Heading using IMU
    public double getHeading() {
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        return orientation.getYaw(AngleUnit.DEGREES);
    }

    // Helper Method to reset the IMU Yaw Heading
    public void resetHeading() {
        imu.resetYaw();
    }

    // Method that corrects the robots original heading.
    // Method assumes the heading to correct to has been set outside of this method
    public void gyroCorrection(double speed, double targetAngle) {
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

    // Method allows robot to rotate using the IMU Yaw Heading
    // Method resets the heading so there is a full rotation based on targetAngle
    public void rotateByGyro(double speed, double targetAngle) {
        resetHeading();
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

    // Method to drive straight either forward or backward using IMU
    public void driveGyroStraight(int encoders, double power, String direction) throws InterruptedException {
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


    // ************** Basic Drive Method ***********************

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
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(speed);
    }

    public void strafeRight(double speed) {
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(-speed);
    }

    public void rotateLeft(double speed) {
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(-speed);
    }

    public void rotateRight(double speed) {
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

    // **********  Drive Method using Encoders *******************

    public void driveForward(double speed, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())) {
            driveForward(speed);
            LinearOp.telemetry.addData("FL tickes", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR tickes", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL tickes", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR tickes", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
        stopMotors();
    }

    public void driveBack(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())) {
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

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())) {
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

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())) {
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

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks) && LinearOp.opModeIsActive()) {
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

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks) && LinearOp.opModeIsActive()) {
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

        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())) {
            diagonalLeftForward(speed);
        }
        stopMotors();
    }

    public void diagonalRightForward(double speed, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())) {
            diagonalRightForward(speed);
        }
        stopMotors();
    }

    public void diagonalLeftBack(double speed, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())) {
            diagonalLeftBack(speed);
        }
        stopMotors();
    }

    public void diagonalRightBack(double speed, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())) {
            diagonalRightBack(speed);
        }
        stopMotors();
    }


    // Drive Using to Run To Position
    public void driveForwardToPosition(double speed, double rotations) {

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

        // Loop until one of the motors reach their target positions
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
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Display a message when the movement is complete
        LinearOp.telemetry.addData("Status", "Movement complete");
        LinearOp.telemetry.update();
    }


    // Method to drive robot using PID control
    public void drivePIDForward(double targetDistance, double power, double p, double i, double d) {
        resetEncoders();

        double error;
        double derivative;
        double output;
        double distance = getEncoderAvgDistance();

        while (Math.abs(targetDistance - distance) > 100 && LinearOp.opModeIsActive()) { // 1 is the tolerance, you can adjust it
            LinearOp.telemetry.addData("targetDistance", targetDistance);
            LinearOp.telemetry.addData("distance", distance);
            distance = getEncoderAvgDistance();
            error = targetDistance - distance;

            integralSum += error;
            derivative = error - lastError;

            output = (p * error) + (i * integralSum) + (d * derivative);

            driveForward(output * power);

            lastError = error;

            // Add a small delay to avoid hogging CPU cycles
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getMotorTelemetry();
            LinearOp.telemetry.update();

        }

        stopMotors();
    }

    // *********  Helper methods for Encoders******************

    // Helper Method to reset ecoders
    public void resetEncoders() {
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    // Helper Method that averages all the encoder counts using getPosition
    public double getEncoderAvgDistance() {
        double average = (frontLeftMotor.getCurrentPosition() + frontRightMotor.getCurrentPosition() + rearLeftMotor.getCurrentPosition() + rearRightMotor.getCurrentPosition()) / 4.0;
        return Math.abs(average);
    }

    // Helper Method to get Motor Telemetry
    public void getMotorTelemetry() {
        LinearOp.telemetry.addData("FLM", frontLeftMotor.getCurrentPosition());
        LinearOp.telemetry.addData("FRM", frontRightMotor.getCurrentPosition());
        LinearOp.telemetry.addData("RLM", rearLeftMotor.getCurrentPosition());
        LinearOp.telemetry.addData("RRM", rearRightMotor.getCurrentPosition());
    }


}
