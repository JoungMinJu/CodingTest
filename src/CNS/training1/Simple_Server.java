package CNS.training1;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Simple_Server {
    public static void main(String[] args) {
        BufferedWriter bw;
        PrintWriter pw = null;
        OutputStream os; // 바이트 기반 출력 스트림의 최상위 추상 클래스
        ServerSocket serverSocket;
        Socket s1 = null;
        InetAddress ipAddrs = null; // IP 주소 표현하는 클래스
        String connectedClient = null;
        String outMessage = null;

        try{
            serverSocket = new ServerSocket(8404);
            System.out.println("SERVER ON...");
            while(true){
                //주기적으로 외부에서 ServerSocket() 연결 요청을 감시하고 연결요청시 연결을 허락한다.
                s1 = serverSocket.accept();
                os = s1.getOutputStream();
                ipAddrs = s1.getInetAddress();
                connectedClient = ipAddrs.toString();
                bw = new BufferedWriter(new OutputStreamWriter(os));
                pw  = new PrintWriter(bw, true); // (Writer out, boolean flush)
                // true이면 println, printf, or format 메서드는 출력 버퍼를 flush한다.
                // flush = 현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다.
                pw.println(connectedClient+" is correctly connected!");
                pw.close();
                s1.close();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
