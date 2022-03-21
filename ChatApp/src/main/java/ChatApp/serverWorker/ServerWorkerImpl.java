package ChatApp.serverWorker;

import ChatApp.reader.SocketReader;
import ChatApp.socketWriter.SocketWriter;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ServerWorkerImpl implements ServerWorker{
    SocketReader reader;
    SocketWriter writer;

    public ServerWorkerImpl(SocketWriter socketWriter, SocketReader socketReader) throws IOException {
        writer = socketWriter;
        reader = socketReader;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        clientListener();
        writeToClient(scanner);
    }

    public void clientListener() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                    while (true) {
                        System.out.println(reader.readLine());
                        System.out.println(Thread.currentThread().getName());
                        writer.write(reader.readLine().toUpperCase(Locale.ROOT));

                }
            }
        });
        thread.start();
    }

    public void writeToClient(Scanner scanner) {
        while (scanner.hasNext()) {
            writer.write(scanner.nextLine());
        }
    }
}
