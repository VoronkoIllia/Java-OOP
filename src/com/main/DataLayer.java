package com.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Даний клас використовується для читання та запису об'єктів до файлу input.txt
 * 
 * Усі вищеназвані файли перебувають у папці res
 */
public class DataLayer {
	
	private final String PATH_TO_INPUT_FILE = "res/input.txt";
	

	/**
	 * використовується для десеріалізації об'єктів з файла input.txt
	 * @return колекцію об'єктів Phone
	 * @throws Exception якщо файл input.txt відсутній, є директорією, або містить пошкоджені дані
	 */
	public Store readPhoneCollection() throws Exception 
	{
		File inputFile = new File(PATH_TO_INPUT_FILE);
		
		try (FileInputStream inputStream = new FileInputStream(inputFile))
		{
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			Store store = (Store)ois.readObject();
			
			ois.close();
			
			return store;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new Exception("Помилка: Файл input.txt відсутній або є директорією!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new Exception("Помилка під час зчитування файла input.txt!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new Exception("Помилка: дані у файлу input.txt пошкоджені!");
		}
	}
	
	/**
	 * викоритовується для серіалізації та збереження об'єктів до файлу inpiut.txt
	 * @param phones - колекція до серіалізації
	 * @throws Exception якщо файл є директорією або немає дозволу на запис
	 */
	public void writePhoneCollection(Store store) throws Exception {
		try (FileOutputStream outputStream = new FileOutputStream(PATH_TO_INPUT_FILE, false))
		{
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			
			oos.writeObject(store);
			
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new Exception("Помилка: Файл input.txt є директорією або немає дозволу на запис!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new Exception("Помилка під час запису до файла input.txt!");
		}
	}
}
