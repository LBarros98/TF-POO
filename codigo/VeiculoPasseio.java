public class VeiculoPasseio extends Veiculo {

    public VeiculoPasseio(String placa, String modelo, int anoFabricacao, double peso) {
        super(placa, modelo, anoFabricacao, peso);
    }

    @Override
    public String toString() {
        return "VeiculoPasseio [" + super.toString() + "]";
    }
    
}
