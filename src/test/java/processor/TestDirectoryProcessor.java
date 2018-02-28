package processor;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestDirectoryProcessor extends TestGitReporterBase {

    @Test
    public void test_Root() throws Exception {
        DirectoryProcessor d = new DirectoryProcessor(testFilePath(""));
        Assert.assertEquals(4, d.getFiles().size());
        Assert.assertEquals(1, d.getSubdirectories().size());
    }

    @Test
    public void test_Subdir1() throws Exception {
        DirectoryProcessor d = new DirectoryProcessor(testFilePath("subdir1"));
        Assert.assertEquals(2, d.getFiles().size());
        Assert.assertEquals(2, d.getSubdirectories().size());
    }

    @Test
    public void test_Subdir2a() throws Exception {
        DirectoryProcessor d = new DirectoryProcessor(testFilePath("subdir1/subdir2a"));
        Assert.assertEquals(1, d.getFiles().size());
        Assert.assertEquals(0, d.getSubdirectories().size());
    }

    @Test
    public void test_Subdir2b() throws Exception {
        DirectoryProcessor d = new DirectoryProcessor(testFilePath("subdir1/subdir2b"));
        Assert.assertEquals(1, d.getFiles().size());
        Assert.assertEquals(0, d.getSubdirectories().size());
    }

    @Test(expected = IOException.class)
    public void test_DirectoryDoesntExist() throws Exception {
        DirectoryProcessor d = new DirectoryProcessor("hopefully not a directory");
    }

}
