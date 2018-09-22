package Patricia;
public class ArvorePatricia {
  private static abstract class PatNo { }
  private static class PatNoInt extends PatNo {
    int index; PatNo esq, dir;
  }  
  private static class PatNoExt extends PatNo {
    Palavra chave; //O tipo da chave depende da aplicao
  }
  
  private PatNo raiz;
  private int nbitsChave;
 
  //Retorna o i-esimo bit da chave k a partir da esquerda
  private int bit (int i, String k) {
    if(i < this.nbitsChave)
    if(k.charAt(i) == '0') return 0;
    else return 1;
    return 0;
  }

  //Verifica se p e no externo
  private boolean eExterno (PatNo p) {    
    Class classe = p.getClass();
    return classe.getName().equals(PatNoExt.class.getName());
  }

  private PatNo criaNoInt (int i, PatNo esq, PatNo dir) {
    PatNoInt p = new PatNoInt();
    p.index = i; p.esq = esq; p.dir = dir;
    return p;
  }

  private PatNo criaNoExt (Palavra k) {
    PatNoExt p = new PatNoExt();
    p.chave = k;
    return p;
  }
  
  private Palavra pesquisa (Palavra k, PatNo t) {
    if (this.eExterno (t)) {
      PatNoExt aux = (PatNoExt)t;
      if (aux.chave.getPalavra().equalsIgnoreCase(k.getPalavra())){
          System.out.println ("Elemento encontrado");
          return k;
      }else{
          System.out.println ("Elemento nao encontrado");
          return null;
      }
    }
    else { 
      PatNoInt aux = (PatNoInt)t;
      if (this.bit (aux.index, k.getBits()) == 0) pesquisa (k, aux.esq);
      else pesquisa (k, aux.dir);
    }
    return null;
  }

  private PatNo insereEntre (Palavra k, PatNo t, int i) {
    PatNoInt aux = null; 
    if (!this.eExterno (t)) 
        aux = (PatNoInt)t;
    if (this.eExterno (t) || (i < aux.index)) { //Cria um novo no externo
        PatNo p = this.criaNoExt (k);
        if (this.bit (i, k.getBits()) == 1) return this.criaNoInt (i, t, p);
        else return this.criaNoInt (i, p, t);
    }
    else {
        if (this.bit (aux.index, k.getBits()) == 1) 
          aux.dir = this.insereEntre (k, aux.dir, i);
        else aux.esq = this.insereEntre (k, aux.esq, i);
        return aux;
    }
  }
  
  private PatNo insere (Palavra k, PatNo t) {
    if (t == null) return this.criaNoExt (k);
    else {
      PatNo p = t;
      while (!this.eExterno (p)) {
        PatNoInt aux = (PatNoInt)p;
        if (this.bit (aux.index, k.getBits()) == 1) p = aux.dir; else p = aux.esq;
      }
      PatNoExt aux = (PatNoExt)p;
      int i = 0; //acha o primeiro bit diferente
      while ((i <= this.nbitsChave)&&
             (this.bit (i, k.getBits()) == this.bit (i, aux.chave.getBits()))) i++;
      if (i > this.nbitsChave) {
        aux.chave.inserePosicao(k.getP().get(0).getColuna(), k.getP().get(0).getLinha());
        System.out.println ("chave ja esta na arvore");
        return null;
      }
      else return this.insereEntre (k, t, i);
    }
  }
  
  private void central (PatNo pai, PatNo filho, String msg) {
    if (filho != null) {
      if (!this.eExterno (filho)) {
        PatNoInt aux = (PatNoInt)filho; 
        central (filho, aux.esq, "ESQ");
        if (pai != null)
          System.out.println ("Pai: "+ ((PatNoInt)pai).index + " " + msg+ " Int: " + aux.index);
        else System.out.println ("Pai: "+ pai + " " + msg+ " Int: " + aux.index);
        central (filho, aux.dir, "DIR");
      } else {
        PatNoExt aux = (PatNoExt)filho;
        if (pai != null)
          System.out.println ("Pai: "+ ((PatNoInt)pai).index + " " + msg+ " Ext: " + aux.chave);
        else System.out.println ("Pai: "+ pai + " " + msg+ " Ext: " + aux.chave);
      }
    }
  }

  public void imprime() {
    this.central (null, this.raiz, "RAIZ");
  }

  public ArvorePatricia (int nbitsChave) {
    this.raiz = null; this.nbitsChave = nbitsChave; 
  }
  
  public Palavra pesquisa (Palavra k) { return (this.pesquisa (k, this.raiz)); }
  
  public void insere (Palavra k) { this.raiz = this.insere (k, this.raiz); }
}
