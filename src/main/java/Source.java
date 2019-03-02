import jdk.nashorn.internal.ir.Block;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static config.Config.*;

public class Source {

    public static void main(String[] args) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        emit(getBlockList(bytes));
    }

    private static List<Block> getBlockList(byte[] bytes) {
        return null;
    }

    private static void emit(List<Block> blocks) {
        throw new Exception();
    }
}
