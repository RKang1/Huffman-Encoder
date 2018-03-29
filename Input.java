import java.util.Scanner;

public class Input {
	Scanner scan;
	
	public Input(){
		scan = new Scanner(System.in);
	}
	
	public boolean getInput(int phase){
		String input;
		String output;
		
		switch(phase){
		case 1:
			output = "huffman tree";
			break;
		case 2:
			output = "code table";
			break;
		case 3:
			output = "binary encoding";
			break;
		case 4:
			output = "decoded file";
			break;
		default:
			output = "";
			break;			
		}
		
		System.out.println("Press any key to view the " + output + ", or type exit to quit.");
		input = scan.nextLine();

		if (input.equals("exit")){
			return false;
		}

		return true;
	}
	
	public void closeScan(){
		scan.close();
	}
}// Input
