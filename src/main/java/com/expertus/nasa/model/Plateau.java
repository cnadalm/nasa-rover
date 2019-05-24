package com.expertus.nasa.model;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private final Coordinates boundaryCoordinates;
    private final List<Position> deploymentPositions;

    public Plateau(Coordinates boundaryCoordinates) {
        this.boundaryCoordinates = boundaryCoordinates;
        this.deploymentPositions = new ArrayList<>();
    }

    public List<Position> getDeployment() {
        return deploymentPositions;
    }

    public void performItinerary(Position initialPosition, List<Movement> movements) {
        if (isValid(initialPosition)) {
            deployRover(initialPosition, movements);
        }
    }

    private void deployRover(Position position, List<Movement> movements) {
        for (Movement movement : movements) {
            Position nextPosition = movement.nexPosition(position);
            if (!isValid(nextPosition)) {
                break;
            }
            position = nextPosition.copy();
        }
        this.deploymentPositions.add(position);
    }

    private boolean isValid(Position position) {
        return !(isOutOfBounds(position) || hasCollision(position));
    }

    private boolean hasCollision(Position position) {
        return deploymentPositions.stream().
                filter(rover -> rover.getCoordinates().equals(position.getCoordinates())).
                findAny().isPresent();
    }

    private boolean isOutOfBounds(Position position) {
        return 0 > position.getCoordinates().getAbsciss()
                || position.getCoordinates().getAbsciss() > boundaryCoordinates.getAbsciss()
                || 0 > position.getCoordinates().getOrdinate()
                || position.getCoordinates().getOrdinate() > boundaryCoordinates.getOrdinate();
    }

}
