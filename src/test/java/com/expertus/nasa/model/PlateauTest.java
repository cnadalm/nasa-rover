package com.expertus.nasa.model;

import static com.expertus.nasa.model.CardinalPoint.E;
import static com.expertus.nasa.model.CardinalPoint.N;
import static com.expertus.nasa.model.CardinalPoint.W;
import static com.expertus.nasa.model.Movement.L;
import static com.expertus.nasa.model.Movement.M;
import static com.expertus.nasa.model.Movement.R;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlateauTest {

    @Test
    public void shouldPerformItinerary_asSample() {
        //given
        Position r1Position = new Position(new Coordinates(1, 2), N);
        List<Movement> r1Movements = Arrays.asList(L, M, L, M, L, M, L, M, M);

        Position r2Position = new Position(new Coordinates(3, 3), E);
        List<Movement> r2Movements = Arrays.asList(M, M, R, M, M, R, M, R, R, M);

        // when
        Plateau plateau = new Plateau(new Coordinates(5, 5));
        plateau.performItinerary(r1Position, r1Movements);
        plateau.performItinerary(r2Position, r2Movements);

        // then
        List<Position> deployment = plateau.getDeployment();
        assertTrue(deployment.get(0).equals(new Position(new Coordinates(1, 3), N)));
        assertTrue(deployment.get(1).equals(new Position(new Coordinates(5, 1), E)));
    }

    @Test
    public void shouldPerformItinerary_withRoverInOutOfBounds() {
        //given
        Position r1Position = new Position(new Coordinates(6, 4), N);
        List<Movement> r1Movements = Arrays.asList(L, M, L, M, L, M, L, M, M);

        // when
        Plateau plateau = new Plateau(new Coordinates(5, 5));
        plateau.performItinerary(r1Position, r1Movements);

        // then
        List<Position> deployment = plateau.getDeployment();
        assertTrue(deployment.isEmpty());
    }

    @Test
    public void shouldPerformItinerary_withTwoCollisions() {
        //given
        Position r1Position = new Position(new Coordinates(1, 2), N);
        List<Movement> r1Movements = Arrays.asList(L, M, L, M, L, M, L, M, M);

        Position r2Position = new Position(new Coordinates(2, 2), E);
        List<Movement> r2Movements = Arrays.asList(L, M, L, M, M, M);

        Position r3Position = new Position(new Coordinates(4, 4), E);
        List<Movement> r3Movements = Arrays.asList(M, M, M);

        // when
        Plateau plateau = new Plateau(new Coordinates(5, 5));
        plateau.performItinerary(r1Position, r1Movements);
        plateau.performItinerary(r2Position, r2Movements);
        plateau.performItinerary(r3Position, r3Movements);

        // then
        List<Position> deployment = plateau.getDeployment();
        assertTrue(deployment.get(0).equals(new Position(new Coordinates(1, 3), N)));
        assertTrue(deployment.get(1).equals(new Position(new Coordinates(2, 3), W)));
        assertTrue(deployment.get(2).equals(new Position(new Coordinates(5, 4), E)));
    }

}
