package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.RedToPixelBackdrop;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoMain;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

public abstract class RedTwoPixelBackdrop extends AutoRedAlliance {

    public void deliverPurple (BlueBot Bot){
        switch(propPosition){
            case FOUR:
                Bot.driveForward(.5,1);
                Bot.rotateRightNew(.5,1);
                break;
            case FIVE:
                Bot.driveForward(.5,1);
                Bot.rotateLeftNew(.5,1);
                break;
            case SIX:
                Bot.driveForward(.5,1);
                Bot.strafeRightNew(.5,1);
                break;

        }
    }

}
