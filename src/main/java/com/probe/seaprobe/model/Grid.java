package com.probe.seaprobe.model;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private final int width;
    private final int height;
    private final Set<Position> obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>();
    }

    public Grid(int width, int height, Set<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles != null ? obstacles : new HashSet<>();
    }

    public boolean isWithinBounds(Position pos) {
        return pos.getX() >= 0 && pos.getX() < width
            && pos.getY() >= 0 && pos.getY() < height;
    }

    public boolean isObstacle(Position pos) {
        return obstacles.contains(pos);
    }

    public void addObstacle(Position pos) {
        obstacles.add(pos);
    }

    public Set<Position> getObstacles() {
        return obstacles;
    }
}
