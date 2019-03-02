import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Source {
    private byte[] getFileBytesContext(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }
}
