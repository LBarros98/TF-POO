import java.time.LocalDate;

public class CarteiraHabilitacao{
    private String numero;
    private String categoria;
    private LocalDate dataVencimento;

    public CarteiraHabilitacao(String numero, String categoria, LocalDate dataVencimento) {
        this.numero = numero;
        this.categoria = categoria;
        this.dataVencimento = dataVencimento;
    }

    public String getNumero() {
        return numero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return "CNH [categoria=" + categoria + ", dataVencimento=" + dataVencimento + ", numero=" + numero + "]";
    }    

}
