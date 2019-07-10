package org.exponential.paths;

public class Line extends PathComponent{
    public float distance;
    public Line(float distance){
        this.distance = distance;
    }

    @Override
    public float getDistance() {
        return distance;
    }

    @Override
    public float getDegrees() {
        return 0;
    }

    @Override
    public float getHeading(float distance) {
        return 0;
    }
}
