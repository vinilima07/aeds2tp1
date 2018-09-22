/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patricia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Positivo
 */
    
public class Palavra{
    private String bits;
    private String palavra;
    private List<Posicao> p = new ArrayList<>();
    
    public Palavra(String bits, String palavra, int coluna, int linha){
        this.bits = bits;
        this.palavra = palavra;
        p.add(new Posicao(coluna, linha));
    }
    
    public void inserePosicao(int coluna, int linha){
        p.add(new Posicao(coluna, linha));
    }

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public List<Posicao> getP() {
        return p;
    }
}

