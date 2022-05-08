package CNS.training2.Server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecThread extends Thread{
    InputStream is;
    BufferedReader br_in;
    Socket socket = null;
    String inMessage = null;

    // 수신 스레드가 사용하는 소켓을 정의해준다.
    public RecThread(Socket s){
        this.socket = s;
    }

    @Override
    public void run() {
        try{
            is = socket.getInputStream(); // 데이터 받기 위한 stream
            br_in = new BufferedReader(new InputStreamReader(is)); // 데이터 받아들임
            while(true){
                inMessage = br_in.readLine(); // socket의 입력 메세지 inMessage에 담음
                System.out.println(inMessage);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
