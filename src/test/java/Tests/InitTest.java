package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Properties;

public abstract class InitTest {
    Log log;
    public Properties properties;
    public final String baseURI="https://petstore.swagger.io/v2";
    public final String basePath = "/pet";

    @BeforeClass
    public void initTest() throws IOException {
        log = new Log().buildLog();
        properties = new Properties();
//        properties.load(new FileInputStream("myProperties.properties"));
    }

    @AfterClass
    public void cleanup(){
    }

    public static void printLog(String log){
        System.out.printf("%s - %s%n", LocalDateTime.now(), log);
    }
}