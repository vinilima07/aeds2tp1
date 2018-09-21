package Patricia;

import java.util.ArrayList;
import java.util.HashMap;
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

        List < Palavra > indexadas = new ArrayList < > ();

        //extrai a palavra do texto e converte em bits
        try {
            
            String palavra = null;
            while ((palavra = next()) != null) {
                int coluna = 0;
                int linha = 0;
                byte[] bytes = palavra.getBytes();
                //recupera a palavra em bytes
                StringBuilder binary = new StringBuilder();
                //converte byte para bits
                for (byte b: bytes) {
                    int val = b;
                    for (int i = 0; i < 8; i++) {
                        binary.append((val & 128) == 0 ? 0 : 1);
                        val <<= 1;
                    }
                }
                //preenche com zeros
                while (binary.length() != 128) {
                    binary.insert(0, '0');
                }
                indexadas.add(new Palavra(binary.toString(), palavra, coluna, linha));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ArvorePatricia dicionario = new ArvorePatricia(128);

        for (String palavra: indexadas) {
            dicionario.insere(palavra);
        }
    }
    
    public String nextWord(){
        
    }
}