package com.probe.seaprobe.dto;

import java.util.List;

public class CommandRequest {
    private List<String> commands;

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}
