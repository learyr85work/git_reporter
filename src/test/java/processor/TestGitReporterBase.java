package processor;

import java.nio.file.Paths;

public abstract class TestGitReporterBase {

    protected static String testFilePath(String path) {
        return Paths.get("src", "test", "resources", path).toString();
    }
}
