package client;

import type.RenderObject;
import window.Scene;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    private static final String WINDOW_NAME = "Display";
    private static final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(2);
    public static final Scene SCENE = new Scene(WIDTH, HEIGHT, WINDOW_NAME);

    public static void main(String[] args) {

    }

    public static void startGame() {
        executor.scheduleAtFixedRate(RenderObject::render, 0, 33, TimeUnit.MILLISECONDS);
    }
}
