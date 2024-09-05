package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains.MecanumDrive;

@Disabled
public abstract class AutoRedAlliance extends AutoMain{

    public double endGameDownPosition = 0;

    // Constructor to for Pipeline processing specific to Red Alliance and Red Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("RED", 140);

    // Construct Program Bot or Competition Bot for all autonomous red paths
    //public BlueBot Bot = new BlueBot();

    // Common method for RED alliance positioning to drop pixel
    public void positionToDropRedBack() {

        if (propPosition == TeamPropPosition.FOUR) {
            //CAN DELAY BY ABOUT 3 SECONDS
            //sleep(3000);
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
            Bot.gyroPath(GYRO_PATH_SPD, 90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 90);
//            EXTEND ARM AND DROP PIXEL
            sleep(SLEEP_GYRO);
            Bot.extendPixelArm(.5, 130);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.retractPixelArm(.5, 80);
            sleep(SLEEP_TIME);
            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);//950
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
            dropPixelBackdrop();
//   END PIXEL DROP
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(4, MAX_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);
            requestOpModeStop();
        }

        else if (propPosition == TeamPropPosition.FIVE) {
            //CAN DELAY BY ABOUT 3 SECONDS
            //sleep(3000);
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2.3, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.25, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
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
            Bot.extendPixelArm(.5, 600);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.retractPixelArm(.5 ,450);
            sleep(SLEEP_TIME);
            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3.1, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.35, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(3.2, MAX_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);


        }
        else {
            //CAN DELAY BY ABOUT 3 SECONDS
            //sleep(3000);
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(1.1, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.85, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
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
            Bot.extendPixelArm(.5, 600);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);

            Bot.retractPixelArm(.5 ,500);
            sleep(SLEEP_TIME);
            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.gyroPath(GYRO_PATH_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(2.6, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(1, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            dropPixelBackdrop();
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(1.9, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
            sleep(SLEEP_TIME);

        }
    }

    public void positionToDropRedAudMiddle(){
        if(propPosition == TeamPropPosition.FOUR){
            //CAN DELAY BY 1.5 SECONDS MAXIMUM
            //sleep(1500);
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(1.1, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(1.5, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -.5);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -.5);
            sleep(SLEEP_GYRO);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 550);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,450);
            sleep(SLEEP_TIME);
//
//            Bot.speedAccelerationStrafe(1.95, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -1.5);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(4.35, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_GYRO);
//            Bot.gyroPath(GYRO_PATH_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -92);
//            Bot.speedAcceleration(9.5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);
//            sleep(SLEEP_TIME);
//            Bot.speedAccelerationStrafe(3.1, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
//            dropPixelBackdrop();
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAccelerationStrafe(2.7, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
//            sleep(SLEEP_TIME);



        }
        else if (propPosition == TeamPropPosition.FIVE){
            //DO NOT DELAY - THERE IS NO TIME!!!!
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.4, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, 0);
            sleep(SLEEP_GYRO);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 775);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,700);
            sleep(SLEEP_TIME);

//            Bot.speedAccelerationStrafe(1.3, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -1.5);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(3.1, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_GYRO);
//            Bot.gyroPath(GYRO_PATH_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -92);
//            Bot.speedAcceleration(10.6, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.rotatePixelArmUp(.5, PIXEL_UP_DISTANCE);
//            sleep(SLEEP_TIME);
//            Bot.speedAccelerationStrafe(3.9, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
//            dropPixelBackdrop();
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAccelerationStrafe(3.2, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
//            sleep(SLEEP_TIME);

        }
        else{

            //DO NOT DELAY - THERE IS NO TIME!!!!
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2.4, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroPath(GYRO_PATH_SPD, -60);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -60);
//            EXTEND ARM AND DROP PIXEL
            sleep(SLEEP_GYRO);
            Bot.extendPixelArm(.5, 250);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,110);
            sleep(SLEEP_TIME);

//            Bot.speedAcceleration(.5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -60);
//            sleep(SLEEP_TIME);
//            Bot.speedAcceleration(4.8, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
//            sleep(SLEEP_GYRO);
//            Bot.gyroPath(GYRO_PATH_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -92);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(11.4, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(4.6, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.rotatePixelArmUp(.5, 600);//950
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            dropPixelBackdrop();
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(4.3, MAX_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);

        }

    }
    public void positionToDropRedAudWall(){
        if(propPosition == TeamPropPosition.FOUR){

            //CAN DELAY BY A MAXIMUM OF 1.5 SECONDS!
            //sleep(1500);
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(1.1, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(1.5, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -.5);
            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -.5);
            sleep(SLEEP_GYRO);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 550);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,450);
            sleep(SLEEP_TIME);

//            Bot.speedAcceleration(.5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
//            sleep(SLEEP_TIME);
//            Bot.gyroPath(GYRO_PATH_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.rotateEndGameArmDown(0);
//            sleep(1500);
//            Bot.rotateEndGameArmStop(.5);
//            sleep(SLEEP_TIME);
//            Bot.speedAccelerationStrafe(.5, STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
//            sleep(SLEEP_TIME);
//            Bot.speedAcceleration(5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(5.15, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(3.4, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.rotatePixelArmUp(.5, 600);//950
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            dropPixelBackdrop();
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(2.4, MAX_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);



        }
        else if (propPosition == TeamPropPosition.FIVE){
            //CAN DELAY BY A MAXIMUM OF 1.5 SECONDS!
            //sleep(1500);
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD,0);
            sleep(SLEEP_GYRO);
            Bot.speedAcceleration(.4, FAST_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
            sleep(SLEEP_TIME);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, 0);
            sleep(SLEEP_GYRO);
//            EXTEND ARM AND DROP PIXEL
            Bot.extendPixelArm(.5, 775);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,700);
            sleep(SLEEP_TIME);

//            Bot.speedAcceleration(.5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
//            sleep(SLEEP_TIME);
//            Bot.gyroPath(GYRO_PATH_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(1.15, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.rotateEndGameArmDown(0);
//            sleep(1500);
//            Bot.rotateEndGameArmStop(.5);
//            sleep(SLEEP_TIME);
//            Bot.speedAcceleration(4.7, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(4.9, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(2.4, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.rotatePixelArmUp(.5, 600);//950
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            dropPixelBackdrop();
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(3.5, MAX_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);

        }
        else{
            Bot.rotatePixelArmDown(.5, PIXEL_DOWN_DISTANCE);
            sleep(SLEEP_TIME);
            Bot.stopPixelArmRotation();
//            DRIVE TO SPIKE MARK
            sleep(SLEEP_TIME);
            Bot.speedAcceleration(2.4, FAST_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
            sleep(SLEEP_GYRO);
            Bot.gyroPath(GYRO_PATH_SPD, -60);
            sleep(SLEEP_GYRO);
            Bot.gyroCorrection(GYRO_CORRECT_SPD, -60);
//            EXTEND ARM AND DROP PIXEL
            sleep(SLEEP_GYRO);
            Bot.extendPixelArm(.5, 250);
            sleep(300);
            Bot.openPixelClawRight();
            sleep(300);
            Bot.closePixelClawRight();
            sleep(300);
            Bot.retractPixelArm(.5 ,110);
            sleep(SLEEP_TIME);

//            Bot.speedAcceleration(.5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
//            sleep(SLEEP_TIME);
//            Bot.gyroPath(GYRO_PATH_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(2.05, FAST_SPD, MecanumDrive.driveDirections.STRAFE_RIGHT);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.rotateEndGameArmDown(0);
//            sleep(1500);
//            Bot.rotateEndGameArmStop(.5);
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(4.7, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(5, MAX_SPD, MecanumDrive.driveDirections.DRIVE_FORWARD);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(2, LONG_STRAFE_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.rotatePixelArmUp(.5, 600);//950
//            sleep(SLEEP_GYRO);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            dropPixelBackdrop();
//            sleep(SLEEP_TIME);
//            Bot.gyroCorrection(GYRO_CORRECT_SPD, -90);
//            sleep(SLEEP_GYRO);
//            Bot.speedAcceleration(4.1, MAX_SPD, MecanumDrive.driveDirections.STRAFE_LEFT);

        }

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
