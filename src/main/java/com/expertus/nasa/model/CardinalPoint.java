package com.expertus.nasa.model;

import java.util.Arrays;
import java.util.List;

public enum CardinalPoint {
    N(Arrays.asList(0, -360, 360)) {
        @Override
        public Position moveForward(Coordinates coordinates) {
            coordinates.incrementOrdinate();
            return new Position(coordinates, this);
        }
    },
    E(Arrays.asList(-270, 90)) {
        @Override
        public Position moveForward(Coordinates coordinates) {
            coordinates.incrementAbsciss();
            return new Position(coordinates, this);
        }
    },
    S(Arrays.asList(-180, 180)) {
        @Override
        public Position moveForward(Coordinates coordinates) {
            coordinates.decrementOrdinate();
            return new Position(coordinates, this);
        }
    },
    W(Arrays.asList(-90, 270)) {
        @Override
        public Position moveForward(Coordinates coordinates) {
            coordinates.decrementAbsciss();
            return new Position(coordinates, this);
        }
    };

    private final List<Integer> degrees;

    private CardinalPoint(List<Integer> degrees) {
        this.degrees = degrees;
    }

    public List<Integer> getDegrees() {
        return degrees;
    }

    public abstract Position moveForward(Coordinates coordinates);

    public static CardinalPoint findByDegrees(int degrees) {
        return Arrays.asList(values()).stream().
                filter(o -> o.getDegrees().contains(degrees)).
                findAny().orElseThrow(() -> new IllegalArgumentException("Illegal degrees value"));
    }

}
