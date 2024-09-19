package com.appName.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // Create the object of Properties
    private static Properties properties=new Properties();

    static {

        //Open th file using FileInputStream

        FileInputStream file= null;
        try {
            file = new FileInputStream("src/test/resources/configurations.properties");
            // Load the properties object by using FileInputStream.
            properties.load(file);
            //close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File is not found in configuration class");
            e.printStackTrace();
        }


    }

    public static void writeToPropertiesFile(String key, String value) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("configurations.properties")) {
            properties.setProperty(key, value);
            properties.store(fileOutputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);

    }
}
