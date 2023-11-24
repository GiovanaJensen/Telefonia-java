import java.util.Calendar;
import java.util.Date;

public class PrePago extends Assinante{
    private float creditos=0;
    private int numRecargas=0;
    private Recarga recargas[] = new Recarga[2];

    public PrePago(long cpf, String nome, int numero){
        super(cpf,nome,numero);
    }

    public void recarregar(Date data, float valor){
        if (numRecargas < recargas.length){
            Recarga novaRecarga = new Recarga(data, valor);
            recargas[numRecargas] = novaRecarga;
            creditos = creditos + valor;
            numRecargas++;
 
            System.out.println("Recarga de R$" +  valor + " efetuada com sucesso! \n Agora voce possui R$" + creditos + " de creditos");
        }else{
            System.out.println("Voce nao tem os requisitos para recarregar");
        }
    }

    public void fazerChamada(Date data, int duracao){

        float valorASerPago = (float)(duracao * 1.45);

        if (numChamadas < chamadas.length && creditos >= valorASerPago){

            Chamada novaChamada = new Chamada(data,duracao);
            chamadas[numChamadas] = novaChamada;
            creditos = valorASerPago - creditos; 
            numChamadas++;

            System.out.println("Chamada realizada com sucesso!");
        }else{
            System.out.println("Você não tem os requisitos necessários para realizar a chamada");
        }
        
    }

    public void imprimirFatura(int mes){
        float valorTotalChamada = 0;
        float valorTotalRecarga = 0;
        float creditosUsados = 0;
        //dados do assinante (cpf, nome, numero)
        System.out.println("Nome: " + super.getNome() + ", Cpf: " + super.getCpf() + ",Numero: " + super.getNumero() );
        //data, duracao, valor das chamadas feitas no mes
        for(Chamada chamada : chamadas){
            if(chamada != null && isMesIgual(chamada.getData(), mes)){
                float valorPorMinuto = 1.45F;
                float valorDaChamada = chamada.getDuracao() * valorPorMinuto;
                valorTotalChamada += valorDaChamada;
                creditosUsados -= valorDaChamada;
                System.out.println(chamada.toString() + ", Valor: " + valorDaChamada);
            }
        }
        //data e valor das recargas feitas no mes
        for(Recarga recarga : recargas){
            if(recarga != null && isMesIgual(recarga.getData(), mes)){
                valorTotalRecarga += recarga.getValor();
                System.out.println(recarga.toString());
            }
        }
        //valor total das ligacoes e recargas do mes
        System.out.println("Valor Total da Chamada: " + valorTotalChamada + ", Valor Total da Recarga: " + valorTotalRecarga);
        //creditos do mes
        System.out.println("Creditos: " + (valorTotalRecarga-creditosUsados));
    }
 
    private boolean isMesIgual(Date data, int mes){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        int chamadaMes = calendario.get(calendario.MONTH) + 1;
        return mes == chamadaMes;
    }
}