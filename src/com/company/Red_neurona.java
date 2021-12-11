package com.company;

public class Red_neurona {
    double [][] weights1;
    double [][] weights2;
    double [][] biasH;
    double [][] biasO;
    double alpha = 0.001;


    public Red_neurona(int inputS, int hiddenS, int ouputS) {
        weights1 = inicializar(hiddenS,inputS);
        weights2 = inicializar(ouputS,hiddenS);
        biasH = inicializar(hiddenS, 1);
        biasO = inicializar(hiddenS, 1);
    }

    public double[][] prediccion(double[][] input_user){

        double[][] hidden = Helper.multiplicacion(weights1, input_user);
        hidden = Helper.mat_Sum(hidden, biasH);
        hidden = Helper.sigmoide(hidden);

        double[][] output = Helper.multiplicacion(weights2, hidden);
        output = Helper.mat_Sum(output, biasO);
        output = Helper.sigmoide(output);
        return output;

    }

    public void train(double[][] input_user, double[][] target){

        double[][] hidden = Helper.multiplicacion(weights1, input_user);
        hidden = Helper.mat_Sum(hidden, biasH);
        hidden = Helper.sigmoide(hidden);

        double[][] output = Helper.multiplicacion(weights2, hidden);
        output = Helper.mat_Sum(output, biasO);
        output = Helper.sigmoide(output);


        double[][] error = Helper.mat_rest(target, output);
        double[][] gradiente = Helper.derivada_sigmoide(output);
        gradiente = Helper.multiplicacion(gradiente,error);
        gradiente = Helper.multi(gradiente,alpha);



    }




    public double[][] inicializar(int filas, int columnas){
        double[][] result = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result[i][j] =Math.random()*2-1;
            }
        }
        return  result;
    }




}
