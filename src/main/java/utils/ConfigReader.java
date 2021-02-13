package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public Properties init_prop() {
        prop=new Properties();
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(fis);

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String getReportConfigPath(){
        String reportConfigPath = prop.getProperty("C:\\Users\\ibm\\IdeaProjects\\uf-automationqa\\src\\test\\resources\\extent-config.xml");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
