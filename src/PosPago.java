import java.util.Date;

public class PosPago extends Assinante{
    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura){
        super(cpf,nome,numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(Date data, int duracao){
        
    }

    public void imprimirFatura(int mes){

    }
}
