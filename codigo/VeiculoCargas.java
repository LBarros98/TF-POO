public class VeiculoCargas extends Veiculo {
    private double capacidadeCarga;
    private int eixos;
    private boolean temUnidadeAcoplada;

    public VeiculoCargas(String placa, String modelo, int anoFabricacao, double peso, double capacidadeCarga, int eixos,
            boolean temUnidadeAcoplada) {
        super(placa, modelo, anoFabricacao, peso);
        this.capacidadeCarga = capacidadeCarga;
        this.eixos = eixos;
        this.temUnidadeAcoplada = temUnidadeAcoplada;
    }
    
    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }

    public boolean temUnidadeAcoplada() {
        return temUnidadeAcoplada;
    }

    public void setTemUnidadeAcoplada(boolean temUnidadeAcoplada) {
        this.temUnidadeAcoplada = temUnidadeAcoplada;
    }

    @Override
    public String toString() {
        return "VeiculoCargas [" + super.toString() + ", capacidadeCarga=" + capacidadeCarga + ", eixos=" + eixos + ", temUnidadeAcoplada=" + temUnidadeAcoplada + "]";
    }
    
}
