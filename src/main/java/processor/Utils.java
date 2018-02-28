package processor;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static void ensureIsDirectory(String path) throws IOException {
        File thisDir = new File(path);
        if (!thisDir.isDirectory()) {
            throw new IOException(String.format("%s is not a directory", path));
        }
    }
}
