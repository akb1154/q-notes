import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintStream;
import java.util.Scanner;

/**
* 
	<p>
	<b> Kleine Warnung </b> 
	Ich musste auf einen alten Computer (mit ges. 1.9 GiB RAM) ausweichen... 
	d.h. Ich konnte es <i>nicht</i> testen... 
	Good Luck xD  
	</p>

* Chat-Server, der den Gesendeten Text zurücksendet
* Protokoll: 
* reg <username> [pwd] >
* < 200 OK
* [...]
* text >
* < text
* [...]
* exit | logout
* [...]
* login <username> [pwd] >
* < (200 OK | 400 No Pwd Provided | 404 user not found )
* [...]
* :qa # shutdown server
* 0 
*/
public class Server {

	public static final int $PORT = 0xC40f; 
	
	private ServerSocket $server;
	private Socket $usr;
	private Scanner $usrscan;
	private PrintStream $print;
	private String $uname, $pwd;

	private int $loginRetryCount; 

	public static void main (String[] args) throws Exception {
		if (args.length == 1) new Server(args);
		else {
			System.out.println("Syntax: java Server <eigene IP Addresse>");
			System.err.println("not enough Arguments");
			System.exit(-1);
		}
	}

	public Server (String[] args) throws Exception {
		$server = new ServerSocket ($PORT, 1, java.net.InetAddress.getByName(args[0]));
		register();
		System.err.println("regged");
		while (true) userInput(); 
	}
	
	private void userInput () throws Exception {
		System.out.println("uIn");
		while (!$usrscan.hasNextLine()) Thread.currentThread().sleep(15);
		System.out.println($usrscan.hasNextLine());
		String read = $usrscan.nextLine(); 
		System.err.println(read+" -> "+read.split(" ")[0]); 
		switch (read.split(" ")[0]) {
			
			case "exit": 
			case "logout": 
				logout(); 
				return; 
				
			case ":qa": 
				qa(0, "/usr/"); 
				return; 
				
			default: 
				$print.println(read); 
				return; 
		}
	}

	private void errlog (String...msg) {
		String $msg = ""; 
		for (String m : msg)
			$msg += m + "\\n";
		System.err.printf("[%s]: %s\\n", Long.toHexString(System.currentTimeMillis()), $msg);
	}

	private void register () throws Exception {
		$usr = $server.accept();
		$usrscan = new Scanner ($usr.getInputStream(), "utf-8");
		$print = new PrintStream ($usr.getOutputStream(), true, "utf-8");
		while (!$usrscan.hasNextLine()) System.err.print("");
		String read = $usrscan.nextLine();	
		while (!read.startsWith ("reg")) {
			errlog("first msg must be reg!");
			$print.printf("Please register first!\\n%s\\n", "Syntax: reg[ister] <username> [password]");
			read = $usrscan.nextLine();
		}
		
		$uname = read.split(" ")[1]; 
		$pwd = ((read.split(" ").length == 3)? read.split(" ")[2] : "\uF98E");
		System.out.println("Connection from "+$uname+"@"+$usr.getInetAddress().getHostName());
		$print.printf("200 OK\n\n");
	}
	
	private void logout () throws Exception {
		$loginRetryCount = 0; 
		$print.printf("logging out"); 
		this.$usr.close(); 
		this.$print.flush();
		this.$usrscan.close();
		this.$usr = null;
		this.$print = null;
		this.$usrscan = null;
		login();
	}
	
	private void login () throws Exception {
		$usr = $server.accept();
		$usrscan = new Scanner ($usr.getInputStream(), "utf-8");
		$print = new PrintStream ($usr.getOutputStream(), true, "utf-8");
		String read = $usrscan.nextLine();
		while (!read.startsWith ("login")) {
			errlog("login first!");
			$print.printf("Please login first!", "Syntax: login <username> [password]");
			read = $usrscan.nextLine();
		}
		String $uname = read.split(" ")[1], $pwd = ((read.split(" ").length == 3)? read.split(" ")[2] : "\uF98E");
		$loginRetryCount++;	
		if ($uname != this.$uname) {
			errlog ("wrong username");
			$print.printf("404 User % Not Found\n", $uname);
			if ($loginRetryCount <= 3) login();
			else qa(-1, "too many retries");
		}
		if ($pwd != this.$pwd) {
			errlog ("wrong pwd");
			$print.printf("400 %s\n", ($pwd=="\uF98E")? "No pwd provided" : (this.$pwd=="\uF98E")? "No Password required" : "Wrong Password");
			if ($loginRetryCount <= 3) login();
			else qa(-1, "too many retries");
		}
	}
	
	public void qa (int statuscode, String errorMsg) {
		System.err.println(errorMsg); 
		System.exit(statuscode);
	}	 
}
