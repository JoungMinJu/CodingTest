package CNS.training2.Client;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class SimpleClient {
    public static void main(String[] args) {
        OutputStream os;
        BufferedReader br_out;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        String outMessage = null;

        try{
            Socket s1 = new Socket("127.0.0.1", 8404);
            os = s1.getOutputStream();
            RecThread rThread = new RecThread(s1);
            rThread.start();

            br_out = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(os));
            pw = new PrintWriter(bw, true);

            while(true){
                outMessage = br_out.readLine();
                if(outMessage.equals("exit")) break;
                pw.println("client = "+outMessage);
            }

            pw.close();
            s1.close();

            if(rThread.isAlive()){
                rThread.interrupt();
                rThread = null;
            }
        }
        catch(SocketException e){
            System.out.println("Connection Closed...");
            System.exit(0);
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}
