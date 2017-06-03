package threads;

/**
 *
 * @author Régis
 */
public class Main {
    public static void main(String[] args) {
        Armazem arm = new Armazem();
        arm.setNumero(0);
        Contador cont = new Contador(arm);
        Impressora imp = new Impressora(arm);
        Thread t1 = new Thread(cont);
        Thread t2 = new Thread(imp);
        
        t1.start();
        t2.start();
        
    }
    
}
