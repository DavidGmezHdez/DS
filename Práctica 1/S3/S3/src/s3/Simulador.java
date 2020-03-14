package s3;

import java.util.Observable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chema
 */
public class Simulador extends Observable implements Runnable{

    private double temperaturaC;
    private double temperaturaF;
    
    private static botonCambioTemp boton;
    private static graficaTemp grafica;
    private static pantallaTemperatura pantalla;
    
    public double getTemperaturaC() {
        //Obtenemos el valor de la temperatura
        return this.temperaturaC;
    }
    public double getTemperaturaF() {
        //Obtenemos el valor de la temperatura
        return this.temperaturaF;
    }
    
    public void setTemperatura(double t) {
        //Cambiamos el valor de la temperatura
        
        this.temperaturaC = t;
        
        double tempF=((double)(t*(9/5))+32);
        this.temperaturaF = tempF;
        
        setChanged();
        notifyObservers(t);
    }
    
    @Override
    public void run(){
        while(true) {
            //Maxima temperatura=max / MinimaTemperatura=min  
            double max = 50, min = -10;
            Random rand = new Random();
            double temp = min + rand.nextFloat() * (max - min);
            this.setTemperatura(temp);

            try {
                //La hebra espera por los ms que queramos
                Thread.sleep(6*1500);
             } catch (Exception exc) {
                System.out.println(exc);
             }
        }
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        
        Simulador sim = new Simulador();
        pantalla = new pantallaTemperatura(sim);
        boton = new botonCambioTemp(sim);
        grafica = new graficaTemp();
        sim.addObserver(boton);
        sim.addObserver(grafica);
        
        // Iniciamos la hebra
        Thread hebra = new Thread(sim);
        hebra.start();
        
        
    }
    
}
