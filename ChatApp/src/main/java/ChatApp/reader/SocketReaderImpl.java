package ChatApp.reader;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketReaderImpl implements SocketReader {

    public SocketReaderImpl() {
    }

    private volatile DataInputStream dataInputStream;

    public SocketReaderImpl(Socket socket) {
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLine() {

        String line = null;
        try {
            while (dataInputStream.available() == 0) {
            }
            line = dataInputStream.readUTF();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line.equalsIgnoreCase("exit")) {
            System.out.println(line + "! we are gonna Terminate the process in this client");
            System.exit(0);//
        }
        return line;
    }
}
