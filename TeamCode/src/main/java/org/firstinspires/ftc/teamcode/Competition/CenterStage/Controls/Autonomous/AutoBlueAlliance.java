package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains.MecanumDrive;

@Disabled
public abstract class AutoBlueAlliance extends AutoMain{

    // Constructor to for Pipeline processing specific to Blue Alliance and Blue Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("BLUE", 140);

    // Construct Program Bot or Competiton Bot for all autonomous red paths
    //public BlueBot Bot = new BlueBot();
    //public BlueBot Bot = new BlueBot();


    // Common method for BLUE alliance positioning to drop pixel
    public void positionToDropBlueBack() {


        if (propPosition == TeamPropPosition.ONE) {


            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(1.1, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(1.4, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 0);
            sleep(SLEEP_GYRO);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 0);
            sleep(SLEEP_GYRO);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 450);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.retractPixelArm(.5 ,300);
            sleep(SLEEP_TIME);
            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(2.4, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(1.6, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3, MAX_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);


        }
        else if (propPosition == TeamPropPosition.TWO) {
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2.2, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.8, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 0);
            sleep(SLEEP_GYRO);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 0);
            sleep(SLEEP_GYRO);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 525);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.retractPixelArm(.5 ,350);
            sleep(SLEEP_TIME);
            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(2.9, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.8, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3.5, MAX_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);

        }
        else {
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2.85, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);
            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, -80);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -80);
//            EXTEND ARM AND DROP PIXEL
            sleep(SLEEP_GYRO);
            Bot.extendPixelArm(.5, 130);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.retractPixelArm(.5 ,80);
            sleep(SLEEP_TIME);
            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);//950
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.5, FAST_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
            sleep(SLEEP_GYRO);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(2.8, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(1.5, STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(0.3, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(4.5, MAX_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);
        }
    }
    public void positionToDropBlueAudMiddle() {
        if (propPosition == TeamPropPosition.ONE) {

            //This is where you can add in a sleep to delay the start of AUTO - MAXIMUM of 2500 milliseconds
            //sleep(2000);
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2.4, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroPath(GYRO_PATH_SPD, 75);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 75);
//            EXTEND ARM AND DROP PIXEL
            sleep(SLEEP_GYRO);
            Bot.extendPixelArm(.5, 250);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,110);
            sleep(SLEEP_TIME);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.speedAcceleration(.5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 75);
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(4.2, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_GYRO);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(10.7, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3.4, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.rotatePixelArmUp(.5, 600);//950
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3.7, MAX_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);

        }
        else if (propPosition == TeamPropPosition.TWO) {

            //DO NOT ADD IN ANY SLEEPS!!!
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.25, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 0);
            sleep(SLEEP_GYRO);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 775);
            sleep(200);
            Bot.openPixelClawRight();
            sleep(200);
            Bot.retractPixelArm(.5 ,700);
            sleep(SLEEP_TIME);
            Bot.closePixelClawRight();
            sleep(200);

            Bot.speedAccelerationStrafe(2, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3.4, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 88);
            Bot.speedAcceleration(10.7, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.speedAccelerationStrafe(3.3, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.speedAccelerationStrafe(3.4, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);

        }
        else {

            //DO NOT ADD IN ANY SLEEPS!!!
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(1.1, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration( .8, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -.5);
            sleep(SLEEP_GYRO);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 550);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,450);
            sleep(SLEEP_TIME);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.speedAccelerationStrafe(1.2, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -1.5);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(4.35, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 92);
            Bot.speedAcceleration(9, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.speedAccelerationStrafe(1.3, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAccelerationStrafe(2.1, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);


        }
    }
    public void positionToDropBlueAudWall() {
        if (propPosition == TeamPropPosition.ONE) {

            //This is where you can add in a sleep to delay the start of AUTO - MAXIMUM of 1500 milliseconds
            //sleep(1500);
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2.4, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
//            Bot.rotateEndGameArmDown(0);
//            sleep(2000);
//            Bot.rotateEndGameArmStop(.5);
//            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, 75);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 75);
//            EXTEND ARM AND DROP PIXEL
            sleep(SLEEP_GYRO);
            Bot.extendPixelArm(.5, 250);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,110);
            sleep(SLEEP_TIME);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.speedAcceleration(.5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(2.25, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.rotateEndGameArmDown(0);
            sleep(1500);
            Bot.rotateEndGameArmStop(.5);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(4.95, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(4.7, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(2.8, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.rotatePixelArmUp(.5, 600);//950
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3.8, MAX_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);

        }
        else if (propPosition == TeamPropPosition.TWO) {

            //DO NOT ADD IN ANY SLEEPS - THERE IS NO TIME!!!!
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2.1, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.25, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 0);
            sleep(SLEEP_GYRO);
//            Bot.rotateEndGameArmDown(0);
//            sleep(2000);
//            Bot.rotateEndGameArmStop(.5);
//            sleep(SLEEP_TIME);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 775);
            sleep(200);
            Bot.openPixelClawRight();
            sleep(200);
            Bot.retractPixelArm(.5 ,700);
            sleep(SLEEP_TIME);
            Bot.closePixelClawRight();
            sleep(200);

            Bot.speedAcceleration(.8, MAX_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(1.15, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.rotateEndGameArmDown(0);
            sleep(1500);
            Bot.rotateEndGameArmStop(.5);
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(4.9, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(4.7, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3.9, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.rotatePixelArmUp(.5, 600);//950
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3, MAX_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);

        }
        else {

            //DO NOT ADD IN ANY SLEEPS - THERE IS NO TIME!!!!
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(1.1, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.7, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -.5);
            sleep(SLEEP_GYRO);
//            Bot.rotateEndGameArmDown(0);
//            sleep(2000);
//            Bot.rotateEndGameArmStop(.5);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 550);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,450);
            sleep(SLEEP_TIME);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.speedAcceleration(.5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.rotateEndGameArmDown(0);
            sleep(1500);
            Bot.rotateEndGameArmStop(.5);
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(5., MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(5.15, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(4.6, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.rotatePixelArmUp(.5, 600);//950
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(2.2, MAX_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);

        }
    }


    public void encoderTesting () {
        Bot.driveForwardToPosition (0.5, 3);
        sleep(100);
        Bot.rotateLeft(0.5, 2);
        sleep(100);
        Bot.gyroCorrection(0.5, 90);
        sleep(100);
    }

    public void CameraDetection () {
        propPosition = pipeline.getAnalysis();
        telemetry.addData("Position Detected: ", propPosition);
        telemetry.update();
        sleep(1000);

        stopCamera();
        telemetry.addLine("Stopping Camera");
        telemetry.update();
        sleep(1000);

    }




}

