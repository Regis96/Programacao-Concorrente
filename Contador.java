package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
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
    public synchronized void run() {
        for(int i=0;i<100;i++){
            arm.getLock().lock();
            
            
            try {
                while(arm.getTipoUmMutex() == 1){
                    arm.foiImpresso.await();
                }
                arm.setNumero(i);
                arm.foiGerado.signal();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                arm.setTipoUmMutex(1);
                arm.getLock().unlock();
            }
            
            
            
            
        }
    } 
    
}
