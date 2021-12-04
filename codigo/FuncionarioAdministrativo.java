import java.time.LocalDate;

public class FuncionarioAdministrativo extends Funcionario {


    public FuncionarioAdministrativo(String nome, LocalDate dataNascimento, String cpf) {
        super(nome, dataNascimento, cpf);
    }

    @Override
    public String toString() {
        return "FuncionarioAdministrativo [" + super.toString()+ "]";
    }
    
}
