package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.exponential.blueshift.Blueshift;
import org.exponential.paths.Arc;
import org.exponential.paths.Line;
import org.exponential.paths.LinearMovement;
import org.exponential.paths.Path;
import org.exponential.paths.PathComponent;

@Autonomous(name="TestPaths", group="Autonomous")

public class TestPaths extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        PathComponent[] pathComponents=
                {
                        new Line(750, Path.ENCODER),
                        new Arc(24, 90, Path.INCH),
                        new Line(750, Path.ENCODER),
                        new Arc(24, 90, Path.INCH),
                        new Line(750, Path.ENCODER),
                        new Arc(24, 90, Path.INCH),
                        new Line(750, Path.ENCODER),
                        new Arc(24, 90, Path.INCH)
                };
        Path path = new Path(pathComponents, Blueshift.drivetrain.MAXACCEL, Blueshift.drivetrain.MAXDEACCEL, .35f, .1f);

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
