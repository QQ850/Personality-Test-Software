/*Qiqi Hu, CS210, 11/17/2020, Coding assignment #7*/
import java.util.*;
import java.io.*;
public class PersonalityTest{
  public static final String[] OPTIONS = {"EI","SN","TF","JP"};
  public static final int[] MAX_VALUES = {10,20,20,20};
  public static final int DIMENSIONS = 4;
  public static final int QUESTIONS = 7;
  public static final int GROUPS = 10;
  
  public static void main(String[] args) throws FileNotFoundException{ //throws an exception
      try{
        Scanner console = new Scanner(System.in);
        System.out.print("Type the name of file: ");
        String file = console.nextLine();
        Scanner input = new Scanner(new File(file));//scan input file
      
        String outputfile = file.replace(".","-out.");//print output file
        PrintStream output = new PrintStream(new File(outputfile)); 
      
        processPerson(input, output); 
      }catch(FileNotFoundException e){
        System.out.println("File not found"); //prompt user the error of filenotfoundStexception  
      }  
   }
   
   public static void processPerson(Scanner input, PrintStream output){
     while (input.hasNextLine()){
       String name = input.nextLine(); //the name of user
       output.println(name+":");
       
       String a = input.nextLine(); //a refers to 70 answers          
       int[] countBs = computerTally(a); //call computerTally method 
      
       int countAs = 0;
       for(int i=0; i<DIMENSIONS; i++){
          countAs = MAX_VALUES[i]-countBs[i];
          output.print(countAs+"A-"+countBs[i]+"B ");
       }
       output.println();  
       
       String personality = "";
       double[] percent = computerPercentage(countBs);//call computerPercentage method
       //fencepost
       if(percent[0]>0.5){ 
            personality += OPTIONS[0].substring(1);
           }else{
            personality += OPTIONS[0].substring(0,1);
           }
       double percentage = percent[0]*100;    
       output.print("["+String.format("%.0f",percentage)+"%");
       //start for loop
       for(int i=1; i<DIMENSIONS; i++){ 
          if(percent[i]>0.5){ 
            personality += OPTIONS[i].substring(1);
           }else{
            personality += OPTIONS[i].substring(0,1);
           }
            percentage = percent[i]*100;
           output.print(", "+String.format("%.0f",percentage)+"%");
       }
       output.println("] = "+personality);   
     }    
         
   }
   
   //return the amount of Bs   
   public static int[] computerTally(String a){  
     int[] countBs = new int[DIMENSIONS]; //four length of the array
     
     for(int i=0; i<QUESTIONS*GROUPS; i++){ //tally array
        int question = i%QUESTIONS;
        if(question == 0 && a.charAt(i)=='B')
          countBs[0]++; 
          
        if(question == 2 || question == 3){
           if(a.charAt(i)=='B')
              countBs[1]++;
              }
        if(question == 4 || question == 5){
           if(a.charAt(i)=='B')
              countBs[2]++;
              }      
      
        if(question == 6 || question == 7){
           if(a.charAt(i)=='B')
              countBs[3]++;
              }  
        }    
     return countBs;
   }
   
   public static double[] computerPercentage(int[] countBs){ //accept the array of the count of Bs
     double[] percent = new double[DIMENSIONS];
     for(int i=0; i<countBs.length; i++){
       percent[i] = (double)countBs[i]/MAX_VALUES[i];
       }
     
     return percent;
   }
}         
