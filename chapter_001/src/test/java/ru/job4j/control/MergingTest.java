package ru.job4j.control;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.*;

public class MergingTest {

    @Test
    public void whenTest() {

        Map<String, Set<String>> expected = new TreeMap<>();
        String userEx1 = "User2";
        String userEx2 = "User5";
        String mailEx1 = "ups@pisem.net";
        String mailEx2 = "foo@gmail.com";
        String mailEx3 = "lol@mail.ru";
        String mailEx4 = "xxx@ya.ru";
        String mailEx5 = "vasya@pupkin.com";
        String mailEx6 = "xyz@pisem.net";
        String mailEx7 = "aaa@bbb.ru";
        Set<String> mailsEx1 = new TreeSet<>();
        Set<String> mailsEx2 = new TreeSet<>();
        mailsEx1.add(mailEx1);
        mailsEx1.add(mailEx2);
        mailsEx1.add(mailEx3);
        mailsEx1.add(mailEx4);
        mailsEx1.add(mailEx7);
        mailsEx2.add(mailEx5);
        mailsEx2.add(mailEx6);
        expected.put(userEx2, mailsEx2);
        expected.put(userEx1, mailsEx1);

        Map<String, Set<String>> forCompute = new HashMap<>();
        String mail11 = "xxx@ya.ru", mail12 = "foo@gmail.com", mail13 = "lol@mail.ru";
        Set<String> mails1 = new TreeSet<>();
        mails1.add(mail11);
        mails1.add(mail12);
        mails1.add(mail13);
        String user1 = "User1";
        forCompute.put(user1, mails1);

        String mail21 = "foo@gmail.com", mail22 = "ups@pisem.net";
        Set<String> mails2 = new TreeSet<>();
        mails2.add(mail21);
        mails2.add(mail22);
        String user2 = "User2";
        forCompute.put(user2, mails2);

        String mail31 = "xyz@pisem.net", mail32 = "vasya@pupkin.com";
        Set<String> mails3 = new TreeSet<>();
        mails3.add(mail31);
        mails3.add(mail32);
        String user3 = "User3";
        forCompute.put(user3, mails3);

        String mail41 = "ups@pisem.net", mail42 = "aaa@bbb.ru";
        Set<String> mails4 = new TreeSet<>();
        mails4.add(mail41);
        mails4.add(mail42);
        String user4 = "User4";
        forCompute.put(user4, mails4);

        String mail51 = "xyz@pisem.net";
        Set<String> mails5 = new TreeSet<>();
        mails5.add(mail51);
        String user5 = "User5";
        forCompute.put(user5, mails5);

        Map<String, Set<String>> result = Merging.mergeUsers(forCompute);

        assertThat(result, equalTo(expected));
    }
}
