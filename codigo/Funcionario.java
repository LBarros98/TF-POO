import java.time.LocalDate;

public abstract class Funcionario {
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;

    public Funcionario(String nome, LocalDate dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", nome=" + nome;
    }
    
}