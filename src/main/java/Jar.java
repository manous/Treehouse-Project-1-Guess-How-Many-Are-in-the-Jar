import java.util.Scanner;
import java.util.Random;
class Jar{
//declare variables  
private String itemName;
private int maxItems;
Scanner scan=new Scanner(System.in);
  //add constructor
 public Jar(){
 
 }

public Jar(String itemName, int maxItems ){
 this.itemName=itemName;
 this.maxItems= maxItems;
} 
  //normalize items name
 public String normalizeItemsName(String itemName){
 if(itemName.length()==0){
   throw new IllegalArgumentException("No itemName found");
  }
 for(char letter:itemName.toCharArray()){
  if(!Character.isLetter(letter)){
    throw new IllegalArgumentException("an item name made with letters is required");
  }
 }
  return itemName.toLowerCase();
}
  
//prompt administrator to enter the type and max numbers of items
 public void identifyItems(){
  boolean isAcceptable=false; 

 System.out.println("ADMINISTRATOR SETUP");
 System.out.println("--------------------");
  do{
 System.out.println("What type of item should go in the jar:");
 itemName= scan.nextLine();
  try{
    itemName=normalizeItemsName(itemName);
    isAcceptable=true;
  }catch(IllegalArgumentException iae){
    System.out.printf("%s. Please try again. %n",
                   iae.getMessage());
  }
  }while(!isAcceptable);
   
 do{
 System.out.printf("What is the maximum amount of %s that should go in the jar:",itemName);
   try{
      maxItems=Integer.parseInt(scan.nextLine());
     isCorrectNum=true;
   }catch(Exception iae){
      System.out.printf("invalid input. Please try again. %n");
   }
  }while(!isCorrectNum);
 System.out.println("--------------------.\n\n");
}
  //fill the jar with a random number
 public int fill(){
   Random rand=new Random();
   //random.nextInt(max-min+1)+min
   int randomNumber=rand.nextInt(maxItems)+1;
   return randomNumber;
 } 
  //guessing method 
  public void guessItem(){
    System.out.println("--------------------");
    System.out.println("Welcome to the guessing game!");
    boolean isCorrect=false;
    int targetNum=fill();
    int numOfTries=0;
    do{
 System.out.printf("How many %s are in the jar? Pick a number between 1 and %d :",itemName,maxItems);
      ++numOfTries;
      int guessInput=scan.nextInt();
      if(guessInput==targetNum){
        System.out.printf("Congrats! You got it in %d attempts!.%n",numOfTries);
       isCorrect=true;
      }
    }while(!isCorrect);
    
  }
}