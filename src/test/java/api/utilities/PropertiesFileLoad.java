package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileLoad {

    public static Properties propFileLoad(String path) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        return prop;
    }

}
