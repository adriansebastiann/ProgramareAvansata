import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Server class
public class Server {
    public static void main(String[] args) throws IOException {
        // server is listening on port 5056
        ServerSocket serverSocket = new ServerSocket(5056);

        // running infinite loop for getting
        // client request
        while (true) {
            Socket socket = null;

            try {
                // socket object to receive incoming client requests
                socket = serverSocket.accept();

                System.out.println("A new client is connected : " + socket);

                // obtaining input and out streams
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                System.out.println("Assigning new thread for this client");

                // create a new thread object
                Thread t = new ClientHandler(socket, dataInputStream, dataOutputStream);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
    }
}