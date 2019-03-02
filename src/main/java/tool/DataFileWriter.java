package tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

/**
 * @author leonyan
 * */

public class DataFileWriter {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        final int MAX_VALUE = 10;
        final int MAX_TIMES = 200000;
        for (int i = 0; i < MAX_TIMES; i++) {
            for (int j = 0; j < MAX_VALUE; j++) {
                stringBuilder.append(i * 10 + j).append(", ");
            }
            stringBuilder.append("\n");
        }
        String data = stringBuilder.toString();

        String filePath = "data.csv";
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    throw new FileAlreadyExistsException(filePath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file.getName(), false);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
