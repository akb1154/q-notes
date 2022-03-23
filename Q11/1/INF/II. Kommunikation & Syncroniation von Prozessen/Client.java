import java.util.Scanner;
import java.net.Socket;
import java.io.PrintStream;

public class Client {
	
	private PrintStream ps; 
	private Socket sct;
	private Scanner sc, usr;
	
	public static void main (String[] args) throws Exception {
		new Client (args[0]);
	}
	
	public Client (String IP) throws Exception{
		sct = new Socket (IP, 0xC40F); 
		ps  = new PrintStream (sct.getOutputStream(), false, "utf-8");
		sc  = new Scanner (sct.getInputStream(), "utf-8");
		usr = new Scanner (System.in, "utf-8");

		String read = ""; 		
		while(true) {
			read = usr.nextLine();
			if (read.startsWith ("con")) 
				sct = new Socket (read.split(" ")[1], 0xC40F); 
			else if (read.startsWith (":qa")){
				ps.println (read); 
				while (sc.hasNextLine())
					System.out.println(sc.nextLine()); 	
				break;
			}
			else {
				ps.println (read); 
				while (sc.hasNextLine())
					System.out.println(sc.nextLine()); 	
			} 
		}
		
		ps.flush();
	}
};
