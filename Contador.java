package threads;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Régis
 */
public class Contador implements Runnable{
    private Armazem arm;

    public Contador(Armazem arm) {
        this.arm=arm;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            arm.setNumero(i);
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
}
