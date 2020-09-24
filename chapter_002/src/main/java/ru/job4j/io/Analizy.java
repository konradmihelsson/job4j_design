package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String line;
            boolean siteAvailableState = true;
            while ((line = read.readLine()) != null) {
                if (line.length() == 0) {
                    continue;
                } else {
                    String[] pair = line.split(" ", 2);
                    if (siteAvailableState && (pair[0].equals("400") || pair[0].equals("500"))) {
                        out.print(pair[1] + ";");
                        siteAvailableState = false;
                    } else if (!siteAvailableState && (pair[0].equals("200") || pair[0].equals("300"))) {
                        out.print(pair[1] + ";" + System.lineSeparator());
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
}
