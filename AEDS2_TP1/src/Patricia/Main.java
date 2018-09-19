package Patricia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius Franca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<String> indexadas = new ArrayList<>();
        
        try{//extrai a palavra do texto e converte em bits
            ExtraiPalavra palavras = new ExtraiPalavra 
                ("C:\\Users\\Positivo\\Documents\\github\\aeds2tp1\\AEDS2_TP1\\src\\Patricia\\delim.txt",
                 "C:\\Users\\Positivo\\Documents\\github\\aeds2tp1\\AEDS2_TP1\\src\\Patricia\\exemplo1.txt");
            String palavra = null;
            while ((palavra = palavras.proximaPalavra())!=null){
                byte[] bytes = palavra.getBytes(); //recupera a palavra em bytes
                StringBuilder binary = new StringBuilder();
                for (byte b : bytes){ //converte byte para bits
                   int val = b;
                   for (int i = 0; i < 8; i++){
                      binary.append((val & 128) == 0 ? 0 : 1);
                      val <<= 1;
                   }
                }
                while(binary.length() != 128){
                    binary.insert(0, '0');
                }
                indexadas.add(binary.toString());
                System.out.println("Palavra:"+palavra+" Bits:"+binary);
            }
            palavras.fecharArquivos();
        }catch (Exception e){
            System.out.println (e.getMessage());    
        }
        
        ArvorePatricia dicionario = new ArvorePatricia (8);
        for(String palavra: indexadas){
            dicionario.insere(palavra);
        }
        
        //Pesquisa cada chave na arvore
        String[] exemplo1 = {"trabalho", "computacao", "governo", "educacao", "tecnologia",
        "formacao", "desenvolvimento", "que", "informatica", "em", "crise"};
        for(String palavra: exemplo1){
            System.out.println ("Palavra");
            dicionario.pesquisa (palavra);
        }
        
    }
}
