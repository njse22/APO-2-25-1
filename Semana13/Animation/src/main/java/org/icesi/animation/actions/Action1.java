package org.icesi.animation.actions;

import org.icesi.animation.model.Element3;

// Publisher
public class Action1 implements  Runnable {

    // Suscriber
    private Element3 suscriber;

    // addSuscriber
    public void setElement(Element3 suscriber) {
        this.suscriber = suscriber;
    }

    // notifySuscriber
    @Override
    public void run() {
        while (suscriber.isAlive()){
            try {
                Thread.sleep(suscriber.getTimer());
                suscriber.setY(suscriber.getY() + 10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
