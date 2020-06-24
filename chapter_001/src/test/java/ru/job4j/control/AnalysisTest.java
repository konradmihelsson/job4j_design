package ru.job4j.control;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalysisTest {

    @Test
    public void whenTest() {
        Analysis.User user1 = new Analysis.User();
        user1.id = 1;
        user1.name = "first";
        Analysis.User user2 = new Analysis.User();
        user2.id = 2;
        user2.name = "second";
        Analysis.User user3 = new Analysis.User();
        user3.id = 3;
        user3.name = "third";
        Analysis.User user4 = new Analysis.User();
        user4.id = 4;
        user4.name = "fourth";
        Analysis.User user5 = new Analysis.User();
        user5.id = 5;
        user5.name = "fifth";
        Analysis.User user6 = new Analysis.User();
        user6.id = 6;
        user6.name = "sixth";
        Analysis.User user3chang = new Analysis.User();
        user3chang.id = 3;
        user3chang.name = "third_change";
        Analysis.User user4chang = new Analysis.User();
        user4chang.id = 4;
        user4chang.name = "fourth_change";

        List<Analysis.User> prev = new ArrayList<>();
        prev.add(user1);
        prev.add(user2);
        prev.add(user3);
        prev.add(user4);

        List<Analysis.User> curr = new ArrayList<>();
        curr.add(user2);
        curr.add(user3chang);
        curr.add(user4chang);
        curr.add(user5);
        curr.add(user6);

        Analysis analysis = new Analysis();
        Analysis.Info info = analysis.diff(prev, curr);

        assertThat(info.added, is(2));
        assertThat(info.changed, is(2));
        assertThat(info.deleted, is(1));
    }
}
