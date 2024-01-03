package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;

public abstract class AutoBlueAlliance extends AutoMain{

    // Constructor to for Pipeline processing specific to Blue Alliance and Blue Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("BLUE", 140);

    // Construct Program Bot or Competiton Bot for all autonomous red paths
    public BlueBot Bot = new BlueBot();
    //public BlueBot Bot = new BlueBot();

    // Common method for BLUE alliance positioning to drop pixel
    public void positionToDropBlueBack() {

        if (propPosition == TeamPropPosition.ONE) {
            Bot.driveForward(.5, 2);
            Bot.strafeLeft(.5, 1.5);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawRight();
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawRight();
            Bot.strafeLeft(.5, 3);
            Bot.driveForward(.5, 2);
            Bot.rotateLeft(.5, 2.5);
            Bot.driveForward(.5, .5);
//            Bot.rotatePixelArmUp(.5);
//            sleep(50);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawLeft();
//            Bot.driveBack(.5, 1);
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawLeft();
//            Bot.rotatePixelArmDown(.5);
//            sleep(50);
            Bot.strafeLeft(.5, 1);
            Bot.driveForward(.5, 1);
            //backstage parks outside
        }
        else if (propPosition == TeamPropPosition.TWO) {
            Bot.strafeLeft(.5, .5);
            Bot.driveForward(.5, 2.5);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawRight();
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawRight();
            Bot.rotateLeft(.5, 2.9);
            Bot.driveForward(.5, 3);
            Bot.strafeRight(.5, .5);
//            Bot.rotatePixelArmUp(.5);
//            sleep(50);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawLeft();
//            Bot.driveBack(.5, 1);
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawLeft();
//            Bot.rotatePixelArmDown(.5);
//            sleep(50);
            Bot.strafeLeft(.5, 1);
            Bot.driveForward(.5, 1);
        }
        else {
            Bot.strafeLeft(.5, .5);
            Bot.driveForward(.5, 2.5);
            Bot.rotateRight(.5, 2.5);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawRight();
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawRight();
            Bot.rotateLeft(.5, 5.5);
            Bot.driveForward(.5, 3);
            Bot.strafeRight(.5, 1);
//            Bot.rotatePixelArmUp(.5);
//            sleep(50);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawLeft();
//            Bot.driveBack(.5, 1);
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawLeft();
//            Bot.rotatePixelArmDown(.5);
//            sleep(50);
            Bot.strafeLeft(.5, 1.5);
            Bot.driveForward(.5, .5);
        }
    }
    public void positionToDropBlueAud() {
        if (propPosition == TeamPropPosition.ONE) {
            Bot.strafeRight(.5, .5);
            Bot.driveForward(.5, 3);
            Bot.rotateLeft(.5, 3.2);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawRight();
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawRight();
            Bot.rotateRight(.5, 2.7);
            Bot.strafeRight(.5, 1);
            Bot.driveForward(.5, 2.5);
            Bot.rotateLeft(.5, 3.1);
            Bot.driveForward(.5, 9);
            Bot.strafeLeft(.5, 5);
//            Bot.rotatePixelArmUp(.5);
//            sleep(50);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawLeft();
//            Bot.driveBack(.5, 1);
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawLeft();
//            Bot.rotatePixelArmDown(.5);
//            sleep(50);
            Bot.strafeRight(.5, 6);
            Bot.driveForward(.5, .5);
        }
        else if (propPosition == TeamPropPosition.TWO) {
            Bot.strafeRight(.5, .5);
            Bot.driveForward(.5, 2);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawRight();
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawRight();
            Bot.strafeRight(.5, 1.5);
            Bot.driveForward(.5, 4.5);
            Bot.rotateLeft(.5, 3);
            Bot.driveForward(.5,9);
            Bot.strafeLeft(.5, .8);
//            Bot.rotatePixelArmUp(.5);
//            sleep(50);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawLeft();
//            Bot.driveBack(.5, 1);
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawLeft();
//            Bot.rotatePixelArmDown(.5);
//            sleep(50);
            Bot.strafeLeft(.5,    .5);
            Bot.driveForward(.5, .5);
        }
        else {
            Bot.driveForward(.5, 2);
            Bot.strafeRight(.5, 1.5);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawRight();
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawRight();
            Bot.strafeLeft(.5, 1.5);
            Bot.driveForward(.5, 3.5);
            Bot.rotateLeft(.5, 3);
            Bot.driveForward(.5, 8);
            Bot.strafeLeft(.5, 1);
//            Bot.rotatePixelArmUp(.5);
//            sleep(50);
//            Bot.extendPixelArm(.5);
//            sleep(50);
//            Bot.openPixelClawLeft();
//            Bot.driveBack(.5, 1);
//            Bot.retractPixelArm(.5);
//            sleep(50);
//            Bot.closePixelClawLeft();
//            Bot.rotatePixelArmDown(.5);
//            sleep(50);
            Bot.strafeLeft(.5, 4);
            Bot.driveForward(.5, 1);
        }
    }

    public void CameraDetection () {
        propPosition = pipeline.getAnalysis();
        sleep(1000);

        // Stop Camera Detection
        stopCamera();
        sleep(1000);
    }


}

