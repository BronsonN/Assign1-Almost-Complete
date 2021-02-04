package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Random;

import classes.Book;
import classes.CookBook;


public class BookApp {
	public static ArrayList<CookBook> cookBooks = new ArrayList<>();
	static char ending;
	
	public static void main(String[] args) throws FileNotFoundException {	
		
		Scanner keyboard = new Scanner(System.in);//.useDelimiter("\\n");
	
		loadFile();
		
		//cookBooks.add((CookBook) loadFile());
        int menuSelection = 0;

        menuSelection = menu(keyboard);

        

            switch(menuSelection) {
                case 1:
                    System.out.print("What book would you like to check out?");
                    String selection = keyboard.nextLine();
                    checkoutBook(cookBooks, selection);
                    break;
                case 2:      
                    System.out.print("Enter a title to search for: ");
                    String titleSearch = keyboard.nextLine();
                    findBookByTitle(cookBooks, titleSearch);           
                    break;
                case 3:
                	System.out.println("#     Type");
                	System.out.println("1     Children's Books");
                	System.out.println("2     CookBooks");
                	System.out.println("3     Paperbacks");
                	System.out.println("4     Periodicals");
                	System.out.println();
                	System.out.print("Enter type of book: ");
                	int category = keyboard.nextInt();
                    displayBooksByCategory(cookBooks, category);
                    break;
                case 4:
                	System.out.print("Enter number of books:");
                	int numberOfBooks = keyboard.nextInt();
                	produceRandom(cookBooks, numberOfBooks);
                	break;
        //}
            }
            //while (menuSelection != 5) {
        //}menuSelection = menu(keyboard);
	}

	
	public static int menu(Scanner keyboard) {
        System.out.println("Welcome to ABC Book Company: How may we assist you?");
        System.out.println("1      Checkout Book");
        System.out.println("2      Find Books by Title");
        System.out.println("3      Display Books by Type");
        System.out.println("4      Produce Random Book List");
        System.out.println("5      Save & Exit");
        System.out.print("Enter option:");
        int select = keyboard.nextInt();
        keyboard.nextLine();
        return select;
    }
	
	
	public static void loadFile() throws FileNotFoundException
	{
		File file = new File("C:\\Users\\561596\\Desktop\\Object Oriented Programming\\books.txt");
		
		Scanner in = new Scanner(file);
		
		
		
		while(in.hasNext())
		{
		
		String line = in.nextLine();
		//System.out.println(line);
		String []fields = line.split(";");
		
		String ISBN = fields[0];
		
		 ending = ISBN.charAt(ISBN.length()-1);
		
		
			if(ending == '2' || ending =='3') {
			
			String callNumber = fields[1];
			int availNumber = Integer.parseInt(fields[2]);
			int totalNumber = Integer.parseInt(fields[3]);
			String bookTitle = fields[4];
			String publisher = fields[5];
			String diet = fields[6];
			//int bookTypeCount =+ 1;
			
			
			CookBook c1 = new CookBook(ISBN, callNumber, availNumber, totalNumber, bookTitle, publisher, diet);
			cookBooks.add(c1);
			
			}
		}
		
		in.close();
		
	}	
	
	public static void findBookByTitle(ArrayList<CookBook> cookBooks, String titleSearch) {
		
		for(int i = 0; i<cookBooks.size(); i++) {
			Object cookBook = cookBooks.get(i);
			
			if(((Book)cookBook).getBookTitle().contains(titleSearch)) {
				System.out.println("Matching books:");
				System.out.println("ISBN:             " + ((Book) cookBooks.get(i)).getISBN());
				System.out.println("Call Number:      " + ((Book) cookBooks.get(i)).getCallNumber());
				System.out.println("Available:        " + ((Book) cookBooks.get(i)).getAvailabiltyNumber());
				System.out.println("Total:            " + ((Book) cookBooks.get(i)).getTotalNumber());
				System.out.println("Title:            " + ((Book) cookBooks.get(i)).getBookTitle());
				System.out.println("Publisher:        " + ((CookBook) cookBooks.get(i)).getPublisher());
				System.out.println("Diet:             " + ((CookBook) cookBooks.get(i)).getDiet());
				System.out.println();			
			}
		}
	}
	
	public static void displayBooksByCategory(ArrayList cookBooks, int category) {
		
		for(int i = 0; i < cookBooks.size(); i++) {
		if(category == 2) {
			System.out.println("Matching books:");
			System.out.println("ISBN:             " + ((Book) cookBooks.get(i)).getISBN());
			System.out.println("Call Number:      " + ((Book) cookBooks.get(i)).getCallNumber());
			System.out.println("Available:        " + ((Book) cookBooks.get(i)).getAvailabiltyNumber());
			System.out.println("Total:            " + ((Book) cookBooks.get(i)).getTotalNumber());
			System.out.println("Title:            " + ((Book) cookBooks.get(i)).getBookTitle());
			System.out.println("Publisher:        " + ((CookBook) cookBooks.get(i)).getPublisher());
			System.out.println("Diet:             " + ((CookBook) cookBooks.get(i)).getDiet());
			System.out.println();	
			}
		}
	}
	
	public static void checkoutBook(ArrayList cookBooks, String selection) {
		
		for(int i = 0; i < cookBooks.size(); i++) {
			
			Object cookBook = cookBooks.get(i);
			
			if(((Book)cookBook).getBookTitle().equals(selection)) {
				cookBooks.remove(i);
				((Book) cookBook).setAvailabiltyNumber();
				System.out.println("Book has been checked out");
			}
		}
	}
	
	public static void produceRandom(ArrayList cookBooks, int numberOfBooks) {
		
		//r = new Random();
		System.out.println("Random Books:");
		for(int i = 0; i < numberOfBooks; i++) {
		int random = (int)(Math.random() *5 + 1);
	
		
		System.out.println("ISBN:             " + ((Book) cookBooks.get(random)).getISBN());
		System.out.println("Call Number:      " + ((Book) cookBooks.get(random)).getCallNumber());
		System.out.println("Available:        " + ((Book) cookBooks.get(random)).getAvailabiltyNumber());
		System.out.println("Total:            " + ((Book) cookBooks.get(random)).getTotalNumber());
		System.out.println("Title:            " + ((Book) cookBooks.get(random)).getBookTitle());
		System.out.println("Publisher:        " + ((CookBook) cookBooks.get(random)).getPublisher());
		System.out.println("Diet:             " + ((CookBook) cookBooks.get(random)).getDiet());
		System.out.println();
	}
	}
	
}
