package com.timegeekbang.todo.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


public class FileUtilsTest {

    @Test
    public void should_be_create_when_giving_input() throws IOException {
        FileUtils fileUtils = new FileUtils();
        fileUtils.createAndCreateFile("liudaming");
    }


    @Test
    public void should_be_read_when_giving_input() {
        FileUtils fileUtils = new FileUtils();
        List<String> strings = fileUtils.readFile("liudaming");
        Assertions.assertTrue(strings.contains("1.1"));
    }

    @Test
    public void should_be_write_when_giving_input() throws IOException{
        FileUtils fileUtils = new FileUtils();
        List<String> strings = fileUtils.writeFile("liudaming","4.4");
        Assertions.assertTrue(strings.contains("4.4"));
    }

    @Test
    public void should_be_write_two_when_giving_input() throws IOException{
        FileUtils fileUtils = new FileUtils();
        List<String> strings = fileUtils.writeFile("liudaming","5.5");
        Assertions.assertTrue(strings.contains("5.5"));
    }
}
