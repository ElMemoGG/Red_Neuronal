package com.company;

public class Main {

    public static void main(String[] args) {
        double[][] X = {
                {0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1},//IZQUIERDA
                {0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1},//IZQUIERDA
                {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1},//IZQUIERDA
                {0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1},//IZQUIERDA
                {0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0},//DERECHA
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0},//DERECHA
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0}//DERECHA

        };
        double[][] Y = {
                {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 1}, {1, 1}, {1, 1}
        };
        Red_neurona nn = new Red_neurona(25, 12, 2);

        //nn.cycleTraining(X, Y, 100000);

        double[][] resultado = nn.prediccion(new double[]{0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,0});
        Helper.ImprimirMatriz(resultado);



    }
}
