package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UrlReaderUtils {
    public static Properties readURLFromFile(String filePath) {
        Properties prop = new Properties();

        try (FileInputStream input = new FileInputStream(filePath)) {
            if (input == null) {
                System.out.println("Unable to find config.properties");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
