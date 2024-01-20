package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;

public abstract class AutoBlueAlliance extends AutoMain{

    // Constructor to for Pipeline processing specific to Blue Alliance and Blue Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("BLUE", 140);

    // Construct Program Bot or Competiton Bot for all autonomous red paths
    //public BlueBot Bot = new BlueBot();
    //public BlueBot Bot = new BlueBot();

    // Common method for BLUE alliance positioning to drop pixel
    public void positionToDropBlueBack() {


        if (propPosition == TeamPropPosition.ONE) {
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2);
            sleep(100);
            Bot.rotateLeft(.5, 1.6);
            sleep(100);

            Bot.extendPixelArm(.5, 160);

            Bot.openPixelClawRight();
            sleep(500);
            Bot.closePixelClawRight();
            sleep(500);

            Bot.retractPixelArm(.5 ,160);


            Bot.driveBack(.5, .15);
            sleep(100);
            Bot.strafeLeft(.5, 2);
            sleep(100);
            Bot.rotateLeft(.5, 1);
            sleep(100);
            Bot.driveForward(.5, 2.85);
            sleep(100);
            Bot.strafeRight(.5, 2.2);
            sleep(100);

            dropPixelBackdrop();
//
            Bot.strafeLeft(.5, 2.7);
            Bot.driveForward(.5, .5);
            //backstage parks outside
        }
        else if (propPosition == TeamPropPosition.TWO) {
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2.5);
            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);

            Bot.extendPixelArm(.5, 400);
            Bot.retractPixelArm(.5, 50);

            Bot.openPixelClawRight();
            sleep(500);
            Bot.closePixelClawRight();
            sleep(500);

            Bot.retractPixelArm(.5, 345);

            Bot.driveBack(.5, 1);
            sleep(100);
            Bot.rotateLeft(.5, 2.8);
            sleep(100);
            Bot.driveForward(.5, 3.55);
            sleep(100);
            Bot.strafeRight(.5, 2.3);

            dropPixelBackdrop();

            Bot.strafeLeft(.5, 3.5);
            sleep(100);
            Bot.driveForward(.5, .5);
            sleep(100);
        }
        else {
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2.3);
            Bot.rotateRight(.5, 2.35);

            Bot.rotateEndGameArmDown(0);
            sleep(2000);
            Bot.rotateEndGameArmStop(.5);

            Bot.extendPixelArm(.5, 260);

            Bot.openPixelClawRight();
            sleep(500);
            Bot.closePixelClawRight();
            sleep(500);

            Bot.retractPixelArm(.5, 230);

            Bot.driveBack(.5, .5);
            sleep(100);
            Bot.rotateLeft(.5, 4.95);
            sleep(100);
            Bot.driveForward(.5, 3.1);
            sleep(100);
            Bot.strafeRight(.5, 1.8);
            sleep(100);

            dropPixelBackdrop();
            Bot.strafeLeft(.5, 3.7);
            sleep(100);
            Bot.driveForward(.5, 1);
        }
    }
    public void positionToDropBlueAud() {
        if (propPosition == TeamPropPosition.ONE) {
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();


            Bot.driveForward(.5, 3);
            Bot.rotateLeft(.5, 2.9);

            Bot.extendPixelArm(.5, 120);

            Bot.openPixelClawRight();
            sleep(500);

            Bot.driveBack(.5, .5);

            Bot.closePixelClawRight();
            sleep(500);

            Bot.retractPixelArm(.5, 100);

//            Bot.rotateRight(.5, 2.7);
//            Bot.strafeRight(.5, 1);
//            Bot.driveForward(.5, 2.5);
//            Bot.rotateLeft(.5, 3.1);
//            Bot.driveForward(.5, 9);
//            Bot.strafeLeft(.5, 5);
//            dropPixelBackdrop();
//            Bot.strafeRight(.5, 6);
//            Bot.driveForward(.5, .5);
        }
        else if (propPosition == TeamPropPosition.TWO) {
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2.5);

            Bot.extendPixelArm(.5, 550);
            Bot.openPixelClawRight();
            sleep(500);

            Bot.driveBack(.5, .5);

            Bot.retractPixelArm(.5, 500);

            Bot.closePixelClawRight();
            sleep(500);

//            Bot.strafeRight(.5, 1.5);
//            Bot.driveForward(.5, 4.5);
//            Bot.rotateLeft(.5, 3);
//            Bot.driveForward(.5,9);
//            Bot.strafeLeft(.5, .8);
//            dropPixelBackdrop();
//            Bot.strafeLeft(.5,    .5);
//            Bot.driveForward(.5, .5);
        }
        else {
            Bot.rotatePixelArmDown(.5);
            sleep(1250);
            Bot.stopPixelArmRotation();

            Bot.driveForward(.5, 2);
            Bot.rotateRight(.5, 1.7);

            Bot.extendPixelArm(.5, 120);
            Bot.openPixelClawRight();
            sleep(500);

            Bot.driveBack(.5, .2);

            Bot.retractPixelArm(.5, 100);
            Bot.closePixelClawRight();
            sleep(500);

//            Bot.strafeLeft(.5, 1.5);
//            Bot.driveForward(.5, 3.5);
//            Bot.rotateLeft(.5, 3);
//            Bot.driveForward(.5, 8);
//            Bot.strafeLeft(.5, 1);
//            dropPixelBackdrop();
//            Bot.strafeLeft(.5, 4);
//            Bot.driveForward(.5, 1);
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

