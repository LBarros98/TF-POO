import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

    public Menu() {
    }

    // MENU DE FUNCIONARIOS:

    public void mostrarMenuFuncionarios() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        
        while(true) {
            System.out.println("\n====== MENU FUNCIONARIOS =====");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Listar funcionários");
            System.out.println("3. Buscar funcionário");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    System.out.println(cadastrarFuncionario());
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    buscarFuncionario();
                    break;
                case 4:
                    System.out.println("\nRetornando para o menu principal!");
                    return;
                default:
                    System.out.println("\nOpcão inválida!");
                    break;
            }
        }
    }
    
    private String cadastrarFuncionario() {
        String mensagem = "\nFuncionário cadastrado com sucesso!";
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("\nInforme o nome: ");
            String nome = sc.nextLine();

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            LocalDate dataNascimento = LocalDate.parse(sc.nextLine(), formato);

            System.out.print("Informe o CPF: ");
            String cpf = sc.nextLine();

            System.out.print("Este funcionário é um Administrador? (S/N): ");
            String res = sc.nextLine();
            boolean isAdmin = res.toUpperCase().equals("S");

            if (isAdmin) {
                Funcionario funcionario = new FuncionarioAdministrativo(nome, dataNascimento, cpf);
                Arrays.funcionarios.add(funcionario);
                return mensagem;
            }

            System.out.print("Número da CNH: ");
            String numeroCNH = sc.nextLine();

            System.out.print("Categoria da CNH: ");
            String categoriaCNH = sc.nextLine();

            System.out.print("Data de vencimento da CNH (dd/mm/aaaa): ");
            LocalDate dataVencimentoCNH = LocalDate.parse(sc.nextLine(), formato);

            CarteiraHabilitacao carteiraHabilitacao = new CarteiraHabilitacao(numeroCNH, categoriaCNH, dataVencimentoCNH);

            System.out.print("Este funcionário é um Manobrista? (S/N): ");
            boolean isManobrista = sc.nextLine().toUpperCase().equals("S");

            if (isManobrista) {
                Funcionario funcionario = new FuncManobrista(nome, dataNascimento, cpf, carteiraHabilitacao);
                Arrays.funcionarios.add(funcionario);
                return mensagem;
            }

            System.out.print("Este funcionário pode transportar cargas perigosas? (S/N): ");
            boolean cargasPerigosas = sc.nextLine().toUpperCase().equals("S");

            System.out.print("Este funcionário pode transportar passageiros? (S/N): ");
            boolean transportePassageiros = sc.nextLine().toUpperCase().equals("S");

            Funcionario funcionario = new FuncMotora(nome, dataNascimento, cpf, carteiraHabilitacao, cargasPerigosas, transportePassageiros);
            Arrays.funcionarios.add(funcionario);
            return mensagem;
        } catch (DateTimeParseException e) {
            mensagem = "\nData inválida! Utilize o padrão \"dd/mm/aaaa\".";
        }
        return mensagem;
    }

    private void listarFuncionarios() {
        if (Arrays.funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado!");
        } else {
            System.out.println("\nFuncionários cadastrados: (ordem alfabética)");
            var lista = Arrays.funcionarios;
            lista.sort((a, b) -> a.getNome().compareTo(b.getNome()));;
            for (var f : lista)
                System.out.println(f);
        }
        return;        
    }

    private void buscarFuncionario() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nInforme o CPF do funcionário: ");
        String cpf = sc.nextLine();

        var funcionario = Arrays.funcionarios.stream().filter(f -> f.getCpf().equals(cpf)).findFirst();
        if (funcionario.isPresent()) {
            System.out.println("Funcionário encontrado:");
            System.out.println(funcionario.get());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
        return;
    }

    // FIM DO MENU DE FUNCIONARIOS

    // INICIO DO MENU DE VEICULOS:

    public void mostrarMenuVeiculos() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        
        while(true) {
            System.out.println("\n======== MENU VEICULOS =======");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Listar veículos");
            System.out.println("3. Buscar veículo");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    System.out.println(cadastrarVeiculo());
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    buscarVeiculo();
                    break;
                case 4:
                    System.out.println("\nRetornando para o menu principal...");
                    return;
                default:
                    System.out.println("\nOpcão inválida!");
                    break;
            }
        }
    }

    private String cadastrarVeiculo() {
        String mensagem = "\nVeículo cadastrado com sucesso!";
        try {
            Scanner sc = new Scanner(System.in);
            Veiculo veiculo = null;

            System.out.print("\nInforme a placa: ");
            String placa = sc.nextLine();

            System.out.print("Informe o modelo: ");
            String modelo = sc.nextLine();

            System.out.print("Ano de fabricação: ");
            int anoFabricacao = sc.nextInt();

            System.out.print("Informe o peso: ");
            double peso = sc.nextDouble();

            System.out.println("\nTipos de veículos disponíveis:");
            System.out.println("1. Veículo de passeio");
            System.out.println("2. Veículo de passageiros");
            System.out.println("3. Veículo de cargas");
            System.out.print("\nEscolha o tipo do veículo: ");
            int tipo = sc.nextInt();

            switch (tipo) {
                case 1:
                    veiculo = new VeiculoPasseio(placa, modelo, anoFabricacao, peso);
                    break;
                case 2:
                    System.out.print("Máximo de passageiros: ");
                    int maxPassageiros = sc.nextInt();

                    veiculo = new VeiculoPassageiros(placa, modelo, anoFabricacao, peso, maxPassageiros);
                    break;
                case 3:
                    System.out.print("Capacidade de carga: ");
                    double capacidadeCarga = sc.nextDouble();

                    System.out.print("Número de eixos: ");
                    int eixos = sc.nextInt();

                    System.out.print("Tem unidade acoplada? (S/N): ");
                    sc = new Scanner(System.in);
                    String res = sc.nextLine();
                    boolean temUnidadeAcoplada = res.toUpperCase().equals("S");

                    veiculo = new VeiculoCargas(placa, modelo, anoFabricacao, peso, capacidadeCarga, eixos, temUnidadeAcoplada);
                    break;
                default:
                    return "\nOpção inválida!";
            }
            Arrays.veiculos.add(veiculo);

        } catch (InputMismatchException e) {
            mensagem = "\nValor inválido! Utilize apenas números.";
        }
        return mensagem;
    }

    private void listarVeiculos() {
        if (Arrays.veiculos.isEmpty()) {
            System.out.println("\nNenhum veículo cadastrado!");
        } else {
            System.out.println("\nVeículos cadastrados: (ordenados por ano de fabricação)");
            var lista = Arrays.veiculos;
            lista.sort((a, b) -> Integer.compare(a.getAnoFabricacao(), b.getAnoFabricacao()));
            for (var v : lista)
                System.out.println(v);
        }
        return;        
    }

    private void buscarVeiculo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nInforme a placa do veículo: ");
        String placa = sc.nextLine();

        var veiculo = Arrays.veiculos.stream().filter(v -> v.getPlaca().equals(placa)).findFirst();
        if (veiculo.isPresent()) {
            System.out.println("Veículo encontrado:");
            System.out.println(veiculo.get());
        } else {
            System.out.println("Veículo não encontrado.");
        }
        return;
    }

    // FIM DO MENU DE VEICULOS

    // INICIO DO MEU DE FRETAMENTOS:

    public void mostrarMenuFretamentos() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        
        while(true) {
            System.out.println("\n====== MENU FRETAMENTOS ======");
            System.out.println("1. Cadastrar fretamento");
            System.out.println("2. Listar motoristas livres");
            System.out.println("3. Listar veículos livres");
            System.out.println("4. Histórico de fretamentos");
            System.out.println("5. Veículos mais lucrativos");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    System.out.println(cadastrarFretamento());
                    break;
                case 2:
                    listarMotoristasLivres();
                    break;
                case 3:
                    listarVeiculosLivres();
                    break;
                case 4:
                    historicoFretamentos();
                    break;
                case 5:
                    veiculosMaisLucrativos();
                    break;
                case 6:
                    System.out.println("\nRetornando para o menu principal...");
                    return;
                default:
                    System.out.println("\nOpcão inválida!");
                    break;
            }
        }
    }

    private String cadastrarFretamento() {
        if (Arrays.funcionarios.isEmpty() || Arrays.veiculos.isEmpty()) {
            return "\nNão há veículos ou motoristas suficientes para realizar um fretamento.";
        }
        try {
            Scanner sc = new Scanner(System.in);
            Fretamento fretamento = null;

            System.out.print("\nInforme a placa: ");
            String placa = sc.nextLine();

            var veiculo = Arrays.veiculos.stream().filter(v -> v.getPlaca().equals(placa)).findFirst();
            if (!veiculo.isPresent()) {
                return "\nVeículo não encontrado.";
            } else if (veiculo.get() instanceof VeiculoPasseio) {
                return "\nFretamento indisponível para este tipo de veículo";
            }

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.print("Data de início (dd/mm/aaaa): ");
            LocalDate dataInicio = LocalDate.parse(sc.nextLine(), formato);

            System.out.print("Data do término (dd/mm/aaaa): ");
            LocalDate dataTermino = LocalDate.parse(sc.nextLine(), formato);

            if (dataInicio.isAfter(dataTermino)) {
                return "\nInfelizmente ainda não temos motoristas capazes de viajar no tempo!";
            }

            System.out.print("Distância a ser percorrida: ");
            double distancia = sc.nextDouble();

            if (veiculo.get() instanceof VeiculoPassageiros) {
                System.out.print("Total de passageiros: ");
                int totalPassageiros = sc.nextInt();

                int maxPassageiros = ((VeiculoPassageiros) veiculo.get()).getMaxPassageiros();
                if (totalPassageiros > maxPassageiros) {
                    return "\nEste veículo comporta apenas " + maxPassageiros + " passageiros.";
                }

                var motoristas = Arrays.funcionarios.stream()
                                                        .filter(f -> f instanceof FuncMotora)
                                                        .map(f -> (FuncMotora) f)
                                                        .filter(m -> m.isTransportePassageiros() && m.getHabilitacao().getDataVencimento().isAfter(LocalDate.now()))
                                                        .collect(Collectors.toList());
                if (totalPassageiros > 8) {
                    motoristas = motoristas.stream().filter(m -> m.getHabilitacao().getCategoria().equals("D")).collect(Collectors.toList());
                } else {
                    motoristas = motoristas.stream().filter(m -> m.getHabilitacao().getCategoria().equals("B")).collect(Collectors.toList());
                }

                if (motoristas.isEmpty()) {
                    return "\nNenhum motorista atende os requisitos para realizar este fretamento.";
                }

                ArrayList<FuncMotora> aux = new ArrayList<>();
                for (var m : motoristas) {
                    for (var f : Arrays.fretamentos.stream().filter(x -> x.getCondutor() == m).collect(Collectors.toList())) {
                        if (f.getDataInicio() == dataInicio || (f.getDataInicio().isBefore(dataInicio) && f.getDataTermino().isAfter(dataInicio)) || dataInicio.isBefore(f.getDataTermino())) {
                            aux.add(m);
                        }
                    }
                }

                for (var m : aux)
                    motoristas.remove(m);

                if (motoristas.isEmpty()) {
                    return "\nTodos os motoristas capazes de realizar este fretamento já estão ocupados neste período.";
                }

                double valorDiaria = 410.00;
                double valorPorKm = 2.20;

                if (((VeiculoPassageiros) veiculo.get()).getMaxPassageiros() > 45) {
                    valorDiaria = 5600.00;
                    valorPorKm = 3.00;
                } else if (((VeiculoPassageiros) veiculo.get()).getMaxPassageiros() > 25) {
                    valorDiaria = 490.00;
                    valorPorKm = 2.80;
                }

                double valorCobrado = Duration.between(dataInicio.atStartOfDay(), dataTermino.atStartOfDay()).toDays() *  valorDiaria + distancia * valorPorKm;
                fretamento = new FretamentoOnibusVans(veiculo.get(), motoristas.get(0), dataInicio, dataTermino, distancia, valorCobrado);
                Arrays.fretamentos.add(fretamento);

            } else if (veiculo.get() instanceof VeiculoCargas) {
                sc = new Scanner(System.in);
                System.out.print("É transporte de carga perigosa? (S/N): ");
                String res = sc.nextLine();
                boolean cargaPerigosa = res.toUpperCase().equals("S");

                var motoristas = Arrays.funcionarios.stream()
                                                        .filter(f -> f instanceof FuncMotora)
                                                        .map(f -> (FuncMotora) f)
                                                        .filter(m -> m.getHabilitacao().getDataVencimento().isAfter(LocalDate.now()))
                                                        .collect(Collectors.toList());
                
                if (cargaPerigosa) {
                    motoristas = motoristas.stream().filter(m -> m.isCargasPerigosas()).collect(Collectors.toList());
                }

                System.out.print("Peso da carga a ser transportada: ");
                double pesoCarga = sc.nextDouble();

                if (pesoCarga > ((VeiculoCargas) veiculo.get()).getCapacidadeCarga()) {
                    return "\nEsta carga é muito pesada para este veículo.";
                }

                if (((VeiculoCargas) veiculo.get()).temUnidadeAcoplada() && pesoCarga + veiculo.get().getPeso() > 6000) {
                    motoristas = motoristas.stream().filter(m -> m.getHabilitacao().getCategoria().equals("E")).collect(Collectors.toList());
                } else if (pesoCarga + veiculo.get().getPeso() > 3500) {
                    motoristas = motoristas.stream().filter(m -> m.getHabilitacao().getCategoria().equals("C")).collect(Collectors.toList());
                }

                if (motoristas.isEmpty()) {
                    return "\nNenhum motorista atende os requisitos para realizar este fretamento.";
                }

                ArrayList<FuncMotora> aux = new ArrayList<>();
                for (var m : motoristas) {
                    for (var f : Arrays.fretamentos.stream().filter(x -> x.getCondutor() == m).collect(Collectors.toList())) {
                        if (f.getDataInicio() == dataInicio || (f.getDataInicio().isBefore(dataInicio) && f.getDataTermino().isAfter(dataInicio)) || dataInicio.isBefore(f.getDataTermino())) {
                            aux.add(m);
                        }
                    }
                }

                for (var m : aux)
                    motoristas.remove(m);

                if (motoristas.isEmpty()) {
                    return "\nTodos os motoristas capazes de realizar este fretamento já estão ocupados neste período.";
                }

                double valorPorKm = cargaPerigosa ? 1.50 : 1.20;
                double valorCobrado = valorPorKm * distancia * ((VeiculoCargas) veiculo.get()).getEixos();

                fretamento = new FretamentoUtilCaminhoes(veiculo.get(), motoristas.get(0), dataInicio, dataTermino, distancia, valorCobrado, cargaPerigosa);
                Arrays.fretamentos.add(fretamento);
            }
            

        } catch (InputMismatchException e) {
            return "\nValor inválido! Utilize apenas números.";
        } catch (DateTimeParseException e) {
            return "\nData inválida! Utilize o padrão \"dd/mm/aaaa\".";
        }
        return "\nFretamento cadastrado com sucesso!";
    }

    private void listarMotoristasLivres() {
        var motoristas = Arrays.funcionarios.stream()
                                                        .filter(f -> f instanceof FuncMotora)
                                                        .map(f -> (FuncMotora) f)
                                                        .filter(m -> m.getHabilitacao().getDataVencimento().isAfter(LocalDate.now()))
                                                        .collect(Collectors.toList());
        ArrayList<FuncMotora> aux = new ArrayList<>();
        var dataInicio = LocalDate.now();
        for (var m : motoristas) {
            for (var f : Arrays.fretamentos.stream().filter(x -> x.getCondutor() == m).collect(Collectors.toList())) {
                if (f.getDataInicio() == dataInicio || (f.getDataInicio().isBefore(dataInicio) && f.getDataTermino().isAfter(dataInicio))) {
                    aux.add(m);
                }
            }
        }

        for (var m : aux)
            motoristas.remove(m);

        if (motoristas.isEmpty()) {
            System.out.println("\nNenhum motorista diponível neste momento.");
        } else {
            System.out.println("\nMotoristas diponíveis neste momento:");
            motoristas.forEach(m -> System.out.println(m));
        }
        
    }

    private void listarVeiculosLivres() {
        var veiculos = Arrays.veiculos.stream().collect(Collectors.toList());
        ArrayList<Veiculo> aux = new ArrayList<>();
        var dataInicio = LocalDate.now();
        for (var v : veiculos) {
            for (var f : Arrays.fretamentos.stream().filter(x -> x.getVeiculo() == v).collect(Collectors.toList())) {
                if (f.getDataInicio() == dataInicio || (f.getDataInicio().isBefore(dataInicio) && f.getDataTermino().isAfter(dataInicio))) {
                    aux.add(v);
                }
            }
        }

        for (var v : aux)
            veiculos.remove(v);

        if (veiculos.isEmpty()) {
            System.out.println("\nNenhum veículo diponível neste momento.");
        } else {
            System.out.println("\nVeículos diponíveis neste momento:");
            veiculos.forEach(m -> System.out.println(m));
        }
    }

    private void historicoFretamentos() {
        var fretamentos = Arrays.fretamentos;
        if (fretamentos.isEmpty()) {
            System.out.println("\nNenhum fretamento registrado.");
        } else {
            System.out.println("\nFretamentos registrados:");
            for (var f : fretamentos) {
                System.out.println(f);
            }
        }
    }

    private void veiculosMaisLucrativos() {
        var fretamentos = Arrays.fretamentos;

        if (fretamentos.isEmpty()) {
            System.out.println("\nNenhum fretamento registrado.");
            return;
        }

        Map<Veiculo, Double> totalLucrado = new HashMap<>();
        for (var v : fretamentos.stream().map(f -> f.getVeiculo()).collect(Collectors.toList())) {
            totalLucrado.put(v, 0.0);
            for (var f : fretamentos.stream().filter(x -> x.getVeiculo().equals(v)).collect(Collectors.toList())) {
                totalLucrado.put(v, totalLucrado.get(v) + f.getValorCobrado());
            }
        }

        System.out.println("\nVeículos mais lucrativos:");

        ArrayList<Double> lista = new ArrayList<>();
        totalLucrado.forEach((x, y) -> lista.add(y));
        lista.sort((a, b) -> b.compareTo(a));
        int count = 0;
        while (!lista.isEmpty() && count < 5) {
            count++;
            Veiculo key = null;
            for (var entry : totalLucrado.entrySet()) {
                if (entry.getValue().equals(lista.get(0))) {
                    System.out.println(count + ". R$ " + String.format("%.2f", entry.getValue()) + " - (Placa " + entry.getKey().getPlaca() + ") " + entry.getKey().getModelo());    
                    key = entry.getKey();
                    break;
                }
            }
            totalLucrado.remove(key);
            lista.remove(0);
        }
    }

    // FIM DO MENU DE FRETAMENTOS
}
