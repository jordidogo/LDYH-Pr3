package es.ull.esit.utils;
import java.util.Objects;

/**
*
* @class Pair
* @brief Clase  para representar un par genérico de objetos
*
*/
public class Pair<F, S> {
    public final F first;   /**< Valor del primer par. */
    public final S second;  /**< Valor del segundo par. */

    /**
     * @brief Constructor
     * @param first -> valor del primer par
     * @param second -> valor del segundo par
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * @brief Comprueba si un par es igual a otro
     * @param o -> comparación
     * @return boolean -> Verdadero o falso
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    /**
     * @brief HashCode de la pareja
     * @return int -> código hash
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

     /**
     * @brief Crea un nuevo par
     * @param a -> valor del primer par
     * @param b -> valor del segundo par
     * @return Pair -> pair creado
     */
    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }
}
