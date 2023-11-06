package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;

public abstract class AutoRedAlliance extends AutoMain{

    // Constructor to for Pipeline processing specific to Red Alliance and Red Color Threshold value
    public TeamPropPositionPipeline pipeline = new TeamPropPositionPipeline("RED", 140);

    // Construct Program Bot or Competiton Bot for all autonomous red paths

//    public ProgramBot Bot = new ProgramBot();
//    public BlueBot Bot = new BlueBot();


    // Common method for red alliance positioning to drop pixel

//    public void positionToDropPixel() {
//
//        if (propPosition == TeamPropPosition.FOUR) {
//            //Bot.strafeLeftNew(.40, 1);
//            telemetry.addLine("Position FOUR: Staffe Left");
//            telemetry.update();
//            sleep(1000);
//        }
//        else if (propPosition == TeamPropPosition.FIVE) {
//            telemetry.addLine("Position FIVE: Hold Position");
//            telemetry.update();
//            sleep(1000);
//        }
//        else {
//            //Bot.strafeRightNew(.40, 1);
//            telemetry.addLine("Position SIX: Staffe Right");
//            telemetry.update();
//            sleep(1000);
//        }
//
//    }
}
