package ru.job4j.inheritance;

public class HtmlReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return  name +  body;
    }
}