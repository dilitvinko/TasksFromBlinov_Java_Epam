package onlyTests.networkProgramms.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetLogic {
    public static void main(String[] args) {
        InetAddress currentIP = null;
        InetAddress bsuIP = null;
        InetAddress elinext = null;
        try {
            currentIP = InetAddress.getLocalHost();
// вывод IP-адреса локального компьютера
            System.out.println("Мой IP -> " + currentIP.getHostAddress());
            bsuIP = InetAddress.getByName("www.bsu.by");
// вывод IP-адреса БГУ www.bsu.by
            System.out.println("BSU -> " + bsuIP.getHostAddress());
            bsuIP = InetAddress.getByName("www.elinext.com");
// вывод IP-адреса ЭЛЯ
            System.out.println("Elinext -> " + bsuIP.getHostAddress());
        } catch (UnknownHostException e) {
// если не удается найти IP
            System.err.println("адрес недоступен " + e);
        }
    }
}
