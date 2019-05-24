package org.firstinspires.ftc.teamcode;

public class TrapezoidalCurve extends MotionCurve{
     float upperLength;
     float slope;
     float slopeLength;
    TrapezoidalCurve(float b1, float b2, float h){
        maxVal=h;
        length=b1;
        slopeLength=(length-upperLength)/2f;
        slope = maxVal/slopeLength;
    }

    TrapezoidalCurve(float b1, float b2, float h, int leftRight){
        maxVal=h;
        length=b1;
        slopeLength=(length-upperLength)/2f;
        slope = maxVal/slopeLength;
        //wip code for left/right centered trapezoidal curves
    }

    @Override
    public float getValue(float x) {
        if(x < slopeLength){
            return x * slope;

        }
        else if(x < (length-upperLength)/2f +length){
            return  maxVal;
        }
        else{
            return  maxVal - x * slope;
        }
    }
}
