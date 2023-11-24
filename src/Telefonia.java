import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public void listarAssinantes() {
        for (int i = 0; i < prePagos.length; i++) {
            if (prePagos[i] != null) {
                System.out.println("CPF: " + prePagos[i].getCpf() + ", Nome: " + prePagos[i].getNome() + ", Numero: " + prePagos[i].getNumero());
            }
        }
    
        for (int i = 0; i < posPagos.length; i++) {
            if (posPagos[i] != null) {
                System.out.println("CPF: " + posPagos[i].getCpf() + ", Nome: " + posPagos[i].getNome() + ", Numero: " + posPagos[i].getNumero());
            }
        }
    }

    public PrePago localizarPrePago(long cpf){ 
        for(int i=0; i<prePagos.length; i++){ 
            if(prePagos[i] != null && cpf == prePagos[i].getCpf()){ 
                return prePagos[i]; 
            } 
        } 
        return null; 
    }

    public PosPago localizarPosPago(long cpf){ 
        for(int i=0; i<posPagos.length; i++){ 
            if(posPagos[i] != null && cpf == posPagos[i].getCpf()){ 
                return posPagos[i]; 
            } 
        } 
        return null; 
    }

    public void imprimirFatura(int mes){
        for(int i=0; i<prePagos.length; i++){
            if(prePagos[i] != null){
                prePagos[i].imprimirFatura(mes);
            }
        }

        for(int i=0; i<posPagos.length; i++){
            if(posPagos[i] != null){
                posPagos[i].imprimirFatura(mes);
            }
        }
        
    }

    //validação dos dados informados e busca nos metodos de localização, realizando a chamada do metodo de fazerChamada em suas respectivas classes
    public void fazerChamada() {
        Scanner entrada = new Scanner(System.in);
        Date data = null;
        System.out.println("Informe o cpf do titular: ");
        long cpf = entrada.nextLong();
        System.out.println("Qual o tipo de assinatura: \n1-Pré-Pago\n2-Pós-Pago");
        int opcaoAssinante = entrada.nextInt();
        System.out.println("Informe a data: ");
        String dataString = entrada.next();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formatoData.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Formato inválido. Por favor, insira o formato dd/MM/yyyy.");
        }
        System.out.println("Informe a duração:");
        int duracao = entrada.nextInt();
    
        PrePago prePago = localizarPrePago(cpf);
        PosPago posPago = localizarPosPago(cpf);
    
        if (prePago != null) {
            prePago.fazerChamada(data, duracao);
        } else if (posPago != null) {
            posPago.fazerChamada(data, duracao);
        } else {
            System.out.println("Os dados informados não correspondem a nenhum assinante, por favor, verifique se as informações estão corretas");
        }
    }
    
    //validação dos dados informados e invocação do metodo recarregar, exclusivo para o tipo de assinatura pré paga
    public void fazerRecarga() {
        Scanner entrada = new Scanner(System.in);
        Date data = null;
        System.out.println("Informe o cpf do titular: ");
        long cpf = entrada.nextLong();
        System.out.println("Informe a data: ");
        String dataString = entrada.next();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formatoData.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Formato inválido. Por favor, insira o formato dd/MM/yyyy.");
        }
        System.out.println("Informe o valor:");
        float valor = entrada.nextFloat();
    
        PrePago prePago = localizarPrePago(cpf);

        if (prePago != null) {
            prePago.recarregar(data, valor);
        } else {
            System.out.println("Os dados informados não correspondem a nenhum assinante pré pago, por favor, verifique se as informações estão corretas");
        }
    }

    public static void main(String[] args) {
        
    }
}