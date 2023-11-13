public abstract class Assinante {
    private long cpf;
    private String nome;
    private int numero;
    protected int numChamadas;
    protected Chamada chamadas[] = new Chamada[2];

    public Assinante(long cpf, String nome, int numero){
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
    }
     
    public long getCpf(){
        return this.cpf;
    }
    //Adição dos metodos getNome e getNumero necessarios ao void listarAssinantes() da classe Telefonia
    public String getNome(){
        return this.nome;
    }

    public long getNumero(){
        return this.numero;
    }

    public String toString(){
        return "CPF: " + cpf + ", Nome: " + nome + ", Numero: " + numero + ", Número de chamadas: " + numChamadas + ", Chamadas: " + chamadas;
    }
}
