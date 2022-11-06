package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileService {

    public void saveFile(String path, byte[] content) {
        File file = new File(path);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
