package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

@Autonomous(name="Red:Audience:Start:2")
public class RedAudienceStart_Truss2 extends AutoRedAlliance {

    BlueBot Bot = new BlueBot();

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()){

            //INSERT AUTO CODE BELOW

            Bot.driveForward(.25, 1.5);

            // INSERT AUTO CODE ABOVE

        }
    }
}
