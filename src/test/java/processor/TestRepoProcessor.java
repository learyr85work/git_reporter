package processor;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestRepoProcessor extends TestGitReporterBase {

    @Test
    public void test_RepoExists() throws Exception {
        RepoProcessor rp = new RepoProcessor(testFilePath(""));
        Assert.assertEquals(8, rp.getTotalFiles());
        Assert.assertEquals(Integer.valueOf(4), rp.getFileTypeMap().get("none"));
        Assert.assertEquals(Integer.valueOf(1), rp.getFileTypeMap().get("EMPTY"));
        Assert.assertEquals(Integer.valueOf(2), rp.getFileTypeMap().get("NORMAL"));
        Assert.assertEquals(Integer.valueOf(1), rp.getFileTypeMap().get("ONLYWHITESPACE"));
    }

    @Test(expected = IOException.class)
    public void test_RepoDoesntExist() throws Exception {
        RepoProcessor rp = new RepoProcessor("hopefully not a real directory");
    }
}
