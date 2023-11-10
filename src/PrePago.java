import java.util.Date;

public class PrePago extends Assinante{
    private float creditos=0;
    private int numRecargas=0;
    private Recarga recargas[] = new Recarga[5];

    public PrePago(long cpf, String nome, int numero){
        super(cpf,nome,numero);
    }

    public void recarregar(Date data, float valor){

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

    }
}
