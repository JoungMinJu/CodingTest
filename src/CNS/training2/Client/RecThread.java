package CNS.training2.Client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecThread extends Thread{
    InputStream is;
    BufferedReader br_in;
    Socket socket = null;
    String inMessage = null;

    public RecThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            is = socket.getInputStream();
            br_in = new BufferedReader(new InputStreamReader(is));
            while(true){
                inMessage = br_in.readLine();
                System.out.println(inMessage);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
