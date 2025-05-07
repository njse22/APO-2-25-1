package ui;

import util.CustomRunnable;
import util.CustomThread;
import util.IFuntional;

public class Main {

    public static void main(String[] args) {

        CustomThread ct = new CustomThread(1000);
        //ct.start();

        // for (int i = 10; i < 20; i++) {
        //     System.out.println("Desde el Main: " + i);
        // }

        CustomRunnable c1 = new CustomRunnable(500);
        Thread t1 = new Thread(c1);
        //t1.start();

        IFuntional f1 = new IFuntional() {
            @Override
            public void unique() {
                System.out.println("Hola desde la interfaz estilo anterior a java 8");
            }
        };

        //f1.unique();

        IFuntional f2 = () -> {
            System.out.println("Hola desde la interfaz estilo después de java 8");
        };

        //f2.unique();

        // Creación de un hilo
        Thread t2 = new Thread(
                // Runnable -> FuntionalInterface -> Lambda Expression
                () -> {
                    System.out.println("Hola desde el Thread con parametro lambda");
                }
        );
        //t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("EXEC >>> " + i);
            new Thread(Main::printer).start();
        }

    }

    public synchronized static void printer(){
        for (int i = 40; i < 50; i++) {
            System.out.println("Hola desde el printer static method in Main " + i);
        }
    }

}
