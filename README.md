Write an application in java that parses a git repo and produces a report file (in html) with the following metrics

    the number of lines in the git repo
    the number of lines that are only whitespace
    the number of characters
    the number of files
    the number of files by file type
    the average number of lines per file


Assumptions:
    Maven dependencies allowed
    Files with no extension will get classified as filetype="NONE"
    Files are UTF-8 encoded
    Lines are treated as raw strings (ie a line containing only "\t" is NOT a tab and therefore not whitespace)
    Files that don't evaluate to true from either Java.File.isFile() or .isDirectory() are ignored
    If an IOException is throws during file processing, the application will continue processing and calculate its results as if that file didn't exist
    Average lines per file is calculated as a double, total lines / total files
    Output file will be "repo_report.html", in the directory in which the program is executed from.
        Any existing file at this location will be overwritten

Usage:
    java -jar <path_to_jar> <directory_to_eval>
    Program will only execute IFF exactly 1 sysarg is provided for <directory_to_eval>
    Make sure you're using the "...-jar-with-dependencies"