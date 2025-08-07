package com.probe.seaprobe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProbeTest {
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid(5, 5, new HashSet<>());
    }

    @Test
    void testForwardMovement() {
        Probe probe = new Probe(new Position(0, 0), Direction.UP);
        probe.moveForward(grid);
        assertEquals(0, probe.getPosition().getX());
        assertEquals(1, probe.getPosition().getY());
    }

    @Test
    void testBackwardMovement() {
        Probe probe = new Probe(new Position(1, 1), Direction.UP);
        probe.moveBackward(grid);
        assertEquals(1, probe.getPosition().getX());
        assertEquals(0, probe.getPosition().getY());
    }

    @Test
    void testTurnLeft() {
        Probe probe = new Probe(new Position(0, 0), Direction.UP);
        probe.turnLeft();
        assertEquals(Direction.LEFT, probe.getDirection());
    }

    @Test
    void testTurnRight() {
        Probe probe = new Probe(new Position(0, 0), Direction.UP);
        probe.turnRight();
        assertEquals(Direction.RIGHT, probe.getDirection());
    }

    @Test
    void testObstacleAvoidance() {
        HashSet<Position> obstacles = new HashSet<>();
        obstacles.add(new Position(0, 1));
        Grid obstacleGrid = new Grid(5, 5, obstacles);

        Probe probe = new Probe(new Position(0, 0), Direction.UP);
        probe.moveForward(obstacleGrid);  // should be blocked
        assertEquals(0, probe.getPosition().getY());
    }
}
