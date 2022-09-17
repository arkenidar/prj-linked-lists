// https://replit.com/@dariocangialosi/liste-collegate-liste-linked#main.c

import java.util.Iterator;
import java.util.function.Consumer;

public class ListaLinked<T> implements Iterable<T> {
    private Nodo<T> primo, ultimo;

    private Nodo<T> nodoCache;
    private int indiceCache;

    public void rimuoviNodo(Nodo<T> quale) {
        if (quale == null) return;
        if (quale == primo) primo = quale.successivo;
        if (quale == ultimo) ultimo = quale.precedente;
        if (quale.precedente != null) quale.precedente.successivo = quale.successivo;
        if (quale.successivo != null) quale.successivo.precedente = quale.precedente;
    }

    public Nodo<T> prendiNodo(int indice) {

        if (nodoCache != null) {
            if (indice == (indiceCache + 1)) {
                nodoCache = nodoCache.successivo;
                indiceCache = indice;
                return nodoCache;
            } else if (indice == (indiceCache - 1)) {
                nodoCache = nodoCache.precedente;
                indiceCache = indice;
                return nodoCache;
            } else if (indice == indiceCache) {
                return nodoCache;
            }
        }

        Nodo<T> scorre = primo;
        for (int i = 0; scorre != null; i++) {
            if (i == indice) {
                nodoCache = scorre;
                indiceCache = indice;
                return scorre;
            }
            scorre = scorre.successivo; // questo rigo non viene usato, se il caching lo previene (breakpoint per verificare!)
        }
        return null;
    }

    public T prendi(int indice) {
        Nodo<T> nodo = prendiNodo(indice);
        if (nodo == null) return null;
        return nodo.contenuto;
    }

    public void aggiungi(T elemento) {
        Nodo<T> corrente = new Nodo<>();
        corrente.contenuto = elemento;
        corrente.successivo = null;
        corrente.precedente = ultimo;
        if (ultimo == null) primo = corrente;
        else ultimo.successivo = corrente;
        ultimo = corrente;
    }

    public void scorriStampando() {
        Nodo<T> scorre;
        scorre = primo;
        while (scorre != null) {
            System.out.println(scorre.contenuto);
            scorre = scorre.successivo;
        }
    }

    public void scorriInverso() {
        Nodo<T> scorre;
        scorre = ultimo;
        while (scorre != null) {
            System.out.println(scorre.contenuto);
            scorre = scorre.precedente;
        }
    }

    public void svuota() {
        primo = null;
        ultimo = null;
    }

    public boolean rimuovi(int indice) {
        Nodo<T> nodo = prendiNodo(indice);
        if (nodo == null) return false;
        rimuoviNodo(nodo);
        return true;
    }

    public int indiceDi(T cosa) {
        Nodo<T> scorre;
        scorre = primo;
        int indice = 0;
        while (scorre != null) {
            if (cosa.equals(scorre.contenuto)) {
                return indice;
            }
            scorre = scorre.successivo;
            indice++;
        }
        return -1;
    }

    public boolean contiene(T cosa) {
        return indiceDi(cosa) != -1;
    }

    public int dimensione() {
        if (primo == null) return 0;
        Nodo<T> scorre;
        scorre = primo;
        int indice = 0;
        while (scorre != null) {
            scorre = scorre.successivo;
            indice++;
        }
        return indice;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<>() {

            private final int dimensione = dimensione();
            private int corrente = 0;

            @Override
            public boolean hasNext() {
                return corrente < dimensione && prendi(corrente) != null;
            }

            @Override
            public T next() {
                return prendi(corrente++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}

class Nodo<T> {
    T contenuto;
    Nodo<T> successivo, precedente;
}