package utils;

public class DataManager {
    public static String getUser(){
        return FileReaderUtil.readFile("src/test/resources/User");
    }

    public static String getPet(){
        return FileReaderUtil.readFile("src/test/resources/Pet");
    }
}
