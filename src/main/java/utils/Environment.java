package utils;

import java.io.File;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public class Environment {
    private static String environment = "";

    public static Config setEnvironment(String env) {
        environment = env;
        Config config = ConfigFactory.parseFile(new File("src/main/resources/environment.conf"));
        Config all = config.getConfig("env.all");
        return config.getConfig("env." + env).withFallback(all).resolve();
    }

    public static Config getCurrentEnvironment() {
        if (environment.isEmpty()) {
            throw new RuntimeException("please provide environment name from src/test/resources/environment.conf file");
        } else {
            return setEnvironment(environment);
        }
    }
}
