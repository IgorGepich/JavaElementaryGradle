package lesson25DB;

import java.util.Scanner;
import lesson25DB.UiUtils.ChooseProgram;

class Menu {

		void EnterNumberOfTheProgram(){

			System.out.println((char) 27 + "[34m         Select an action 1-9: " + (char)27 + "[0m");
			Scanner programNumber = new Scanner(System.in);
			int choose = 0;

			ChooseProgram.Choose();
			if (programNumber.hasNextInt()){
				choose = programNumber.nextInt();
			}

			switch (choose) {
				case 1:
					new CreateTable().createTable();
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 2:
					new DeleteTable().deleteTable();
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 3:
					new AddContact().addContact();
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 4:
					new SortAndPrint().getAllSortedContacts();
					System.out.println("\n" + (char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 5:
					new FindByName().findName();
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 6:
					// Test case
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;

				default:
					System.out.println((char) 27 + "[31m                WARNING!" + (char)27 + "[0m");
					System.out.println((char) 27 + "[31m-----------------------------------------" + (char)27 + "[0m");
					System.out.println((char) 27 + "[31m           Wrong programme number " + (char)27 + "[0m");
					System.out.println((char) 27 + "[31m-----------------------------------------" + (char)27 + "[0m");
					EnterNumberOfTheProgram();
			}
		}

	private void ExitOrContinue() {

			 System.out.println((char) 27 + "[34m------------------PRESS------------------" + (char) 27 + "[0m");
			 System.out.println((char) 27 + "[34m 1. Continue ------ or ------ 2. EXIT " + (char) 27 + "[0m");
			 Scanner choose2 = new Scanner(System.in);
			 int secondChoose = 0;

			 // Input number check
			 if (choose2.hasNextInt()) {
				 secondChoose = choose2.nextInt();
			 }

			 switch (secondChoose) {
				 case 1:
					 EnterNumberOfTheProgram();
					 break;
				 case 2:
					 System.out.println((char) 27 + "[31m-----------------------------------------" + (char) 27 + "[0m");
					 System.out.println((char) 27 + "[31m                   EXIT " + (char) 27 + "[0m");
					 System.out.println((char) 27 + "[31m-----------------------------------------" + (char) 27 + "[0m");
					 break;
				 default:
					 System.out.println((char) 27 + "[31m                WARNING!" + (char) 27 + "[0m");
					 System.out.println((char) 27 + "[31m-----------------------------------------" + (char) 27 + "[0m");
					 System.out.println((char) 27 + "[31m             Enter 1 or 2" + (char) 27 + "[0m");
					 System.out.println((char) 27 + "[31m-----------------------------------------" + (char) 27 + "[0m");
					 ExitOrContinue();
			 }
	}
}



