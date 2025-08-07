package com.probe.seaprobe.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.probe.seaprobe.dto.CommandRequest;
import com.probe.seaprobe.dto.InitRequest;
import com.probe.seaprobe.dto.StatusResponse;
import com.probe.seaprobe.service.ProbeService;

@RestController
@RequestMapping("/probe")
public class ProbeController {
    
    private final ProbeService probeService;

    public ProbeController(ProbeService probeService) {
        this.probeService = probeService;
    }

    @PostMapping("/init")
    public ResponseEntity<String> init(@RequestBody InitRequest request) {
        probeService.initializeProbe(request);
        return ResponseEntity.ok("Probe initialized successfully.");
    }

    @PostMapping("/command")
    public ResponseEntity<String> command(@RequestBody CommandRequest request) {
        probeService.processCommands(request);
        return ResponseEntity.ok("Commands processed.");
    }

    @GetMapping("/status")
    public ResponseEntity<StatusResponse> status() {
        return ResponseEntity.ok(probeService.getStatus());
    }
}
