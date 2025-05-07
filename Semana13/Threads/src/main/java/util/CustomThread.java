package util;

public class CustomThread extends Thread {

    private int timer;

    public CustomThread(int timer){
        this.timer = timer;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(timer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
