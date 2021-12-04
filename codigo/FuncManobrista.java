import java.time.LocalDate;

public class FuncManobrista extends Funcionario {
    private CarteiraHabilitacao habilitacao;

    public FuncManobrista(String nome, LocalDate dataNascimento, String cpf, CarteiraHabilitacao CNH) {
        super(nome, dataNascimento, cpf);
        this.habilitacao = CNH;
    }

    public FuncManobrista(String nome, LocalDate dataNascimento, String cpf, String numeroCNH, String categoriaCNH, LocalDate dataVencimentoCNH) {
        super(nome, dataNascimento, cpf);
        this.habilitacao = new CarteiraHabilitacao(numeroCNH, categoriaCNH, dataVencimentoCNH);
    }

    public CarteiraHabilitacao getCNH() {
        return habilitacao;
    }

    public void setCNH(CarteiraHabilitacao habilitacao) {
        this.habilitacao = habilitacao;
    }

    @Override
    public String toString() {
        return "FuncionarioManobrista [" + super.toString() + ", habilitacao=" + habilitacao + "]";
    }    
    
}
