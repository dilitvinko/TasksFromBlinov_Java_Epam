package onlyTests.networkProgramms.smallClientServer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SmallServerSocket1 {
    public static void main(String[] args) {
        Socket s = null;
        PrintStream ps = null;
        BufferedReader br = null;
        try { // отправка строки клиенту
// создание объекта и назначение номера порта
            ServerSocket server = new ServerSocket(8030);
            s = server.accept(); // ожидание соединения
            br = new BufferedReader(new InputStreamReader(
                    s.getInputStream()));
            String message = br.readLine();
            System.out.println(message);
            ps = new PrintStream(s.getOutputStream());
// помещение строки "привет!" в буфер
            ps.println("привет! (сервер)");
// отправка содержимого буфера клиенту
            ps.flush();
        } catch (IOException e) {
            System.err.println("Ошибка соединения потока: " + e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (s != null) {
                try { // разрыв соединения
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
