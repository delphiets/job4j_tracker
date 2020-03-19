package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);

        HtmlReport htmlReport = new HtmlReport();
        String textSecond = htmlReport.generate("Report's name", "Report's body");
        System.out.println(textSecond);

        JSONReport jsonReport = new JSONReport();
        String textThird = jsonReport.generate("name \n", "body");
        System.out.println(textThird);
    }
    }