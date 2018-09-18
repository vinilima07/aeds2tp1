package Patricia;
/**
 *
 * @author Vinicius Franca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //extrai a palavra do texto e converte em bits
        try{
            ExtraiPalavra palavras = new ExtraiPalavra 
                ("C:\\Users\\Positivo\\Documents\\github\\aeds2tp1\\AEDS2_TP1\\src\\Patricia\\delim.txt",
                 "C:\\Users\\Positivo\\Documents\\github\\aeds2tp1\\AEDS2_TP1\\src\\Patricia\\exemplo1.txt");
            String p = "vini";
            String palavra = null;
            while ((palavra = palavras.proximaPalavra())!=null){
                byte[] bytes = palavra.getBytes();
                StringBuilder binary = new StringBuilder();
                for (byte b : bytes)
                {
                   int val = b;
                   for (int i = 0; i < 8; i++){
                      binary.append((val & 128) == 0 ? 0 : 1);
                      val <<= 1;
                   }
                }
                while(binary.length() != 128){
                    binary.insert(0, '0');
                }
                System.out.println("Palavra:"+palavra+" Bits:"+binary);
            }
            palavras.fecharArquivos();
        }catch (Exception e){
            System.out.println (e.getMessage ());    
        }
        
        ArvorePatricia dicionario = new ArvorePatricia (8);
        int min = 32, max = 126;

        char vetor[] = new char[max-min+1];

        for (int i = min; i <= max; i++)
          vetor[i-min] = (char)i;

        //Gera uma permutacao aleatoria de chaves dos caracteres UNICODE 32 a  126
        PermutacaoRandomica.permut (vetor, vetor.length);

        //Insere cada chave na arvore
        for (int i = 0; i < vetor.length; i++) { 
          char c = vetor[i];
          dicionario.insere (c);
          System.out.println ("Inseriu chave"+ i + ": " + (int)c + " -- char:" + c);
        }

        //Gera outra permutacao aleatoria das chaves
        PermutacaoRandomica.permut (vetor, vetor.length);

        //Pesquisa cada chave na arvore
        for (int i = 0; i < vetor.length; i++) {
          char c = vetor[i];
          System.out.println ("Pesquisando chave" + i + ": " + c);
          dicionario.pesquisa (c);
        }
    }
}
