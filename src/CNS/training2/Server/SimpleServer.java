package CNS.training2.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SimpleServer {
    public static void main(String[] args) {
        BufferedReader br_out;
        BufferedWriter bw;
        PrintWriter pw = null;
        OutputStream os;
        ServerSocket serverSocket;
        Socket s1 = null;
        String outMessage = null;

        try{
            serverSocket = new ServerSocket(8404);
            System.out.println("Server ON...");
            s1 = serverSocket.accept(); // 해당 클라이언트와 통신할 수 있는 소켓 만듬
            os = s1.getOutputStream(); // 데이터 보내기 위한
            RecThread rThread = new RecThread(s1);
            //start()는 코드의 완료 여부와 상관없이 계속 아래 코드를 수행하기 때문에
            //멀티 스레드를 사용하는 경우에는 run()이 아닌 start를 사용해 줘야 한다는 것!
            rThread.start();

            br_out = new BufferedReader(new InputStreamReader(System.in)); // 입력받음
            bw = new BufferedWriter(new OutputStreamWriter(os));
            pw = new PrintWriter(bw, true);
            pw.println("server: Welcome to connection");

            while(true){
                outMessage = br_out.readLine();
                if(outMessage.equals("exit")) break;
                pw.println("server= "+outMessage);
            }

            pw.close();
            s1.close();

            if(rThread.isAlive()){
                rThread.interrupt();
                rThread = null;
            }
        }catch(SocketException e){
            System.out.println("Connection Closed ...");
            System.exit(0);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
