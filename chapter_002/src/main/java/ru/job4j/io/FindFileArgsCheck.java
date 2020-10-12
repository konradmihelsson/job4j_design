package ru.job4j.io;

public class FindFileArgsCheck {

    private final String[] args;

    public FindFileArgsCheck(String[] args) {
        this.args = args;
    }

    void validation() {
        if (this.args.length != 7) {
            throw new IllegalArgumentException("Wrong args.\n"
                    + "Usage: java -jar FindFile.jar [-d <folder>] [-n <string>] [-f | -m | -r] [-o <file>]\n"
                    + "-d <folder>\tPath to folder.\n"
                    + "-n <string>\tString for search.\n"
                    + "-f\t\tString as exact filename.\n"
                    + "-m\t\tString as filename mask.\n"
                    + "-r\t\tString as regex for search.\n"
                    + "-o <file>\tFile for save search result.\n"
                    + "For example: java -jar FindFile.jar -d C:\\ProgramData\\ -n [a-z]*\\.log"
                    + " -r -o C:\\Temp\\output.file");
        }
    }

    public String rootDirectory() {
        return this.args[1];
    }

    public String getCriterion() {
        return this.args[3];
    }

    public String getOpt() {
        return this.args[4];
    }

    public String getOutput() {
        return this.args[6];
    }
}
