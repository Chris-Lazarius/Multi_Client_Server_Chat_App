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
            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String sMsg1 = "", sMsg2 = "";
            while(!sMsg1.equals("stop"))
            {
                sMsg1 = din.readUTF();
            }

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
