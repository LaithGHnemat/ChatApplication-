package ChatApp.run;

import ChatApp.reader.SocketReader;
import ChatApp.reader.SocketReaderImpl;
import ChatApp.serverWorker.ServerWorker;
import ChatApp.serverWorker.ServerWorkerImpl;
import ChatApp.socketWriter.SocketWriter;
import ChatApp.socketWriter.SocketWriterImpl;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {
    private static ExecutorService threadPool;

    public static void main(String[] args) {

        try {
            threadPool = Executors.newCachedThreadPool();
            System.out.println("waiting for clients");
            while (true) {
                try {
                    ServerSocket server = new ServerSocket(5000);
                    Socket clientSocket = server.accept();
                    System.out.println("Client Connected!");
                    //creating clients connection listener
                    SocketReader reader = new SocketReaderImpl(clientSocket);
                    SocketWriter socketWriter = new SocketWriterImpl(clientSocket);
                    ServerWorker serverWorker = new ServerWorkerImpl(socketWriter, reader);
                    threadPool.execute(serverWorker);
                } catch (BindException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
