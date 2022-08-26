package HandlingThread;

import java.io.*;
import java.net.Socket;
import java.util.logging.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class HandlingClass extends Thread {
    
    Socket client;
    int iClientNumber;

    public HandlingClass(Socket client, int iClientNumber) {
        this.client = client;
        this.iClientNumber = iClientNumber;
    }

    @Override
    public void run() {
        DataInputStream inStream = null;
        try {
            inStream = new DataInputStream(client.getInputStream());
            DataOutputStream outStream = new DataOutputStream(client.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String sMsg1 = "", sMsg2 = "";
            while (!sMsg1.equalsIgnoreCase("bye")) {
                sMsg1 = inStream.readUTF();
                System.out.println("Client " + iClientNumber + " said: " + sMsg1);
                System.out.println("Reply to client " + iClientNumber + ": ");
                sMsg2 = br.readLine();
                outStream.writeUTF(sMsg2);
                outStream.flush();
            }
            outStream.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(HandlingClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                inStream.close();
            } catch (IOException ex) {
                Logger.getLogger(HandlingClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
