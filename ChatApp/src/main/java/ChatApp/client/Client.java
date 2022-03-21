package ChatApp.client;

import java.util.Scanner;

public interface Client extends Runnable{
    void writeToServer(Scanner scanner);
    void readFromServer();
}
