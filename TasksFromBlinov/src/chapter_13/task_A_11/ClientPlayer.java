package chapter_13.task_A_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientPlayer {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        Scanner in = new Scanner(System.in);
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8040);
            br = new BufferedReader(new InputStreamReader( socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());
            System.out.println(br.readLine());
            String readAnswerPlayer = "";
            String serverMessage = "";
            do {
                readAnswerPlayer = in.next();
                ps.println(readAnswerPlayer);
                serverMessage = br.readLine();
                System.out.println(serverMessage);
                if (serverMessage.contains("LOST") || serverMessage.contains("WINNER") ){
                    break;
                }
            }while (readAnswerPlayer.equals("Y"));
//            if (readAnswerPlayer.equals("N")){
//                serverMessage = br.readLine();
//                System.out.println(serverMessage);
//            }
        } catch (IOException e) {
            System.err.println("ошибка: " + e);
        } finally {
            if (br != null) {
                try{
                    br.close();
                }catch (IOException e){
                    System.err.println(e.getMessage());
                }
            }
            if (socket != null) {
                try { // разрыв соединения
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
