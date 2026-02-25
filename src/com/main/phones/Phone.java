package com.main.phones;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * бренд смартфона
	 */
	private String brand;
	/**
	 * модель смартфона
	 */
	private String model;
	/**
	 * вартість смартфона
	 */
	private double price;

	/**
	 * колір смартфона
	 */
	private String color;
	
	/**
	 * кількість створених смартфонів
	 */

	// конструктор за замовчуванням
	public Phone() {
		this.brand = "no brand";
		this.model = "no model";
		this.price = 0.01;
		this.color = "transparent";
		
	}
	
	// конструктор з параметрами
	
	/**
	 * 
	 * @param brand - бренд телефона
	 * @param model - модель телефона
	 * @param os -операційна система телефона
	 * @param price - вартість телефона
	 * @param sizeMemory - об'єм внутрішньої пам'яті телефона
	 * @param sizeRAM - об'єм оперативної пам'яті телефона
	 * @param color - колір телефона
	 * @throws Exception - якщо який-небудь параметр має неприпустиме значення
	 */
	public Phone(String brand, String model, double price, String color)
	{
		// заповнення полів об'єкта
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.color = color;
		
	}

	// конструктор копіювання
	public Phone(Phone phone) {
		this.brand = phone.brand;
		this.model = phone.model;
		this.price = phone.price;
		this.color = phone.color;
		
	}
	
	public String getBrand() {
		return brand;
	}
	
	/**
	 * встановлює бренд телефона
	 * @param brand - бренд телефона
	 * @throws Exception - якщо brand порожній рядок
	 */
	public void setBrand(String brand) throws Exception {
		if(brand.length() != 0) {			
			this.brand = brand;
		}
		else {
			throw new Exception("Назва бренду не повинна бути порожньою!");
		}
	}
	
	public String getModel() {
		return model;
	}
	
	/**
	 * встановлює модель телефона
	 * @param model - модель телефона
	 * @throws Exception - якщо model порожній рядок
	 */
	public void setModel(String model) throws Exception {
		if(model.length() != 0) {	
			this.model = model;
		}
		else {
			throw new Exception("Назва моделі не повинна бути порожньою!");
		}
	}
	
	public double getPrice() {
		return price;
	}
	
	/**
	 * встановлює вартість телефона
	 * @param price - вартість телефона в умовних одиницях
	 * @throws Exception - якщо price рівний або менше за нуль
	 */
	public void setPrice(double price) throws Exception {
		if(price > 0) {	
			this.price = price;
		}
		else {
			throw new Exception("Вартість телефона повинна бути більшою за нуль!");
		}
	}
	
	
	
	public String getColor() {
		return color;
	}
	
	/**
	 * встановлює колір телефона
	 * @param color - колір телефона
	 * @throws Exception - якщо color порожній рядок
	 */
	public void setColor(String color) throws Exception {
		if(color.length() != 0) {	
			this.color = color;
		}
		else {
			throw new Exception("Назва кольору не повинна бути порожньою!");
		}
	}
	
	@Override
	public String toString() {
		return "Бренд: " + this.brand +"\n"
			 + "Модель: " + this.model + "\n"
		+ "Вартість: " + this.price + " у. о. \n"
		+ "Колір: " + this.color;
		
	}
	
	@Override
	public boolean equals(Object phone) {
		if (this == phone) return true;
	    if (phone == null || getClass() != phone.getClass()) return false;
		
		return this.brand.equals(((Phone)phone).brand) && 
				this.model.equals(((Phone)phone).model)
				&& this.color.equals(((Phone)phone).color);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(brand, model, color);
	}
	
}