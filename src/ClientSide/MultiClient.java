package ClientSide;


import java.io.*;
import java.net.*;


public class MultiClient {
    
    public static void main(String[] args) {
        String sMsg1 = "", sMsg2 = "";
        try {
            Socket sc = new Socket("127.0.0.1", 8888);
            DataInputStream din = new DataInputStream(sc.getInputStream());
            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(!sMsg1.equals("stop"))
            {
                System.out.println("Client: ");
                sMsg1 = br.readLine();
                dout.writeUTF(sMsg1);
                dout.flush();
                sMsg2 = din.readUTF();
                System.out.println("server say: " + sMsg2);
            }
            sc.close();
            dout.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
