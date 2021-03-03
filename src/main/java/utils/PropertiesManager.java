package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesManager {
  private static final String path = "src/main/resources/environment.conf";
  private static final Properties properties;

  static {
    properties = new Properties();
    try {
      properties.load(new FileInputStream(new File(path)));
      System.out.println("Properties loaded");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getProperty(String name) {
    return properties.getProperty(name).toString();
  }
}
