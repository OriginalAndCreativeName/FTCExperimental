package org.firstinspires.ftc.teamcode;

public class TrapezoidalCurve extends MotionCurve{
     private float upperLength;
     private float slope;
     private float slopeLength;
     private float bias;
    //gen motion curves based on max accel

    TrapezoidalCurve(float b1, float b2, float h, float minBias){
        maxVal=h;
        length=b1;
        upperLength=b2;
        slopeLength=(length-upperLength)/2f;
        slope = maxVal/slopeLength;
        bias = minBias;
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
            if(x * slope > bias){
                return x * slope;
            }
            return bias;

        }
        else if(x < length - ((length-upperLength)/2f) ){
            return  maxVal;
        }
        else{
           // if(maxVal - x * slope > bias){
                return  maxVal - ((x -((length-upperLength)/2f))  * slope);
          //  }

            //return bias;
        }
    }
}
