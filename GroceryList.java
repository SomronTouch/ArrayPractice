import java.util.Scanner;

public class GroceryList {

	private static Scanner input = new Scanner(System.in);
	private static Grocery grocery = new Grocery();

	public static void main(String[] args) {
		boolean quit = false;
		int choice = 0;
		printInstructions();
		while (!quit) {
			System.out.println("Enter your choice: ");
			choice = input.nextInt();
			input.nextLine();

			switch (choice) {
			case 0:
				printInstructions();
				break;
			case 1:
				grocery.printGroceryList();
				break;
			case 2:
				addItem();
				break;
			case 3:
				modifyItem();
				break;
			case 4:
				removeItem();
				break;
			case 5:
				searchForItem();
				break;
			case 6:
				quit = true;
				break;
			}
		}
	}

	public static void printInstructions() {
		System.out.println("\nPress ");
		System.out.println("\t 0 - To print the choice Options.");
		System.out.println("\t 1 - To print the list of grocery Items.");
		System.out.println("\t 2 - To add items to the list.");
		System.out.println("\t 3 - To modify items in the list.");
		System.out.println("\t 4 - To remove and item from the list.");
		System.out.println("\t 5 - To Search for an item in the list.");
		System.out.println("\t 6 - To quit the application.");
	}

	
	//TRY TO MAKE THIS CODE HAVE A WHILE LOOP SO THAT USERS CAN ENTER MULTIPLE ITEMS BEFORE DECIDING TO EXIT LOOP 
	//
	//
	public static void addItem() {
		boolean list = true;
		System.out.println("Please enter the grocery item: ");
		System.out.println("type 'done' to stop adding items");
		String item;
		while (list) {
			if (grocery.addGroceryItem(input.nextLine()).equals("done")) {
				list = false;
			} else {
				list = true;
				grocery.addGroceryItem(input.nextLine());
			}

		}
	}

	public static void modifyItem() {
		System.out.print("enter item number: ");
		int itemNo = input.nextInt();
		input.nextLine();
		System.out.println("Enter replacement item: ");
		String newItem = input.nextLine();
		grocery.modifyGroceryItem(itemNo - 1, newItem);
	}

	public static void removeItem() {
		System.out.print("enter item number: ");
		int itemNo = input.nextInt();
		input.nextLine();
		grocery.removeGroceryItem(itemNo - 1);
	}

	public static void searchForItem() {
		System.out.println("Item to search for: ");
		String searchItem = input.nextLine();
		if (grocery.findItem(searchItem) != null) {
			System.out.println("Found " + searchItem + " in our grocery list.");
		} else {
			System.out.println(searchItem + " is not in our grocery list");
		}
	}

}
