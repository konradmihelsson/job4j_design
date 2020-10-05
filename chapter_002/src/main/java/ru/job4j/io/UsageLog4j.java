package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte numOfRooms = 4;
        short numOfFloors = 33;
        int height = 109000;
        char literal = 'D';
        long totalArea = 262000000000L;
        float distanceToRoad = 0.808f;
        double distanceToCityCentre = 543275827788.34234234233333333;
        boolean isMonolith = true;

        LOG.debug("Number of rooms : {}, num of floors : {}, height in mm : {}"
                + ", literal in address: {}, total area in square mm: {}, distance to road in km: {}"
                + ", distance to centre of city: {}, building technology is monolith", numOfRooms,
                numOfFloors, height, literal, totalArea, distanceToRoad, distanceToCityCentre, isMonolith);
    }
}
