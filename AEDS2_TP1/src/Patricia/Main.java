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
        try{
            ExtraiPalavra palavras = new ExtraiPalavra (args[0], args[1]);
            String palavra = null; int i = 1;
            while ((palavra = palavras.proximaPalavra())!=null)
            System.out.println ("Palavra"+ (i++) +": " + palavra); 
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
        dicionario.imprime ();

        //Gera outra permutacai aleatoria das chaves
        PermutacaoRandomica.permut (vetor, vetor.length);

        //Pesquisa cada chave na arvore
        for (int i = 0; i < vetor.length; i++) {
          char c = vetor[i];
          System.out.println ("Pesquisando chave" + i + ": " + c);
          dicionario.pesquisa (c);
        }
    }
}
