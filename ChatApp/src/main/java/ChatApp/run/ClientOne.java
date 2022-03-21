package ChatApp.run;

import ChatApp.client.Client;
import ChatApp.client.ClientImpl;
import ChatApp.reader.SocketReader;
import ChatApp.reader.SocketReaderImpl;
import ChatApp.socketWriter.SocketWriter;
import ChatApp.socketWriter.SocketWriterImpl;

import java.io.IOException;
import java.net.Socket;

public class ClientOne {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            SocketReader reader = new SocketReaderImpl(socket);
            SocketWriter writer = new SocketWriterImpl(socket);
            Client client = new ClientImpl(writer, reader);
            Thread thread = new Thread(client);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
