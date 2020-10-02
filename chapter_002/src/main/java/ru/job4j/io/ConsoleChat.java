package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ConsoleChat {

    private final Map<String, Consumer<String>> actions = new HashMap<>();

    public ConsoleChat() {
        this.actions.put("стоп", this::pause);
        this.actions.put("продолжить", this::proceed);
        this.actions.put("закончить", this::exit);
    }

    private boolean isExit = false;
    private boolean isPause = false;

    private void pause(String userInput) {
        this.isPause = true;
    }

    private void proceed(String userInput) {
        this.isPause = false;
    }

    private void exit(String userInput) {
        this.isPause = true;
        this.isExit = true;
    }

    private void chatting(String userInput) {

    }

    public static void main(String[] args) {

        ConsoleChat consoleChat = new ConsoleChat();
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
            while (!consoleChat.isExit) {
                userPhrase = in.nextLine();
                out.println(userPhrase);
                consoleChat.actions.getOrDefault(userPhrase, consoleChat::chatting).accept(userPhrase);
                if (!consoleChat.isPause) {
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
