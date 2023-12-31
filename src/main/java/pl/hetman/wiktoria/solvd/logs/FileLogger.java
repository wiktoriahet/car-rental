package pl.hetman.wiktoria.solvd.logs;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

    public static void logToFile(String message) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/logs.txt", true)) {
            fileWriter.write(message);
        } catch (IOException e) {
            System.out.println("Problem with writing to file: " + e.getMessage());
        }
    }

}
