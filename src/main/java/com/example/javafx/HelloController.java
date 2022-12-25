package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    private String str_num = "";
    private float first_num;
    private char operation;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button btn_0;
    @FXML
    private Button btn_1;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_3;
    @FXML
    private Button btn_4;
    @FXML
    private Button btn_5;
    @FXML
    private Button btn_6;
    @FXML
    private Button btn_7;
    @FXML
    private Button btn_8;
    @FXML
    private Button btn_9;
    @FXML
    private Button clear_btn;
    @FXML
    private Button comma_btn;
    @FXML
    private Button del_btn;
    @FXML
    private Button equal_btn;
    @FXML
    private Button minus_btn;
    @FXML
    private Button mult_btn;
    @FXML
    private Button percent_btn;
    @FXML
    private Button plus_btn;
    @FXML
    private Button plus_minus_btn;
    @FXML
    private Label textField;

    @FXML
    void initialize() {
        btn_0.setOnAction(event -> {
            addNumber(0);
        });
        btn_1.setOnAction(event -> {
            addNumber(1);
        });
        btn_2.setOnAction(event -> {
            addNumber(2);
        });
        btn_3.setOnAction(event -> {
            addNumber(3);
        });
        btn_4.setOnAction(event -> {
            addNumber(4);
        });
        btn_5.setOnAction(event -> {
            addNumber(5);
        });
        btn_6.setOnAction(event -> {
            addNumber(6);
        });
        btn_7.setOnAction(event -> {
            addNumber(7);
        });
        btn_8.setOnAction(event -> {
            addNumber(8);
        });
        btn_9.setOnAction(event -> {
            addNumber(9);
        });
        plus_btn.setOnAction(actionEvent -> {
            mathAction('+');
        });
        minus_btn.setOnAction(actionEvent -> {
            mathAction('-');
        });
        mult_btn.setOnAction(actionEvent -> {
            mathAction('*');
        });
        del_btn.setOnAction(actionEvent -> {
            mathAction('/');
        });
        percent_btn.setOnAction(actionEvent -> {
            if (this.str_num != "") {
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                textField.setText(str_num);
            }
        });
        equal_btn.setOnAction(actionEvent -> {
            if (this.operation == '+' ||
                    this.operation == '-' ||
                    this.operation == '/' ||
                    this.operation == '*')
                equalMethod();
        });
        comma_btn.setOnAction(actionEvent -> {
            if (!this.str_num.contains(".")) {
                this.str_num += ".";
                textField.setText(str_num);
            }
        });
        plus_minus_btn.setOnAction(actionEvent -> {
            if (this.str_num != "") {
                float num = Float.parseFloat(this.str_num) * -1;
                this.str_num = Float.toString(num);
                textField.setText(str_num);
            }
        });
        clear_btn.setOnAction(actionEvent -> {
            textField.setText("0");
            this.str_num = "";
            this.first_num = 0;
            this.operation = 'A';
        });

    }

    void equalMethod() {
        float res = 0;
        switch (this.operation) {
            case '+':
                res = this.first_num + Float.parseFloat(this.str_num);
                break;

            case '-':
                res = this.first_num - Float.parseFloat(this.str_num);
                break;

            case '/':
                if (Integer.parseInt(this.str_num) != 0) {
                    res = this.first_num / Float.parseFloat(this.str_num);
                } else res = 0;
                break;
            case '*':
                res = this.first_num * Float.parseFloat(this.str_num);
                break;
        }
        textField.setText(Float.toString(res));

        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
    }

    void mathAction(char operation) {
        if (this.operation != '+' &&
                this.operation != '-' &&
                this.operation != '/' &&
                this.operation != '*') {
            this.first_num = Float.parseFloat(this.str_num);
            textField.setText(String.valueOf(operation));
            this.str_num = "";
            this.operation = operation;
        }

    }

    void addNumber(int number) {
        this.str_num += Integer.toString(number);
        textField.setText(str_num);
    }

}
