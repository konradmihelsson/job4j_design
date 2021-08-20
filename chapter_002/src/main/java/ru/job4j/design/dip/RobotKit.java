package ru.job4j.design.dip;

import java.util.List;

public class RobotKit {

    private List<Robot> finishedRobots;

    Robot build(List<Block> components) {
        return new Robot();
    }
}
