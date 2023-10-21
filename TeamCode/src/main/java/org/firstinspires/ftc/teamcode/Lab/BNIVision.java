package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;

@Disabled
@TeleOp(name = "Vision:Auto with Detection", group="iLab")
public class BNIVision extends LinearOpMode {

    OpenCvCamera webcam;
    TeamPropPositionPipeline pipeline;

    @Override
    public void runOpMode()
    {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

        // Used for SamplePipe from WebcamExample.  Going to change it to use "SkystoneDeterminationPipeline" based on Wizards.exe example.
        pipeline = new TeamPropPositionPipeline();
        webcam.setPipeline(pipeline);
        webcam.setViewportRenderingPolicy(OpenCvCamera.ViewportRenderingPolicy.MAXIMIZE_EFFICIENCY);
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                // Supported Resolution
                // https://ftc-docs.firstinspires.org/en/latest/apriltag/vision_portal/visionportal_webcams/visionportal-webcams.html
                webcam.startStreaming(960, 720, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {}
        });


        waitForStart();

        while (opModeIsActive())
        {
            telemetry.addData("Analysis", pipeline.getAnalysis());
            telemetry.addData("Position", pipeline.position);
            telemetry.update();

            // Don't burn CPU cycles busy-looping in this sample
            sleep(50);
        }
    }

    public static class TeamPropPositionPipeline extends OpenCvPipeline {

        // Enum for Team Prop Position
        public enum TeamPropPosition {ONE, TWO, THREE, FOUR, FIVE, SIX}
        public boolean blue_alliance = true;
        public double colorThreshold = 100;

        // Constants for the Color Boxes
        static final Scalar BLUE = new Scalar(0, 0, 255);
        static final Scalar GREEN = new Scalar(0, 255, 0);
        static final Scalar RED = new Scalar(255, 0, 0);

        // Constants for the Points to draw a box
        static final Point REGION1_TOPLEFT_ANCHOR_POINT = new Point(50, 450);
        static final Point REGION2_TOPLEFT_ANCHOR_POINT = new Point(390, 400);
        static final Point REGION3_TOPLEFT_ANCHOR_POINT = new Point(690, 450);
        static final int REGION_WIDTH = 100;
        static final int REGION_HEIGHT = 100;


        Point region1_pointA = new Point(REGION1_TOPLEFT_ANCHOR_POINT.x, REGION1_TOPLEFT_ANCHOR_POINT.y);
        Point region1_pointB = new Point(REGION1_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH, REGION1_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);
        Point region2_pointA = new Point(REGION2_TOPLEFT_ANCHOR_POINT.x, REGION2_TOPLEFT_ANCHOR_POINT.y);
        Point region2_pointB = new Point(REGION2_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH, REGION2_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);
        Point region3_pointA = new Point(REGION3_TOPLEFT_ANCHOR_POINT.x, REGION3_TOPLEFT_ANCHOR_POINT.y);
        Point region3_pointB = new Point(REGION3_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH, REGION3_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);

        // Image Matrices and Variables for Detecting Object
        Mat YCrCb = new Mat();
        Mat region1Chan, region2Chan, region3Chan;
        Mat chan = new Mat();

        // Volatile since accessed by OpMode thread w/o synchronization
        private volatile TeamPropPosition position = TeamPropPosition.ONE;

        // Method to convert RGB to YCrCb to eliminate lighting, luminosty differences
        // Method to extact our the Cr channel and the Cb channel
        void inputToCbCr(Mat input) {
            // COnve
            Imgproc.cvtColor(input, YCrCb, Imgproc.COLOR_RGB2YCrCb);

            if (blue_alliance) {
                Core.extractChannel(YCrCb, chan, 2); //Index 2 is Cb Channel (Blue)
                colorThreshold = 190.0;
            } else {
                Core.extractChannel(YCrCb, chan, 1); //Index 1 is Cr Channel (Red)
                colorThreshold = 190.0;
            }
        }

        // Initialize the Image Matrices and Initialize the Object Detection
        @Override
        public void init(Mat firstFrame) {

            inputToCbCr(firstFrame);

            region1Chan = chan.submat(new Rect(region1_pointA, region1_pointB));
            region2Chan= chan.submat(new Rect(region2_pointA, region2_pointB));
            region3Chan = chan.submat(new Rect(region3_pointA, region3_pointB));

        }

        @Override
        public Mat processFrame(Mat input) {

            inputToCbCr(input);

            // Draw Rectagnles of Detection Areas
            Imgproc.rectangle(input, region1_pointA, region1_pointB, BLUE, 2);
            Imgproc.rectangle(input, region2_pointA, region2_pointB, BLUE, 2);
            Imgproc.rectangle(input, region3_pointA, region3_pointB, BLUE, 2);

            // Apply thresholding to the channel ( Above threshold will get white pixels, below threshold will get black)
            Imgproc.threshold(region1Chan, region1Chan, colorThreshold, 255, Imgproc.THRESH_BINARY);
            Imgproc.threshold(region2Chan, region2Chan, colorThreshold, 255, Imgproc.THRESH_BINARY);
            Imgproc.threshold(region3Chan, region3Chan, colorThreshold, 255, Imgproc.THRESH_BINARY);

            // Counts  White Pixels
            int area1 = Core.countNonZero(region1Chan);
            int area2 = Core.countNonZero(region2Chan);
            int area3 = Core.countNonZero(region3Chan);

            // Determine Area of with Most White Pixels
            int maxArea = Math.max(area1, Math.max(area2, area3));

            // Determine which area equals the max area and place a solid green box over it.
            if (maxArea == area1) {
                position = TeamPropPosition.ONE;
                Imgproc.rectangle(input, region1_pointA, region1_pointB, GREEN, -1);
            }
            else if (maxArea == area2) {
                position = TeamPropPosition.TWO;
                Imgproc.rectangle(input, region2_pointA, region2_pointB, GREEN, -1);
            }
            else {
                position = TeamPropPosition.THREE;
                Imgproc.rectangle(input, region3_pointA, region3_pointB, GREEN, -1);
            }
            return input;
        }

        public TeamPropPosition getAnalysis()
        {
            return position;
        }

    }

}

