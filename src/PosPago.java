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

    }
}
