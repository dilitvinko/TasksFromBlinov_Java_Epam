package chapter_13.task_A_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8040);
            System.out.println("initialized");
            while (true) {
// ожидание клиента
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected");
//создание отдельного потока для обмена данными с соединившимся клиентом
                ServerThread thread = new ServerThread(socket);
// запуск потока
                thread.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }


    public static int randCard(){
        return 2 + (int)(Math.random()*10);
    }

    public static int oneGameServer(){
        int res = 0;
        int diapason = 15 +  (int)(Math.random()*5);  // 15 - 19 диапазон остановки прибавления
        while (res < diapason){
            res += randCard();
        }

        return res;
    }

}

class ServerThread extends Thread {
    private PrintStream os; // передача
    private BufferedReader is; // прием
    private InetAddress addr; // адрес клиента
    public ServerThread(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();
    }
    public void run() {
        int i = 0;
        int firstCard = Server.randCard();
        int secondCard = Server.randCard();
        int sum = firstCard + secondCard;
        int nextCard;
        String str;
        try {
            os.println("Your card is " + firstCard + ", " + secondCard + " and SUMM is " + sum + "\tDo you want next card? (Y/N)");
            while ((str = is.readLine()) != null) {
                if ("Y".equals(str)) {
                    nextCard = Server.randCard();
                    sum += nextCard;
                    if (sum == 21){
                        os.println("Your card is " + nextCard + " and SUMM is " + sum + ". You are WINNER!!!");
                        break;
                    }else if (sum > 21){
                        os.println("Your card is " + nextCard + " and SUMM is " + sum + ". You are LOST! ");
                        break;
                    }else {
                        os.println("Your card is " + nextCard + " and SUMM is " + sum + "\tDo you want next card? (Y/N)");
                    }
                }
                if ("N".equals(str)){
                    int pointsServer = Server.oneGameServer();

                    if(pointsServer > 21 || pointsServer < sum) {
                        os.println("Your score is " + sum + " PC score " + pointsServer + ". You are WINNER!!!");
                        break;
                    }
                    if (pointsServer >= sum ){
                        os.println("Your score is " + sum + " PC score " + pointsServer + ". You are LOST!!!");
                        break;
                    }

                }
                System.out.println("Step "+ ++i);
            }
        }catch (IOException e) {
// если клиент не отвечает, соединение с ним разрывается
            System.err.println("Disconnect");
        } finally {
            disconnect(); // уничтожение потока
        }
    }
    public void disconnect() {
        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
            System.out.println(addr.getHostName() + " disconnecting");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }
}