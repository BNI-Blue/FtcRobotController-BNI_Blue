package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class MecanumDrive_Acker_Bkp {
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;

    public LinearOpMode LinearOp = null;

    public static final double TICKS_PER_ROTATION = 537.7;

    public IMU imu = null;
    public double headingError = 0;
    public double targetHeading = 0;
    public double driveSpeed = 0;
    public double turnSpeed = 0;
    public double leftSpeed = 0;
    public double rightSpeed = 0;
    public int leftTarget = 0;
    public int rightTarget = 0;

    static final double COUNTS_PER_MOTOR_REV = 537.7 ;
    static final double DRIVE_GEAR_REDUCTION = 1.0 ;
    static final double WHEEL_DIAMETER_INCHES = 4.0 ;
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);

    static final double DRIVE_SPEED = 0.4;
    static final double TURN_SPEED = 0.2;
    static final double HEADING_THRESHOLD = 1.0 ;
    static final double P_TURN_GAIN = 0.02;     // Larger is more responsive, but also less stable
    static final double P_DRIVE_GAIN = 0.03;     // Larger is more responsive, but also less stable

    public MecanumDrive_Acker_Bkp() {}

    public void setLinearOp(LinearOpMode LinearOp) {this.LinearOp = LinearOp;}

    public void setMotorRunModes(DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    // ****** Methods for driving with power only *****

    public void stopMotors() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
    }

    public void driveForward(double speed) {
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(-speed);
    }

    public void driveBack(double speed) {
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(speed);
    }

    public void rotateLeft(double speed) {
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(-speed);

    }

    public void rotateRight(double speed) {
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(speed);

    }

    public void strafeLeft(double speed) {
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(speed);

    }

    public void strafeRight(double speed) {
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(-speed);
    }

    // ****** Overloaded methods for driving distiance with encoder counts *****

    public void driveForward(double speed, double rotations) {

        double ticks = rotations  * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
            driveForward(speed);
        }
        stopMotors();
    }

    public void driveBack (double speed, double rotations) {
        double ticks = rotations  * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive() ) ){
            driveBack(speed);
        }
        stopMotors();

    }

    public void strafeLeft(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ){
            strafeLeft(speed);
        }
        stopMotors();
    }

    public void strafeRight(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ) {
            strafeRight(speed);
        }
        stopMotors();

    }

    public void rotateRight(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontRightMotor.getCurrentPosition() ) < ticks) && LinearOp.opModeIsActive()) {
            rotateRight(speed);
        }
        stopMotors();
    }

    public void rotateLeft(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks ) && LinearOp.opModeIsActive()) {
            rotateLeft(speed);
        }
        stopMotors();
    }

    // ****** Overloaded methods for driving distance with gyro *****

    public void driveStraight(double maxDriveSpeed,
                              double distance,
                              double heading) {

        // Ensure that the OpMode is still active
        if (LinearOp.opModeIsActive()) {

            int moveCounts = (int)(distance * COUNTS_PER_INCH);
            leftTarget = frontLeftMotor.getCurrentPosition() + moveCounts;
            rightTarget = frontRightMotor.getCurrentPosition() + moveCounts;

            // Set Target FIRST, then turn on RUN_TO_POSITION
            frontLeftMotor.setTargetPosition(leftTarget);
            frontRightMotor.setTargetPosition(rightTarget);

            frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // Set the required driving speed  (must be positive for RUN_TO_POSITION)
            // Start driving straight, and then enter the control loop
            maxDriveSpeed = Math.abs(maxDriveSpeed);
            moveRobot(maxDriveSpeed, 0);

            // keep looping while we are still active, and BOTH motors are running.
            while (LinearOp.opModeIsActive() &&
                    (frontLeftMotor.isBusy() && frontRightMotor.isBusy())) {

                // Determine required steering to keep on heading
                turnSpeed = getSteeringCorrection(heading, P_DRIVE_GAIN);

                // if driving in reverse, the motor correction also needs to be reversed
                if (distance < 0)
                    turnSpeed *= -1.0;

                // Apply the turning correction to the current driving speed.
                moveRobot(driveSpeed, turnSpeed);

                // Display drive status for the driver.
                sendTelemetry(true);
            }

            // Stop all motion & Turn off RUN_TO_POSITION
            moveRobot(0, 0);
            frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }

    public void turnToHeading(double maxTurnSpeed, double heading) {

        // Run getSteeringCorrection() once to pre-calculate the current error
        getSteeringCorrection(heading, P_DRIVE_GAIN);

        // keep looping while we are still active, and not on heading.
        while (LinearOp.opModeIsActive() && (Math.abs(headingError) > HEADING_THRESHOLD)) {

            // Determine required steering to keep on heading
            turnSpeed = getSteeringCorrection(heading, P_TURN_GAIN);

            // Clip the speed to the maximum permitted value.
            turnSpeed = Range.clip(turnSpeed, -maxTurnSpeed, maxTurnSpeed);

            // Pivot in place by applying the turning correction
            moveRobot(0, turnSpeed);

            // Display drive status for the driver.
            sendTelemetry(false);
        }

        // Stop all motion;
        moveRobot(0, 0);
    }


    public double getSteeringCorrection(double desiredHeading, double proportionalGain) {
        targetHeading = desiredHeading;  // Save for telemetry

        // Determine the heading current error
        headingError = targetHeading - getHeading();

        // Normalize the error to be within +/- 180 degrees
        while (headingError > 180)  headingError -= 360;
        while (headingError <= -180) headingError += 360;

        // Multiply the error by the gain to determine the required steering correction/  Limit the result to +/- 1.0
        return Range.clip(headingError * proportionalGain, -1, 1);
    }

    public void moveRobot(double drive, double turn) {
        driveSpeed = drive;     // save this value as a class member so it can be used by telemetry.
        turnSpeed  = turn;      // save this value as a class member so it can be used by telemetry.

        leftSpeed  = drive - turn;
        rightSpeed = drive + turn;

        // Scale speeds down if either one exceeds +/- 1.0;
        double max = Math.max(Math.abs(leftSpeed), Math.abs(rightSpeed));
        if (max > 1.0)
        {
            leftSpeed /= max;
            rightSpeed /= max;
        }

        frontRightMotor.setPower(leftSpeed);
        frontRightMotor.setPower(rightSpeed);
    }

    private void sendTelemetry(boolean straight) {

        if (straight) {
            LinearOp.telemetry.addData("Motion", "Drive Straight");
            LinearOp.telemetry.addData("Target Pos L:R",  "%7d:%7d",      leftTarget,  rightTarget);
            LinearOp.telemetry.addData("Actual Pos L:R",  "%7d:%7d",      frontLeftMotor.getCurrentPosition(),
                    frontRightMotor.getCurrentPosition());
        } else {
            LinearOp.telemetry.addData("Motion", "Turning");
        }

        LinearOp.telemetry.addData("Heading- Target : Current", "%5.2f : %5.0f", targetHeading, getHeading());
        LinearOp.telemetry.addData("Error  : Steer Pwr",  "%5.1f : %5.1f", headingError, turnSpeed);
        LinearOp.telemetry.addData("Wheel Speeds L : R", "%5.2f : %5.2f", leftSpeed, rightSpeed);
        LinearOp.telemetry.update();
    }

    /**
     * read the Robot heading directly from the IMU (in degrees)
     */
    public double getHeading() {
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        return orientation.getYaw(AngleUnit.DEGREES);
    }






}
