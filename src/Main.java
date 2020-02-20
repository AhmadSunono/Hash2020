import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static int potato() throws IOException{
		
//		BufferedReader bufferedReader = new BufferedReader(new FileReader("a_example.in"));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out1.txt"));
//		
//		bufferedReader.readLine();
//		
//		
//		bufferedWriter.write("potato");
//		bufferedWriter.newLine();
//		
//		
//		bufferedReader.close();
//		bufferedWriter.close();

		return 0;
	}

	public static void main(String[] args) throws IOException {

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
	
		
		

//		System.out.println(numOfBooks+" "+numOfLibaries+" "+ numOfDays);

		
		bufferedReader.close();
		bufferedWriter.close();

		
		
	}

}