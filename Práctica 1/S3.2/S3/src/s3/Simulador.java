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

    private double temperaturaCAn;
    private double temperaturaFAn;
    
    private double temperaturaCCl;
    private double temperaturaFCl;
    
    private double temperaturaCCm;
    private double temperaturaFCm;
    
    private static Mapa mapa;
    
    public double getTempCCl() {
        //Obtenemos el valor de la temperatura en C de Castilla y Leon
        return this.temperaturaCCl;
    }
    public double getTempFCl() {
        //Obtenemos el valor de la temperatura en F de Castilla y Leon
        return this.temperaturaFCl;
    }
    
    public double getTempCCm() {
        //Obtenemos el valor de la temperatura en C de Castilla-LaMancha
        return this.temperaturaCCm;
    }
    public double getTempFCm() {
        //Obtenemos el valor de la temperatura en f de Castilla-LaMancha
        return this.temperaturaFCm;
    }
    
    public double getTempCAn() {
        //Obtenemos el valor de la temperatura en C de Andalucia
        return this.temperaturaCAn;
    }
    public double getTempFAn() {
        //Obtenemos el valor de la temperatura en F de Andalucia
        return this.temperaturaFAn;
    }
    
    
    public void setTemp(double cl, double cm, double an) {
        //Cambiamos el valor de las temperaturas
        
        this.temperaturaCCl = cl;
        this.temperaturaCCm = cm;
        this.temperaturaCAn = an;
        
        double tempFCl=((double)(cl*(9.0/5.0))+32);
        double tempFCm=((double)(cm*(9.0/5.0))+32);
        double tempFAn=((double)(an*(9.0/5.0))+32);
        
        this.temperaturaFCl = tempFCl;
        this.temperaturaFCm = tempFCm;
        this.temperaturaFAn = tempFAn;
        
        setChanged();
        notifyObservers(tempFCl);
        notifyObservers(tempFCm);
        notifyObservers(tempFAn);
        
    }
    
    @Override
    public void run(){
        while(true) {
            //Maxima temperatura=max / MinimaTemperatura=min 
            
            double maxAn = 40, minAn = -8,
                    maxCm = 35 , minCm = -10,
                    maxCl = 25, minCl = -4;
            
            Random rand = new Random();
            
            double Cm = minCm + rand.nextFloat() * (maxCm - minCm);
            double Cl = minCl + rand.nextFloat() * (maxCl - minCl);
            double An = minAn + rand.nextFloat() * (maxAn - minAn);
            this.setTemp(Cm, Cl, An);

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
        mapa = new Mapa();
        sim.addObserver(mapa);
        
        // Iniciamos la hebra
        Thread hebra = new Thread(sim);
        hebra.start();
        
        
    }
    
}
