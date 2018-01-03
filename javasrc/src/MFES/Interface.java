package MFES;

import java.util.Iterator;
import java.util.Scanner;

public class Interface {
	private static final String MAIN = "main";
	private static final String CONSUMER = "consumer";
	private static final String CONSUMER_SEE_ALL_CONSUMERS = "consumer1";
	private static final String CONSUMER_SEE_LAST_BASKET = "consumer2";
	private static final String CONSUMER_REGISTER = "consumer3";
	private static final String CONSUMER_FETCH = "consumer4";
	private static final String CONSUMER_CANCEL = "consumer5";
	private static final String PRODUCER = "producer";
	private static final String DELEGATION = "delegation";
	private static final String EXIT = "exit";
	private static String state;
	
	
	private static FrutaFeia frutaFeia;
	
	
	public static void main(String[] args){
		frutaFeia = new FrutaFeia();
		state = MAIN;
		while(state!=EXIT) {
			if(state == MAIN) {
				mainMenu();
				readOption();
			}else if(state == CONSUMER) {
				consumerMenu();
				readOption();
			}else if(state == CONSUMER_REGISTER) {
				consumerRegister();
			}else if(state == CONSUMER_SEE_ALL_CONSUMERS) {
				consumerSeeAll();
			}else if(state == CONSUMER_SEE_LAST_BASKET) {
				consumerLastBasket();
			}else if(state == CONSUMER_FETCH) {
				consumerFetchBasket();
			}else if(state == CONSUMER_CANCEL) {
				consumerCancelBasket();
			}else if(state == PRODUCER) {
				producerMenu();
				readOption();
			}else if(state == DELEGATION) {
				delegationMenu();
				readOption();
			}
			
		}
	}
	
	private static void mainMenu() {
		System.out.println(
				"*******************************\n"
			  + "*                             *\n"
			  + "*     F R U T A   F E I A     *\n"
			  + "*                             *\n"
			  + "*******************************\n"
			  + "1 - Consumer\n"
			  + "2 - Producer\n"
			  + "3 - Delegation\n"
			  + "4 - Exit\n"
			  + "\nOption: ");
	}
	
	private static void consumerMenu() {
		System.out.println(
				"*******************************\n"
			  + "*                             *\n"
			  + "*       C O N S U M E R       *\n"
			  + "*                             *\n"
			  + "*******************************\n"
			  + "1 - Register\n"
			  + "2 - See All Consumers\n"
			  + "3 - See Last Basket\n"
			  + "4 - Fetch Basket\n"
			  + "5 - Cancel Basket\n"
			  + "6 - BACK\n"
			  + "\nOption: ");
	}
	
	private static void consumerRegister() {
		System.out.println("To cancel write 'exit'.");
		System.out.print("Name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		if(name == "exit") {
			state = CONSUMER;
			return;
		}
		System.out.println("large - 4 types of products \nsmall - 3 types of products");
		System.out.print("Basket ('large' or 'small'): ");
		String basket = in.nextLine();
		if(name.equals("exit")) {
			state = CONSUMER;
			return;
		}
		while(true) {
			System.out.println(basket);
			if(basket.equals("large") || basket.equals("small")) {
				break;
			}
			System.out.print("Invalid choice, write 'large' or 'small'!\nBasket ('large' or 'small'): ");
			basket = in.nextLine();
		}
		if(basket.equals("large")) {
			frutaFeia.newCustomer(name, MFES.quotes.GrandeQuote.getInstance());
		}else {
			frutaFeia.newCustomer(name, MFES.quotes.PequenaQuote.getInstance());
		}
		System.out.println("Consumer created");
		state = CONSUMER;
	}

	private static void consumerSeeAll() {	
		Iterator it = frutaFeia.getConsumers().iterator();
		while(it.hasNext()) {
			Consumer obj = (Consumer) it.next();
			if(obj.delegation == null) {
				System.out.println("name = " + obj.name + ", basket = " + obj.maxbasketsize.toString());
			}else {
				System.out.println("name = " + obj.name + ", basket = " + obj.maxbasketsize.toString() + ", delegation = " + obj.delegation.name);
			}
		}
		System.out.print("Write '0' to go back.\nOption: ");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		while(option != 0) {
			System.out.print("Write '0' to go back.\nOption: ");
			option = in.nextInt();
		}
		state = CONSUMER;
	}
	
	private static void consumerLastBasket() {
		System.out.print("Consumer name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		System.out.println(frutaFeia.getLastBasket(name).toString());
		System.out.print("Write '0' to go back.\nOption: ");
		int option = in.nextInt();
		while(option != 0) {
			System.out.print("Write '0' to go back.\nOption: ");
			option = in.nextInt();
		}
		state = CONSUMER;
	}
	
	private static void consumerFetchBasket() {
		System.out.print("Consumer name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		frutaFeia.fetchBasket(name);
		System.out.print("Write '0' to go back.\nOption: ");
		int option = in.nextInt();
		while(option != 0) {
			System.out.print("Write '0' to go back.\nOption: ");
			option = in.nextInt();
		}
		state = CONSUMER;
	}
	
	private static void consumerCancelBasket() {
		System.out.print("Consumer name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		frutaFeia.cancelBasket(name);
		System.out.print("Write '0' to go back.\nOption: ");
		int option = in.nextInt();
		while(option != 0) {
			System.out.print("Write '0' to go back.\nOption: ");
			option = in.nextInt();
		}
		state = CONSUMER;
	}
	
	private static void producerMenu() {
		System.out.println(
				"*******************************\n"
			  + "*                             *\n"
			  + "*       P R O D U C E R       *\n"
			  + "*                             *\n"
			  + "*******************************\n"
			  + "1 - Register\n"
			  + "2 - See All Producers\n"
			  + "3 - Make Product\n"
			  + "4 - Send to Delegation\n"
			  + "5 - View Products\n"
			  + "6 - BACK\n"
			  + "\nOption: ");
	}
	
	private static void producerRegister() {
		System.out.println("To cancel write 'exit'.");
		System.out.print("Name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		if(name == "exit") {
			state = PRODUCER;
			return;
		}
		frutaFeia.newProducer(name);
		System.out.println("Producer created");
		state = PRODUCER;
	}
	
	private static void producerSeeAll() {
		Iterator it = frutaFeia.getProducers().iterator();
		while(it.hasNext()) {
			Producer obj = (Producer) it.next();
			System.out.println("name = " + obj.name);
		}
		System.out.print("Write '0' to go back.\nOption: ");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		while(option != 0) {
			System.out.print("Write '0' to go back.\nOption: ");
			option = in.nextInt();
		}
		state = PRODUCER;
	}
	
	private static void producerMakeProduct() {
		System.out.print("Producer name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		System.out.print("Product name: ");
		String pName = in.nextLine();
		frutaFeia.addProductPro(name, pName);
		frutaFeia.addProductStockPro(name, pName, 2L);
		System.out.print("Write '0' to go back.\nOption: ");
		int option = in.nextInt();
		while(option != 0) {
			System.out.print("Write '0' to go back.\nOption: ");
			option = in.nextInt();
		}
		state = PRODUCER;
	}
	
	private static void producerSend() {
		System.out.print("Producer name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		frutaFeia.sendToDels(name);
		System.out.print("Write '0' to go back.\nOption: ");
		int option = in.nextInt();
		while(option != 0) {
			System.out.print("Write '0' to go back.\nOption: ");
			option = in.nextInt();
		}
		state = PRODUCER;
	}
	
	private static void producerViewProducts() {
		//TODO
		Iterator it = frutaFeia.getProducers().iterator();
		while(it.hasNext()) {
			Producer obj = (Producer) it.next();
			System.out.println("name = " + obj.name);
		}
		System.out.print("Write '0' to go back.\nOption: ");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		while(option != 0) {
			System.out.print("Write '0' to go back.\nOption: ");
			option = in.nextInt();
		}
		state = PRODUCER;
	}
	
	private static void delegationMenu() {
		System.out.println(
				"*******************************\n"
			  + "*                             *\n"
			  + "*     D E L E G A T I O N     *\n"
			  + "*                             *\n"
			  + "*******************************\n"
			  + "1 - Register\n"
			  + "2 - Make Basket\n"
			  + "3 - Add Consumer\n"
			  + "4 - Remove Consumer\n"
			  + "5 - See All Delegations\n"
			  + "6 - View Products\n"
			  + "7 - View Baskets\n"
			  + "8 - BACK\n"
			  + "\nOption: ");
	}
	
	private static void readOption() {
		int option = -1;
		while(true) {
			Scanner in = new Scanner(System.in);
			option = in.nextInt();
			if(validateOption(option)) break;
		}
		if(state == MAIN) {
			switch(option) {
			case 1:
				state = CONSUMER;
				break;
			case 2:
				state = PRODUCER;
				break;
			case 3:
				state = DELEGATION;
				break;
			case 4:
				state = EXIT;
				break;
			}
		}else if(state == CONSUMER) {
			switch(option) {
			case 1:
				state = CONSUMER_REGISTER;
				break;
			case 2:
				state = CONSUMER_SEE_ALL_CONSUMERS;
				break;
			case 3:
				state = CONSUMER_SEE_LAST_BASKET;
				break;
			case 4:
				state = CONSUMER_FETCH;
				break;
			case 5:
				state = CONSUMER_CANCEL;
				break;
			case 6:
				state = MAIN;
				break;
			}
		}else if(state == PRODUCER) {
			switch(option) {
			case 1:
				state = CONSUMER_REGISTER;
				break;
			case 2:
				state = CONSUMER_SEE_ALL_CONSUMERS;
				break;
			case 3:
				state = CONSUMER_SEE_LAST_BASKET;
				break;
			case 4:
				state = CONSUMER_FETCH;
				break;
			case 5:
				state = CONSUMER_CANCEL;
				break;
			case 6:
				state = MAIN;
				break;
			}
		}else if(state == DELEGATION) {
			switch(option) {
			case 1:
				state = CONSUMER_REGISTER;
				break;
			case 2:
				state = CONSUMER_SEE_ALL_CONSUMERS;
				break;
			case 3:
				state = CONSUMER_SEE_LAST_BASKET;
				break;
			case 4:
				state = CONSUMER_FETCH;
				break;
			case 5:
				state = CONSUMER_CANCEL;
				break;
			case 6:
				state = MAIN;
				break;
			}
		}
	}
	
	private static boolean validateOption(int option) {
		if(state == MAIN) {
			if(option>0 && option<5) {
				return true;
			}
		}else if(state == CONSUMER) {
			if(option>0 && option<7) {
				return true;
			}
		}
		System.out.println("Invalid Option!\n\nOption: ");
		return false;
	}
}
