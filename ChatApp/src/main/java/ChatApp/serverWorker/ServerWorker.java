package ChatApp.serverWorker;

import java.util.Scanner;

public interface ServerWorker extends Runnable{
    void clientListener();

    void writeToClient(Scanner scanner);
}
