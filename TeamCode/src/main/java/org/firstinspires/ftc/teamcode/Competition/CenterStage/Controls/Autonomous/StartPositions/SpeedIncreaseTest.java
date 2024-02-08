package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoMain;

@Autonomous(name = "Speed Increase Test")

public class SpeedIncreaseTest extends AutoMain {
    @Override
    public void runOpMode() throws InterruptedException {
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        waitForStart();
        while(opModeIsActive()){
            Bot.speedAcceleration(10, .6);
        }
    }
}
