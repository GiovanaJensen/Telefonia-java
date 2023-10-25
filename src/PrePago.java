import java.util.Date;

public class PrePago extends Assinante{
    private float creditos;
    private int numRecargas;
    private Recarga recargas[];

    public PrePago(long cpf, String nome, int numero){
        super(cpf,nome,numero);
    }

    public void recarregar(Date data, float valor){

    }

    public float fazerChamada(Date data, int duracao){
        return 1; // modificar
    }

    public void imprimirFatura(int mes){

    }
}
