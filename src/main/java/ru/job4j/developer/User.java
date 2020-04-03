package ru.job4j.developer;

public class User {
    public static void main(String[] args) {
        Developer developer = new Developer();

        developer.setActivity(new Slipping());
        developer.userActivity();

        developer.setActivity(new Work());
        developer.userActivity();

        developer.setActivity(new Relaxation());
        developer.userActivity();

        developer.setActivity(new Slipping());
        developer.userActivity();
    }
}
