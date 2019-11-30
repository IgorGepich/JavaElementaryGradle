package Lesson25DB;

import java.util.Scanner;
import Lesson25DB.UiUtils.ChooseProgram;

class Menu {

	private DbConnection dbConnection = new DbConnection();
	private AddContact addContact = new AddContact();
	private CreateDeleteTable table = new CreateDeleteTable();
	private SortAndPrint sortAndPrint = new SortAndPrint();

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
					table.createTable();
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 2:
					table.deleteTable();
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 3:
					addContact.addContact();
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 4:
					sortAndPrint.getAllSortedContacts();
					System.out.println("\n" + (char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 5:
					dbConnection.findContact();
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;
				case 6:
					System.out.println((char) 27 + "[34m-----------------------------------------" + (char)27 + "[0m");
					ExitOrContinue();
					break;

				default:
					System.out.println((char) 27 + "[31m                WARNING!" + (char)27 + "[0m");
					System.out.println((char) 27 + "[31m-----------------------------------------" + (char)27 + "[0m");
					System.out.println((char) 27 + "[31m    Wrong programme number " + (char)27 + "[0m");
					System.out.println((char) 27 + "[31m-----------------------------------------" + (char)27 + "[0m");
					EnterNumberOfTheProgram();
			}
		}

	void ExitOrContinue() {

			 System.out.println((char) 27 + "[34m------------------PRESS------------------" + (char) 27 + "[0m");
			 System.out.println((char) 27 + "[34m 1. Continue ------ or ------ 2. EXIT " + (char) 27 + "[0m");
			 Scanner choose2 = new Scanner(System.in);
			 int secondChoose = 0;

			 // проверка на ввод числа с клавиатуры, при вводе буквы возвращает на старт ввода номера программы
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



