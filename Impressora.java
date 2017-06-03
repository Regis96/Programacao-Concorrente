package threads;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Régis
 */
public class Impressora implements Runnable{
    private Armazem arm;
    
    public Impressora(Armazem arm){
        this.arm=arm;
    }
    
    @Override
    public void run(){
        for(int i =0;i<100;i++){
            System.out.println(arm.getNumero());
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Impressora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
