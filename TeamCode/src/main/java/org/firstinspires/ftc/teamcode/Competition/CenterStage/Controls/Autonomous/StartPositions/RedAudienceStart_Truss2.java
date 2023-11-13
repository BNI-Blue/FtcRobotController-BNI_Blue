package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

@Disabled
@Autonomous(name="Red:Audience:Start")
public class RedAudienceStart_Truss2 extends AutoRedAlliance {

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()){

            //INSERT AUTO CODE BELOW


            Bot.driveForward(.5, 3);
            sleep(100);

            Bot.rotateRightNew(.25, 3.15);
            sleep(100);

            Bot.driveForward(.5, 10);
            sleep(100);

            // INSERT AUTO CODE ABOVE

            requestOpModeStop();

        }
        idle();
    }
}
