package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;

public abstract class AutoRedAlliance extends AutoMain{

    public double endGameDownPosition = 0;

    // Constructor to for Pipeline processing specific to Red Alliance and Red Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("RED", 140);

    // Construct Program Bot or Competition Bot for all autonomous red paths
    //public BlueBot Bot = new BlueBot();

    // Common method for RED alliance positioning to drop pixel
    public void positionToDropRedBack() {

        if (propPosition == TeamPropPosition.FOUR) {
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2.3);
            Bot.rotateLeft(.5, 2.3);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);

            Bot.extendPixelArm(.5, 160);

            Bot.openPixelClawRight();
            sleep(500);
            Bot.closePixelClawRight();
            sleep(500);

            Bot.retractPixelArm(.5 ,160);

            Bot.driveBack(.5, 3);
            Bot.rotateRight(.5, 5.6);
            Bot.driveForward(.5, 0.2);
            Bot.strafeLeft(.5,1.9);

//            PIXEL DELIVERY
            dropPixelBackdrop();

//          PARKING
            Bot.strafeRight(.5, 4.5);
            Bot.driveForward(.5, .5);
        }
        else if (propPosition == TeamPropPosition.FIVE) {
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2.5);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);

            Bot.extendPixelArm(.5, 550);

            Bot.openPixelClawRight();
            sleep(500);
            Bot.closePixelClawRight();
            sleep(500);

            Bot.retractPixelArm(.5, 550);

            Bot.driveBack(.5, 1);
            Bot.rotateRight(.5, 2.9);
            Bot.driveForward(.5, 3.35);
            Bot.strafeLeft(.5, 2.3);


            dropPixelBackdrop();

            /////////////////////////////////////////
            Bot.strafeRight(.5, 3.1);
            Bot.driveForward(.5, .5);
        }
        else {
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2);
            Bot.rotateRight(.5, 1.7);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);

            Bot.openPixelClawRight();
            sleep(500);
            Bot.closePixelClawRight();
            sleep(500);

            Bot.driveBack(.5, .15);
            Bot.rotateRight(.5, 1.7);
            Bot.strafeRight(.5, .5);

            Bot.driveForward(.5, 3.8);
            sleep(100);
            Bot.strafeLeft(.5, 1.2);
            sleep(100);

            dropPixelBackdrop();
//

            Bot.strafeRight(.5, 2.7);
            sleep(100);
            Bot.driveForward(.5 ,.5);
            sleep(100);
        }

//        switch (propPosition) {
//
//            case FOUR:
//                Bot.driveForward(.5, 1);
//                break;
//            case FIVE:
//                Bot.driveForward(.4, 1);
//                break;
//            case SIX:
//                Bot.driveForward(.7, 1);
//                break;
//
//        }

    }

    public void positionToDropRedAud(){
        if(propPosition == TeamPropPosition.FOUR){
//            Bot.rotatePixelArmDown(.5);
//            sleep(1250);
//            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2);

            Bot.extendPixelArm(.5, 160);

            Bot.openPixelClawRight();
            sleep(500);

            Bot.driveBack(.5, .5);

            Bot.retractPixelArm(.5, 140);

            Bot.closePixelClawRight();
            sleep(500);
//            Bot.strafeRight(.5, 1.5);
  //          Bot.driveForward(.5, 3.5);
    //        Bot.rotateRight(.5, 3);
      //      Bot.driveForward(.5, 8
            //Bot.strafeRight(.5, 4);
//            dropPixelBackdrop();
 //           Bot.strafeLeft(.5, 1);
   //         Bot.driveForward(.5, .5);
        }
        else if (propPosition == TeamPropPosition.FIVE){
//            Bot.rotatePixelArmDown(.5);
//            sleep(1250);
//            Bot.stopPixelArmRotation();
          Bot.driveForward(.5, 2.5);

          Bot.extendPixelArm(.5, 550);

          Bot.openPixelClawLeft();
          sleep(500);

          Bot.retractPixelArm(.5, 500);

          Bot.closePixelClawLeft();
          sleep(500);
//            Bot.strafeLeft(.5, 1.5);
  //          Bot.driveForward(.5, 4.5);
    //        Bot.rotateRight(.5, 3);
      //      Bot.driveForward(.5,9);
        //    Bot.strafeRight(.5,    .5);
//          Bot.rotatePixelArmUp(.5, .5);
//          Bot.extendPixelArm(.5, .5);
//          Bot.openPixelClawRight();
//          Bot.driveBack(.5, 1);
//          Bot.retractPixelArm(.5, .5);
//          Bot.closePixelClawRight();
//          Bot.rotatePixelArmDown(.5, .5);
//            Bot.strafeLeft(.5, 1.5);
  //          Bot.driveForward(.5, .5);
        }
        else{
//            Bot.rotatePixelArmDown(.5);
//            sleep(1250);
//            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2);
            Bot.rotateRight(.5, 1.7);

            Bot.extendPixelArm(.5, 160);

            Bot.openPixelClawLeft();
            sleep(500);

            Bot.retractPixelArm(.5, 140);

            Bot.closePixelClawLeft();
            sleep(500);
//          Bot.rotateLeft(.5, 2.7);
//          Bot.strafeLeft(.5, 1);
//          Bot.driveForward(.5, 2.5);
//          Bot.rotateRight(.5, 3.1);
//          Bot.driveForward(.5, 9);
//          Bot.strafeRight(.5, 5);
//          Bot.rotatePixelArmUp(.5, .5);
//          Bot.extendPixelArm(.5, .5);
//          Bot.openPixelClawRight();
//          Bot.driveBack(.5, 1);
//          Bot.retractPixelArm(.5, .5);
//          Bot.closePixelClawRight();
//          Bot.rotatePixelArmDown(.5, .5);
//          Bot.strafeLeft(.5, 6);
//          Bot.driveForward(.5, .5);
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

    // Red Audience Section Switch Case

//    public void deliverPurpleRedAud(){
//        switch(propPosition){
//            case FOUR:
//                Bot.driveForward(.5,1);
//                break;
//            case FIVE:
//                Bot.driveForward(.5,1);
//                Bot.rotateLeft(.5,1);
//                break;
//            case SIX:
//                Bot.driveForward(.5,1);
//                Bot.strafeRight(.5,1);
//                break;
//            default:
//                Bot.driveForward(.5,1);
//                Bot.rotateRight(.5, 1);
//                break;
//
//        }
//    }



}
