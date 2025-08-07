package com.probe.seaprobe.dto;

import java.util.List;

import com.probe.seaprobe.model.Position;

public class StatusResponse {
    private int x;
    private int y;
    private String direction;
    private List<Position> visited;

    public StatusResponse(int x, int y, String direction, List<Position> visited) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.visited = visited;
    }

    public int getX() { return x; }
    public String getDirection() { return direction; }
    public int getY() { return y; }
    public List<Position> getVisited() { return visited; }
}
