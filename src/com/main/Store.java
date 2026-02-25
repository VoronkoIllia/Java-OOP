package com.main;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.main.phones.Phone;


public class Store implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	/**
	 * склад телефонів
	 */
	private Map<Phone, Integer> inventory;
	/**
	 * чи відчинено магазин
	 */
	private boolean isOpen;
	
	public Store() {
		inventory = new HashMap<Phone, Integer>();
		setOpen(true);
	}

	
	
	/**
	 * додає новий телефон у магазин
	 * @param ph - телефон, що додається
	 * @param quantity - кількість, яку необхідно додати
	 */
	public void addNewPhone(Phone ph, int quantity) {
		if(quantity < 1) return;
		inventory.put(ph, inventory.getOrDefault(ph, 0) + quantity);
	}
	
	public Map<Phone, Integer> getAllPhones(){
		return inventory;
	}
	
	/**
	 * фільтрація товарів за назвою бренду
	 * @param brand - назва бренду, за якою виконується фільтрація
	 * @return - товари, що мають назву бренду brand
	 */
	public Map<Phone, Integer> filterPhonesByBrand(String brand){
		
		Map<Phone, Integer> filteredPhones = new HashMap<Phone, Integer>();
		for(Phone phone: inventory.keySet()) 
		{
			if(phone.getBrand().equals(brand)) 
			{
				filteredPhones.put(phone, inventory.get(phone));
			}
		}
		
		return filteredPhones;
	}
	
	/**
	 * фільтрація товарів за вартістю
	 * @param price - вартість, за якою виконується фільтрація
	 * @return товари, що мають вартість зі значенням price
	 */
	public Map<Phone, Integer> filterPhonesByPrice(double price){
		
		Map<Phone, Integer> filteredPhones = new HashMap<Phone, Integer>();
		for(Phone phone: inventory.keySet()) 
		{
			if(phone.getPrice() == price) 
			{
				filteredPhones.put(phone, inventory.get(phone));
			}
		}
		
		return filteredPhones;
	}

	/**
	 * фільтрація товарів за кольором
	 * @param color - колір, за яким виконується фільтрація
	 * @return товари, що мають значення color у полі кольору
	 */
	public Map<Phone, Integer> filterPhonesByColor(String color){
		
		Map<Phone, Integer> filteredPhones = new HashMap<Phone, Integer>();
		for(Phone phone: inventory.keySet()) 
		{
			if(phone.getBrand().equals(color)) 
			{
				filteredPhones.put(phone, inventory.get(phone));
			}
		}
		
		return filteredPhones;
	}

	
	
	/**
	 * @return the isOpen
	 */
	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * @param isOpen the isOpen to set
	 */
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	
}
