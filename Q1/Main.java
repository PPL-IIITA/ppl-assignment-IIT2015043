package Q1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
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
        
       

        Scanner random = new Scanner(new File("random.txt"));

        ArrayList <Boy> boy = new ArrayList <>();
        ArrayList <Girl> girl = new ArrayList<>();
        

        while(random.hasNextLine()){
            if(count!=0)
            {
            Boy b =new Boy();
        
            String line = random.nextLine();
            b.name= line;
            Scanner scanner = new Scanner(line);
            while(scanner.hasNextInt()){
                b.attractiveness=scanner.nextInt();
                b.intelligence=scanner.nextInt();
                b.budget=scanner.nextInt();
                boy.add(b);
                count--;
                
            }
            scanner.close();
        }
       
            Girl g = new Girl();
        
            String line = random.nextLine();
            g.name= line;
            Scanner scanner = new Scanner(line);
            while(scanner.hasNextInt()){
                g.attractiveness=scanner.nextInt();
                g.intelligence=scanner.nextInt();
                g.maintenance=scanner.nextInt();
                girl.add(g);
            }
            scanner.close();
        
        }
        random.close();
        
  
 for(Girl g : girl)
    {
       for(Boy b : boy)
        {
              if(g.maintenance<=b.budget &&((b.attractiveness-g.attractiveness)<=10)
                      &&((b.intelligence-g.intelligence)<=10))
                {
    System.out.println(b.name+g.name);
    boy.remove(b);
    girl.remove(g);
    
                  }

         }
        
    }
 
  }
    
}

  

        
        
