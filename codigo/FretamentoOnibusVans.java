import java.time.LocalDate;

public class FretamentoOnibusVans extends Fretamento {

    public FretamentoOnibusVans(Veiculo veiculo, Funcionario condutor, LocalDate dataInicio,
            LocalDate dataTermino, double distancia, double valorCobrado) {
        super(veiculo, condutor, dataInicio, dataTermino, distancia, valorCobrado);
    }

    @Override
    public String toString() {
        return "FretamentoOnibusVans [" + super.toString() + "]";
    }    
    
}
