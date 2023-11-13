import java.util.Calendar;
import java.util.Date;

import javax.xml.validation.Validator;

public class PosPago extends Assinante{
    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura){
        super(cpf,nome,numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(Date data, int duracao){

        float valorASerPago = (float)(duracao*1.04);
        if (numChamadas < chamadas.length){

            Chamada novaChamada = new Chamada(data, duracao);
            chamadas[numChamadas] = novaChamada;
            valorASerPago =+ valorASerPago;
            numChamadas++;

            System.out.println("Chamada na modalidade pos pago realizada com sucesso!");
        }else{
            System.out.println("Voce nao tem os requisitos para realizar chamada na modalidade pos pago!");
        }
        
    }

public void imprimirFatura(int mes){

        float valorTotalChamada = 0;
        //dados do assinante (cpf, nome, numero)
        System.out.println("Nome: " + super.getNome() + ", Cpf: " + super.getCpf() + ",Numero: " + super.getNumero() );
        //data, duracao, valor das chamadas feitas no mes
        for(Chamada chamada : chamadas){
            if(isMesIgual(chamada.getData(), mes)){
                float valorPorMinuto = 1.04F;
                float valorDaChamada = chamada.getDuracao() * valorPorMinuto;
                valorTotalChamada += valorDaChamada;
                System.out.println(chamada.toString() + ", Valor: " + valorDaChamada);
            }
        }
        //valor total das ligacoes
        System.out.println("Valor total da Chamada:" + valorTotalChamada);
        }
 
    private boolean isMesIgual(Date data, int mes){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        int chamadaMes = calendario.get(calendario.MONTH) + 1;
        return mes == chamadaMes;
    }
}
