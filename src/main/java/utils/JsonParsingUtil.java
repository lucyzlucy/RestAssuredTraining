package utils;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import lombok.SneakyThrows;

import java.io.FileReader;

public class JsonParsingUtil {
  @SneakyThrows
  public static String getValue(String stringToBeParsed, String key) {
    return new JsonParser()
        .parse(stringToBeParsed)
        .getAsJsonObject()
        .get(key)
        .getAsString();
  }
}
