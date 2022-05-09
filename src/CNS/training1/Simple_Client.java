package CNS.training1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Simple_Client {
    public static void main(String[] args) {
        InputStream is;
        BufferedReader br;
        String message = null;
        try{
            Socket s1 =new Socket("127.0.0.1", 8404);
            is = s1.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            message = br.readLine();
            System.out.println(message);
            s1.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
