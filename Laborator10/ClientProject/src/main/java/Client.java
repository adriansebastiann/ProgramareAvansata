
// Java implementation for a client
// Save file as Client.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

// Client class
public class Client {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5056
            Socket socket = new Socket(ip, 5056);
            socket.setSoTimeout(5*1000);

            // obtaining input and out streams
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // the following loop performs the exchange of
            // information between client and client handler
            while (true) {
                String input = inputStream.readUTF();
                System.out.println(input);
                if(input.startsWith("The server is not accepting more clients")){
                    break;
                }
                System.out.print("Command: ");
                String toSend = scanner.nextLine();
                outputStream.writeUTF(toSend);

                // If client sends exit,close this connection 
                // and then break from the while loop
                if (toSend.equals("Exit")) {
                    System.out.println("Closing this connection : " + socket);
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                socket.setSoTimeout(5*1000);
                // printing date or time as requested by client
            }

            // closing resources
            scanner.close();
            inputStream.close();
            outputStream.close();
        } catch(SocketException e) {
            System.out.println("Connection with server lost! You've waited too much!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}