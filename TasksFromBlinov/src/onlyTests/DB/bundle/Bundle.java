package onlyTests.DB.bundle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ResourceBundle;

public class Bundle {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("testprop");
        String test = resourceBundle.getString("test");
        System.out.println(test);

        //String url = resourceBundle.getString("db.url");
        //String user = resourceBundle.getString("db.user");
    }
}
