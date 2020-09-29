package ru.job4j.io;

import java.util.Arrays;
import java.util.List;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (this.args.length == 0 || this.args.length > 3) {
            throw new IllegalArgumentException("Wrong args. Usage: java -jar zip.jar"
                    + " -d=DISK:\\path\\to\\folder\\ -e=exclude,filetypes,log,txt,etc"
                    + " -o=DISK:\\path\\to\\OutputFile.zip");
        }
        return true;
    }

    public String directory() {
        return this.args[0].substring(3);
    }

    public List<String> exclude() {

        return Arrays.asList(this.args[1].substring(3).split(","));
    }

    public String output() {
        return this.args[2].substring(3);
    }
}
