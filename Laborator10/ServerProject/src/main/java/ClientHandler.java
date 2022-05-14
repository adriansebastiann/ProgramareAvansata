import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientHandler extends Thread {
    final DataInputStream dataInputStream;
    final DataOutputStream outputStream;
    final Socket socket;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.socket = s;
        this.dataInputStream = dis;
        this.outputStream = dos;
    }

    @Override
    public void run() {
        String received;
        while (true) {
            try {
                // Ask user what he wants
                outputStream.writeUTF("What do you want? Please type a command..\n" +
                        "Type Exit to terminate connection.");

                // receive the answer from client
                received = dataInputStream.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                } else {
                    System.out.println("The desired command is: " + received);
                    outputStream.writeUTF("Cool! We are working on that!");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // closing resources
            this.dataInputStream.close();
            this.outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}