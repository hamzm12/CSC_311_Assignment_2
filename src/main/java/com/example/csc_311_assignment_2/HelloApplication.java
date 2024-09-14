package com.example.csc_311_assignment_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        //creating labels and text fields
        Label interestRate = new Label("Annual Interest Rate:");
        TextField textInterestRate = new TextField();
        Label numOfYears = new Label("Number of Years:");
        TextField textNumOfYears = new TextField();
        Label loanAmount = new Label("Loan Amount:");
        TextField textLoanAmount = new TextField();
        Label monthlyPayment = new Label("Monthly Payment:");
        TextField textMonthyPayment = new TextField();
        Label totalPayment = new Label("Total Payment:");
        TextField textTotalPayment = new TextField();

        //set monthyPayments, TotalPayments to be non editable
        textMonthyPayment.setEditable(false);
        textTotalPayment.setEditable(false);

        //created the calculate Button
        Button calculate = new Button("Calculate");
        calculate.setStyle("-fx-background-color: white; -fx-text-fill: black");

        //create the layout
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10,10,10,10));
        gp.setVgap(5);
        gp.setHgap(5);

        //adding labels, text fields, and button onto the grid
        gp.add(interestRate, 0, 0);
        gp.add(textInterestRate, 1, 0);
        gp.add(numOfYears, 0, 1);
        gp.add(textNumOfYears, 1, 1);
        gp.add(loanAmount,0, 2 );
        gp.add(textLoanAmount, 1, 2);
        gp.add(monthlyPayment, 0, 3);
        gp.add(textMonthyPayment, 1, 3);
        gp.add(totalPayment, 0, 4);
        gp.add(textTotalPayment, 1, 4);
        gp.add(calculate, 1, 5);

        //setting action to the button
        calculate.setOnAction(e -> {
            //parse input values
                double loanAmount1 = Double.parseDouble(textLoanAmount.getText());
                double annualInterestRate = Double.parseDouble(textInterestRate.getText());
                double numOfYears1 = Double.parseDouble(textNumOfYears.getText());

                double monthlyInterestRate = annualInterestRate / 1200;
                double numberOfPayments = numOfYears1 * 12;
//calculating monthly interest
                double monthlyPaymentValue = (loanAmount1 * monthlyInterestRate) /
                        (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
//calculatingtotal payment
                double totalPaymentValue = monthlyPaymentValue * numberOfPayments;
//displaying the results
                textMonthyPayment.setText(String.format("$%.2f", monthlyPaymentValue));
                textTotalPayment.setText(String.format("$%.2f", totalPaymentValue));

        });

//creating ans setting the scene
        Scene sc = new Scene(gp, 400, 300);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(sc);
        primaryStage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}