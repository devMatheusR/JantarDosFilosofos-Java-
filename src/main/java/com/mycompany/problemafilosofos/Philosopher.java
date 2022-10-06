package com.mycompany.problemafilosofos;

public class Philosopher implements Runnable{
        private Object leftFork;
        private Object rightFork;
        private int foodLeft = 4;

        public Philosopher(Object leftFork,Object rightFork){
            this.leftFork= leftFork;
            this.rightFork= rightFork;
        }
        
        public void doActionComer(String action) throws InterruptedException{
            System.out.println(Thread.currentThread().getName()+" "+action);
            int timeSleep = (int)(Math.random()*1000);
            System.out.println(Thread.currentThread().getName() + " = Passou "+timeSleep+" ms comendo");
            Thread.sleep(timeSleep);
            
        }
        
        public void doAction(String action) throws InterruptedException{
            System.out.println(Thread.currentThread().getName()+" "+action);
            int timeSleep = (int)(Math.random()*1000);
            Thread.sleep(timeSleep);
        }


        @Override
        public void run() {
            try{
                while(foodLeft>0){
                    doAction(
                      "Comida restante : "+this.foodLeft+"   : Pensando" );
                    
                    synchronized (leftFork){
                        doAction(
                         "Comida restante : "+this.foodLeft+
                          " : Pegou garfo esquerdo");
                        synchronized (rightFork){
                            doAction(
                              "Comida restante: "+this.foodLeft+" : Pegou garfo direito e começou a comer");
                            doAction(
                              "Comida restante : "+this.foodLeft+
                               " : Largou garfo direito");
                            this.foodLeft-=1;
                        }
                        doActionComer(
                           "Comida  : "+this.foodLeft+
                           " : Largou garfo esquerdo e começou a pensar");
                    }
                }
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }  
        }
    }
