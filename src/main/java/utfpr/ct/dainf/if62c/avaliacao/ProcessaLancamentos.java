package utfpr.ct.dainf.if62c.avaliacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class ProcessaLancamentos {
    private BufferedReader reader;

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(arquivo));
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        this(new File(path));
    }
    
    private String getNextLine() throws IOException {
        return reader.readLine();
    }
    
    private Lancamento processaLinha(String linha) {
        Integer conta = Integer.valueOf(linha.substring(0, 6));
        GregorianCalendar cal = new GregorianCalendar(
        Integer.parseInt(linha.substring(6, 10)),
        Integer.parseInt(linha.substring(10, 12))-1,
        Integer.parseInt(linha.substring(12, 14)));
        Date data = cal.getTime();
        String descricao = linha.substring(14, 74).trim();
        Double valor = Long.valueOf(linha.substring(74, 86)) / 100.0;
        return new Lancamento(conta, data, descricao, valor);
    }
    
    private Lancamento getNextLancamento() throws IOException {
        String linha = getNextLine();
        return linha == null ? null : processaLinha(linha);
    }
    
    public List<Lancamento> getLancamentos() throws IOException {
        List<Lancamento> lancamentos = new ArrayList<>();
        Lancamento c;
        try {
            while ((c = getNextLancamento()) != null) {
                lancamentos.add(c);
            }
        }finally{
            reader.close();
        }
        return lancamentos;
    }
    
}
