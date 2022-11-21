package Client;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

public class ClientThread extends Thread{
    private DatagramSocket datagramSocket;
    public ClientThread(int port) { try { this.datagramSocket = new DatagramSocket(port); } catch (Exception e) { e.printStackTrace(); } }
    public void run() {
        byte[] data = new byte[1024 * 16];
        int length;
        //16KB
        File file = new File("D:\\Code\\UDP\\movie.mp4");
        //随便传个10个G的电影吧，格式要求mp4
        Random rand = new Random();
        try {
            DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length);
            FileOutputStream outputStream = new FileOutputStream(file);
            do {
                datagramSocket.receive(datagramPacket);
                length = datagramPacket.getLength();
                outputStream.write(data, 0, data.length);
                outputStream.flush();
                sleep(rand.nextInt(500));
            }
            while (length > 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
