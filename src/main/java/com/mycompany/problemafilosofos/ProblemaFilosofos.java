package com.mycompany.problemafilosofos;

    public class ProblemaFilosofos {
        public static void main(String[] args) throws  Exception{
            Philosopher philosopher[] = new Philosopher[5];
            Object fork[] = new Object[5];

            for(int i=0;i<philosopher.length;i++){
                fork[i] = new Object();
            }

            for(int i=0;i<philosopher.length;i++){
                Object leftFork = fork[i];
                Object rightFork = fork[(i+1)%5];

                if(i == philosopher.length-1){
                    philosopher[i] = new Philosopher(leftFork,rightFork);
                }else{
                    philosopher[i] = new Philosopher(rightFork,leftFork);
                }
                Thread t = new Thread(philosopher[i] ," Filósofo "+(i+1));
                t.start();
            }
        }
    }

    
    


