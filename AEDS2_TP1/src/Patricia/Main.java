package Patricia;

import java.io.IOException;
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
        //b.discover(file1, palavras1);
        b.discover(file2, palavras2);
    }
}