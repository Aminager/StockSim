import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Executors;

public class Visualizer {
    String title;
    int height, width;
    gameLoop loop;
    Container contentPane;
    JPanel[][] panels = new JPanel[5][5];

    public Visualizer(String title, int height, int width){
        this.title = title;
        this.height = height;
        this.width = width;
        loop = new gameLoop();

        JFrame window = new JFrame(title);
        this.contentPane = window.getContentPane();

        window.setSize(height, width);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.white);


        contentPane.setLayout(new GridLayout(6, 5));

        setUp();

        window.setVisible(true);


    }

    public void setUp(){
        loop.setUp();
        addStocks();
        addButtons();
    }

    private void addStocks(){
        Stock[][] stocks = loop.getStocks();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){

                panels[i][j] = new JPanel(new GridLayout(4, 1));
                panels[i][j].add(new JLabel(stocks[i][j].getName()));
                panels[i][j].add(new JLabel(" Value: " + String.valueOf(stocks[i][j].getValue())));
                panels[i][j].add(new JLabel(" Change: " ));
                panels[i][j].add(new JLabel("__________________"));

                contentPane.add(panels[i][j]);
            }
        }
    }

    private void addButtons(){
        JButton startstop = new JButton("Start/Stop");
        startstop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loop.gameLoop();
                update();
            }
        });
        contentPane.add(startstop);

        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(2);
            }
        });
        contentPane.add(quit);
    }

    public void update(){
        Stock[][] stocks = loop.getStocks();

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                JLabel value = (JLabel)panels[i][j].getComponent(1);
                JLabel change = (JLabel)panels[i][j].getComponent(2);
                value.setText(" Value: " +String.valueOf(stocks[i][j].getValue()));
                value.setForeground(stocks[i][j].getColor());
                change.setText(" Change: " +String.valueOf((stocks[i][j].getChange().subtract(new BigDecimal(1))).setScale(2, RoundingMode.HALF_EVEN)) + "%");
            }
        }
    }
}
