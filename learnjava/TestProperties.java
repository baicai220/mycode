import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    @Test
    public void test01() {
        Properties properties = System.getProperties();
        String fileEncoding = properties.getProperty("file.encoding");
        System.out.println("fileEncoding = " + fileEncoding); // fileEncoding = UTF-8
    }
    @Test
    public void test02() {
        Properties properties = new Properties();
        properties.setProperty("user","songhk");
        properties.setProperty("password","123456");
        System.out.println(properties); // {password=123456, user=songhk}
    }

    @Test
    public void test03() throws IOException {
        Properties pros = new Properties();
        pros.load(new FileInputStream("jdbc.properties"));
        String user = pros.getProperty("user");
        System.out.println(user); // root
    }
}
