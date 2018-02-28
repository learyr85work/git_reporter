package processor;

import java.io.IOException;
import java.util.*;

public class RepoProcessor {

    private String root;
    private Map<String, Integer> fileTypeMap;
    private int totalLines;
    private int totalWhitespaceLines;
    private int totalCharacters;
    private int totalFiles;
    private double avgLinesPerFile;

    public RepoProcessor(String root) throws IOException {
        Utils.ensureIsDirectory(root);
        this.root = root;
        fileTypeMap = new HashMap<>();
        totalLines = 0;
        totalWhitespaceLines = 0;
        totalCharacters = 0;

        Queue<String> dirsToProcess = new LinkedList<>();
        dirsToProcess.add(root);

        while (dirsToProcess.size() > 0) {
            try {
                DirectoryProcessor curDir = new DirectoryProcessor(dirsToProcess.poll());
                dirsToProcess.addAll(curDir.getSubdirectories());
                for (FileProcessor fp : curDir.getFiles()) {
                    totalLines += fp.getNumTotalLines();
                    totalWhitespaceLines += fp.getNumWhitespaceLines();
                    totalCharacters += fp.getNumChars();

                    if (!fileTypeMap.containsKey(fp.getFileType())) {
                        fileTypeMap.put(fp.getFileType(), 0);
                    }
                    fileTypeMap.put(fp.getFileType(), fileTypeMap.get(fp.getFileType()) + 1);
                }
            } catch (IOException ex) {
                // do nothing
            }
        }

        totalFiles = fileTypeMap.values().stream().mapToInt(p -> p).sum();
        avgLinesPerFile = (double)totalLines / (double)totalFiles;

    }

    public String getRoot() {
        return root;
    }

    public Map<String, Integer> getFileTypeMap() {
        return fileTypeMap;
    }

    public int getTotalLines() {
        return totalLines;
    }

    public int getTotalWhitespaceLines() {
        return totalWhitespaceLines;
    }

    public int getTotalCharacters() {
        return totalCharacters;
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    public double getAvgLinesPerFile() {
        return avgLinesPerFile;
    }
}
