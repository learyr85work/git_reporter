package processor;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new RuntimeException("Only supply the directory to be processed");
        }
        RepoProcessor rp = new RepoProcessor(args[0]);
        String html = HtmlGenerator.generate(rp);
        File outputFile = new File("repo_report.html");
        Files.write(html, outputFile, Charset.forName("UTF-8"));
    }
}
