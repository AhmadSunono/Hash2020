import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
//	public void sendToTimeline(Libary lib, Timeline timeline, ArrayList<Book> books) {
//		
//		int i;
//		boolean flag = false;
//		for(i=0 ; i <timeline.numOfDays; i++) {
//			if(timeline.signingUp.get(i)==false) {
//				break;
//			}
//		}
//			
//			for(int j=i; j<lib.signUpDayas+i; j++) {
//				if(j == timeline.numOfDays)
//					flag=true;
//				if(flag==true) break
//				timeline.signingUp.set(j, true);
//			}
//			for(int k=lib.signUpDayas+i; k<lib.books.size();k++) {
////				timeline.days.get(k).booksToday.add(books.get());
//				if(flag==true) break;
//
//				
//			}
//		}
	
	

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
			lib.id = i;
			
			
			
			String[] tmpBooks = bufferedReader.readLine().split(" ");
			
			for(int j=0; j<tmpBooks.length; j++) {
				int currentBookID = Integer.valueOf(tmpBooks[j]);
				lib.books.add(books.get(j));
			}
			libaries.add(lib);
		}
		
		

		

		
		bufferedReader.close();
		bufferedWriter.close();

		}

}
