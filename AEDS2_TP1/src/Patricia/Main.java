package Patricia;

import static Patricia.Busca.getBit;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Vinicius Franca
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        String[] palavras1 = {"trabalho", "computação", "governo", "educacao",
            "tecnologia", "formacao", "desenvolvimento", "que", "informatica",
            "em", "crise"};
        String[] palavras2= {"sociedade", "software", "ideia", "pessoa", "informatica", "etica", "muito", "ciencia", "computacao", "que", "area", "Moral"};
        
        String file1 = "C:\\Users\\Positivo\\Documents\\github\\treePatricia\\AEDS2_TP1\\src\\Patricia\\exemplo1.txt";
        String file2 = "C:\\Users\\Positivo\\Documents\\github\\treePatricia\\AEDS2_TP1\\src\\Patricia\\exemplo2.txt";
        Busca b = new Busca();
        String word[] = new String[1];
        Scanner scanner = new Scanner(System.in);
        int escolha;
        try{        
        while (true) {
            System.out.println("\nEscolha a busca da palavras catalogadas (1) ou"
                    + "\nBusca por uma palavra da sua escolha (2)"
                    +"\nSair (3)");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Qual o exemplo (1) ou (2)?");
                    escolha = scanner.nextInt();
                    if(escolha == 1) b.discover(file1, palavras1);
                    else if( escolha == 2) b.discover(file2, palavras2);
                    break;
                case 2:
                    System.out.println("Qual a palavra?");
                    word[0] = scanner.next();
                    if(word[0].length() > 16) System.out.println("palavra muito grande");
                    System.out.println("Qual o exemplo (1) ou (2)?");
                    escolha = scanner.nextInt();
                    if(escolha == 1) b.discover(file1, word);
                    else if( escolha == 2) b.discover(file2, word);
                    break;
                case 3:
                    return;
            }
        }
        }catch(Exception e){
            System.out.println("Voce inseriu incorretamente : (");
            System.out.println(e.getMessage());
        }
    }
}