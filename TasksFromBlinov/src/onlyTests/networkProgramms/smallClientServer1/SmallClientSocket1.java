package onlyTests.networkProgramms.smallClientServer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SmallClientSocket1 {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        PrintStream ps = null;
        try { // получение строки клиентом
            socket = new Socket("localhost", 8030);
/* здесь "ИМЯ_СЕРВЕРА" компьютер,
на котором стоит сервер-сокет"*/
            ps = new PrintStream(socket.getOutputStream());
// помещение строки "привет!" в буфер
            ps.println("привет (клиент)!");
            // отправка содержимого буфера клиенту
            ps.flush();
            br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            String message = br.readLine();
            System.out.println(message);
        } catch (IOException e) {
            System.err.println("ошибка: " + e);
        } finally {
            if (ps != null) {
                ps.close();
            }
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
