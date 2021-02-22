
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

public class Roulette {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 //print results after 30 seconds
		
    	File file = new File("filename.txt");
    	FileWriter fr = new FileWriter(file, true);
    	BufferedWriter br = new BufferedWriter(fr);

		
		boolean playAgain = true;
	    try {
	        while (playAgain) {
	        		
		System.out.println("hello world");
		 String[] data = new String[100];
		 
		int results = 0;
		int count = 0;//Count the numb er of lines in the file
		boolean repeat = true;// ask if the user wants to place more bets
		double money = 0.0;
		
		

		 try {
		      File myObj = new File("sales.txt");
		      Scanner myReader = new Scanner(myObj);

		      
		      while (myReader.hasNextLine()) 
		      {
		    	  
		        data[count] = myReader.nextLine();
		     
		        count++;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 double[] amounts = new double[count];// the money the player spent on a bet
		 String[] report = new String[count];//to show if player won or lost
		 String[] names = new String[count];
		 double[] winnings = new double[count];//for calculating the winnings per user
		 System.out.println("Players's names " );
		 
		 //Display the  names of players as stored in the file
		 if(data.length>0)
		 {
			 for (int i = 0; i < names.length; i++) 
			 {
				
				names[i] = data[i].substring(0,data[i].length());
				System.out.println(names[i]);
			 }
		 }
		 String betType;
		 //Read inputs from the console
		 String[] myNumbers = new String[names.length];
		 for(int i = 0; i<names.length;i++)
		 {
			
			do
			{
				System.out.println("Name : "+names[i] );
			 	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("Enter what do you want to bet ? Press 1 for 1-36 or Press 2 for odd or even");
	
			     betType= myObj.nextLine();  // Read user input
			     
				    //Randomise the numbers 1-36
			         results= (int) (Math.random()*36);
			         
			         //Check if the random number is not 0, if yes, add a 1
			         if(results ==0)
			         results++;
				 
				    if(betType.equalsIgnoreCase("1"))
				    {
				    	
				    	
						System.out.println("Name : "+names[i] );
					 	Scanner myNumbers2 = new Scanner(System.in);  // Create a Scanner object
					    System.out.println("Choose a number between 1 - 36");
					    myNumbers[i]= myNumbers2.nextLine();  // Read user input
					    
					    winnings[i]= 36*amounts[i];
					    
					    System.out.println("How much do you want to bet with");
					    amounts[i]= Double.parseDouble(myNumbers2.nextLine());  // Read user amounts
				    }
				    
				    //for betting Odd or Even
				    if(betType.equalsIgnoreCase("2"))
				    {
					 	Scanner myNumbers2 = new Scanner(System.in);  // Create a Scanner object
					    System.out.println("Please type Even or Odd");
					    myNumbers[i]= myNumbers2.nextLine();
					    

					    System.out.println("How much do you want to bet with");
					    amounts[i]= Double.parseDouble(myNumbers2.nextLine());  // Read user amounts
				    }
				  
				    //Ask if the player wants to place more bets
				    
				    Scanner myNumbers2 = new Scanner(System.in);  // Create a Scanner object
				    System.out.println("do you want to place more bets? Y/N");
				    String answer = myNumbers2.nextLine();
				  
				    if(answer.equalsIgnoreCase("Y"))
				    {
				    	repeat = true;
				    }
				    else
				    {
				    	repeat = false;
				    }
				    
				    
			}while(repeat);

		 }
		 

		            Thread.sleep(30 * 1000);
		            //check if the randomised number is Odd or Even          
		            System.out.println("Number : "+results);
		            
				    if(results%2==0)
				    {
				    	System.out.println("Even");
				    	
				    	
				    }
				    
				    else
				    {
				    	System.out.println("Odd");
				    }
				    
				    
				    
				    String[] outcome = new String[count];
					
				    //check the winner
				    
				    System.out.println("Player" + "			"+"Bet"+"			"+"Outcome"+"			"+"Winings"	);
				    
				    for(int i = 0; i< count;i++)
				    {

					 
				    	if(myNumbers[i].equalsIgnoreCase("Even")&& results%2==0)
				    	{
				    		winnings[i] = 2*amounts[i];
				    		outcome[i] = "Win";
							System.out.println(names[i]+ " 			"+myNumbers[i]+ "			"+outcome[i]+ "			"+winnings[i]);
				    	}
				    	
				    	else if(myNumbers[i].equalsIgnoreCase("Odd")&& results%2!=0)
				    	{
				    		winnings[i] = 2*amounts[i];
				    		outcome[i] = "Win";
							System.out.println(names[i]+ " 			"+myNumbers[i]+ "			"+outcome[i]+ "			"+winnings[i]);
				    	}
				    	
				    	
				    	else if(myNumbers[i].equalsIgnoreCase(Integer.toString(results)))
						{
				    		outcome[i] = "Win";
							System.out.println(names[i]+ " 			"+myNumbers[i]+ "			"+outcome[i]+ "			"+winnings[i]);
						}
				    	
				    	else {
				    		
				    		winnings[i] = 0*amounts[i];
				    		outcome[i] = "Lose";
							System.out.println(names[i]+ " 			"+myNumbers[i]+ "			"+outcome[i]+ "			"+winnings[i]);
				    	}

				     	br.write(names[i]+"\t"+winnings[i]+"\r\n");
		
					    
				    }
				    
				
				    
				       //ask if player wants to play again or exit the game
				    Scanner myNumbers2 = new Scanner(System.in);  // Create a Scanner object
					System.out.println("Do you want to play again ? Y/N");
				    String answer = myNumbers2.nextLine();
				  
				    if(answer.equalsIgnoreCase("Y"))
				    {
				    	playAgain = true;
				    }
				    else
				    {
				    	playAgain = false;
				    }
		        }
	        
	        //Save all the informnation into a file 
	      
	       
		
	    	

	    	br.close();
	    	fr.close();
	    	
	    	String[] data2 = new String[200];
	        int count2=0;
	    	//read the winnings saved file
			 try {
			      File myObj = new File("filename.txt");
			      Scanner myReader = new Scanner(myObj);

			      
			      while (myReader.hasNextLine()) 
			      {
			    	  
			        data2[count2] = myReader.nextLine();
			  
			        
			        
			        
			        count2++;
			      }
			      myReader.close();
			    } catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			 
			 String[] names2 = new String[count2];
			 int[] betsNumber = new int[count2];
			 int sum = 0;
			 for (int i = 0; i < count2; i++) 
			 {
			
				 System.out.println("inside the loop ");
				 for (int j = 1; j < count2; j++) 
				 {
					 System.out.println("inside 2nd loop");
					 if(names2[i].equalsIgnoreCase(names2[j]))
					 {
						 System.out.println("inside the if ");
						 sum++;
					 }
				 }
				 
				 System.out.println("bet numbers"+ sum);
			 }
	        
			 
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		   

		    	
	}

}
