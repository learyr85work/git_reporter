package processor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryProcessor {
    private String directory;
    private List<String> subdirectories;
    private List<FileProcessor> files;

    public DirectoryProcessor(String directory) throws IOException {
        Utils.ensureIsDirectory(directory);
        this.directory = directory;
        subdirectories = new ArrayList<>();
        files = new ArrayList<>();

        File[] contents = new File(directory).listFiles();
        if (contents == null) {
            return;
        }
        for (File f : contents) {
            if (f.isDirectory()) {
                subdirectories.add(f.toString());
            } else if (f.isFile()) {
                files.add(new FileProcessor(f.toString()));
            } // ignoring other cases here
        }
    }

    public String getDirectory() {
        return directory;
    }

    public List<String> getSubdirectories() {
        return subdirectories;
    }

    public List<FileProcessor> getFiles() {
        return files;
    }
}
