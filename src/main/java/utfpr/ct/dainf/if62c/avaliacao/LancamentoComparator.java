package utfpr.ct.dainf.if62c.avaliacao;

import java.util.Comparator;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class LancamentoComparator implements Comparator<Lancamento> {
  
    @Override
    public int compare(Lancamento o1, Lancamento o2) {
        int comp = o1.getConta().compareTo(o2.getConta());
        if (comp == 0)
            comp = o1.getData().compareTo(o2.getData());
        return comp;
    }

}
