import utils.ServerStatus;
import utils.State;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

// Server class
public class Server {
    public static void main(String[] args) throws IOException {
        // server is listening on port 5056
        ServerSocket serverSocket = new ServerSocket(5056);
        ServerStatus status = new ServerStatus();
        status.setRunning(true);
        status.setNotAcceptingAnyMoreClients(false);

        // running infinite loop for getting
        // client request
        while (true) {
            Socket socket = null;
            try {
                // socket object to receive incoming client requests
                socket = serverSocket.accept();
                if(status.isNotAcceptingAnyMoreClients()){
                    System.out.println("The server is not accepting more clients");
                    socket = serverSocket.accept();
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF("The server is not accepting more clients");
                    Thread.sleep(3000);
                    socket.close();
                    break;
                }

                System.out.println("A new client is connected : " + socket);

                // obtaining input and out streams
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                System.out.println("Assigning new thread for this client");

                // create a new thread object
                Thread t = new ClientHandler(socket, dataInputStream, dataOutputStream, status);

                // Invoking the start() method
                t.start();

            }  catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
    }
}