import java.time.LocalDate;

public class FretamentoUtilCaminhoes extends Fretamento {
    private boolean cargaPerigosa;

    public FretamentoUtilCaminhoes(Veiculo veiculo, Funcionario condutor, LocalDate dataInicio,
            LocalDate dataTermino, double distancia, double valorCobrado, boolean cargaPerigosa) {
        super(veiculo, condutor, dataInicio, dataTermino, distancia, valorCobrado);
        this.cargaPerigosa = cargaPerigosa;
    }

    public boolean isCargaPerigosa() {
        return cargaPerigosa;
    }

    public void setCargaPerigosa(boolean cargaPerigosa) {
        this.cargaPerigosa = cargaPerigosa;
    }

    @Override
    public String toString() {
        return "FretamentoUtilitariosCaminhoes [" + super.toString() + "cargaPerigosa=" + cargaPerigosa + "]";
    }
    
}
