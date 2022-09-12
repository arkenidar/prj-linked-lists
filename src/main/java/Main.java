// https://replit.com/@dariocangialosi/liste-collegate-liste-linked#main.c

public class Main {
    private static int progressivo = 1;

    public static void main(String[] args) {

        final String linea = "-----------------------";

        scrivi("Hello LinkedLists !");
        scrivi(linea);

        test1();
        scrivi(linea);

        testListaInteri();
        scrivi(linea);

        testStringa();
        scrivi(linea);
    }

    public static void testListaInteri() {

        ListaDiInteri interi = new ListaDiInteri();
        scrivi("tests ListaDiInteri INIZIO");

        mostra(interi);
        uguali(interi.size(), 0); // #1
        interi.add(1);
        mostra(interi);
        uguali(interi.size(), 1); // #2
        interi.add(2);
        interi.add(3);
        mostra(interi);
        uguali(interi.contains(2), true); // #3
        uguali(interi.remove(1), true); // #4
        mostra(interi);
        uguali(interi.contains(2), false); // #5
        uguali(interi.remove(5), false); // #6
        mostra(interi);
        uguali(interi.get(0), 1); // # 7
        uguali(interi.get(1), 3); // # 8
        uguali(interi.get(2), null); // # 9
        interi.clear();
        mostra(interi);
        uguali(interi.size(), 0); // # 10
        uguali(interi.remove(0), false); // # 11
        mostra(interi);

        scrivi("tests ListaDiInteri FINE");
        progressivo = 1;
    }

    public static void testStringa() {
        MiaStringa stringa = new MiaStringa();
        scrivi("tests MiaStringa INIZIO");

        stringa.add('a');
        stringa.add('b');
        stringa.add('c');
        mostra(stringa);
        uguali(stringa, "abc"); // #1
        uguali(stringa.contains('z'), false); // #2
        uguali(stringa.contains('c'), true); // #3
        stringa.remove(1);
        mostra(stringa);
        stringa.remove(1);
        mostra(stringa);
        uguali(stringa.get(0), 'a'); // #4
        stringa.clear();
        mostra(stringa);
        uguali(stringa.size(), 0); // #5

        scrivi("tests MiaStringa FINE");
        progressivo = 1;
    }

    public static void test1() {
        ListaLinked<String> lista = new ListaLinked<>();
        for (int n = 1; n <= 3; n++) {
            lista.aggiungi(String.valueOf(n));
        }

        lista.scorri();
        lista.scorriInverso();

        lista.rimuoviNodo(lista.prendiNodo(2));
        lista.scorri();

    }

    public static void scrivi(String testo) {
        System.out.println(testo);
    }

    public static void uguali(Object oggetto1, Object oggetto2) {
        boolean uguali;
        if (oggetto1 != null && oggetto2 != null) {
            uguali = oggetto1.equals(oggetto2);
        } else uguali = oggetto1 == null && oggetto2 == null;
        String esito = uguali ? "OK" : ("ERRORE poiché non uguali: " + oggetto1 + " & " + oggetto2);
        scrivi(esito + " #" + progressivo++);
    }

    public static String mostra(Object oggetto) {
        String stringa = "(" + oggetto.toString() + ")";
        scrivi(stringa);
        return stringa;
    }
}