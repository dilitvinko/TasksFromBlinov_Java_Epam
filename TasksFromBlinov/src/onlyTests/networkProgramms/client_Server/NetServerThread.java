package onlyTests.networkProgramms.client_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThread {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8071);
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
        String str;
        try {
            while ((str = is.readLine()) != null) {
                if ("PING(client)".equals(str)) {
                    os.println("PONG " + ++i);
                }
                System.out.println("PING-PONG " + i + " with " + addr.getHostName());
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