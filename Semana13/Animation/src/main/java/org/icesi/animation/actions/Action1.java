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
                suscriber.setY(suscriber.getY() + 2);
                Thread.sleep(suscriber.getTimer());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
