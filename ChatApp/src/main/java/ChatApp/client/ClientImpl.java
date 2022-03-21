package ChatApp.client;

import ChatApp.reader.SocketReader;
import ChatApp.socketWriter.SocketWriter;

import java.io.IOException;
import java.util.Scanner;

public class ClientImpl implements Client{
       SocketWriter writer;
     SocketReader socketReader;

    public ClientImpl(SocketWriter socketWriter, SocketReader Reader) throws IOException {
        writer = socketWriter;
        socketReader = Reader;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        readFromServer();
        writeToServer(scanner);
    }

    public void writeToServer(Scanner scanner) {
        while (scanner.hasNext()) {
            writer.write(scanner.nextLine());
        }
    }

    public void readFromServer() {
        Thread thread = new Thread(() -> {

            while (true) {
                //  exit();
               // synchronized (this){}

                System.out.println(socketReader.readLine());
            }



        });
        thread.start();
    }

// private void exit(){
//     if(socketReader.readLine().equals("exit")){
//         System.out.println("Exit! we are gonna exit this connection now ");
//         System.exit(0);
//     }
    //}

}
