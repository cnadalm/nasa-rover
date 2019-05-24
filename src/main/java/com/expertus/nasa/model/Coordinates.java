package com.expertus.nasa.model;

public class Coordinates {

    private int absciss;
    private int ordinate;

    public Coordinates(int absciss, int ordinate) {
        this.absciss = absciss;
        this.ordinate = ordinate;
    }

    public int getAbsciss() {
        return absciss;
    }

    public int getOrdinate() {
        return ordinate;
    }

    public void incrementAbsciss() {
        ++absciss;
    }

    public void decrementAbsciss() {
        --absciss;
    }

    public void incrementOrdinate() {
        ++ordinate;
    }

    public void decrementOrdinate() {
        --ordinate;
    }

    public Coordinates copy() {
        return new Coordinates(this.absciss, this.ordinate);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.absciss;
        hash = 13 * hash + this.ordinate;
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
        final Coordinates other = (Coordinates) obj;
        if (this.absciss != other.absciss) {
            return false;
        }
        return this.ordinate == other.ordinate;
    }

    @Override
    public String toString() {
        return "Coordinate{" + "absciss=" + absciss + ", ordinate=" + ordinate + '}';
    }

}
