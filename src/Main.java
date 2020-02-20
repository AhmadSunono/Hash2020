import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		ArrayList<Libary> libaries = new ArrayList<Libary>();

		BufferedReader bufferedReader = new BufferedReader(new FileReader("a_example.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out1.txt"));
		
		String firstLine = bufferedReader.readLine();
		int numOfBooks = Integer.valueOf(firstLine.split(" ")[0]);
		int numOfLibaries = Integer.valueOf(firstLine.split(" ")[1]);
		int numOfDays = Integer.valueOf(firstLine.split(" ")[2]);
		
		Timeline timeline = new Timeline(numOfDays);
		
		ArrayList<Book> books = new ArrayList<Book>();
		
		String[] secondLine = bufferedReader.readLine().split(" ");
		
		for(int i=0; i<numOfBooks; i++) {
			Book tmp = new Book();
			tmp.id=i;
			tmp.value= Integer.valueOf(secondLine[i]);
			books.add(tmp);
		}
		
		
		for(int i=0; i<numOfLibaries; i++) {
			String tmp = bufferedReader.readLine();
			int tmpNumBooks = Integer.valueOf(tmp.split(" ")[0]);
			int tmpSignup = Integer.valueOf(tmp.split(" ")[1]);
			int dailyBooks = Integer.valueOf(tmp.split(" ")[2]);
			
			Libary lib = new Libary();
			lib.dailyBooks = dailyBooks;
			lib.signUpDayas = tmpSignup;
			
			
			
			String[] tmpBooks = bufferedReader.readLine().split(" ");
			
			for(int j=0; j<tmpBooks.length; j++) {
				int currentBookID = Integer.valueOf(tmpBooks[j]);
				lib.books.add(books.get(j));
			}
			libaries.add(lib);
		}
		
		

//		for(int i=0; i<libaries.size(); i++) {
//			System.out.println(libaries.get(i).books.size());
//		}

		
		bufferedReader.close();
		bufferedWriter.close();

		}

}
