package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.exponential.blueshift.Blueshift;
import org.exponential.paths.LinearMovement;

@Autonomous(name="TestArc", group="Autonomous")

public class TestArc extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        LinearMovement testMove = new LinearMovement(Blueshift.drivetrain.MAXACCEL, Blueshift.drivetrain.MAXDEACCEL, 2500, .5f, .1f, LinearMovement.TRAPEZOID);

        Blueshift.initialize(this);
        Blueshift.drivetrain.initializeIMU();
        waitForStart();
        while (opModeIsActive()) {
            Blueshift.drivetrain.moveIMUArc(testMove, 90f / 2500f);
            Blueshift.readHub1Data();
            telemetry.update();
        }
    }
}
