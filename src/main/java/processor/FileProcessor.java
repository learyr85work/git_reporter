package processor;

import com.google.common.base.Strings;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class FileProcessor {

    private String file;
    private int numLines;
    private int whitespaceLines;
    private int numChars;
    private String fileType;

    public FileProcessor(String file) throws IOException {
        this.file = file;
        fileType = Files.getFileExtension(file);
        if (Strings.isNullOrEmpty(fileType)) {
            fileType = "none";
        }
        List<String> lines = Files.readLines(new File(file), Charset.defaultCharset());

        numLines = lines.size();
        numChars = 0;

        for (String line : lines) {
            numChars += line.length();
            if (line.trim().length() == 0) {
                whitespaceLines++;
            }
        }
    }

    public String getFile() {
        return file;
    }

    public int getNumTotalLines() {
        return numLines;
    }

    public int getNumWhitespaceLines() {
        return whitespaceLines;
    }

    public int getNumChars() {
        return numChars;
    }

    public String getFileType() {
        return fileType;
    }
}
