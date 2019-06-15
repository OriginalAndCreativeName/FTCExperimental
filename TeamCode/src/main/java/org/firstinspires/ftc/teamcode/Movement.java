package org.firstinspires.ftc.teamcode;

import android.graphics.Point;

public abstract class Movement {
    MotionCurve LFrontCurve;
    MotionCurve RFrontCurve;
    MotionCurve LBackCurve;
    MotionCurve RBackCurve;
    int tolerance = 10;
    Point start;
    Point end;


    //thicc curve pls i need a 5
    abstract void generateCurves();

    public Point getEnd() {
        return end;
    }

    public Point getStart() {
        return start;
    }
}
