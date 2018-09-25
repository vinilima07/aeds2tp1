/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patricia;

import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author Positivo
 */
class Busca {
    public void discover(String fileName) throws IOException{
        ArvorePatricia dicionario = new ArvorePatricia(128);
        StringBuilder string = new StringBuilder();
        RandomAccessFile file = null;
        //extrai a palavra do texto e converte em bits
        try {
            file = new RandomAccessFile(fileName, "r");
            char c = '\u0000';
            int coluna = 0;
            int linha = 1;
            int EOF = 0;
            while(true){
                EOF = file.read();
                if(EOF != -1) {
                   c = (char) EOF; // conversao int para char
                }else break;
                if(c == ' ' || c == '\t' || c == '\n' ||  c == '\r'
                    || c == ',' || c == '.' ||  c == '!' || c == '?'){
                    
                    if(string.length() > 0){
                        dicionario.insere(new Palavra(getBit(string.toString()), string.toString(), coluna, linha));
                        string = new StringBuilder();
                    }
                    if(c == '\n'){
                        linha++;
                        coluna = 0;
                    }
                }else{
                    string.append(c);
                }
                coluna++;
            }
            System.out.println("fim while");
            //india, ou ver, mais uma vez, uma grande oportunidade passar sem ser aproveitada.
            Palavra p = (new Palavra(getBit("Importancia"), "Importancia", 0, 0));
            dicionario.pesquisa(p);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally{
            if(file != null) file.close();
        }
    }
    
    public static String getBit(String palavra){
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
        return binary.toString();
    }
    
}
