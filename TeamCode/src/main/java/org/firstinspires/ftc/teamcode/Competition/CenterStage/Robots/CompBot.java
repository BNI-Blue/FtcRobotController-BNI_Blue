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

public class CompBot extends MecanumDrive {


    public HardwareMap hwBot = null;

    public DcMotor viperSlideRight = null;
    public DcMotor wormgearRight = null;
    public DcMotor hookArm = null;
    public Servo hookArmRaiser = null;

    public ElapsedTime currentTime = new ElapsedTime();

    public ElapsedTime timer = new ElapsedTime();


    public BNO055IMU imu;
    public Orientation angles;
    public Acceleration gravity;
    public final double SPEED = .3;
    public final double TOLERANCE = .4;

    public CompBot (){}

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

        viperSlideRight = hwBot.dcMotor.get("viper_slide_right");
        viperSlideRight.setDirection(DcMotor.Direction.FORWARD);
        viperSlideRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        wormgearRight = hwBot.dcMotor.get("wormgear_right");
        wormgearRight.setDirection(DcMotor.Direction.FORWARD); //check direction b/f testing
        wormgearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        hookArm = hwBot.dcMotor.get("hookArm"); //Expantion Hub Port 0

       hookArm.setDirection(DcMotorSimple.Direction.FORWARD);


        hookArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        hookArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hookArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        hookArmRaiser = hwBot.get(Servo.class, "hookArmRaiser");
        hookArmRaiser.setDirection(Servo.Direction.FORWARD);





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


    public void hookArmUp (){
        hookArm.setPower(100);
    }

    public void hookArmDown(){
        hookArm.setPower(-100);
    }
    public void hookArmStop(){
        hookArm.setPower(0);
    }


    public void hookArmRaiserUp(){
        hookArmRaiser.setPosition(1);
    }

    public void hookArmRaiserDown(){
        hookArmRaiser.setPosition(0);
    }


    public void stopMotors(){
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);
    }

    public void linearSlideUp (double power) {
        viperSlideRight.setPower(-Math.abs(power));
    }

    public void linearSlideDown (double power) {viperSlideRight.setPower(Math.abs(power));
    }

    public void linearSlideUp (double power, double rotations)  {
        double ticks = rotations * (1) * TICKS_PER_ROTATION;
        viperSlideRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperSlideRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (Math.abs(viperSlideRight.getCurrentPosition()) < ticks && LinearOp.opModeIsActive()) {
            linearSlideUp(power);
        }
        linearSlideStop();
    }

    public void linearSlideDown (double power, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        viperSlideRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperSlideRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (Math.abs(viperSlideRight.getCurrentPosition())< ticks && LinearOp.opModeIsActive()) {
            linearSlideDown(power);
        }
        linearSlideStop();
    }

    public void linearSlideStop() {
        viperSlideRight.setPower(0);
    }

    public void rightWormgearLeft (double power) {
        wormgearRight.setPower(Math.abs(power));
    }

    public void rightWormgearRight (double power) {
        wormgearRight.setPower(-Math.abs(power));
    }

}
