import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task08_FileIO_WordCount {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:\\csatest\\demo.txt");
        String content = Files.readString(filePath);
        String[] cutContents = content.replaceAll("csa", " ").strip().split(" ");
        System.out.println("有 " + cutContents.length + " 个2021");
    }
}
