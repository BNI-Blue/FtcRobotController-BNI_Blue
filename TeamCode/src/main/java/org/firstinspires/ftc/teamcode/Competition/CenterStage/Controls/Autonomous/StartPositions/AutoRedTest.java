package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoMain;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains.MecanumDrive;

@Disabled
@Autonomous(name = "Red_Speed_test")

public class AutoRedTest extends AutoMain {

    @Override

    public void runOpMode() throws InterruptedException {


        double GYRO_PATH_SPD = .35;
        double GYRO_CORRECT_SPD = .2;
        double MAX_SPD = 1.0;
        double FAST_SPD = .7;
        double MED_SPD = .5;
        double SLOW_SPD = .3;
        double STRAFE_SPD = .8;

        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        waitForStart();
        Bot.resetHeading();

        while(opModeIsActive()){
            // Don't like how GyroDrive works.  speedAcceleration seems to work well enough.
//            sleep(SLEEP_TIME);
//            Bot.driveGyroStraight(2, .5, "FORWARD");
//            LOWER ARM
            Bot.rotatePixelArmDown(.5, 1300);
            sleep(1250);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2.85, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);
            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
//            EXTEND ARM AND DROP PIXEL
            sleep(500);
            Bot.extendPixelArm(.5, 130);
            sleep(500);
            Bot.openPixelClawRight();
            sleep(500);
            Bot.closePixelClawRight();
            sleep(500);

            Bot.retractPixelArm(.5 ,80);
            sleep(SLEEP_TIME);
            Bot.rotatePixelArmUp(.5, 600);//950
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3.5, FAST_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
            sleep(SLEEP_GYRO);
            Bot.gyroPath(GYRO_PATH_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.85, STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(0.3, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.driveForward(0.3);
            sleep(1000);
            Bot.stopMotors();
            sleep(100);


//    CODE FOR PIXEL DROP!
            Bot.extendPixelArm(.5);//1200
            sleep(1000);
            Bot.stopPixelArm();
            sleep(100);
            Bot.openPixelClawLeft();
            sleep(500);
            Bot.speedAcceleration(.5, MED_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
            Bot.closePixelClawLeft();
            sleep(500);
            Bot.retractPixelArm(.5, 400);
            sleep(SLEEP_TIME);
            Bot.rotatePixelArmDown(.5, 200);
//   END PIXEL DROP


            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(4, MAX_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);
            requestOpModeStop();
        }
        idle();
    }
}
