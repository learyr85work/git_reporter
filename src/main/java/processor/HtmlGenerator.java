package processor;

import static j2html.TagCreator.*;

public class HtmlGenerator {

    public static String generate(RepoProcessor rp) {

        return html(
                head(
                        title(String.format("Analysis of %s:", rp.getRoot()))
                ), 
                body(
                        
                        p(String.format("Total lines: %s", rp.getTotalLines())),
                        p(String.format("Whitespace lines: %s", rp.getTotalWhitespaceLines())),
                        p(String.format("Total characters: %s", rp.getTotalCharacters())),
                        p(String.format("Total file count: %s", rp.getTotalFiles())),
                        p("File type counts:"),
                        each(rp.getFileTypeMap().entrySet(),
                                fileType -> div(
                                        p(String.format("-\t\t%s: %s", fileType.getKey(), fileType.getValue()))
                                )
                        ),
                        p(String.format("File line count median: %s", rp.getAvgLinesPerFile()))
                )
        ).render();
    }
}
