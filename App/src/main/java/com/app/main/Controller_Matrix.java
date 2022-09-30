package com.app.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

import back.Functions;
import back.Matrix;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;


public class Controller_Matrix{

    private PrintStream ps ; //выводящий поток

    public class ConsoleOut extends OutputStream {
        private TextArea console;

        public ConsoleOut(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) throws IOException {
            appendText(String.valueOf((char)b));
        }

    } //класс консоли (вывод)


    @FXML
    void initialize() {
        ps = new PrintStream(new ConsoleOut(outputConsole)); //Инициализация потока вывода
        System.setOut(ps);
        System.setErr(ps);


        butConfirmDim.setOnAction(actionEvent -> {



        });

        butDeterminant.setOnAction(actionEvent -> {
            try {
                System.out.println(Functions.foundDet(getFirstMatrix()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        butDeterminant1.setOnAction(actionEvent -> {
            try {
                System.out.println(Functions.foundDet(getSecondMatrix()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        butClearFirstMatrix.setOnAction(actionEvent -> {
            clearMatrixOne();
        });
        butClearSecondMatrix.setOnAction(actionEvent -> {
            clearMatrixTwo();
        });
        butProduct.setOnAction(actionEvent -> {
            try {
                Functions.printMatrix(Functions.getProduct(getFirstMatrix(),getSecondMatrix()));
            } catch (Exception e) {
                System.out.println("Error with gettingProduct");
            }
        });
        butSumma.setOnAction(actionEvent -> {
            try {
                Functions.printMatrix(Functions.getSum(getFirstMatrix(),getSecondMatrix()));
            } catch (Exception e) {
                System.out.println("Error with summ");
            }
        });
        butDifference.setOnAction(actionEvent -> {
            try {
                Functions.printMatrix(Functions.getDifference(getFirstMatrix(),getSecondMatrix()));
            } catch (Exception e) {
                System.out.println("Error with diff");
            }
        });
        clearConsoleOutput.setOnAction(actionEvent -> {
            outputConsole.clear();
        });

    }

    public Matrix getFirstMatrix(){
       StringBuilder sb = new StringBuilder();
       double[][] matrixArray = new double[3][3];

        sb.append(field00.getText()).append(" ");
        sb.append(field01.getText()).append(" ");
        sb.append(field02.getText()).append(" ");
        sb.append(field10.getText()).append(" ");
        sb.append(field11.getText()).append(" ");
        sb.append(field12.getText()).append(" ");
        sb.append(field20.getText()).append(" ");
        sb.append(field21.getText()).append(" ");
        sb.append(field22.getText()).append(" ");

        String[] numbers = sb.toString().split(" ");
        int k = 0;
        for (int i = 0; i < matrixArray.length ; i++) {

            for (int j = 0; j <matrixArray[0].length ; j++) {
                 try {
                     matrixArray[i][j] = Double.parseDouble(numbers[k]);

                 }
                 catch (NumberFormatException e ){
                     System.out.println(String.format("Invalid number in the cell %d %d ",i,j));
                 }
                k++;

            }
        }
        return new Matrix(matrixArray);
    }

    public Matrix getSecondMatrix(){
        StringBuilder sb = new StringBuilder();
        double[][] matrixArray = new double[3][3];

        sb.append(field001.getText()).append(" ");
        sb.append(field011.getText()).append(" ");
        sb.append(field021.getText()).append(" ");
        sb.append(field101.getText()).append(" ");
        sb.append(field111.getText()).append(" ");
        sb.append(field121.getText()).append(" ");
        sb.append(field201.getText()).append(" ");
        sb.append(field211.getText()).append(" ");
        sb.append(field221.getText()).append(" ");

        String[] numbers = sb.toString().split(" ");
        int k = 0;
        for (int i = 0; i < matrixArray.length ; i++) {

            for (int j = 0; j <matrixArray[0].length ; j++) {
                try {
                    matrixArray[i][j] = Double.parseDouble(numbers[k]);

                }
                catch (NumberFormatException e ){
                    System.out.println(String.format("Invalid number in the cell %d %d ",i,j));
                }
                k++;

            }
        }
        return new Matrix(matrixArray);
    }

    public void clearMatrixOne(){
        field00.clear();
        field01.clear();
        field02.clear();
        field10.clear();
        field11.clear();
        field12.clear();
        field20.clear();
        field21.clear();
        field22.clear();
    }
    public void clearMatrixTwo(){
        field001.clear();
        field011.clear();
        field021.clear();
        field101.clear();
        field111.clear();
        field121.clear();
        field201.clear();
        field211.clear();
        field221.clear();

    }

        @FXML
        private Button butClearFirstMatrix;

        @FXML
        private Button butClearSecondMatrix;

        @FXML
        private Button butConfirmDim;

        @FXML
        private Button butDeterminant;

        @FXML
        private Button butDeterminant1;

        @FXML
        private Button butDifference;

        @FXML
        private Button butFindRank;

        @FXML
        private Button butFindRank1;

        @FXML
        private Button butLvRazloj;

        @FXML
        private Button butLvRazloj1;

        @FXML
        private Button butObratMAtrix;

        @FXML
        private Button butObratMAtrix1;

        @FXML
        private Button butProduct;

        @FXML
        private Button butSobstvennieChislaAndVektor;

        @FXML
        private Button butSobstvennieChislaAndVektor1;

        @FXML
        private Button butSumma;

        @FXML
        private Button butTransponirovat;

        @FXML
        private Button butTransponirovat1;

        @FXML
        private Button butTriangleView;

        @FXML
        private Button butTriangleView1;

        @FXML
        private Button butdiagonalVie;

        @FXML
        private Button butdiagonalVie1;

        @FXML
        private Button clearConsoleOutput;

        @FXML
        private TextField dimentionFirstMatrixX;

        @FXML
        private TextField dimentionFirstMatrixY;

        @FXML
        private TextArea field00;

        @FXML
        private TextArea field001;

        @FXML
        private TextArea field01;

        @FXML
        private TextArea field011;

        @FXML
        private TextArea field02;

        @FXML
        private TextArea field021;

        @FXML
        private TextArea field10;

        @FXML
        private TextArea field101;

        @FXML
        private TextArea field11;

        @FXML
        private TextArea field111;

        @FXML
        private TextArea field12;

        @FXML
        private TextArea field121;

        @FXML
        private TextArea field20;

        @FXML
        private TextArea field201;

        @FXML
        private TextArea field21;

        @FXML
        private TextArea field211;

        @FXML
        private TextArea field22;

        @FXML
        private TextArea field221;

        @FXML
        private TextArea outputConsole;

}








