public class VeiculoPassageiros extends Veiculo {
    private int maxPassageiros;

    public VeiculoPassageiros(String placa, String modelo, int anoFabricacao, double peso, int maxPassageiros) {
        super(placa, modelo, anoFabricacao, peso);
        this.maxPassageiros = maxPassageiros;
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    @Override
    public String toString() {
        return "VeiculoPassageiros [" + super.toString() + ", maxPassageiros=" + maxPassageiros + "]";
    }
    
}