import java.util.Calendar;
import java.util.Date;

public class PosPago extends Assinante{
    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura){
        super(cpf,nome,numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(Date data, int duracao){
        float ValorPos = (float)(duracao * 1.05);

        if (numChamadas < chamadas.length){
            Chamada novaChamada = new Chamada(data,duracao);
            chamadas[numChamadas] = novaChamada;
            ValorPos += ValorPos;
            numChamadas++;
            System.out.println("Chamada Pos Paga realizada com sucesso!");
        }else{
            System.out.println("Você não tem os requisitos necessários para realizar a chamada Pos Paga");
        } 
    }

    public void imprimirFatura(int mes){
        float valorTotalChamada = 0;
        float valorTotalRecarga = 0;
        //dados do assinante (cpf, nome, numero)
        System.out.println("Nome: " + super.getNome() + ", Cpf: " + super.getCpf() + ",Numero: " + super.getNumero() );
        //data, duracao, valor das chamadas feitas no mes
        for(Chamada chamada : chamadas){
            if(chamada != null && isMesIgual(chamada.getData(), mes)){
                float valorPorMinuto = 1.05F;
                float valorDaChamada = chamada.getDuracao() * valorPorMinuto;
                valorTotalChamada += valorDaChamada;
                System.out.println(chamada.toString() + ", Valor: " + valorDaChamada);
            }
        }
        //valor total das ligacoes e recargas do mes
        System.out.println("Valor Total da Chamada: " + valorTotalChamada);
    }
 
    private boolean isMesIgual(Date data, int mes){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        int chamadaMes = calendario.get(calendario.MONTH) + 1;
        return mes == chamadaMes;
    }
}
