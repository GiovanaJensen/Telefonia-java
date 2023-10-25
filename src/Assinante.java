public abstract class Assinante {
    private long cpf;
    private String nome;
    private int numero;
    protected int numChamadas;
    protected Chamada chamadas[];

    public Assinante(long cpf, String nome, int numero){
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
    }

    public long getCpf(){
        return this.cpf;
    }

    public String toString(){
        return "";
    }
}
