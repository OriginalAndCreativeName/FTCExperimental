package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.exponential.paths.LinearMovement;

@Autonomous(name="Test", group="Autonomous")
public class Test extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        LinearMovement testMove = new LinearMovement(Blueshift.drivetrain.MAXACCEL, Blueshift.drivetrain.MAXDEACCEL,2500,.5f,.1f);


        Blueshift.initialize(this);
        Blueshift.drivetrain.initializeIMU();
        waitForStart();
        while(opModeIsActive()){
            Blueshift.drivetrain.move(testMove);
            Blueshift.readHub1Data();
            //Blueshift.readHub2Data();
        }
    }
}
