package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

public class Drivetrain {
    private Orientation targetHeading = new Orientation();
    private Orientation currentHeading = new Orientation();
    private Position currentPosition = new Position();
    private Position targetPosition = new Position();

    Drivetrain(DcMotorEx LFront, DcMotorEx RFront,DcMotorEx LBack, DcMotorEx RBack){

    }
    public void translate (float direction, float distance){

    }

}
