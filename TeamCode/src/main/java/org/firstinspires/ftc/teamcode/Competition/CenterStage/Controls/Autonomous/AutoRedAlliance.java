package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;

public abstract class AutoRedAlliance extends AutoMain{

    // Constructor to for Pipeline processing specific to Red Alliance and Red Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("RED", 140);

    // Construct Program Bot or Competiton Bot for all autonomous red paths
    //public ProgramBot Bot = new ProgramBot();
    public BlueBot Bot = new BlueBot();

    // Common method for RED alliance positioning to drop pixel
    public void positionToDropPixel() {

        if (propPosition == TeamPropPosition.FOUR) {
            Bot.strafeLeftNew(.40, 1);
            telemetry.addLine("Position FOUR: Strafe Left");
            telemetry.update();
            sleep(1000);
        }
        else if (propPosition == TeamPropPosition.FIVE) {
            telemetry.addLine("Position FIVE: Hold Position");
            telemetry.update();
            sleep(1000);
        }
        else {
            Bot.strafeRightNew(.40, 1);
            telemetry.addLine("Position SIX: Strafe Right");
            telemetry.update();
            sleep(1000);
        }



        switch (propPosition) {

            case FOUR:
                Bot.driveForward(.5, 1);
                break;
            case FIVE:
                Bot.driveForward(.4, 1);
                break;
            case SIX:
                Bot.driveForward(.7, 1);
                break;

        }

    }
    public void CameraDetection () {
        propPosition = pipeline.getAnalysis();
        telemetry.addData("Position Detected: ", propPosition);
        telemetry.update();
        sleep(1000);

        // Backup detection after first detection
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
