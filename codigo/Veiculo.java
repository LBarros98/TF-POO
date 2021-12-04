public abstract class Veiculo {
    private String placa;
    private String modelo;
    private int anoFabricacao;
    private double peso;
    
    public Veiculo(String placa, String modelo, int anoFabricacao, double peso) {
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.peso = peso;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "anoFabricacao=" + anoFabricacao + ", modelo=" + modelo + ", peso=" + peso + ", placa=" + placa;
    }

}
