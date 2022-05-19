import databaseOperatios.Commands;
import objects.Message;
import utils.ServerStatus;
import utils.State;
import objects.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ClientHandler extends Thread {
    final DataInputStream dataInputStream;
    final DataOutputStream outputStream;
    final Socket socket;
    private User user;
    private ServerStatus status;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, ServerStatus status) {
        this.socket = s;
        this.dataInputStream = dis;
        this.outputStream = dos;
        this.user = new User();
        this.status = status;
    }

    @Override
    public void run() {
        String received;
        this.user.setState(utils.State.DISCONNECTED);
        // Ask user what he wants
        try {
            outputStream.writeUTF("What do you want? Please type a command..\n" +
                    "Type Exit to terminate connection.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                socket.setSoTimeout(10 * 1000);
            } catch (SocketException e) {
                break;
            }
            try {
                // receive the answer from client
                received = dataInputStream.readUTF();
                if (received.equals("Exit")) {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                } else {
                    switch (received.split(" ")[0]) {
                        case "login":
                            if (Commands.userExists(received.split(" ")[1])) {
                                System.out.println("Successfully logged in!!!");
                                outputStream.writeUTF("Successfully logged in!!!");
                                this.user.setState(utils.State.CONNECTED);
                                this.user.setUsername(received.split(" ")[1]);
                            }
                            else{
                                System.out.println("Invalid username :( ");
                                outputStream.writeUTF("Invalid username :( ");
                            }
                            break;
                        case "register":
                            if (Commands.userExists(received.split(" ")[1])) {
                                System.out.println("User already exists!!!");
                                outputStream.writeUTF("User already exists!!!");
                            }
                            else{
                                if (Commands.createUser(received.split(" ")[1])) {
                                    System.out.println("User registered successfully!");
                                    outputStream.writeUTF("User registered successfully!");
                                    this.user.setState(utils.State.CONNECTED);
                                    this.user.setUsername(received.split(" ")[1]);
                                }
                                else {
                                    System.out.println("Error");
                                    outputStream.writeUTF("Error");
                                }
                            }
                            break;
                        case "friend":
                            if(this.user.getState().equals(utils.State.CONNECTED)) {
                                String[] friends = received.split("\\s+");
                                List<String> addedFriends = new ArrayList<>();
                                List<String> deniedFriends = new ArrayList<>();
                                for (int index = 1; index < friends.length; index++) {
                                    if(Commands.userExists(friends[index])) {
                                        addedFriends.add(friends[index]);
                                        Commands.insertFriendship(Commands.getIdByUsername(this.user.getUsername()),
                                                Commands.getIdByUsername(friends[index]));
                                    } else {
                                        deniedFriends.add(friends[index]);
                                    }
                                }
                                outputStream.writeUTF("Added friendship with " + addedFriends + '\n' +
                                        "We are sorry, we don't know " + deniedFriends);
                            } else {
                                outputStream.writeUTF("We are sorry, you need to connect first!");
                            }
                            break;
                        case "send":
                            if(this.user.getState().equals(utils.State.CONNECTED)) {
                                List<Integer> friendsIds = Commands.getFriendsByUsername(this.user.getUsername());
                                String body = received.substring(5);
                                for (Integer friendsId : friendsIds) {
                                    Commands.insertMessage(Commands.getIdByUsername(this.user.getUsername()), friendsId, body);
                                }
                                outputStream.writeUTF("Message send to all friends!");
                            } else {
                                outputStream.writeUTF("We are sorry, you need to connect first!");
                            }
                            break;
                        case "read":
                            if(this.user.getState().equals(utils.State.CONNECTED)) {
                               String allMessages = "You received the following messages until now: " + "\n";
                               for(Message message : Commands.getAllMessagesForUser(this.user.getUsername())) {
                                   allMessages = allMessages + Commands.getUsernameById(message.getIdSender()) + " sent you: " + message.getBody() + "\n";
                               }
                                outputStream.writeUTF(allMessages);
                            } else {
                                outputStream.writeUTF("We are sorry, you need to connect first!");
                            }
                            break;
                        case "stop":
                            if(this.user.getState().equals(utils.State.CONNECTED)) {
                                status.setNotAcceptingAnyMoreClients(true);
                                outputStream.writeUTF("Server received the request..");
                            } else {
                                outputStream.writeUTF("We are sorry, you need to connect first!");
                            }
                            break;
                        default:
                            break;
                    }
                }
            } catch (SocketTimeoutException exception) {
                try {
                    System.out.println("You have lost a soldier, he don't wanna speak with you anymore!");
                    this.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
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