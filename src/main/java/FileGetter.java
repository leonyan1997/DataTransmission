import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 输入文件路径，获取{@code byte[]}类型的文件内容。
 *
 * @author leonyan
 * */
public class FileGetter {
    private String filePath;
    private File file;
    private FileInputStream fileInputStream;
    private String encoding;

    /**
     * 默认编码格式是utf-8。这个以后可以把字符串常量定义转化为，创建一个常量类，用该类的静态常量定义。
     * */
    public FileGetter(String filePath) {
        this.filePath = filePath;
        this.file = null;
        this.fileInputStream = null;
        this.encoding = "utf-8";
    }

    public byte[] getFileContext() {
        file = new File(filePath);
        Long fileLength = file.length();
        /*
        * TODO:这个地方非常危险！！如果返回过大的fileLength可能会使内存不够（需要2GB内存）。
        * */
        byte[] fileBytesContext = new byte[fileLength.intValue()];
        try {
            fileInputStream = new FileInputStream(file);
            if (fileInputStream.read(fileBytesContext) != -1) {
                throw new Exception("The end of file has not been reached");
            }
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileBytesContext;
    }
}
