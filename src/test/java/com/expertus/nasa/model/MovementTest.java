package com.expertus.nasa.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MovementTest {

    @Test
    public void shouldGetNextPositionFromLeft() {
        //given
        Coordinates coordinates = new Coordinates(0, 0);
        Position position = new Position(coordinates, CardinalPoint.N);
        // when
        Position actual = Movement.L.nexPosition(position);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.W);
        assertTrue(actual.getCoordinates().getAbsciss() == 0);
        assertTrue(actual.getCoordinates().getOrdinate() == 0);
    }

    @Test
    public void shouldGetNextPositionFromRight() {
        //given
        Coordinates coordinates = new Coordinates(0, 0);
        Position position = new Position(coordinates, CardinalPoint.S);
        // when
        Position actual = Movement.R.nexPosition(position);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.W);
        assertTrue(actual.getCoordinates().getAbsciss() == 0);
        assertTrue(actual.getCoordinates().getOrdinate() == 0);
    }

    @Test
    public void shouldMoveForward_north() {
        //given
        Coordinates coordinates = new Coordinates(0, 0);
        Position position = new Position(coordinates, CardinalPoint.N);
        // when
        Position actual = Movement.M.nexPosition(position);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.N);
        assertTrue(actual.getCoordinates().getAbsciss() == 0);
        assertTrue(actual.getCoordinates().getOrdinate() == 1);
    }

    @Test
    public void shouldMoveForward_east() {
        //given
        Coordinates coordinates = new Coordinates(0, 0);
        Position position = new Position(coordinates, CardinalPoint.E);
        // when
        Position actual = Movement.M.nexPosition(position);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.E);
        assertTrue(actual.getCoordinates().getAbsciss() == 1);
        assertTrue(actual.getCoordinates().getOrdinate() == 0);
    }

    @Test
    public void shouldMoveForward_south() {
        //given
        Coordinates coordinates = new Coordinates(1, 1);
        Position position = new Position(coordinates, CardinalPoint.S);
        // when
        Position actual = Movement.M.nexPosition(position);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.S);
        assertTrue(actual.getCoordinates().getAbsciss() == 1);
        assertTrue(actual.getCoordinates().getOrdinate() == 0);
    }

    @Test
    public void shouldMoveForward_west() {
        //given
        Coordinates coordinates = new Coordinates(1, 1);
        Position position = new Position(coordinates, CardinalPoint.W);
        // when
        Position actual = Movement.M.nexPosition(position);
        // then
        assertTrue(actual.getCardinalPoint() == CardinalPoint.W);
        assertTrue(actual.getCoordinates().getAbsciss() == 0);
        assertTrue(actual.getCoordinates().getOrdinate() == 1);
    }

}
