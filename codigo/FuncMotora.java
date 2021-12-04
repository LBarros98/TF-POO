import java.time.LocalDate;

public class FuncMotora extends Funcionario {
    private CarteiraHabilitacao habilitacao;
    private boolean cargasPerigosas;
    private boolean transportePassageiros;

    public FuncMotora(String nome, LocalDate dataNascimento, String cpf, CarteiraHabilitacao CNH, boolean cargasPerigosas, boolean transportePassageiros) {
        super(nome, dataNascimento, cpf);
        this.habilitacao = CNH;
        this.cargasPerigosas = cargasPerigosas;
        this.transportePassageiros = transportePassageiros;
    }

    public FuncMotora(String nome, LocalDate dataNascimento, String cpf, String numeroCNH, String categoriaCNH, LocalDate dataVencimentoCNH, boolean cargasPerigosas, boolean transportePassageiros) {
        super(nome, dataNascimento, cpf);
        this.habilitacao = new CarteiraHabilitacao(numeroCNH, categoriaCNH, dataVencimentoCNH);
        this.cargasPerigosas = cargasPerigosas;
        this.transportePassageiros = transportePassageiros;
    }

    public CarteiraHabilitacao getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(CarteiraHabilitacao habilitacao) {
        this.habilitacao = habilitacao;
    }

    public boolean isCargasPerigosas() {
        return cargasPerigosas;
    }

    public void setCargasPerigosas(boolean cargasPerigosas) {
        this.cargasPerigosas = cargasPerigosas;
    }

    public boolean isTransportePassageiros() {
        return transportePassageiros;
    }

    public void setTransportePassageiros(boolean transportePassageiros) {
        this.transportePassageiros = transportePassageiros;
    }

    @Override
    public String toString() {
        return "FuncionarioMotorista [" + super.toString() + ", cargasPerigosas=" + cargasPerigosas + ", habilitacao=" + habilitacao
                + ", transportePassageiros=" + transportePassageiros + "]";
    } 
    
}
