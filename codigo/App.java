import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        int opcao;

        var funcMoto1 = new FuncMotora("Carlos", LocalDate.now(), "021.584.758-88", "14201534858", "B", LocalDate.now().plusMonths(1), true, true);
        var funcMoto2 = new FuncMotora("Pedro", LocalDate.now(), "154.552.368-97", "56847812469", "C", LocalDate.now().plusMonths(1), true, true);
        var funcMoto3 = new FuncMotora("Patrick", LocalDate.now(), "475.441.201-63", "55420138756", "E", LocalDate.now().plusMonths(1), true, true);

        Arrays.funcionarios.add(funcMoto1);
        Arrays.funcionarios.add(funcMoto2);
        Arrays.funcionarios.add(funcMoto3);

        var veiculo1 = new VeiculoPassageiros("475", "Palio", 2020, 200, 30);
        var veiculo2 = new VeiculoPassageiros("623", "Compass", 2021, 200, 50);
        var veiculo3 = new VeiculoCargas("000", "Caminhão", 2020, 200, 500, 2, false);

        Arrays.veiculos.add(veiculo1);
        Arrays.veiculos.add(veiculo2);
        Arrays.veiculos.add(veiculo3);

        Arrays.fretamentos.add(new FretamentoOnibusVans(veiculo1, funcMoto1, LocalDate.now(), LocalDate.now().plusMonths(1), 20, 3000));
        Arrays.fretamentos.add(new FretamentoOnibusVans(veiculo1, funcMoto1, LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(3), 20, 4000));
        Arrays.fretamentos.add(new FretamentoOnibusVans(veiculo2, funcMoto2, LocalDate.now(), LocalDate.now().plusMonths(1), 20, 6000));
        Arrays.fretamentos.add(new FretamentoOnibusVans(veiculo3, funcMoto3, LocalDate.now(), LocalDate.now().plusMonths(1), 20, 3000));
        Arrays.fretamentos.add(new FretamentoOnibusVans(veiculo3, funcMoto3, LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(4), 20, 2500));
        Arrays.fretamentos.add(new FretamentoOnibusVans(veiculo3, funcMoto3, LocalDate.now().plusMonths(6), LocalDate.now().plusMonths(7), 20, 1000));

        System.out.println("Bem-vindo ao programa!");

        while(true) {
            System.out.println("\n============ MENU ============");
            System.out.println("1. Funcionários");
            System.out.println("2. Veículos");
            System.out.println("3. Fretamentos");
            System.out.println("4. Encerrar");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    menu.mostrarMenuFuncionarios();
                    break;
                case 2:
                    menu.mostrarMenuVeiculos();
                    break;
                case 3:
                    menu.mostrarMenuFretamentos();
                    break;
                case 4:
                    System.out.println("\nPrograma encerrado.");
                    return;
                default:
                    System.out.println("\nOpcão inválida!");
                    break;
            }
        }

    }
}
