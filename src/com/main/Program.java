package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

import com.main.phones.GamingSmartphone;
import com.main.phones.KeypadPhone;
import com.main.phones.Phone;
import com.main.phones.RuggedKeypadPhone;
import com.main.phones.Smartphone;

/**
 * Воронко Ілля, група ІН-33
 * Лабораторна робота 15
 * Lambda expressions (заміна анонімних класів Comparator на лямбда-вирази)
 */
public class Program {

	public static Scanner scan = new Scanner(System.in);
	public static Store store;
	public static DataLayer dataLayer = new DataLayer();
	
	public static void main(String[] args) throws Exception {
		
		//зчитуємо дані з файла
		try {
			store = dataLayer.readPhoneCollection();
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
			return;
		}
		
		while(true) {
			int chosenOption;
			

			System.out.println("======= Меню програми =======");
			System.out.println("1. Додати новий об'єкт до списку");
			System.out.println("2. Відобразити список усіх об'єктів");
			System.out.println("3. Фільтрація об'єктів у списку");
			System.out.println("4. Роздрукувати відсортовану колекцію об'єктів");
			System.out.println("5. Пошук за UUID");
			System.out.println("0. Завершити роботу");
			
			
			chosenOption = getUserOption(0, 5);
			
			
			switch(chosenOption) {
				case 1:
					while(true) {
						clearConsole();
						System.out.println("======= Меню додавання нових об'єктів =======");
						System.out.println("1. Додати новий об'єкт Smartphone до списку");
						System.out.println("2. Додати новий об'єкт KeypadPhone до списку");
						System.out.println("3. Додати новий об'єкт GamingSmartphone до списку");
						System.out.println("4. Додати новий об'єкт RuggedKeypadPhone до списку");
						System.out.println("0. Повернутися у меню");
						
						chosenOption = getUserOption(0, 4);
						
						if(chosenOption == 1) {
							clearConsole();
							
							// отримуємо дані від користувача
							Smartphone newSmartphone = getSmartphoneDataFromUserInput();
							int count = getItemsCountFromUserInput();
							
							clearConsole();
							System.out.println("===== Введені дані про смартфон =====");
							System.out.println(newSmartphone);
							System.out.println("Кількість до додавання: " + count);
							
							
							// запитуємо, чи бажає користувач додати введені дані до списку
							System.out.print("Бажаєте додати дані до списку? (Y/n): ");
							String answer = scan.next();
							if(answer.equals("Y") || answer.equals("y")) {
								store.addNewPhone(newSmartphone, count);
							}
							
							// запитуємо, чи бажає користувач продовжити запис
							System.out.print("Бажаєте продовжити запис даних? (Y/n): ");
							answer = scan.next();
							if(answer.equals("Y") || answer.equals("y")) {
								continue;
							}
						}
						else if(chosenOption == 2) {
							clearConsole();
							
							// отримуємо дані від користувача
							KeypadPhone newKeypadPhone = getKeypadPhoneDataFromUserInput();
							int count = getItemsCountFromUserInput();
							
							clearConsole();
							System.out.println("===== Введені дані про кнопковий телефон =====");
							System.out.println(newKeypadPhone);
							System.out.println("Кількість до додавання: " + count);
							
							// запитуємо, чи бажає користувач додати введені дані до списку
							System.out.print("Бажаєте додати дані до списку? (Y/n): ");
							String answer = scan.next();
							if(answer.equals("Y") || answer.equals("y")) {
								store.addNewPhone(newKeypadPhone, count);
							}
							
							// запитуємо, чи бажає користувач продовжити запис
							System.out.print("Бажаєте продовжити запис даних? (Y/n): ");
							answer = scan.next();
							if(answer.equals("Y") || answer.equals("y")) {
								continue;
							}
						}
						else if(chosenOption == 3) {
							clearConsole();
							
							// отримуємо дані від користувача
							GamingSmartphone newGamingSmartphone = getGamingSmartphoneDataFromUserInput();
							int count = getItemsCountFromUserInput();
							
							clearConsole();
							System.out.println("===== Введені дані про ігровий смартфон =====");
							System.out.println(newGamingSmartphone);
							System.out.println("Кількість до додавання: " + count);
							
							// запитуємо, чи бажає користувач додати введені дані до списку
							System.out.print("Бажаєте додати дані до списку? (Y/n): ");
							String answer = scan.next();
							if(answer.equals("Y") || answer.equals("y")) {
								store.addNewPhone(newGamingSmartphone, count);
							}
							
							// запитуємо, чи бажає користувач продовжити запис
							System.out.print("Бажаєте продовжити запис даних? (Y/n): ");
							answer = scan.next();
							if(answer.equals("Y") || answer.equals("y")) {
								continue;
							}
						
						}
						else if(chosenOption == 4) {
							clearConsole();
							
							// отримуємо дані від користувача
							RuggedKeypadPhone newRuggedKeypadPhone = getRuggedKeypadPhoneDataFromUserInput();
							int count = getItemsCountFromUserInput();
							
							clearConsole();
							System.out.println("===== Введені дані про захищений кнопковий телефон =====");
							System.out.println(newRuggedKeypadPhone);
							System.out.println("Кількість до додавання: " + count);
							
							// запитуємо, чи бажає користувач додати введені дані до списку
							System.out.print("Бажаєте додати дані до списку? (Y/n): ");
							String answer = scan.next();
							if(answer.equals("Y") || answer.equals("y")) {
								store.addNewPhone(newRuggedKeypadPhone, count);
							}
							
							// запитуємо, чи бажає користувач продовжити запис
							System.out.print("Бажаєте продовжити запис даних? (Y/n): ");
							answer = scan.next();
							if(answer.equals("Y") || answer.equals("y")) {
								continue;
							}
						
						}
						clearConsole();
						break;
					}
					break;
				case 2:
					scan.nextLine();
					System.out.println("===== Об'єкти у списку =====");
					printPhonesCollection(store.getAllPhones());
					System.out.print("Щоб повернутися до головного меню натисніть Enter...");
					scan.nextLine();
					clearConsole();
					break;
				case 3:
					while(true) {
						clearConsole();
						System.out.println("======= Меню пошуку об'єктів у списку =======");
						System.out.println("1. Пошук за брендом");
						System.out.println("2. Пошук за вартістю");
						System.out.println("3. Пошук за кольором");
						System.out.println("0. Повернутися у меню");
						
						chosenOption = getUserOption(0, 3);
						
						if(chosenOption == 0) { 
							break; 
						}
						
						// здійснюємо пошук відповідно до обраного варіанту
						Map<Phone, Integer> filteredPhones;
						
						if(chosenOption == 1) {
							System.out.print("Введіть назву бренда: ");
							String filterBrandName = scan.next();
							filteredPhones = store.filterPhonesByBrand(filterBrandName);
						}
						else if(chosenOption == 2) {
							double filterPrice; 
							while(true) {
								try {
									System.out.print("Введіть вартість: ");
									filterPrice = scan.nextDouble();
									break;
								}
								catch(Exception e) {
									System.out.println("Введені дані не є числом! Спробуйте ще раз.");
								}
							}
							filteredPhones = store.filterPhonesByPrice(filterPrice);
						}
						else {
							System.out.print("Введіть назву кольору: ");
							String filterColor = scan.next();
							filteredPhones = store.filterPhonesByColor(filterColor);
						}
						
						System.out.println();
						
						if(filteredPhones.isEmpty()) {
							System.out.println("Потрібних елементів не знайдено.");
						}
						else {
							System.out.println("===== Результати пошуку =====");
							printPhonesCollection(filteredPhones);
						}
						
						scan.nextLine();
						System.out.print("Щоб повернутися до головного меню натисніть Enter...");
						scan.nextLine();
						clearConsole();
					}
					clearConsole();
					break;
				case 4:
					while(true) 
					{
						clearConsole();
						System.out.println("======= Меню сортування об'єктів =======");
						System.out.println("1. Сортування за брендом");
						System.out.println("2. Сортування за вартістю");
						System.out.println("3. Сортування за кольором");
						System.out.println("0. Повернутися у меню");
						
						chosenOption = getUserOption(0, 3);
						
						if(chosenOption == 0) { 
							break; 
						}
						
						
						Map<Phone, Integer> inventory = store.getAllPhones();
						// отримуємо список об'єктів у Store
						List<Phone> phones = new ArrayList<Phone>();
						phones.addAll(inventory.keySet());
						
						String sortTypeTitle = "\t\tВідсортовано за: ";
						
						if(chosenOption == 1) {
							// сортуємо за полем brand
							phones.sort((p1, p2) -> p1.getBrand().compareTo(p2.getBrand()));
							
							sortTypeTitle += "бренд";
						}
						else if(chosenOption == 2) {
							// сортуємо за полем price
							phones.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
							
							sortTypeTitle += "вартість";
						}
						else if(chosenOption == 3) {
							// сортуємо за полем color
							phones.sort((p1, p2) -> p1.getColor().compareTo(p2.getColor()));
							
							sortTypeTitle += "колір";
						}
						
						
						// друкуємо результат
						System.err.println(sortTypeTitle);
						for(Phone phone: phones) {
							System.out.println(phone);
							System.out.println("Доступно на складі: " + inventory.get(phone));
							System.out.println();
						}
			
						scan.nextLine();
						System.out.print("Щоб повернутися до меню натисніть Enter...");
						scan.nextLine();
					}
					clearConsole();
					break;
				case 5:
					while(true) 
					{
						clearConsole();
						
						if(scan.hasNextLine()) {
							scan.nextLine();
						}
						
						UUID enteredUUID;
						while(true) 
						{
							try 
							{
								System.out.print("Введіть UUID об'єкта, який бажаєте знайти: ");
								String userInput = scan.nextLine();
								enteredUUID = UUID.fromString(userInput);
								break;
							}
							catch(IllegalArgumentException e) 
							{
								System.out.println("Введене значення не є UUID! Спробуйте ще раз");
							}
							
						}
						
						Entry<Phone, Integer> foundPhone = store.findByUUID(enteredUUID);
						
						
						if(foundPhone == null) {
							System.out.println("Потрібних елементів не знайдено.");
						}
						else {
							System.out.println("===== Результати пошуку =====");
							System.out.println(foundPhone.getKey());
							System.out.println("Доступно на складі: " + foundPhone.getValue());
							System.out.println();
						}
						
						System.out.print("Бажаєте продовжити пошук? (Y/n): ");
						String answer = scan.next();
						if(answer.equals("Y") || answer.equals("y")) {
							continue;
						}
						
						break;
					}
					break;
				case 0:
					try {
						dataLayer.writePhoneCollection(store);
						System.out.println("Сеанс завершено.");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					finally {
						scan.close();						
					}
					return;
			}
		}		
	}
	
	/**
	 * повертає номер варіанту, обраний користувачем з клавіатури
	 * @param start - найменший номер варіанта
	 * @param end - найбільший номер варіанта
	 * @return обраний номер варіанта з клавіатури
	 */
	public static int getUserOption(int start, int end) {
		int chosenOption;
		while(true) {
			System.out.print("\nОберіть варіант: ");
			try {
				chosenOption = scan.nextInt();
			}
			catch (Exception e) {
				System.out.println("Введені дані не є числом! Спробуйте ще раз.");
				continue;
			} 
			
			if(chosenOption < 0 && chosenOption > 2) {
				System.out.println("Такого варіанта не існує! Спробуйте ще раз.");
			}
			else {
				break;
			}
		}
		return chosenOption;
	}
	
	/**
	 * функція для отримання кількості товару
	 * @return кількість товару, що введена з клавіатури
	 */
	public static int getItemsCountFromUserInput() {
		int itemsCount;
		
		while(true) {
			System.out.print("\nОберіть варіант: ");
			try {
				itemsCount = scan.nextInt();
			}
			catch (Exception e) {
				System.out.println("Введені дані не є числом! Спробуйте ще раз.");
				continue;
			} 
			
			if(itemsCount < 1) {
				System.out.println("Не можна додати менше одного товару! Спробуйте ще раз.");
			}
			else {
				break;
			}
		}
		
		return itemsCount;
	}
		
	/**
	 * функція для формування нового об'єкта Smartphone відповідно до даних, введених з клавіатури 
	 * @return
	 * Об'єкт Smartphone, значення полів якого введено користувачем 
	 */
	public static Smartphone getSmartphoneDataFromUserInput() {
		

		String brand, model, color, os;
		double price;
		int sizeMemory, sizeRAM;
		boolean hasNFC;
		
		
		scan.nextLine();
		
		
		// введення назви бренду
		while(true) {
			System.out.print("Введіть бренд телефону: ");
			brand = scan.nextLine();
			if(brand.length() == 0) {
				System.out.println("Назва бренду не повинна бути порожньою!");
				continue;
			}
			else {
				break;
			}
			
		}
		
		// введення назви моделі
		while(true) {
			System.out.print("Введіть модель телефону: ");
			model = scan.nextLine();
			if(model.length() == 0) {
				System.out.println("Назва моделі не повинна бути порожньою!");
			}
			else {
				break;
			}
		}
		
		// введення кольору
		while(true) {
			System.out.print("Введіть колір телефону: ");
			color = scan.nextLine();
			if(color.length() == 0) {
				System.out.println("Назва кольору не повинна бути порожньою!");
			}
			else {
				break;
			}
		}

		// введення вартості
		while(true) {
			System.out.print("Введіть вартість телефону: ");
			try {
				price = scan.nextDouble();
				if(price <= 0) {
					System.out.println("Вартість телефона повинна бути більшою за нуль!");
				}
				else {
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Введені дані не є числом! Спробуйте ще раз.");
				scan.nextLine();
			}
		}
		
		// введення назви OC
		while(true) {
			System.out.print("Введіть назву операційної системи: ");
			os = scan.nextLine();
			if(os.length() == 0) {
				System.out.println("Назва операційної системи не повинна бути порожньою!");
				continue;
			}
			else {
				break;
			}
		}


		// введення об'єму внутрішньої пам'яті
		while(true) {
			System.out.print("Введіть об'єм внутрішньої пам'яті: ");
			try {
				sizeMemory = scan.nextInt();
				if(sizeMemory <= 0) {
					System.out.println("Об'єм внутрішньої пам'яті повинен бути більшою за нуль!");
				}
				else {
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Введені дані не є числом! Спробуйте ще раз.");
				scan.nextLine();
			}
		}
		
		// введення об'єму оперативної пам'яті
		while(true) {
			System.out.print("Введіть об'єм оперативної пам'яті: ");
			try {
				sizeRAM = scan.nextInt();
				if(sizeRAM <= 0) {
					System.out.println("Об'єм оперативної пам'яті повинен бути більшою за нуль!");
				}
				else {
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Введені дані не є числом! Спробуйте ще раз.");
				scan.nextLine();
			}
		}
		
		scan.nextLine();
		
		// введення наявності NFC
		while(true) {
			System.out.print("Чи має пристрій NFC-модуль? (y/n): ");
			String answer = scan.nextLine();
			
			if(answer.length() == 0){
				continue;
			}
			else {
				hasNFC = answer.toLowerCase().equals("y");
				break;
			}
		}
		
		
		return new Smartphone(brand, model, price, color, os, sizeMemory, sizeRAM, hasNFC);
	}
	
	/**
	 * функція для формування нового об'єкта KeypadPhone відповідно до даних, введених з клавіатури 
	 * @return
	 * Об'єкт KeypadPhone, значення полів якого введено користувачем 
	 */
	public static KeypadPhone getKeypadPhoneDataFromUserInput() {
			
			String brand, model, color;
			double price;
			int batteryCapacity;
			boolean hasPhysicalKeyboard, hasRadio;
			
			scan.nextLine();
			
			// введення назви бренду
			while(true) {
				System.out.print("Введіть бренд телефону: ");
				brand = scan.nextLine();
				if(brand.length() == 0) {
					System.out.println("Назва бренду не повинна бути порожньою!");
					continue;
				}
				else {
					break;
				}
				
			}
			
			// введення назви моделі
			while(true) {
				System.out.print("Введіть модель телефону: ");
				model = scan.nextLine();
				if(model.length() == 0) {
					System.out.println("Назва моделі не повинна бути порожньою!");
				}
				else {
					break;
				}
			}
			
			// введення кольору
			while(true) {
				System.out.print("Введіть колір телефону: ");
				color = scan.nextLine();
				if(color.length() == 0) {
					System.out.println("Назва кольору не повинна бути порожньою!");
				}
				else {
					break;
				}
			}

			// введення вартості
			while(true) {
				System.out.print("Введіть вартість телефону: ");
				try {
					price = scan.nextDouble();
					if(price <= 0) {
						System.out.println("Вартість телефона повинна бути більшою за нуль!");
					}
					else {
						break;
					}
				}
				catch (Exception e) {
					System.out.println("Введені дані не є числом! Спробуйте ще раз.");
					scan.nextLine();
				}
			}
	
			
			scan.nextLine();
			
			// введення наявності фізичної клавіатури
			while(true) {
				System.out.print("Чи має пристрій фізичну клавіатуру? (y/n): ");
				String answer = scan.nextLine();
				
				if(answer.length() == 0){
					continue;
				}
				else {
					hasPhysicalKeyboard = answer.toLowerCase().equals("y");
					break;
				}
			}
			
			// введення наявності радіо
			while(true) {
				System.out.print("Чи має пристрій радіо? (y/n): ");
				String answer = scan.nextLine();
				
				if(answer.length() == 0){
					continue;
				}
				else {
					hasRadio = answer.toLowerCase().equals("y");
					break;
				}
			}
			
			// введення об'єму батареї
			while(true) {
				System.out.print("Введіть об'єм батареї у mAh: ");
				try {
					batteryCapacity = scan.nextInt();
					if(batteryCapacity <= 0) {
						System.out.println("Об'єм батареї повинен бути більшим за нуль!");
					}
					else {
						break;
					}
				}
				catch (Exception e) {
					System.out.println("Введені дані не є числом! Спробуйте ще раз.");
					scan.nextLine();
				}
			}
			
			return new KeypadPhone(brand, model, price, color, hasPhysicalKeyboard, hasRadio, batteryCapacity);
		}
	
	/**
	 * функція для формування нового об'єкта GamingSmartphone відповідно до даних, введених з клавіатури 
	 * @return
	 * Об'єкт GamingSmartphone, значення полів якого введено користувачем 
	 */
	public static GamingSmartphone getGamingSmartphoneDataFromUserInput() {
			
	
			String brand, model, color, os;
			double price;
			int sizeMemory, sizeRAM, refreshRate;
			boolean hasNFC, hasCoolingSystem;
			
			
			scan.nextLine();
			
			
			// введення назви бренду
			while(true) {
				System.out.print("Введіть бренд телефону: ");
				brand = scan.nextLine();
				if(brand.length() == 0) {
					System.out.println("Назва бренду не повинна бути порожньою!");
					continue;
				}
				else {
					break;
				}
				
			}
			
			// введення назви моделі
			while(true) {
				System.out.print("Введіть модель телефону: ");
				model = scan.nextLine();
				if(model.length() == 0) {
					System.out.println("Назва моделі не повинна бути порожньою!");
				}
				else {
					break;
				}
			}
			
			// введення кольору
			while(true) {
				System.out.print("Введіть колір телефону: ");
				color = scan.nextLine();
				if(color.length() == 0) {
					System.out.println("Назва кольору не повинна бути порожньою!");
				}
				else {
					break;
				}
			}
	
			// введення вартості
			while(true) {
				System.out.print("Введіть вартість телефону: ");
				try {
					price = scan.nextDouble();
					if(price <= 0) {
						System.out.println("Вартість телефона повинна бути більшою за нуль!");
					}
					else {
						break;
					}
				}
				catch (Exception e) {
					System.out.println("Введені дані не є числом! Спробуйте ще раз.");
					scan.nextLine();
				}
			}
			scan.nextLine();
			
			// введення назви OC
			while(true) {
				System.out.print("Введіть назву операційної системи: ");
				os = scan.nextLine();
				if(os.length() == 0) {
					System.out.println("Назва операційної системи не повинна бути порожньою!");
					continue;
				}
				else {
					break;
				}
			}
	
	
			// введення об'єму внутрішньої пам'яті
			while(true) {
				System.out.print("Введіть об'єм внутрішньої пам'яті: ");
				try {
					sizeMemory = scan.nextInt();
					if(sizeMemory <= 0) {
						System.out.println("Об'єм внутрішньої пам'яті повинен бути більшою за нуль!");
					}
					else {
						break;
					}
				}
				catch (Exception e) {
					System.out.println("Введені дані не є числом! Спробуйте ще раз.");
					scan.nextLine();
				}
			}
			
			
			// введення об'єму оперативної пам'яті
			while(true) {
				System.out.print("Введіть об'єм оперативної пам'яті: ");
				try {
					sizeRAM = scan.nextInt();
					if(sizeRAM <= 0) {
						System.out.println("Об'єм оперативної пам'яті повинен бути більшою за нуль!");
					}
					else {
						break;
					}
				}
				catch (Exception e) {
					System.out.println("Введені дані не є числом! Спробуйте ще раз.");
					scan.nextLine();
				}
			}
			
			scan.nextLine();
			
			// введення наявності NFC
			while(true) {
				System.out.print("Чи має пристрій NFC-модуль? (y/n): ");
				String answer = scan.nextLine();
				
				if(answer.length() == 0){
					continue;
				}
				else {
					hasNFC = answer.toLowerCase().equals("y");
					break;
				}
			}
			
			// введення частоти оновлення екрану
			while(true) {
				System.out.print("Введіть частоту оновлення екрану: ");
				try {
					refreshRate = scan.nextInt();
					if(refreshRate <= 0) {
						System.out.println("Частота оновлення екрану повинна бути більшою за нуль!");
					}
					else {
						break;
					}
				}
				catch (Exception e) {
					System.out.println("Введені дані не є числом! Спробуйте ще раз.");
					scan.nextLine();
				}
			}
			
			scan.nextLine();
			
			// введення кулера
			while(true) {
				System.out.print("Чи є охолоджувальна система? (y/n): ");
				String answer = scan.nextLine();
				
				if(answer.length() == 0){
					continue;
				}
				else {
					hasCoolingSystem = answer.toLowerCase().equals("y");
					break;
				}
			}
			
			return new GamingSmartphone(brand, model, price, color, os, sizeMemory, sizeRAM, hasNFC, refreshRate, hasCoolingSystem);
		}

	/**
	 * функція для формування нового об'єкта RuggedKeypadPhone відповідно до даних, введених з клавіатури 
	 * @return
	 * Об'єкт RuggedKeypadPhone, значення полів якого введено користувачем 
	 */
	public static RuggedKeypadPhone getRuggedKeypadPhoneDataFromUserInput() {
		
		String brand, model, color;
		double price;
		int batteryCapacity;
		boolean hasPhysicalKeyboard, hasRadio, isWaterproof, isShockproof;
		
		scan.nextLine();
		
		// введення назви бренду
		while(true) {
			System.out.print("Введіть бренд телефону: ");
			brand = scan.nextLine();
			if(brand.length() == 0) {
				System.out.println("Назва бренду не повинна бути порожньою!");
				continue;
			}
			else {
				break;
			}
			
		}
		
		// введення назви моделі
		while(true) {
			System.out.print("Введіть модель телефону: ");
			model = scan.nextLine();
			if(model.length() == 0) {
				System.out.println("Назва моделі не повинна бути порожньою!");
			}
			else {
				break;
			}
		}
		
		// введення кольору
		while(true) {
			System.out.print("Введіть колір телефону: ");
			color = scan.nextLine();
			if(color.length() == 0) {
				System.out.println("Назва кольору не повинна бути порожньою!");
			}
			else {
				break;
			}
		}

		// введення вартості
		while(true) {
			System.out.print("Введіть вартість телефону: ");
			try {
				price = scan.nextDouble();
				if(price <= 0) {
					System.out.println("Вартість телефона повинна бути більшою за нуль!");
				}
				else {
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Введені дані не є числом! Спробуйте ще раз.");
				scan.nextLine();
			}
		}

		
		scan.nextLine();
		
		// введення наявності фізичної клавіатури
		while(true) {
			System.out.print("Чи має пристрій фізичну клавіатуру? (y/n): ");
			String answer = scan.nextLine();
			
			if(answer.length() == 0){
				continue;
			}
			else {
				hasPhysicalKeyboard = answer.toLowerCase().equals("y");
				break;
			}
		}
		
		// введення наявності радіо
		while(true) {
			System.out.print("Чи має пристрій радіо? (y/n): ");
			String answer = scan.nextLine();
			
			if(answer.length() == 0){
				continue;
			}
			else {
				hasRadio = answer.toLowerCase().equals("y");
				break;
			}
		}
		
		// введення об'єму батареї
		while(true) {
			System.out.print("Введіть об'єм батареї у mAh: ");
			try {
				batteryCapacity = scan.nextInt();
				if(batteryCapacity <= 0) {
					System.out.println("Об'єм батареї повинен бути більшим за нуль!");
				}
				else {
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Введені дані не є числом! Спробуйте ще раз.");
				scan.nextLine();
			}
		}
		
		scan.nextLine();
		
		// введення водонепроникності
		while(true) {
			System.out.print("Чи є пристрій водонепроникним? (y/n): ");
			String answer = scan.nextLine();
			
			if(answer.length() == 0){
				continue;
			}
			else {
				isWaterproof = answer.toLowerCase().equals("y");
				break;
			}
		}
		
		// введення стійкості до ударів
		while(true) {
			System.out.print("Чи є пристрій ударостійким? (y/n): ");
			String answer = scan.nextLine();
			
			if(answer.length() == 0){
				continue;
			}
			else {
				isShockproof = answer.toLowerCase().equals("y");
				break;
			}
		}
		
		
		
		return new RuggedKeypadPhone(brand, model, price, color, hasPhysicalKeyboard, hasRadio, batteryCapacity, isWaterproof, isShockproof);
	}

	/**
	 * роздруковує колекцію телефонів в консоль
	 * @param phonesCollection - колекція телефонів, яку потрібно розлрукувати
	 */
	public static void printPhonesCollection(Map<Phone, Integer> phonesCollection) 
	{
		for(Phone phone: phonesCollection.keySet()) 
		{
			System.out.println(phone);
			System.out.println("Доступно на складі: " + phonesCollection.get(phone)+"\n");
		}
	}
	
	/**
	 * функція для емуляції очищення консолі
	 */
	public static void clearConsole() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
    }
}
