/* File: SimpleDemo.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 */
import businesslayer.AuthorsBusinessLogic;
import businesslayer.ValidationException;
import transferobjects.AuthorDTO;

import java.util.List;
public class SimpleDemo {

	public void demo(){
		try{
			AuthorsBusinessLogic logic = new AuthorsBusinessLogic();
			List<AuthorDTO> list = null;
			AuthorDTO author = null;
			
			System.out.println("Printing Authors");
			list = logic.getAllAuthors();
			printAuthors(list);
			
			System.out.println("Printing One Author");
			author = logic.getAuthor(1);
			printAuthor(author);
			System.out.println();
			
			System.out.println("Inserting One Author");
			author = new AuthorDTO();
			author.setFirstName("FirstTestAdd");
			author.setLastName("LastTestAdd");
			logic.addAuthor(author);
			list = logic.getAllAuthors();
			printAuthors(list);
			
			System.out.println("Updating last author");
			Integer updatePrimaryKey = list.get(list.size() - 1).getAuthorID();
			author = new AuthorDTO();
			author.setAuthorID(updatePrimaryKey);
			author.setFirstName("FirstTestUpdate");
			author.setLastName("LastTestUpdate");
			logic.updateAuthor(author);
			list = logic.getAllAuthors();
			printAuthors(list);
			
			System.out.println("Deleting last author");
			author = list.get(list.size() - 1);
			logic.deleteAuthor(author);
			list = logic.getAllAuthors();
			printAuthors(list);	
		}
		catch(ValidationException e){
			System.err.println(e.getMessage());
		}

	}
	
	private static void printAuthor(AuthorDTO author){
	    	String output = String.format("%s, %s, %s",
	    			author.getAuthorID().toString(),
	    			author.getFirstName(),
	    			author.getLastName());
	    	System.out.println(output);
	}
	
	private static void printAuthors(List<AuthorDTO> authors){
	    for(AuthorDTO author : authors){
	    	printAuthor(author);
	    }
	    System.out.println();
	}
	

}
