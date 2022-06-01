import java.util.Scanner;

public class Javapedia {
	
	static Scanner scan = new Scanner(System.in);
	static String[] generalInfo = new String[] {"Name", "Date of birth", "Occupation"};
	static String[][] historicalFigures;
	
	public static void main(String[] args) {
		int historicalFiguresCount = getHistoricalFiguresCount();       
		historicalFigures = new String[historicalFiguresCount][generalInfo.length];
		setHistoricalFigureGeneralInfo();
		print2DArray();
		printInformationForSearchedHistoricalFigure();    
		scan.close();
    	}
	
	private static void editHistoricalFigureInformation(String mode, String search) 
	{
		for (int i = 0; i < historicalFigures.length; i++) 
        	{
			if (mode.equals("set")) 
				System.out.println("\n\tFigure " + (i+1));
			
			printHistorcalFigureInfoMode(mode, search, i);
			
			if (mode.equals("print2D")) 
    				System.out.print("\n");
        	}
	}

	private static void printHistorcalFigureInfoMode(String mode, String search, int i) {
		for (int j = 0; j < generalInfo.length; j++) 
		{
			if ((mode.equals("print") && historicalFigures[i][0].equals(search)) || mode.equals("print2D")) 
			{
				System.out.print("\t - " + generalInfo[j] + ": " + historicalFigures[i][j]);
			}
			else if (mode.equals("set"))
			{
				System.out.print("\t - " + generalInfo[j] + ": ");
				historicalFigures[i][j] = scan.next();
			}
		}
	}

	private static void printInformationForSearchedHistoricalFigure() {
		System.out.print("\nWho do you want information on? ");  
		String search = scan.next();
		editHistoricalFigureInformation("print", search);
	}

	private static void setHistoricalFigureGeneralInfo() {
		editHistoricalFigureInformation("set", new String());
	}

	private static int getHistoricalFiguresCount() {
		System.out.println("\n**********Javapedia**********");
		System.out.println("How many historical figures will you register?");
		int historicalFiguresCount = -1;
		do 
		{
			System.out.println("Please enter a positive number!");
			while(!scan.hasNextInt()) 
		    {
				System.out.println("That's not a number!");
				scan.next(); // this is important!
		    }
			historicalFiguresCount = scan.nextInt();

		} while(historicalFiguresCount < 0);
		return historicalFiguresCount;
	}

	private static void print2DArray() {
		System.out.println("These are the values you stored:"); 
		editHistoricalFigureInformation("print2D", new String()); 
	}
}
