import java.time.LocalDate;

public abstract class Fretamento {
    private int id;
    private Veiculo veiculo;
    private Funcionario condutor;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double distancia;
    private double valorCobrado;
    private static int count = 0;

    public Fretamento(Veiculo veiculo, Funcionario condutor, LocalDate dataInicio, LocalDate dataTermino,
            double distancia, double valorCobrado) {
        this.id = count++;
        this.veiculo = veiculo;
        this.condutor = condutor;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.distancia = distancia;
        this.valorCobrado = valorCobrado;
    }

    public int getId() {
        return id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Funcionario getCondutor() {
        return condutor;
    }

    public void setCondutor(Funcionario condutor) {
        this.condutor = condutor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    @Override
    public String toString() {
        return "condutor=" + condutor + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino
                + ", distancia=" + distancia + ", id=" + id + ", valorCobrado=" + valorCobrado + ", veiculo=" + veiculo;
    }
    
}
