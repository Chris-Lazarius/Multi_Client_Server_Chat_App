package ServerSide;
import java.io.*;
import java.net.*;

public class Server {
    /*
import java.io.*;
import java.net.*;
     */
    public static void main(String[] args) throws IOException {
        String sMsg1 = "", sMsg2 = "";
        try {
            ServerSocket ssc = new ServerSocket(8888);
            Socket sc = ssc.accept();
            DataInputStream din = new DataInputStream(sc.getInputStream());
            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(!sMsg1.equals("stop"))
            {
                sMsg1 = din.readUTF();
                System.out.println("client say: " + sMsg1);
                sMsg2 = br.readLine();
                dout.writeUTF(sMsg2);
                dout.flush();
            }
            ssc.close();
            sc.close();
            din.close();
            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
