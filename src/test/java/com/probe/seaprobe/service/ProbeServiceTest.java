package com.probe.seaprobe.service;

import com.probe.seaprobe.dto.CommandRequest;
import com.probe.seaprobe.dto.InitRequest;
import com.probe.seaprobe.dto.StatusResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProbeServiceTest {

    private ProbeService probeService;

    @BeforeEach
    void setUp() {
        probeService = new ProbeService();

        InitRequest init = new InitRequest();
        init.setX(0);
        init.setY(0);
        init.setDirection("UP"); // must be a valid enum name
        probeService.initializeProbe(init);
    }

    @Test
    void testProcessCommands() {
        CommandRequest cmd = new CommandRequest();
        cmd.setCommands(Arrays.asList("F", "R", "F"));

        assertDoesNotThrow(() -> probeService.processCommands(cmd));

        StatusResponse status = probeService.getStatus();
        assertEquals(1, status.getX());
        assertEquals(1, status.getY());
        assertEquals("RIGHT", status.getDirection());
    }

    @Test
    void testVisitedPath() {
        CommandRequest cmd = new CommandRequest();
        cmd.setCommands(Arrays.asList("F", "F"));

        probeService.processCommands(cmd);
        StatusResponse status = probeService.getStatus();

        // start + 2 moves = 3
        assertEquals(3, status.getVisited().size());
    }
}
