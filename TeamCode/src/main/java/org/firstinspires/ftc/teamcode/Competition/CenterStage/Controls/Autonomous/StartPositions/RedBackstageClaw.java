package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;

@Disabled
@Autonomous(name = "Red:Backstage:Claw")
public class RedBackstageClaw extends AutoRedAlliance {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();


        waitForStart();

        while (opModeIsActive()) {

            //INSERT CODE UNDER

            Bot.driveForward(.5, .5);
            sleep(100);

            Bot.rotateRight(.5, 2.9);
            sleep(100);

            Bot.driveForward(.5, 2.6);
            sleep(100);//everything from here down needs testing

            Bot.strafeLeft(.5, 2);
            sleep(100);

            Bot.driveForward(.5, 2);
            sleep(100);

            Bot.driveBack(.5, .7);
            sleep(100);

            //INSERT CODE ABOVE
        }
    }
}
