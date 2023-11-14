import java.util.Scanner;

public class Telefonia {
    private int numPrePagos = 0;
    private int numPosPagos = 0;
    private PrePago prePagos[] = new PrePago[2];
    private PosPago posPagos[] = new PosPago[2];

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

        switch (opcao) {
            case 1:
                PrePago novoPrePago = new PrePago(cpf, nome, numero);
                for (int i = 0; i < prePagos.length; i++) {
                    if (prePagos[i] == null) {
                        prePagos[i] = novoPrePago;
                        System.out.println("Pré-Pago criado com sucesso!");
                        numPrePagos++;
                        System.out.println(numPrePagos);
                        break;
                    }
                }
                break; 
        
            case 2:
                System.out.println("Digite a assinatura: ");
                assinatura = entrada.nextFloat();
                PosPago novoPosPago = new PosPago(cpf, nome, numero, assinatura);
                if (numPosPagos < posPagos.length) {
                    posPagos[numPosPagos] = novoPosPago;
                    numPosPagos++;
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
    //listagem baseado nos tipos de assinaturas
    public void listarAssinantes() {
        for (int i = 0; i < prePagos.length; i++) {
            if (prePagos[i] != null) { //adicao da Giovana, verificacao de consistencia
                System.out.println("CPF: " + prePagos[i].getCpf() + ", Nome: " + prePagos[i].getNome() + ", Numero: " + prePagos[i].getNumero());
            }
        }
    
        for (int i = 0; i < posPagos.length; i++) {
            if (posPagos[i] != null) {
                System.out.println("CPF: " + posPagos[i].getCpf() + ", Nome: " + posPagos[i].getNome() + ", Numero: " + posPagos[i].getNumero());
            }
        }
    }
    //implementacao 
    public void fazerChamada(int opcao, long cpf) {
        if (localizarPrePago(cpf) != null) {
            System.out.println(localizarPrePago(cpf));
        }else if (localizarPosPago(cpf) != null) {
            System.out.println(localizarPosPago(cpf));
        }else {
            System.out.println("Os dados informados nao correspondem a nenhum assinante, por favor verifique se as informações estao corretas");
        }
    }

    //implementação do metodo de recargas(Enviar)
    public void fazerRecarga(long cpf){
        if (localizarPrePago(cpf) != null) {
            System.out.println("Achou, agr só implementar!");
            //implementar lógica
        }else if (localizarPosPago(cpf) != null) {
            System.out.println("O cpf informado nao corresponde a uma assinatura pre paga");
        }else {
            System.out.println("Os dados informados nao correspondem a nenhuma assinatura, por favor verifique se as informações estao corretas");
        } 
    }

    public static void main(String[] args) {
        
    }
}
