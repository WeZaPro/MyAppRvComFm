package com.example.basicinterfacecomfm17;


public class MyChidModel extends MyParentModel{

        private double result;
        private int radioChoice;

        public MyChidModel() {
        }

        public MyChidModel(double numA, double numB, int radioChoice) {
            super(numA, numB);
            setResult(numA, numB, radioChoice);
        }

        public double getResult() {
            return result;
        }

        public void setResult(double numA, double numB, int radioChoice) {
            switch (radioChoice) {
                case 0:
                    this.result = numA + numB;
                    break;
                case 1:
                    this.result = numA - numB;
                    break;
                case 2:
                    this.result = numA * numB;
                    break;
                case 3:
                    this.result = numA / numB;
                    break;
            }
        }
}
