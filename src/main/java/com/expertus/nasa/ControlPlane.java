package com.expertus.nasa;

import static com.expertus.nasa.model.CardinalPoint.*;
import com.expertus.nasa.model.Coordinates;
import com.expertus.nasa.model.Movement;
import static com.expertus.nasa.model.Movement.L;
import static com.expertus.nasa.model.Movement.M;
import static com.expertus.nasa.model.Movement.R;
import com.expertus.nasa.model.Plateau;
import com.expertus.nasa.model.Position;
import java.util.Arrays;
import java.util.List;

/**
 * This class is responsible to instance a Plateau object then call the
 * <code>performItinerary()</code> method.
 *
 * The data set could be allocated in a simple file or in a directory, or could
 * be received in a file by a rest endpoint...
 */
public class ControlPlane {

    public static void main(String[] args) {

        Position r1Position = new Position(new Coordinates(1, 2), N);
        List<Movement> r1Movements = Arrays.asList(L, M, L, M, L, M, L, M, M);

        Position r2Position = new Position(new Coordinates(3, 3), E);
        List<Movement> r2Movements = Arrays.asList(M, M, R, M, M, R, M, R, R, M);

        Plateau plateau = new Plateau(new Coordinates(5, 5));
        plateau.performItinerary(r1Position, r1Movements);
        plateau.performItinerary(r2Position, r2Movements);

        print(plateau.getDeployment());
    }

    private static void print(List<Position> deployment) {

        System.out.println("### Deployment result:");
        deployment.forEach(position -> System.out.println(position));
    }
}
