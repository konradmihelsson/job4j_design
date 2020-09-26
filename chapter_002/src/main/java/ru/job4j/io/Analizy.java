package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> linesStore = getData(source);
        boolean siteAvailableState = true;
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String line : linesStore) {
                if (line.length() != 0) {
                    String[] pair = line.split(" ", 2);
                    if (siteAvailableState && (pair[0].equals("400") || pair[0].equals("500"))) {
                        out.print(pair[1] + ";");
                        siteAvailableState = false;
                    } else if (!siteAvailableState && (pair[0].equals("200") || pair[0].equals("300"))) {
                        out.println(pair[1] + ";");
                        siteAvailableState = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("./chapter_002/src/test/resources/analizy_unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> getData(String sourceFilePath) {
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(sourceFilePath))) {
            read.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
