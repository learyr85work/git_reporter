package processor;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class TestFileProcessor extends TestGitReporterBase {

    @Test
    public void test_NormalFile() throws Exception {
        FileProcessor f = new FileProcessor(testFilePath("normal.NORMAL"));
        Assert.assertEquals(5, f.getNumTotalLines());
        Assert.assertEquals(1, f.getNumWhitespaceLines());
        Assert.assertEquals(50, f.getNumChars());
        Assert.assertEquals("NORMAL", f.getFileType());
    }

    @Test
    public void test_NoFileType() throws Exception {
        FileProcessor f = new FileProcessor(testFilePath("noFileType"));
        Assert.assertEquals(2, f.getNumTotalLines());
        Assert.assertEquals(0, f.getNumWhitespaceLines());
        Assert.assertEquals(19, f.getNumChars());
        Assert.assertEquals("none", f.getFileType());
    }

    @Test
    public void test_EmptyFile() throws Exception {
        FileProcessor f = new FileProcessor(testFilePath("empty.EMPTY"));
        Assert.assertEquals(0, f.getNumTotalLines());
        Assert.assertEquals(0, f.getNumWhitespaceLines());
        Assert.assertEquals(0, f.getNumChars());
        Assert.assertEquals("EMPTY", f.getFileType());
    }

    @Test
    public void test_OnlyWhitespaceFile() throws Exception {
        FileProcessor f = new FileProcessor(testFilePath("onlywhitespace.ONLYWHITESPACE"));
        Assert.assertEquals(3, f.getNumTotalLines());
        Assert.assertEquals(3, f.getNumWhitespaceLines());
        Assert.assertEquals(5, f.getNumChars());
        Assert.assertEquals("ONLYWHITESPACE", f.getFileType());
    }

    @Test(expected = FileNotFoundException.class)
    public void test_FileDoesntExist() throws Exception {
        FileProcessor f = new FileProcessor("hopefully this file doesnt exist");
    }
}
