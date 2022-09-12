// https://replit.com/@dariocangialosi/liste-collegate-liste-linked#main.c

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello LinkedLists !");

        ListaLinked<String> lista = new ListaLinked<>();
        for (int n = 1; n <= 3; n++) {
            lista.aggiungi(String.valueOf(n));
        }

        lista.scorri();
        lista.scorriInverso();

        lista.rimuovi(lista.prendi(2));
        lista.scorri();

    }
}