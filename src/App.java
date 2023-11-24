import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        Telefonia telefonia = new Telefonia();

        while (opcao != 8) {
            System.out.println("----MENU----");
            System.out.println("1- Cadastrar Assinante");
            System.out.println("2- Listar Assinantes");
            System.out.println("3- Fazer Chamada");
            System.out.println("4- Fazer Recarga");
            System.out.println("5- Imprimir Fatura");
            System.out.println("6- Localizar Pré-Pago");
            System.out.println("7- Localizar Pós-Pago");
            System.out.println("8- Sair do Programa");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    telefonia.cadastrarAssinante();
                    break;
                case 2:
                    telefonia.listarAssinantes();
                    break;
                case 3:
                    telefonia.fazerChamada();
                    break;
                case 5: 
                    System.out.println("Digite o mes que deseja ver as faturas: "); 
                    int mes = entrada.nextInt(); 
                    telefonia.imprimirFatura(mes); 
                    break; 
                case 6: 
                    System.out.println("Digite seu cpf: "); 
                    long cpf = entrada.nextLong(); 
                    telefonia.localizarPrePago(cpf); 
                    break; 
                case 7: 
                    System.out.println("Digite seu cpf: "); 
                    cpf = entrada.nextLong(); 
                    telefonia.localizarPosPago(cpf); 
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
                    break;
            }
        }

        entrada.close();
    }
}
