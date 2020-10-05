package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ConsoleChat implements Runnable {

    private final Map<String, Consumer<String>> actions = new HashMap<>();
    private List<String> logChatData = new ArrayList<>();
    private List<String> robotPhrases = getData("./robot_answer.txt");
    private String outputFile = "./console_chat.log";
    private Random random = new Random();

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
        if (!this.isPause) {
            String robotPhrase = robotPhrases.get(random.nextInt(robotPhrases.size()));
            System.out.println(robotPhrase);
            logChatData.add(robotPhrase);
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.run();
    }

    private List<String> getData(String sourceFilePath) {
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(sourceFilePath, UTF_8))) {
            read.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private void writeData(List<String> linesForWrite, String outputFileName) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(outputFileName)))) {
            linesForWrite.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Консольный чат. Для отключения робота-собеседника наберите \"стоп\",");
        System.out.println(" для включения наберите \"продолжить\". Для выхода из программы наберите \"закончить\".");
        System.out.println("Введите фразу для начала диалога.");
        try (Scanner in = new Scanner(System.in)) {
            while (!this.isExit) {
                String userPhrase = in.nextLine();
                logChatData.add(userPhrase);
                this.actions.getOrDefault(userPhrase, this::chatting).accept(userPhrase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeData(this.logChatData, outputFile);
    }
}
