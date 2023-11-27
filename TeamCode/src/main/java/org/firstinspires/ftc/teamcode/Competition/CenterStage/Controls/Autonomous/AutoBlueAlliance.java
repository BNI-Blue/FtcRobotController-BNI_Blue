package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;

public abstract class AutoBlueAlliance extends AutoMain{

    // Constructor to for Pipeline processing specific to Blue Alliance and Blue Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("BLUE", 140);

    // Construct Program Bot or Competiton Bot for all autonomous red paths
    public ProgramBot Bot = new ProgramBot();
    //public BlueBot Bot = new BlueBot();

    // Common method for BLUE alliance positioning to drop pixel
    public void positionToDropBlueBack() {

        if (propPosition == TeamPropPosition.ONE) {
            Bot.driveForward(.5, 2);
            Bot.strafeLeft(.5, 1.5);
            sleep(50);
            Bot.strafeLeft(.5, 3);
            Bot.driveForward(.5, 2);
            Bot.rotateLeft(.5, 2.5);
            Bot.driveForward(.5, .5);
            //does backstage park inside or outside?

        }
        else if (propPosition == TeamPropPosition.TWO) {
            sleep(1000);
        }
//        else {
//            Bot.strafeRight(.40, 1);
//            telemetry.addLine("Position THREE: Strafe Right");
//            telemetry.update();
//            sleep(1000);
//        }

    }

    public void CameraDetection () {
        propPosition = pipeline.getAnalysis();
        telemetry.addData("Position Detected: ", propPosition);
        telemetry.update();
        sleep(1000);

        // Stop Camera Detection
        stopCamera();
        telemetry.addLine("Stopping Camera");
        telemetry.update();
        sleep(1000);
    }


}

