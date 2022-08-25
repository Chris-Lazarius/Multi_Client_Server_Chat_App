package ServerSide;
import java.io.*;
import java.net.*;

public class Server {
    /*
import java.io.*;
import java.net.*;
     */
    public static void main(String[] args) throws IOException {
    
        try {
            ServerSocket ssc = new ServerSocket(8888);
            Socket sc = ssc.accept();
            DataInputStream din = new DataInputStream(sc.getInputStream());
            String sMsg = (String)din.readUTF();
            System.out.println("message: " + sMsg);
            ssc.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
