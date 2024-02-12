package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Drivetrains.MecanumDrive;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;
import org.firstinspires.ftc.vision.VisionPortal;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;


public abstract class AutoMain extends LinearOpMode {

    // Instance Variables for Camera Resolution
    public int webCamWidth = 960;
    public int webCamHeight = 720;

    public int SLEEP_TIME = 100;
    public int SLEEP_GYRO = 150;


    // Enum for Team Prop Position
    public TeamPropPosition propPosition;

    // Construct Program Bot or Competiton Bot for all autonomous red paths
    public BlueBot Bot = new BlueBot();

    //Object Declaration
    public OpenCvCamera webcam;
    public VisionPortal visionPortal;

    double GYRO_PATH_SPD = .35;
    double GYRO_CORRECT_SPD = .2;
    double MAX_SPD = 1.0;
    double FAST_SPD = .7;
    double MED_SPD = .5;
    double SLOW_SPD = .3;
    double STRAFE_SPD = .8;
    double LONG_STRAFE_SPD = 1;
    int PIXEL_DOWN_DISTANCE = 1400;
    double PIXEL_UP_DISTANCE = 650;

    //Method to Initialize Camera Hardware
    public void initCamera() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().
                createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
    }

    // Stop the Streaming and Close the Camera Pipeline
    public void stopCamera() {
        webcam.stopStreaming();
        webcam.closeCameraDevice();
    }

    // Start the OpenCV Pipeline for image processing
    public void startPipeline(TeamPropPositionPipeline pipe) {
        webcam.setPipeline(pipe);
        webcam.setViewportRenderingPolicy(OpenCvCamera.ViewportRenderingPolicy.MAXIMIZE_EFFICIENCY);
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(webCamWidth, webCamHeight, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {
            }
        });

    }

    public void dropPixelBackdrop() {
        Bot.driveForward(0.3);
        sleep(800);
        Bot.stopMotors();
        sleep(100);
        Bot.extendPixelArm(.5);//1200
        sleep(1000);
        Bot.stopPixelArm();
        sleep(100);
        Bot.openPixelClawLeft();
        sleep(500);
        Bot.speedAcceleration(.35, MED_SPD, MecanumDrive.driveDirections.DRIVE_BACK);
        Bot.closePixelClawLeft();
        sleep(500);
        Bot.retractPixelArm(.5, 375);
        sleep(SLEEP_TIME);
        Bot.rotatePixelArmDown(.5, 200);

        /*
        Bot.rotatePixelArmUp(.5, 760);//950
//    FORWARD with power so robot does not time out driving into backdrop
//        Bot.driveForward(.2, 0.6);
        Bot.driveForward(0.3);
        sleep(1000);
        Bot.stopMotors();
        sleep(100);
        Bot.extendPixelArm(.5, 685);//1200
        Bot.openPixelClawLeft();
        sleep(500);
        Bot.driveBack(.5, .3);
        Bot.closePixelClawLeft();
        sleep(500);
        Bot.retractPixelArm(.5, 300);
        Bot.driveBack(.5, 0.6);
        Bot.rotatePixelArmDown(.5, 735);

         */

    }


}