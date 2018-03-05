package services;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesLoader {

    public static JsonNode loadFileAsJson(String path) throws IOException {
        String jsonStr = new String(Files.readAllBytes(Paths.get(path)));

        return Json.parse(jsonStr);
    }

    public static String loadFileAsString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
