import java.util.*;

public class battleship {

	
	static String[][]boardArray = new String [10][10];
	static String[][]boardTargets = new String [10][10];
	static int row = 10, col=10;

	public static void main(String[] args)
	{
			board();
			setShips();
			attackShips();
	}
	
	
	
	public static void board() 
	{
		System.out.print("  A  B  C  D  E  F  G  H  I  J\n");
		for (row = 0; row < 10; row++) 
		{      
			System.out.print(row);
			for (col = 0; col < 10; col++) 
			{        
				System.out.print(" | ");  
			}
			System.out.println(" | ");    
		}    
	}
	
	
	
	public static void setShips() 
	{
		int counter = 0;
		int shipsPlaced =17;
		Random random;
		random = new Random();
		while (counter < shipsPlaced)
		{
			int randomRow = random.nextInt(row-1);
			int randomCol = random.nextInt(col-1);
			boardTargets[randomRow][randomCol] = "W";
			counter++;
		}	
	}
	
	
	
	
	
	public static void attackShips() {
		String UIhitPoint = "X";
		String UImissPoint = "O";
		boolean targetHit = false;
		int totalHits = 0;
		
		while (totalHits != 17)
		{	
			Scanner in = new Scanner (System.in);
			System.out.println("\nPlease enter coordinates of the ship you want to attack");
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter a column (A to H) for y coordinate: ");
			String UIcol = in.nextLine();
			char aChar = UIcol.charAt(0);
			aChar = Character.toUpperCase(aChar);
					
			System.out.println(aChar);  // TEST if the first character is read and converted to upper case
	
			/*int cases = 10;
			switch (cases)
			{
				case 1: aChar='A';
				case 2: aChar='B';
				case 3: aChar='C';
				case 4: aChar='D';
				case 5: aChar='E';
				case 6: aChar='F';
				case 7: aChar='G';
				case 8: aChar='H';
				case 9: aChar='I';
				case 10: aChar='J';	
				default: System.out.println("Invalid character. Please enter a character within the range (A-J): ");
				in.next();
			}*/
			
			//while (!in.hasNext("[a-z]"))
			/*while (aChar != 'A' || aChar != 'B' || aChar != 'C' || aChar != 'D' || aChar != 'E' || aChar != 'F' || aChar != 'G' || aChar != 'H' || aChar != 'I' || aChar != 'J')
			{
				System.out.println("Please enter a character within the range: ");
				in.next();
			}*/
			
			System.out.println("Enter a row (1 to 10) for x coordinate: ");
			int UIrow = in.nextInt();

			//boardArray[row][col] = "X";
			//board();
			
			
			System.out.println("You just attacked: " + aChar + "," + UIrow);
			
			if (targetHit == true)
			{	
				totalHits++;
			}
			
			
			/*System.out.println("Are these the coordinates you want to attack? --> " + UIcol + "," + UIrow);
			System.out.println("Y/N ?");
			char UIyesNo = in.next().charAt(0);
			if (UIyesNo == 'Y')
			{
				
			}	
			else 
			{
				
			}*/		
			
		}
	}

}