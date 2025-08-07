package com.probe.seaprobe.model;

import java.util.ArrayList;
import java.util.List;

public class Probe {
    private Position position;
    private Direction direction;
    private final List<Position> visited;

    public Probe(Position startPosition, Direction startDirection) {
        this.position = startPosition;
        this.direction = startDirection;
        this.visited = new ArrayList<>();
        this.visited.add(new Position(startPosition.getX(), startPosition.getY()));
    }

    public void moveForward(Grid grid) {
        Position newPos = getNextPosition(1);
        if (grid.isWithinBounds(newPos) && !grid.isObstacle(newPos)) {
            position = newPos;
            visited.add(new Position(newPos.getX(), newPos.getY()));
        }
    }

    public void moveBackward(Grid grid) {
        Position newPos = getNextPosition(-1);
        if (grid.isWithinBounds(newPos) && !grid.isObstacle(newPos)) {
            position = newPos;
            visited.add(new Position(newPos.getX(), newPos.getY()));
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Position> getVisited() {
        return visited;
    }

    private Position getNextPosition(int step) {
        int x = position.getX();
        int y = position.getY();

        switch (direction) {
            case UP:
                return new Position(x, y + step);
            case DOWN:
                return new Position(x, y - step);
            case RIGHT:
                return new Position(x + step, y);
            case LEFT:
                return new Position(x - step, y);
            default:
                throw new IllegalStateException("Unknown direction: " + direction);
        }
    }
}
