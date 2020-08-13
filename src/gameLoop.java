import static java.lang.Thread.sleep;

public class gameLoop {
    boolean stop = true;
    Stock[][] stocks = new Stock[5][5];


    public void setUp(){
        createStocks();
    }


    
    public void gameLoop(){
        System.out.println("go");
        for(Stock[] stocks: this.stocks){
            for(Stock stock: stocks){
                stock.update();
            }
        }
    }
    
    private void createStocks(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                stocks[i][j] = new Stock("Stock " + i+ ", " + j);
            }
        }
    }

    public Stock[][] getStocks() {
        return stocks;
    }

    public void setStop(){
        stop = !stop;
    }
}
