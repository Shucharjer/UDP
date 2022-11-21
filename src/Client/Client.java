package Client;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Client {
    public static void main(String[] args) {
        ClientThread clientThread = new ClientThread(60114);
        clientThread.start();
    }
}
