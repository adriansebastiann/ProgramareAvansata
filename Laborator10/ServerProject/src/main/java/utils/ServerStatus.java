package utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServerStatus {
    private boolean isRunning;
    private boolean isNotAcceptingAnyMoreClients;

    public ServerStatus() {
        this.isRunning = false;
        this.isNotAcceptingAnyMoreClients = false;
    }
}
