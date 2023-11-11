package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraRotation;

public abstract class AutoBlueAlliance extends AutoMain{

    // Constructor to for Pipeline processing specific to Blue Alliance and Blue Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("BLUE", 140);

    // Construct Program Bot or Competiton Bot for all autonomous red paths
    //public ProgramBot Bot = new ProgramBot();
    public BlueBot Bot = new BlueBot();

    // Common method for BLUE alliance positioning to drop pixel
//    public void positionToDropPixel() {
//
//        if (propPosition == TeamPropPosition.ONE) {
//            Bot.strafeLeftNew(.40, 1);
//            telemetry.addLine("Position ONE: Staffe Left");
//            telemetry.update();
//            sleep(1000);
//        }
//        else if (propPosition == TeamPropPosition.TWO) {
//            telemetry.addLine("Position TWO: Hold Position");
//            telemetry.update();
//            sleep(1000);
//        }
//        else {
//            Bot.strafeRightNew(.40, 1);
//            telemetry.addLine("Position THREE: Staffe Right");
//            telemetry.update();
//            sleep(1000);
//        }

    }

