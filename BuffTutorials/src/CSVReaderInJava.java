import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderInJava
{
	public static void main(String ...args)
	{
		List<Books> bookz = readBooksFromCSV("books.txt");
		
		for(Books bb: bookz)
		{
			System.out.println(bb);
		}
	}

	private static List<Books> readBooksFromCSV(String s) 
	{
		List<Books> bookzy = new ArrayList<>();
		Path pathToFile = Paths.get(s);
	
		try(BufferedReader b = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
		{
			String l = b.readLine();
			
			while(l != null) 
			{
				String [] atts = l.split(",");
				Books book = createBook(atts);
			
				bookzy.add(book);
				l = b.readLine();
			}
		}
		catch (IOException oh)
		{
			oh.printStackTrace();
		}
			
		return bookzy;
		
	}

	private static Books createBook(String[] z) 
	{
		String name = z[0];
		String author = z[2];
		int price = Integer.parseInt(z[1]);
		
		return new Books(name, author, price);
	}
}
