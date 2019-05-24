package com.expertus.nasa.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CardinalPointTest {

    @Test
    public void shouldFindByDegrees() {
        //given
        int northDegrees = 0;
        // when
        CardinalPoint cp = CardinalPoint.findByDegrees(northDegrees);
        // then
        assertTrue(cp == CardinalPoint.N);

        //given
        int eastDegrees = 90;
        // when
        cp = CardinalPoint.findByDegrees(eastDegrees);
        // then
        assertTrue(cp == CardinalPoint.E);

        //given
        int southDegrees = 180;
        // when
        cp = CardinalPoint.findByDegrees(southDegrees);
        // then
        assertTrue(cp == CardinalPoint.S);

        //given
        int westDegrees = 270;
        // when
        cp = CardinalPoint.findByDegrees(westDegrees);
        // then
        assertTrue(cp == CardinalPoint.W);
    }

    @Test
    public void shouldGetNextPositionFromNorth() {
        //given
        Coordinates coordinates = new Coordinates(0, 0);
        // when
        Position actual = CardinalPoint.N.moveForward(coordinates);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.N);
        assertTrue(actual.getCoordinates().getAbsciss() == 0);
        assertTrue(actual.getCoordinates().getOrdinate() == 1);
    }

    @Test
    public void shouldGetNextPositionFromEast() {
        //given
        Coordinates coordinates = new Coordinates(0, 0);
        // when
        Position actual = CardinalPoint.E.moveForward(coordinates);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.E);
        assertTrue(actual.getCoordinates().getAbsciss() == 1);
        assertTrue(actual.getCoordinates().getOrdinate() == 0);
    }

    @Test
    public void shouldGetNextPositionFromSouth() {
        //given
        Coordinates coordinates = new Coordinates(1, 1);
        // when
        Position actual = CardinalPoint.S.moveForward(coordinates);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.S);
        assertTrue(actual.getCoordinates().getAbsciss() == 1);
        assertTrue(actual.getCoordinates().getOrdinate() == 0);
    }

    @Test
    public void shouldGetNextPositionFromWest() {
        //given
        Coordinates coordinates = new Coordinates(1, 1);
        // when
        Position actual = CardinalPoint.W.moveForward(coordinates);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.W);
        assertTrue(actual.getCoordinates().getAbsciss() == 0);
        assertTrue(actual.getCoordinates().getOrdinate() == 1);
    }
}
