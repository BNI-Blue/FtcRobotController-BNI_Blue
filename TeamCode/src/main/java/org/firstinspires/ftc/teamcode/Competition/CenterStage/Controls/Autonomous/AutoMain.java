package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPositionPipeline;
import org.firstinspires.ftc.vision.VisionPortal;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;


public abstract class AutoMain extends LinearOpMode {

    // Instance Variables for Camera Resolution
    public int webCamWidth = 960;
    public int webCamHeight = 720;

    // Enum for Team Prop Position
    public TeamPropPosition propPosition;

    //Object Declaration
    public OpenCvCamera webcam;
    public VisionPortal visionPortal;

    //Method to Initialize Camera Hardware
    public void initCamera() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam =OpenCvCameraFactory.getInstance().
                createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"),cameraMonitorViewId);
    }

    // Stop the Streaming and Close the Camera Pipeline
    public void stopCamera() {
        visionPortal.stopStreaming();
        visionPortal.close();
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

}