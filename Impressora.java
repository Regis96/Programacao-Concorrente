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
    public synchronized void run(){
        for(int i =0;i<100;i++){
            
            arm.getLock().lock();
            try{
                while(arm.getTipoUmMutex() == 0){
                    arm.foiGerado.await();
                }
                
                System.out.println(arm.getNumero());
                arm.foiImpresso.signal();
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                arm.setTipoUmMutex(0);
                arm.getLock().unlock();
            }
            
            
            
                
           }
            
        
    }
}
