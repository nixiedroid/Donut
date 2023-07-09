package com.nixiedroid.Donut.render;

public class LightSource {
    private final Coords lightSourceCoords;
    private LightSource() {
        this.lightSourceCoords = new Coords(0, 0, 0);
    }
    public Coords getCoords(){
        return lightSourceCoords;
    }
    private LightSource normalise(){
        lightSourceCoords.normalise();
        return this;
    }
    @SuppressWarnings("unused")
    public static class Builder {
        private final LightSource lightSource;
        public Builder(){
            lightSource = new LightSource();
        }
        public Builder placeUp(){
            lightSource.lightSourceCoords.y = -1;
            return this;
        }
        public Builder placeDown(){
            lightSource.lightSourceCoords.y = 1;
            return this;
        }
        public Builder placeLeft(){
            lightSource.lightSourceCoords.x = -1;
            return this;
        }
        public Builder placeRight(){
            lightSource.lightSourceCoords.x = 1;
            return this;
        }
        public Builder placeForwards(){
            lightSource.lightSourceCoords.z = 1;
            return this;
        }
        public Builder placeBackwards(){
            lightSource.lightSourceCoords.z = -1;
            return this;
        }
        public LightSource normalise(){
            return lightSource.normalise();
        }
    }
}
