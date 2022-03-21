package ChatApp.socketWriter;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketWriterImpl implements SocketWriter{
    private  Socket socket;
    private  DataOutputStream write;

    public SocketWriterImpl(Socket socket) {
        this.socket = socket;
    }

    public SocketWriterImpl() {
    }

    public void write(String string) {
        try {
            write = new DataOutputStream(socket.getOutputStream());
            write.writeUTF(string);   // write.writeUTF(string.toUpperCase());// here to send the words in upper case
            System.out.println(Thread.currentThread().getName());
            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        write = null;
    }
}
