/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static com.sun.javafx.application.PlatformImpl.exit;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class GraficoReporte extends Application {

    public static Object[][] grafico;

    GraficoReporte(Object[][] grafico2) {
        grafico = grafico2;
    }

    public GraficoReporte() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub  
        //Defining string to label XAxis   

        //Configuring category and NumberAxis   
        CategoryAxis xaxis = new CategoryAxis();
        NumberAxis yaxis = new NumberAxis(0.1, 5, 1);
        xaxis.setLabel("Preguntas");
        yaxis.setLabel("Promedio");

        //Configuring BarChart   
        BarChartExt<String, Float> bar = new BarChartExt(xaxis, yaxis);
        bar.setAnimated(false);
        bar.setTitle("Coordinación de Carreras");

        //Configuring Series for XY chart   
        XYChart.Series<String, Float> series = new XYChart.Series<>();
        Data<String, Float> data1 = new XYChart.Data(grafico[0][0].toString(), grafico[0][1]);

        series.getData().add(data1);
        series.getData().add(new XYChart.Data(grafico[1][0], grafico[1][1]));
        series.getData().add(new XYChart.Data(grafico[2][0], grafico[2][1]));
        series.getData().add(new XYChart.Data(grafico[3][0], grafico[3][1]));
        series.getData().add(new XYChart.Data(grafico[4][0], grafico[4][1]));
        series.getData().add(new XYChart.Data(grafico[5][0], grafico[5][1]));
        series.getData().add(new XYChart.Data(grafico[6][0], grafico[6][1]));
        series.getData().add(new XYChart.Data(grafico[7][0], grafico[7][1]));
        series.getData().add(new XYChart.Data(grafico[8][0], grafico[8][1]));

        bar.setCategoryGap(0);
        bar.setBarGap(6);
        bar.setMinWidth(1150);
        bar.setMinHeight(550);
        //Adding series to the barchart   
        bar.getData().add(series);

        bar.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent;");

        Node n = bar.lookup(".data0.chart-bar");
        n.setStyle("-fx-bar-fill: #FE642E");

        n = bar.lookup(".data1.chart-bar");
        n.setStyle("-fx-bar-fill: #FE9A2E");

        n = bar.lookup(".data2.chart-bar");
        n.setStyle("-fx-bar-fill: #00FF80");

        n = bar.lookup(".data3.chart-bar");
        n.setStyle("-fx-bar-fill: #81F7F3");

        n = bar.lookup(".data4.chart-bar");
        n.setStyle("-fx-bar-fill: #0174DF");

        n = bar.lookup(".data5.chart-bar");
        n.setStyle("-fx-bar-fill: #8000FF");

        n = bar.lookup(".data6.chart-bar");
        n.setStyle("-fx-bar-fill: #DF0174");

        n = bar.lookup(".data7.chart-bar");
        n.setStyle("-fx-bar-fill: #6E6E6E");

        n = bar.lookup(".data8.chart-bar");
        n.setStyle("-fx-bar-fill: #FE642E");

        bar.setLegendVisible(false);
        // configuring group and scene   
        Group root = new Group();
        root.getChildren().add(bar);

        Scene scene = new Scene(root, 650, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BarChart Example");
        primaryStage.show();
        primaryStage.close();
        saveAsPng(bar);
        System.out.println("PRUEBA DE K ENTRA");

    }

    public void start(Stage primaryStage, Object[][] grafico2) throws Exception {
        // TODO Auto-generated method stub  
        //Defining string to label XAxis   

        //Configuring category and NumberAxis   
        CategoryAxis xaxis = new CategoryAxis();
        NumberAxis yaxis = new NumberAxis(0.1, 5, 1);
        xaxis.setLabel("Preguntas");
        yaxis.setLabel("Promedio");

        //Configuring BarChart   
        BarChartExt<String, Float> bar = new BarChartExt(xaxis, yaxis);
        bar.setAnimated(false);
        bar.setTitle("Coordinación de Carreras");

        //Configuring Series for XY chart   
        XYChart.Series<String, Float> series = new XYChart.Series<>();
        Data<String, Float> data1 = new XYChart.Data(grafico[0][0].toString(), grafico[0][1]);

        series.getData().add(data1);
        series.getData().add(new XYChart.Data(grafico2[1][0], grafico2[1][1]));
        series.getData().add(new XYChart.Data(grafico2[2][0], grafico2[2][1]));
        series.getData().add(new XYChart.Data(grafico2[3][0], grafico2[3][1]));
        series.getData().add(new XYChart.Data(grafico2[4][0], grafico2[4][1]));
        series.getData().add(new XYChart.Data(grafico2[5][0], grafico2[5][1]));
        series.getData().add(new XYChart.Data(grafico2[6][0], grafico2[6][1]));
        series.getData().add(new XYChart.Data(grafico2[7][0], grafico2[7][1]));
        series.getData().add(new XYChart.Data(grafico2[8][0], grafico2[8][1]));

        bar.setCategoryGap(0);
        bar.setBarGap(6);
        bar.setMinWidth(1150);
        bar.setMinHeight(550);
        //Adding series to the barchart   
        bar.getData().add(series);

        bar.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent;");

        Node n = bar.lookup(".data0.chart-bar");
        n.setStyle("-fx-bar-fill: #FE642E");

        n = bar.lookup(".data1.chart-bar");
        n.setStyle("-fx-bar-fill: #FE9A2E");

        n = bar.lookup(".data2.chart-bar");
        n.setStyle("-fx-bar-fill: #00FF80");

        n = bar.lookup(".data3.chart-bar");
        n.setStyle("-fx-bar-fill: #81F7F3");

        n = bar.lookup(".data4.chart-bar");
        n.setStyle("-fx-bar-fill: #0174DF");

        n = bar.lookup(".data5.chart-bar");
        n.setStyle("-fx-bar-fill: #8000FF");

        n = bar.lookup(".data6.chart-bar");
        n.setStyle("-fx-bar-fill: #DF0174");

        n = bar.lookup(".data7.chart-bar");
        n.setStyle("-fx-bar-fill: #6E6E6E");

        n = bar.lookup(".data8.chart-bar");
        n.setStyle("-fx-bar-fill: #FE642E");

        bar.setLegendVisible(false);
        // configuring group and scene   
        Group root = new Group();
        root.getChildren().add(bar);

        new Thread(() -> {
            //Do whatever
            Scene scene = new Scene(root, 650, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("BarChart Example");
            primaryStage.show();
            //exit();
            primaryStage.close();
        }).start();

        saveAsPng(bar);
        System.out.println("PRUEBA DE K ENTRA");
        //deinitialize();
    }

  

    /**
     * Custom barchart with text on top of bars
     *
     * @param <X>
     * @param <Y>
     */
    private static class BarChartExt<X, Y> extends BarChart<X, Y> {

        /**
         * Registry for text nodes of the bars
         */
        Map<Node, Node> nodeMap = new HashMap<>();

        public BarChartExt(Axis xAxis, Axis yAxis) {
            super(xAxis, yAxis);
        }

        /**
         * Add text for bars
         */
        @Override
        protected void seriesAdded(Series<X, Y> series, int seriesIndex) {

            super.seriesAdded(series, seriesIndex);

            for (int j = 0; j < series.getData().size(); j++) {

                Data<X, Y> item = series.getData().get(j);

                Node text = new Text(String.valueOf(item.getYValue()));
                nodeMap.put(item.getNode(), text);
                getPlotChildren().add(text);

            }

        }

        /**
         * Remove text of bars
         */
        @Override
        protected void seriesRemoved(final Series<X, Y> series) {

            for (Node bar : nodeMap.keySet()) {

                Node text = nodeMap.get(bar);
                getPlotChildren().remove(text);

            }

            nodeMap.clear();

            super.seriesRemoved(series);
        }

        /**
         * Adjust text of bars, position them on top
         */
        @Override
        protected void layoutPlotChildren() {

            super.layoutPlotChildren();

            for (Node bar : nodeMap.keySet()) {

                Node text = nodeMap.get(bar);

                text.relocate(bar.getBoundsInParent().getMinX() + 46, bar.getBoundsInParent().getMinY() - 30);

            }

        }
    }

    public void hacerGrafico(Object[][] grafico_sub) throws Exception {
        grafico = grafico_sub;

        launch();

    }

  

    @FXML
    public void saveAsPng(BarChart barChart) {
        WritableImage image = barChart.snapshot(new SnapshotParameters(), null);

        // TODO: probably use a file chooser here
        File file = new File("src/Archivos/" + "grafica.png");

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
        }
    }
}
