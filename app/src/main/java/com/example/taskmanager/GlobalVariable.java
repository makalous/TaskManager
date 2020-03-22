package com.example.taskmanager;
import android.app.Application;
public class GlobalVariable extends Application {
    private boolean started;
    private boolean ended;

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }
}
