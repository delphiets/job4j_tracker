package ru.job4j.developer;

public class Developer {
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void userActivity() {
        activity.doIt();
    }
}
