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
                        new Line(750),
                        new Arc(750, 90),
                        new Line(750),
                        new Arc(750, 90),
                        new Line(750),
                        new Arc(750, 90),
                        new Line(750),
                        new Arc(750, 90)
                };
        Path path = new Path(pathComponents, Blueshift.drivetrain.MAXACCEL, Blueshift.drivetrain.MAXDEACCEL, .3f, .1f);

        Blueshift.initialize(this);
        Blueshift.drivetrain.initializeIMU();
        waitForStart();
        while (opModeIsActive()) {
            Blueshift.drivetrain.moveIMUPath(path);
            Blueshift.readHub1Data();
            telemetry.update();
        }
    }
}
