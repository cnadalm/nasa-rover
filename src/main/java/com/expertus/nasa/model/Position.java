package com.expertus.nasa.model;

import java.util.Objects;

public class Position implements Cloneable {

    private final Coordinates coordinates;
    private final CardinalPoint cardinalPoint;

    public Position(Coordinates coordinates, CardinalPoint cardinalPoint) {
        this.coordinates = new Coordinates(coordinates.getAbsciss(), coordinates.getOrdinate());
        this.cardinalPoint = cardinalPoint;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public CardinalPoint getCardinalPoint() {
        return cardinalPoint;
    }

    public Position copy() {
        return new Position(this.coordinates.copy(), this.cardinalPoint);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.coordinates);
        hash = 47 * hash + Objects.hashCode(this.cardinalPoint);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        return this.cardinalPoint == other.cardinalPoint;
    }

    @Override
    public String toString() {
        return "Position{" + "coordinates=" + coordinates + ", cardinalPoint=" + cardinalPoint + '}';
    }

}
