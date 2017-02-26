/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;



/**
 *
 * @author Vika$h
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Gift_Main
{
    int  cost;
   
    public static void main (String[] args) throws FileNotFoundException
    {
PrintWriter out = new PrintWriter(new File("random.txt"));
      int  count=0, count2=0;
      while(count!=30)
      {
       
    
            out.print("Boy " + Integer.toString(count+1) );
             out.print(MyRandom.myRandom.makeRandom());
             out.print(MyRandom.myRandom.makeRandom());
             out.print(MyRandom.myRandom.makeRandom());
            count++;
            out.println();
         }  
            while(count2!=20)
            {
                
                
                out.print("Girl " + Integer.toString(count2+1));
                 out.print(MyRandom.myRandom.makeRandom());
                  out.print(MyRandom.myRandom.makeRandom());
                   out.print(MyRandom.myRandom.makeRandom());
                count2++;
                out.println();
            }
        final Random rnd = new Random();
        final ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < 100; i++) 
         values.add(rnd.nextInt());
        Collections.sort(values);

            ArrayList <Boy> boy;
            ArrayList <Girl> girl;
            ArrayList <Couple> couple;
            ArrayList <Integer> happiness =new ArrayList<>();
            ArrayList <Integer> compatibility =new ArrayList<>();
        try (Scanner random = new Scanner(new File("random.txt"))) {
            boy = new ArrayList <>();
            girl = new ArrayList<>();
            couple = new ArrayList <>();
            while(random.hasNextLine()){
                if(count!=0)
                {
                    Boy b =new Boy();
                    
                    String line = random.nextLine();
                    b.name= line;
                    try (Scanner scanner = new Scanner(line)) {
                        while(scanner.hasNextInt()){
                            b.attractiveness=scanner.nextInt();
                            b.intelligence=scanner.nextInt();
                            b.budget=scanner.nextInt();
                            boy.add(b);
                            count--;
                            
                        }   }
                }
                
                Girl g = new Girl();
                
                String line = random.nextLine();
                g.name= line;
                try (Scanner scanner = new Scanner(line)) {
                    while(scanner.hasNextInt()){
                        g.attractiveness=scanner.nextInt();
                        g.intelligence=scanner.nextInt();
                        g.maintenance=scanner.nextInt();
                        girl.add(g);
                    }
                }
                
            }
        }
  
 for(Girl g : girl)
    {
       for(Boy b : boy)
        {
              if(g.maintenance<=b.budget &&((b.attractiveness-g.attractiveness)<=10)
                      &&((b.intelligence-g.intelligence)<=10))
                {
    System.out.println(b.name+g.name);
    Couple c = new Couple();
    c.boyname=b.name;
    c.girlname=g.name;
    c.ba=b.attractiveness;
    c.bi=b.intelligence;
    c.ga=g.attractiveness;
    c.gi=g.intelligence;
    String line=b.name+g.name;
    c.name=line;
    c.boybudget=b.budget;
    c.girlmaintenance=g.maintenance;
    couple.add(c);
    boy.remove(b);
    girl.remove(g);
                  }

         }
        
    }
 for(Couple c : couple){
     
         
    Scanner a = new  Scanner(System.in);
    String s = a.nextLine();
    String s2=a.nextLine();
    if(s.equals("miser")&&s2.equals("choosy"))
        {
         for(int counter=0;counter<values.size();counter++){
             if(values.get(counter)<c.girlmaintenance)
             {
                 c.cost=values.get(counter);
             
                 c.girlmaintenance=c.girlmaintenance-values.get(counter);
         }
         }
             c.happiness=(int) (c.boybudget-c.cost+ Math.log10(c.girlmaintenance));
             c.compatibility=Math.abs((c.ba-c.ga) + (c.bi-c.gi))+c.boybudget-c.girlmaintenance;
            happiness.add(c.happiness);
                         compatibility.add(c.compatibility);

        }
     if (s.equals("miser")&&s2.equals("normal"))
        { 
            
         for(int counter=0;counter<values.size();counter++){
             if(values.get(counter)<c.girlmaintenance)
             {
                 c.cost=values.get(counter);
             
                 c.girlmaintenance=c.girlmaintenance-values.get(counter);
         }
         }
             c.happiness=(int) (c.boybudget-c.cost+ c.girlmaintenance);
             c.compatibility=Math.abs((c.ba-c.ga) + (c.bi-c.gi))+c.boybudget-c.girlmaintenance;
             happiness.add(c.happiness);
                          compatibility.add(c.compatibility);

            
        }
     if (s.equals("miser")&&s2.equals("desperate"))
        { 
            
         for(int counter=0;counter<values.size();counter++){
             if(values.get(counter)<c.girlmaintenance)
             {
                 c.cost=values.get(counter);
             
                 c.girlmaintenance=c.girlmaintenance-values.get(counter);
         }
         }
             c.happiness=(int) (c.boybudget-c.cost+ Math.exp(c.girlmaintenance));
             c.compatibility=Math.abs((c.ba-c.ga) + (c.bi-c.gi))+c.boybudget-c.girlmaintenance;
             happiness.add(c.happiness);
                          compatibility.add(c.compatibility);

            
        }
     if(s.equals("generous")&&s2.equals("choosy"))
        {
         for(int counter=0;counter<values.size();counter++){
             if(values.get(counter)<c.boybudget)
             {
                 c.cost=values.get(counter);
             
                 c.boybudget=c.boybudget-values.get(counter);
         }
         }
             c.happiness=(int) (2* Math.log10(c.girlmaintenance));
             c.compatibility=Math.abs((c.ba-c.ga) + (c.bi-c.gi))+c.boybudget-c.girlmaintenance;
             happiness.add(c.happiness);
                   compatibility.add(c.compatibility);
       
            
        }
        
    if(s.equals("generous")&&s2.equals("normal"))
        {
         for(int counter=0;counter<values.size();counter++){
             if(values.get(counter)<c.boybudget)
             {
                 c.cost=values.get(counter);
             
                 c.boybudget=c.boybudget-values.get(counter);
         }
         }
             c.happiness=(int) (2* c.girlmaintenance);
             c.compatibility=Math.abs((c.ba-c.ga) + (c.bi-c.gi))+c.boybudget-c.girlmaintenance;
             happiness.add(c.happiness);
            compatibility.add(c.compatibility);
 
        }
        if (s.equals("generous")&&s2.equals("desperate"))
        { 
            
         for(int counter=0;counter<values.size();counter++){
             if(values.get(counter)<c.boybudget)
             {
                 c.cost=values.get(counter);
             
                 c.boybudget=c.boybudget-values.get(counter);
         }
         }
             c.happiness=(int) (2*Math.exp( c.girlmaintenance));
             c.compatibility=Math.abs((c.ba-c.ga) + (c.bi-c.gi))+c.boybudget-c.girlmaintenance;
             happiness.add(c.happiness);
            compatibility.add(c.compatibility);
            
        }
        if(s.equals("geek")&&s2.equals("choosy"))
        {
         for(int counter=0;counter<values.size();counter++){
             if(values.get(counter)<c.girlmaintenance)
             {
                 c.cost=values.get(counter);
             
                 c.girlmaintenance=c.girlmaintenance-values.get(counter);
         }
         }
             c.happiness=(int) (c.gi + Math.log10(c.girlmaintenance));
             c.compatibility=Math.abs((c.ba-c.ga) + (c.bi-c.gi))+c.boybudget-c.girlmaintenance;
             happiness.add(c.happiness);
             compatibility.add(c.compatibility);
            
        }
        if(s.equals("geek")&&s2.equals("normal"))
        {
         for(int counter=0;counter<values.size();counter++){
             if(values.get(counter)<c.girlmaintenance)
             {
                 c.cost=values.get(counter);
             
                 c.girlmaintenance=c.girlmaintenance-values.get(counter);
         }
         }
             c.happiness=(int) (c.gi + c.girlmaintenance);
             c.compatibility=Math.abs((c.ba-c.ga) + (c.bi-c.gi))+c.boybudget-c.girlmaintenance;
             happiness.add(c.happiness);
             compatibility.add(c.compatibility);

            
        }
        if(s.equals("geek")&&s2.equals("desperate"))
        {
         for(int counter=0;counter<values.size();counter++){
             if(values.get(counter)<c.girlmaintenance)
             {
                 c.cost=values.get(counter);
             
                 c.girlmaintenance=c.girlmaintenance-values.get(counter);
         }
         }
             c.happiness=(int) (c.gi + Math.exp(c.girlmaintenance));
             c.compatibility=Math.abs((c.ba-c.ga) + (c.bi-c.gi))+c.boybudget-c.girlmaintenance;
             happiness.add(c.happiness);
             compatibility.add(c.compatibility);
            
        }
 }
      Collections.sort(happiness);
      Collections.sort(compatibility);
          Scanner sc = new  Scanner(System.in);
          int k = sc.nextInt();
          while(k!=0)
          {
              for(Couple c2 : couple)
              {  
              if(c2.happiness==(happiness.get(happiness.size())))
                    {
                System.out.print(c2.name);
              happiness.remove(happiness.size());
                    }
              if(c2.compatibility==(compatibility.get(compatibility.size())))
                      {
                          System.out.print(c2.name);
                        compatibility.remove(compatibility.size());
                      }
              
              k--;
                      }
                }
          }
    }

