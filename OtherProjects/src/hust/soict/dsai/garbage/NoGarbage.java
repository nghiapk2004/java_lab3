package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;

        try {
            Path filePath = Paths.get(filename);
            if (Files.exists(filePath)) {
                inputBytes = Files.readAllBytes(filePath);
            } else {
                System.err.println("Error: File not found at " + filename);
                return;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
            e.printStackTrace();
            return;
        }

        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + "ms");
        System.out.println(outputStringBuilder.toString());
    }
}
