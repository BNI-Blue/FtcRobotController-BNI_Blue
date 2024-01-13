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
    public BlueBot Bot = new BlueBot();

    // Common method for RED alliance positioning to drop pixel
    public void positionToDropRedBack() {

        if (propPosition == TeamPropPosition.FOUR) {
//            Bot.rotatePixelArmDown(.5);
//            sleep(1250);
//            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2.3);
            Bot.rotateLeft(.5, 2.3);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);
            Bot.extendPixelArm(.5);
            sleep(150);
            Bot.stopPixelArm();
            Bot.openPixelClawRight();
            sleep(500);
            Bot.closePixelClawRight();
            Bot.retractPixelArm(.5);
            sleep(500);
            Bot.stopPixelArm();
            Bot.driveBack(.5, 3);
            Bot.rotateRight(.5, 5.6);
            Bot.driveForward(.5, 0.2);
            Bot.strafeLeft(.5,2.1);

//            PIXEL DELIVERY
             Bot.rotatePixelArmUp(.5);
            sleep(1300);
            Bot.stopPixelArmRotation();
            Bot.extendPixelArm(.5);
            sleep(1700);
            Bot.stopPixelArm();
            sleep(100);
            Bot.openPixelClawLeft();
            sleep(500);
            Bot.closePixelClawLeft();
            Bot.retractPixelArm(.5);
            sleep(1500);
            Bot.stopPixelArm();
            Bot.rotatePixelArmDown(.5);
            sleep(800);
            Bot.stopPixelArmRotation();
//          PARKING
            Bot.strafeRight(.5, 4.5);
            Bot.driveForward(.5, .5);
        }
        else if (propPosition == TeamPropPosition.FIVE) {
//            Bot.rotatePixelArmDown(.5);
//            sleep(1250);
//            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2.3);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);
            Bot.extendPixelArm(.5);
            sleep(750);
            Bot.stopPixelArm();
            Bot.openPixelClawRight();
            sleep(500);
            Bot.retractPixelArm(.5);
            sleep(700);
            Bot.stopPixelArm();
            Bot.closePixelClawRight();
            sleep(500);
            Bot.driveBack(.5, 1);
            Bot.rotateRight(.5, 2.9);
            Bot.driveForward(.5, 3.65);
            Bot.strafeLeft(.5, 2.5);

            Bot.rotatePixelArmUp(1);
            sleep(550);
            Bot.stopPixelArmRotation();
            Bot.extendPixelArm(.5);
            sleep(1300);
            Bot.stopPixelArm();
            Bot.driveForward(.5, .75);
            Bot.openPixelClawLeft();
            sleep(500);
            Bot.closePixelClawLeft();
            Bot.driveBack(.5, .75);
            Bot.retractPixelArm(.5);
            sleep(1200);
            Bot.stopPixelArm();
            Bot.rotatePixelArmDown(.75);
            sleep(500);
            Bot.stopPixelArmRotation();

            /////////////////////////////////////////
            Bot.strafeRight(.5, 3.1);
            Bot.driveForward(.5, .5);
        }
        else {
//            Bot.rotatePixelArmDown(.5);
//            sleep(1250);
//            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2.5);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);
            Bot.extendPixelArm(.5);
            sleep(500);
            Bot.stopPixelArm();
            Bot.openPixelClawRight();
            Bot.retractPixelArm(.5);
            sleep(50);
            Bot.closePixelClawRight();
            Bot.driveBack(.5, 1);
            Bot.rotateRight(.5, 2.7);
            Bot.driveForward(.5, 3);
//          Bot.strafeLeft(.5, 1.25);
//          Bot.rotatePixelArmUp(.5);
//          sleep(50);
//          Bot.extendPixelArm(.5);
//          sleep(50);
//          Bot.openPixelClawLeft();
//          Bot.driveBack(.5, 1);
//          Bot.closePixelClawLeft();
//          Bot.retractPixelArm(.5);
//          sleep(50);
//          Bot.rotatePixelArmDown(.5);
//          sleep(50);
        //    Bot.stopPixelArmRotation();
            Bot.strafeRight(.5, .5);
            Bot.driveForward(.5 ,5.);
            Bot.openPixelClawLeft();
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
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2);
            Bot.strafeLeft(.5, 1.5);
            Bot.extendPixelArm(.5);
            sleep(500);
            Bot.openPixelClawRight();
            Bot.retractPixelArm(.5);
            sleep(50);
            Bot.closePixelClawRight();
//            Bot.strafeRight(.5, 1.5);
  //          Bot.driveForward(.5, 3.5);
    //        Bot.rotateRight(.5, 3);
      //      Bot.driveForward(.5, 8);
        //    Bot.strafeRight(.5, 4);
//          Bot.rotatePixelArmUp(.5);
//          sleep(50);
//          Bot.extendPixelArm(.5);
//          sleep(50);
//          Bot.openPixelClawLeft();
//          Bot.driveBack(.5, 1);
//          Bot.retractPixelArm(.5);
//          sleep(50);
//          Bot.closePixelClawLeft();
//          Bot.rotatePixelArmDown(.5);
//          sleep(50);
//            Bot.stopPixelArmRotation();
 //           Bot.strafeLeft(.5, 1);
   //         Bot.driveForward(.5, .5);
        }
        else if (propPosition == TeamPropPosition.FIVE){
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2);
            Bot.extendPixelArm(.5);
            sleep(500);
            Bot.openPixelClawLeft();
            Bot.retractPixelArm(.5);
            sleep(50);
          Bot.closePixelClawLeft();
//            Bot.strafeLeft(.5, 1.5);
  //          Bot.driveForward(.5, 4.5);
    //        Bot.rotateRight(.5, 3);
      //      Bot.driveForward(.5,9);
        //    Bot.strafeRight(.5,    .5);
//          Bot.rotatePixelArmUp(.5);
//          sleep(50);
//          Bot.extendPixelArm(.5);
//          sleep(50);
//          Bot.openPixelClawRight();
//          Bot.driveBack(.5, 1);
//          Bot.retractPixelArm(.5);
//          sleep(50);
//          Bot.closePixelClawRight();
//          Bot.rotatePixelArmDown(.5);
//          sleep(50);
//            Bot.stopPixelArmRotation();
//            Bot.strafeLeft(.5, 1.5);
  //          Bot.driveForward(.5, .5);
        }
        else{
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 3);
            Bot.rotateRight(.5, 3.2);
            Bot.extendPixelArm(.5);
            sleep(500);
            Bot.openPixelClawLeft();
            Bot.retractPixelArm(.5);
            sleep(50);
          Bot.closePixelClawLeft();
//          Bot.rotateLeft(.5, 2.7);
//          Bot.strafeLeft(.5, 1);
//          Bot.driveForward(.5, 2.5);
//          Bot.rotateRight(.5, 3.1);
//          Bot.driveForward(.5, 9);
//          Bot.strafeRight(.5, 5);
//          Bot.rotatePixelArmUp(.5);
//          sleep(50);
//          Bot.extendPixelArm(.5);
//          sleep(50);
//          Bot.openPixelClawRight();
//          Bot.driveBack(.5, 1);
//          Bot.retractPixelArm(.5);
//          sleep(50);
//          Bot.closePixelClawRight();
//          Bot.rotatePixelArmDown(.5);
//          sleep(50);
//          Bot.stopPixelArmRotation();
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
