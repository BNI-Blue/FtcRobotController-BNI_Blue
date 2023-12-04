package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;

public abstract class AutoRedAlliance extends AutoMain{

    // Constructor to for Pipeline processing specific to Red Alliance and Red Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("RED", 140);

    // Construct Program Bot or Competiton Bot for all autonomous red paths
    public BlueBot Bot = new BlueBot();
    //public BlueBot Bot = new BlueBot();

    // Common method for RED alliance positioning to drop pixel
    public void positionToDropRedBack() {

        if (propPosition == TeamPropPosition.FOUR) {
            Bot.strafeRight(.5, .5);
            Bot.driveForward(.5, 3);
            Bot.rotateLeft(.5, 2.5);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawLeft();
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawLeft();
            Bot.rotateRight(.5, 5.5);
            Bot.driveForward(.5, 3);
            Bot.strafeLeft(.5,1);
//            Bot.rotatePixelArmUp(.5);
//            sleep(50);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawRight();
//            Bot.driveBack(.5, 1);
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawRight();
//            Bot.rotatePixelArmDown(.5);
//            sleep(50);
            Bot.strafeRight(.5, 1.5);
            Bot.driveForward(.5, .5);
            sleep(100);
        }
        else if (propPosition == TeamPropPosition.FIVE) {
            Bot.strafeRight(.5, .5);
            Bot.driveForward(.5, 2.5);
//          Bot.extendPixelArm(.5);
//          sleep(50);
//          Bot.openPixelClawLeft();
//          Bot.retractPixelArm(.5);
//          sleep(50);
//          Bot.closePixelClawLeft();
            sleep(50);
            Bot.rotateRight(.5, 2.9);
            Bot.driveForward(.5, 3);
            Bot.strafeLeft(.5, .5);
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
            Bot.strafeRight(.5, 1);
            Bot.driveForward(.5, .5);
            sleep(100);
        }
        else {
            Bot.strafeRight(.5, .5);
            Bot.driveForward(.5, 2.5);
//          Bot.extendPixelArm(.5);
//          sleep(50);
//          Bot.openPixelClawLeft();
//          Bot.retractPixelArm(.5);
//          sleep(50);
//          Bot.closePixelClawLeft();
            Bot.driveBack(.5, 1);
            Bot.rotateRight(.5, 2.7);
            Bot.driveForward(.5, 3);
            Bot.strafeLeft(.5, 1.25);
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
            Bot.strafeRight(.5, .5);
            Bot.driveForward(.5 ,5.);
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
            Bot.driveForward(.5, 2);
            Bot.strafeLeft(.5, 1.5);
//          Bot.extendPixelArm(.5);
//          sleep(50);
//          Bot.openPixelClawLeft();
//          Bot.retractPixelArm(.5);
//          sleep(50);
//          Bot.closePixelClawLeft();
            Bot.strafeRight(.5, 1.5);
            Bot.driveForward(.5, 3.5);
            Bot.rotateRight(.5, 3);
            Bot.driveForward(.5, 8);
            Bot.strafeRight(.5, 4);
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
            Bot.strafeLeft(.5, 1);
            Bot.driveForward(.5, .5);
        }
        else if (propPosition == TeamPropPosition.FIVE){
            Bot.strafeLeft(.5, .5);
            Bot.driveForward(.5, 2);
//          Bot.extendPixelArm(.5);
//          sleep(50);
//          Bot.openPixelClawLeft();
//          Bot.retractPixelArm(.5);
//          sleep(50);
//          Bot.closePixelClawLeft();
            Bot.strafeLeft(.5, 1.5);
            Bot.driveForward(.5, 4.5);
            Bot.rotateRight(.5, 3);
            Bot.driveForward(.5,9);
            Bot.strafeRight(.5,    .5);
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
            Bot.strafeLeft(.5, 1.5);
            Bot.driveForward(.5, .5);
        }
        else{
            Bot.strafeLeft(.5, .5);
            Bot.driveForward(.5, 3);
            Bot.rotateRight(.5, 3.2);
//          Bot.extendPixelArm(.5);
//          sleep(50);
//          Bot.openPixelClawLeft();
//          Bot.retractPixelArm(.5);
//          sleep(50);
//          Bot.closePixelClawLeft();
            Bot.rotateLeft(.5, 2.7);
            Bot.strafeLeft(.5, 1);
            Bot.driveForward(.5, 2.5);
            Bot.rotateRight(.5, 3.1);
            Bot.driveForward(.5, 9);
            Bot.strafeRight(.5, 5);
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
            Bot.strafeLeft(.5, 6);
            Bot.driveForward(.5, .5);
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
