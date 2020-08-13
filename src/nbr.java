import java.math.BigDecimal;

public class nbr {

    public static int getInt(int min, int max){
        return (int)(Math.random()*((max-min)+1))+min;
    }
    
    public static BigDecimal getDouble(double min, double max){
        return new BigDecimal(Math.random() * (max - min) + 1 +min);
    }
}
