package webdriverSetup;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class ConfigReader {

    static Map<String, Object > data;

    public static Map dataProperties() {

        Yaml properties = new Yaml();
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/resources/flghtData.yaml");
            data = properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
