package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ConsoleChat {
    public static void main(String[] args) {
        boolean isStop = false, isExit = false;
        List<String> robotPhrases = getData("./robot_answer.txt");
        String userPhrase, robotPhrase;
        String outputFile = "./console_chat.log";

        Random random = new Random();
        System.out.println("Консольный чат. Для отключения робота-собеседника наберите \"стоп\",");
        System.out.println(" для включения наберите \"продолжить\". Для выхода из программы наберите \"закончить\".");
        System.out.println("Введите фразу для начала диалога.");
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(outputFile)));
             Scanner in = new Scanner(System.in)) {
            while (!isExit) {
                userPhrase = in.nextLine();
                out.println(userPhrase);
                if (userPhrase.equals("закончить")) {
                    isExit = true;
                    continue;
                } else if (userPhrase.equals("стоп") && !isStop) {
                    isStop = true;
                } else if (userPhrase.equals("продолжить") && isStop) {
                    isStop = false;
                    continue;
                }

                if (!isStop) {
                    robotPhrase = robotPhrases.get(random.nextInt(robotPhrases.size()));
                    System.out.println(robotPhrase);
                    out.println(robotPhrase);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getData(String sourceFilePath) {
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(sourceFilePath, UTF_8))) {
            read.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
