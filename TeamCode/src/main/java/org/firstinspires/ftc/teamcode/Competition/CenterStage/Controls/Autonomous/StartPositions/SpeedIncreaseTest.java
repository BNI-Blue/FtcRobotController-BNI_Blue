package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoMain;

@Disabled
@Autonomous(name = "Speed Acceleration Test")

public class SpeedIncreaseTest extends AutoMain {

    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        waitForStart();

        while(opModeIsActive()){
            sleep(1000);
            Bot.speedAcceleration(10, .6);

            requestOpModeStop();
        }
        idle();
    }
}
