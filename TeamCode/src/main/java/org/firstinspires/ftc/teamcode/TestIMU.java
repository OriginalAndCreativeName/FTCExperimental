package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.exponential.blueshift.Blueshift;

@Autonomous(name="TestIMU", group="Autonomous")
public class TestIMU extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        //LinearMovement testMove = new LinearMovement(Blueshift.dt.MAXACCEL, Blueshift.dt.MAXDEACCEL,2500,.5f,.1f);
        Blueshift.initialize(this);
        Blueshift.drivetrain.initializeIMU();
        waitForStart();
        while(opModeIsActive()){
            //Blueshift.dt.move(testMove);
            telemetry.update();
            Blueshift.drivetrain.driveIMU(0, .1f);
        }


    }
}
