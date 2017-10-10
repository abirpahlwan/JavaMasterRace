import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class WordCollection {
	private Scanner s;
	private HashSet<String> hs = new HashSet<String>();

	public WordCollection() {
		try{
			s = new Scanner(new File("WordDB.txt"));
			makeHash();
		}
		catch(Exception ex){
			
		}
	}
	
	public void makeHash(){
		while(s.hasNext())
			hs.add(s.nextLine());
	}
	
	public boolean searchWord(String w){
		return hs.contains(w);
	}
}
