import java.text.SimpleDateFormat;
import java.util.Date;

public class Recarga {
    private Date data;
    private float valor;

    public Recarga(Date data, float valor){
        this.data = data;
        this.valor = valor;
    }

    public Date getData(){
        return this.data;
    }

    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = simpleDateFormat.format(data);
        return "Data: " + dataFormatada + ", Valor: R$" + valor;
    }
}
