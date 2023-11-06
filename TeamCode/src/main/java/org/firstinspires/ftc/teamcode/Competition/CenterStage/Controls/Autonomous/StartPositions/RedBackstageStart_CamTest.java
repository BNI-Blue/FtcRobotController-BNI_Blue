package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;
import org.firstinspires.ftc.teamcode.Lab.BNIVision;

@Autonomous(name="Red:Backstage:Start:CamTest")
public class RedBackstageStart_CamTest extends AutoRedAlliance {

    public boolean isCompetition = false;
    ProgramBot Bot = new ProgramBot();

    @Override
    public void runOpMode() throws InterruptedException{

        //Initialize Robot, Initialize Camera, and Integrate Linear OP
        Bot.initBot(hardwareMap);
        initCamera();
        Bot.setLinearOp(this);

        // Start OpenCV Pipeline Processing
        startPipeline(pipeline);
        telemetry.addLine("Starting Vision Pipeline");
        telemetry.update();

        // Wait for Start Button to be pressed... No position detection yet due to randomization
        waitForStart();

        while(opModeIsActive()){

            // First detection after randomization
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

            //Bot.driveForward(.5, .5);
            telemetry.addLine("Drive Forward");
            telemetry.update();
            sleep(100);

            //Bot.rotateRightNew(0.5, 3.1);
            telemetry.addLine("Rotate Right");
            telemetry.update();
            sleep(100);

            //Bot.driveForward(.5,3.6);
            telemetry.addLine("Drive Forward");
            telemetry.update();
            sleep(100);

            if (propPosition == TeamPropPosition.ONE) {
                //Bot.strafeLeftNew(.40, 1);
                telemetry.addLine("Position One: Staffe Left");
                telemetry.update();
            }
            else if (propPosition == TeamPropPosition.TWO) {
                sleep(100);
                telemetry.addLine("Position Two: Hold Position");
                telemetry.update();
            }
            else {
                //Bot.strafeRightNew(.40, 1);
                telemetry.addLine("Position Three: Staffe Right");
                telemetry.update();
            }
            requestOpModeStop();

        }

        idle();
    }

}
