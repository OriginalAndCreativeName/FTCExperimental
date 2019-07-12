package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.exponential.blueshift.Blueshift;
import org.exponential.paths.Arc;
import org.exponential.paths.Path;
import org.exponential.paths.PathComponent;

@Autonomous(name="TestPathsZigZag", group="Autonomous")

public class TestPathsZigZag extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        PathComponent[] pathComponents=
                {
                        new Arc(1500, 180),
                        new Arc(1500, -180),
                };
        Path path = new Path(pathComponents, Blueshift.drivetrain.MAXACCEL, Blueshift.drivetrain.MAXDEACCEL, .3f, .1f);

        Blueshift.initialize(this);
        Blueshift.drivetrain.initializeIMU();
        waitForStart();
        while (opModeIsActive()) {
            Blueshift.drivetrain.movePath(path);
            Blueshift.readHub1Data();
            telemetry.update();
        }
    }
}
