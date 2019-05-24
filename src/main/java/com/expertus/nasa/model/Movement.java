package com.expertus.nasa.model;

public enum Movement {
    L {
        @Override
        public Position nexPosition(Position position) {
            CardinalPoint nextCardinal = rotateTo(position.getCardinalPoint(), -90);
            return new Position(position.getCoordinates().copy(), nextCardinal);
        }
    },
    R {
        @Override
        public Position nexPosition(Position position) {
            CardinalPoint nextCardinal = rotateTo(position.getCardinalPoint(), 90);
            return new Position(position.getCoordinates().copy(), nextCardinal);
        }
    },
    M {
        @Override
        public Position nexPosition(Position position) {
            return position.getCardinalPoint().
                    moveForward(position.getCoordinates().copy());
        }
    };

    private static CardinalPoint rotateTo(CardinalPoint cp, int degreesToRotate) {
        return CardinalPoint.findByDegrees(cp.getDegrees().get(0) + degreesToRotate);
    }

    public abstract Position nexPosition(Position position);
}
