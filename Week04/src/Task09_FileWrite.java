import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task09_FileWrite {

    static final String SOURCE_PATH = "C:/csatest/demo.txt";
    static final String TARGET_PATH = "C:/csatest/demo2.txt";

    public static void main(String[] args) {
        File source = new File(SOURCE_PATH);
        File destination = new File(TARGET_PATH);

        copyFile(source, destination);

//        copyFileNIO(SOURCE_PATH, TARGET_PATH);
    }

    /**
     * 普通的用输入输出流一点一点的挪
     * @param source
     * @param target
     */
    public static void copyFile(File source, File target) {
        try (InputStream input = new FileInputStream(source);
             OutputStream output = new FileOutputStream(target)) {
            byte[] bytes = new byte[1024];
            while (input.read(bytes) > 0) {
                output.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用java.io.nio的Files.readString和writeString方法
     * 如果文件太大应该不行
     * @param source
     * @param target
     */
    public static void copyFileNIO(String source, String target) {
        try {
            Path sourcePath = Path.of(source);
            Path targetPath = Path.of(target);

            Files.writeString(targetPath, Files.readString(sourcePath));

            System.out.println(Files.readString(targetPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
