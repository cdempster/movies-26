package edu.kirkwood.view;

public class Animator implements Runnable{
    private final String message;
    private final String[] states = {".", "..", "...", "...."};
    private int currentStateIndex = 0;
    private volatile boolean running = true;

    public Animator(String message) {
        this.message = message;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        while(running) {
            System.out.print("\r" + message + states[currentStateIndex]);
            currentStateIndex = (currentStateIndex + 1) % states.length;
            try {
                Thread.sleep(400); // 4/10ths of a second
            } catch (InterruptedException e) {
                running = false;
            }
        }
        String cleanup = " ".repeat(message.length() + states.length);
        System.out.print("\r" + cleanup + "\r");
    }
}
