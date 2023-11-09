import java.util.Scanner;

public class Telefonia {
    private int numPrePagos = 0;
    private int numPosPagos = 0;
    private PrePago prePagos[] = new PrePago[5];
    private PosPago posPagos[] = new PosPago[5];

    public Telefonia() {}

    public void cadastrarAssinante() {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0, numero;
        String nome;
        long cpf;
        float assinatura;

        while (opcao != 1 && opcao != 2) {
            System.out.println("Qual o tipo de assinatura: \n1-Pré-Pago\n2-Pós-Pago");
            opcao = entrada.nextInt();
        }

        System.out.println("Digite o nome do assinante: ");
        nome = entrada.next();
        System.out.println("Digite o cpf do assinante: ");
        cpf = entrada.nextLong();
        System.out.println("Digite o n° de telefone: ");
        numero = entrada.nextInt();

        switch(opcao) {
            case 1:
                PrePago novoPrePago = new PrePago(cpf, nome, numero);
                if (numPrePagos < prePagos.length) {
                    prePagos[numPrePagos++] = novoPrePago;
                    System.out.println("Pré-Pago criado com sucesso!");
                } else {
                    System.out.println("Limite de Pré-Pagos atingido!");
                }
                break;

            case 2:
                System.out.println("Digite a assinatura: ");
                assinatura = entrada.nextFloat();
                PosPago novoPosPago = new PosPago(cpf, nome, numero, assinatura);
                if (numPosPagos < posPagos.length) {
                    posPagos[numPosPagos++] = novoPosPago;
                    System.out.println("Pós-Pago criado com sucesso!");
                } else {
                    System.out.println("Limite de Pós-Pagos atingido!");
                }
                break;

            default:
                System.out.println("Insira uma opção válida!");
                break;
        }
    }

    public void listarAssinantes() {
        for(int i = 0; i < prePagos.length; i++) {
            System.out.println("CPF: " + prePagos[i].getCpf() + ", Nome: " + prePagos[i].getNome() + ", Numero: " + prePagos[i].getNumero());
        }

        for(int i = 0; i < posPagos.length; i++) {
            System.out.println("CPF: " + posPagos[i].getCpf() + ", Nome: " + posPagos[i].getNome() + ", Numero: " + posPagos[i].getNumero());
        }
    }

    public static void main(String[] args) {
        
    }
}
