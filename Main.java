package br.edu.cefsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_16;


public class Main {

    private static final char PARENTESE_ESQUERDO = '(';
    private static final char PARENTESE_DIREITO = ')';
    private static final char CHAVE_ESQUERDA = '{';
    private static final char CHAVE_DIREITA = '}';
    private static final char COLCHETE_ESQUERDO = '[';
    private static final char COLCHETE_DIRETO = ']';

    public static boolean isBalanced(String s) {
        List<Character> lista = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)){
                case PARENTESE_ESQUERDO:
                    lista.add(PARENTESE_ESQUERDO);
                    break;
                case CHAVE_ESQUERDA:
                    lista.add(CHAVE_ESQUERDA);
                    break;
                case COLCHETE_ESQUERDO:
                    lista.add(COLCHETE_ESQUERDO);
                    break;
                case PARENTESE_DIREITO:
                    if (lista.isEmpty())        return false;
                    if (lista.remove(lista.size() - 1) != PARENTESE_ESQUERDO) return false;
                    break;
                case CHAVE_DIREITA:
                    if (lista.isEmpty())        return false;
                    if (lista.remove(lista.size() - 1) != CHAVE_ESQUERDA) return false;
                    break;
                case COLCHETE_DIRETO:
                    if (lista.isEmpty())        return false;
                    if (lista.remove(lista.size() - 1) != COLCHETE_ESQUERDO) return false;
                    break;
            }
        }
        return lista.isEmpty();
    }


    public static void main(String[] args) throws IOException {
        if(args.length > 1) {
            Path path = Path.of(args[1]);
            String s = Files.readString(path, UTF_16);
            System.out.println(isBalanced(s));
        }
    }
}
