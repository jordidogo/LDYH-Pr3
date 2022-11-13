package es.ull.esit.utilities;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
*
* @class PowerSet
* @brief Clase para calcular cada subconjunto de un conjunto dado
*
*/
public class PowerSet<E> implements Iterator<Set<E>>, Iterable<Set<E>> {

    private E[] arr = null;
    private BitSet bset = null;

    /**
     * @brief constructor de clase 
     * @param set -> set para calcular sus subconjuntos
     */
    @SuppressWarnings("unchecked")
    public PowerSet(Set<E> set) {
        this.arr = (E[]) set.toArray();
        this.bset = new BitSet(this.arr.length + 1);
    }

    /**
     * @brief Comprueba si un subconjunto tiene un subconjunto siguiente
     * @return bool -> Verdadero o falso
     */
    @Override
    public boolean hasNext() {
        return !this.bset.get(this.arr.length);
    }

    /**
     * @brief Calcula el siguiente subconjunto
     * @return set -> set resultado
     */
    @Override
    public Set<E> next() {
        Set<E> returnSet = new TreeSet<>();
        for (int i = 0; i < this.arr.length; i++) {
            if (this.bset.get(i)) {
                returnSet.add(this.arr[i]);
            }
        }
        for (int i = 0; i < this.bset.size(); i++) {
            if (!this.bset.get(i)) {
                this.bset.set(i);
                break;
            } else {
                this.bset.clear(i);
            }
        }
        return returnSet;
    }

    /**
     * @brief Mensaje de error
     * @return Not Supported
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not Supported!");
    }

    /**
     * @brief Iterador
     * @return this
     */
    @Override
    public Iterator<Set<E>> iterator() {
        return this;
    }
}