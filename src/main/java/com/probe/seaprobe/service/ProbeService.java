package com.probe.seaprobe.service;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.probe.seaprobe.dto.CommandRequest;
import com.probe.seaprobe.dto.InitRequest;
import com.probe.seaprobe.dto.StatusResponse;
import com.probe.seaprobe.exception.InvalidCommandException;
import com.probe.seaprobe.model.Direction;
import com.probe.seaprobe.model.Grid;
import com.probe.seaprobe.model.Position;
import com.probe.seaprobe.model.Probe;

@Service
public class ProbeService {
    private Probe probe;
    private Grid grid;

    public void initializeProbe(InitRequest request) {
        Direction direction;
        try {
            direction = Direction.valueOf(request.getDirection().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandException("Invalid direction: " + request.getDirection());
        }

        Position start = new Position(request.getX(), request.getY());
        this.grid = new Grid(10, 10, new HashSet<>()); // 10x10 grid, no obstacles for now
        this.probe = new Probe(start, direction);
    }

    public void processCommands(CommandRequest request) {
        if (probe == null || grid == null) {
            throw new InvalidCommandException("Probe is not initialized.");
        }

        for (String cmd : request.getCommands()) {
            switch (cmd.toUpperCase()) {
                case "F":
                    probe.moveForward(grid);
                    break;
                case "B":
                    probe.moveBackward(grid);
                    break;
                case "L":
                    probe.turnLeft();
                    break;
                case "R":
                    probe.turnRight();
                    break;
                default:
                    throw new InvalidCommandException("Invalid command: " + cmd);
            }
        }
    }

    public StatusResponse getStatus() {
        if (probe == null) {
            throw new InvalidCommandException("Probe is not initialized.");
        }
        Position pos = probe.getPosition();
        return new StatusResponse(pos.getX(), pos.getY(), probe.getDirection().name(), probe.getVisited());
    }
}
