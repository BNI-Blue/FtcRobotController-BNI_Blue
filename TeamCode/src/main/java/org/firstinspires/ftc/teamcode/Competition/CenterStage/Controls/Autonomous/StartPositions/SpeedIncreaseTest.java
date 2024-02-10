package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoMain;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains.MecanumDrive;

//@Disabled
@Autonomous(name = "Speed Acceleration Test")

public class SpeedIncreaseTest extends AutoMain {

    @Override

    public void runOpMode() throws InterruptedException {


        double GYRO_SPD = .15;
        double FAST_SPD = .8;
        double MED_SPD = .5;
        double SLOW_SPD = .3;
        double STRAFE_SPD = .8;

        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        waitForStart();

        while(opModeIsActive()){
            Bot.resetHeading();
            // Don't like how GyroDrive works.  speedAcceleration seems to work well enough.
//            sleep(SLEEP_TIME);
//            Bot.driveGyroStraight(2, .5, "FORWARD");
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(4, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_TIME);
//            Bot.speedAcceleration(300, .3);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_SPD, 0);
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(1, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_SPD, 0);
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(1, STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_SPD, 0);
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2, STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_SPD, 0);
            Bot.speedAcceleration(1, STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);




            sleep(1000);
            requestOpModeStop();
        }
        idle();
    }
}
