package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    NumberAxis x_axis ;
    @FXML
    NumberAxis y_axis ;
    @FXML
    ScatterChart<Number,Number> sc1;
    @FXML
    ScatterChart<Number,Number> sc2;
    @FXML
    NumberAxis x_axis2 ;
    @FXML
    NumberAxis y_axis2 ;

    private  XYChart.Series series1 ;
    private XYChart.Series series2;
    int fib(int n){
        if(n==0){
            return 1;
        }
        else{
            if(n==1){
                return 1;
            }else{
                return fib(n-1)+fib(n-2);
            }
        }
    }
    int fibTail(int  n , int res1 , int res2){
        if(n==0){
            return res2;
        }
        else{
            if(n==1){
                return res2;
            }else{
                return fibTail(n-1,res2,res2+res1);
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        series1  = new XYChart.Series();
        series2 = new XYChart.Series();
        sc1.getData().add(series1);
        series1.setName("F1");
        sc2.getData().add(series2);
        series2.setName("F2");
        //System.gc();
        for (int  i = 10 ; i < 45;i++ ) {
            double t1 = System.nanoTime();
            fib(i);
            double finalTime = System.nanoTime() - t1;
            series1.getData().add(new XYChart.Data(i, finalTime));
        }
        System.gc();
        for (int  i = 10 ; i < 1000;i++ ) {
            double t1 = System.nanoTime();
            fibTail(i,0,1);
            double finalTime = System.nanoTime() - t1;
            System.out.println(finalTime);
            series2.getData().add(new XYChart.Data(i, finalTime));
        }
    }
}
