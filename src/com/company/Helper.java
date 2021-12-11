package com.company;

public class Helper {


    public static double[][] multiplicacion(double[][] a, double[][] b) {
        double[][] respuesta=new double[a.length][b[0].length];
        for(int i = 0; i<respuesta.length; i++)
        {
            for(int j = 0; j<respuesta[0].length; j++)
            {
                double sum=0;
                for(int k = 0; k<respuesta[0].length; k++)
                {
                    sum+=a[i][k]*b[k][j];
                }
                respuesta[i][j]=sum;
            }
        }
        return respuesta;
    }
    public static double[][] mat_Sum(double[][] mat_A, double[][] mat_B){
        double[][] mat_sum;

        if(mat_A.length == mat_B.length && mat_B[0].length == mat_A[0].length){
            mat_sum = new double[mat_A.length][mat_A[0].length];
            for(int i=0;i<mat_A.length;i++){
                for(int j=0;j<mat_A[0].length;j++){
                    mat_sum[i][j] = mat_A[i][j] + mat_B[i][j];
                }
            }
            return mat_sum;
        } else {
            return null;
        }
    }
    public static double[][] sigmoide(double [][] neuron) {
        for(int i = 0; i < neuron.length; i++)
        {
            for(int j = 0; j < neuron[0].length; j++)
                neuron[i][j] = 1/(1+Math.exp(-neuron[i][j]));
        }
        return neuron;
    }
    public static double[][] mat_rest(double[][] mat_A, double[][] mat_B){
        double[][] mat_rest;

        if(mat_A.length == mat_B.length && mat_B[0].length == mat_A[0].length){
            mat_rest = new double[mat_A.length][mat_A[0].length];
            for(int i=0;i<mat_A.length;i++){
                for(int j=0;j<mat_A[0].length;j++){
                    mat_rest[i][j] = mat_A[i][j] - mat_B[i][j];
                }
            }
            return mat_rest;
        } else {
            return null;
        }
    }

    public static double[][] derivada_sigmoide(double[][] ma) {
        double[][] ans=new double[ma.length][ma[0].length];
        for(int i = 0; i< ma.length; i++)
        {
            for(int j = 0; j< ma[0].length; j++)
                ans[i][j] = ma[i][j] * (1-ma[i][j]);
        }
        return ans;
    }

    public static double[][] multi(double[][] ma, double a) {
        double[][] ans=new double[ma.length][ma[0].length];

        for(int i = 0; i< ma.length; i++)
        {
            for(int j = 0; j< ma[0].length; j++)
            {
                ans[i][j] = ma[i][j] *a;
            }
        }
        return ans;

    }






}
