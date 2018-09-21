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
    
    public Palavra(String bits, Palavra p){
        this.bits = bits;
        this.palavra = p.palavra;
        this.p = p.p;
    }
    
    public Palavra(String palavra, int coluna, int linha){
        this.palavra = palavra;
        p.add(new Posicao(coluna, linha));
    }
    
    public void inserePosicao(int coluna, int linha){
        p.add(new Posicao(coluna, linha));
    }
}

