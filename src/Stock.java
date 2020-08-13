import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.random;

public class Stock {
    private String name = "";
    private BigDecimal value = new BigDecimal(1);
    private BigDecimal change = new BigDecimal(1);
    private Color changeColor = Color.GRAY;


    public Stock(String name){
        this.name = name;
        value = nbr.getDouble(-1, 100).setScale(3, RoundingMode.HALF_EVEN);
    }

    public BigDecimal update(){
        change = new BigDecimal(String.valueOf(nbr.getDouble(-15, 15)));
        if(change.doubleValue() < 1){
            value = value.multiply(new BigDecimal(100).add(change).divide(new BigDecimal(100))).setScale(3, RoundingMode.HALF_EVEN);
            changeColor = new Color(150,35,30);
        } else if (change.doubleValue() > 1){
            value = value.multiply(new BigDecimal(100).add(change).divide(new BigDecimal(100))).setScale(3, RoundingMode.HALF_EVEN);
            changeColor = new Color(90,150,25);
        } else {
            changeColor = Color.GRAY;
        }
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getChange() {
        return change;
    }

    public Color getColor() {
        return changeColor;
    }
}
