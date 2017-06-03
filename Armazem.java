package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Régis
 */
public class Armazem {
    private static int numero;
    private int tipoUmMutex;
    private final Lock lock = new ReentrantLock(true);
    protected final Condition foiGerado = lock.newCondition();
    protected final Condition foiImpresso = lock.newCondition();

    public int getTipoUmMutex() {
        return tipoUmMutex;
    }

    public void setTipoUmMutex(int tipoUmMutex) {
        this.tipoUmMutex = tipoUmMutex;
    }
    public Armazem(){
        tipoUmMutex=0;
    }

    public Lock getLock() {
        return lock;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        Armazem.numero = numero;
    }
    
    
}
