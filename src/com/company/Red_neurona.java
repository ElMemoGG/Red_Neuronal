package com.company;

public class Red_neurona {
    double [][] weights1;
    double [][] weights2;
    double [][] biasH;
    double [][] biasO;
    double alpha = 0.01;


    public Red_neurona(int inputS, int hiddenS, int ouputS) {
        weights1 = inicializar(hiddenS,inputS);
        weights2 = inicializar(ouputS,hiddenS);
        biasH = inicializar(hiddenS, 1);
        biasO = inicializar(ouputS, 1);
    }

    public double[][] prediccion(double[] x){

        double[][] input_user= Helper.convertir_Array_Matrix(x);

        double[][] hidden = Helper.multiplicacion(weights1, input_user);
        hidden = Helper.mat_Sum(hidden, biasH);
        hidden = Helper.sigmoide(hidden);

        double[][] output = Helper.multiplicacion(weights2, hidden);
        output = Helper.mat_Sum(output, biasO);

        output = Helper.sigmoide(output);
        return output;

    }

    public void train(double[] x, double[] y){

        double[][] target = Helper.convertir_Array_Matrix(y);
        double[][] input_user =Helper.convertir_Array_Matrix(x);


        //Optenemos el output // lo mismo que prediccion()
        double[][] hidden = Helper.multiplicacion(weights1, input_user);
        hidden = Helper.mat_Sum(hidden, biasH);
        hidden = Helper.sigmoide(hidden);

        double[][] output = Helper.multiplicacion(weights2, hidden);
        output = Helper.mat_Sum(output, biasO);
        output = Helper.sigmoide(output);

        //obtenemos la gradiente
        double[][] error = Helper.mat_rest(target, output);

        double[][] gradiente = Helper.derivada_sigmoide(output);
        gradiente = Helper.multiplicacion(gradiente, error);
        gradiente = Helper.multi(gradiente,alpha);

        //de aqui en adelante quien sabe que vergas hace esto y como se pueda hacer dinamico es un misterio

        double[][] who_delta = Helper.multiplicacion( gradiente, Helper.matrix_XT(hidden));

        weights2 = Helper.mat_Sum(weights2, who_delta);
        biasO = Helper.mat_Sum(biasO, gradiente );

        double[][] hidden_errors = Helper.multiplicacion(Helper.matrix_XT(who_delta), error);

        double[][] h_gradiente = Helper.derivada_sigmoide(hidden);
        h_gradiente = Helper.multiplicacion(h_gradiente, hidden_errors );
        h_gradiente = Helper.multi(h_gradiente, alpha);

        double[][] wih_delta = Helper.multiplicacion( h_gradiente, Helper.matrix_XT(input_user));


        weights1 = Helper.mat_Sum(weights1, wih_delta );
        biasH = Helper.mat_Sum(biasH, h_gradiente);

    }
    public void cycleTraining(double[][]x, double[][]y, int iteration)
    {
        for(int i=0;i<iteration;i++)
        {
            int sampleN =  (int)(Math.random() * x.length );
            train(x[sampleN], y[sampleN]);
        }
    }



    public double[][] inicializar(int filas, int columnas){
        double[][] result = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result[i][j] =Math.random()*2-1;
                //result[i][j] = 1;
            }
        }
        return  result;
    }




}
