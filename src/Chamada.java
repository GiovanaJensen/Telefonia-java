import java.text.SimpleDateFormat;
import java.util.Date;

public class Chamada {
    private Date data;
    private int duracao;

    public Chamada(Date data, int duracao){
        this.data = data;
        this.duracao = duracao;
    }

    public Date getData(){
        return this.data;
    }

    public int getDuracao(){
        return this.duracao;
    }

    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = simpleDateFormat.format(data);
        return "Data: " + dataFormatada + ", Duração: " + duracao + " minutos";
    }

}
