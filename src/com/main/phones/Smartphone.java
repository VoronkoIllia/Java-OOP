package com.main.phones;

import java.util.Objects;

public class Smartphone extends Phone {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * операційна система смартфона
	 */
	private String os;
	/**
	 * об'єм внутрішньох пам'яті смартфона, вимірюється у GB
	 */
	private int sizeMemory;
	/**
	 * об'єм оперативної пам'яті смартфона, вимірюється у GB
	 */
	private int sizeRAM;
	/**
	 * чи є в нявності NFC-модуль
	 */
	private boolean hasNFC;
	
	
	
	public Smartphone(String brand, String model, double price, String color, String os, int sizeMemory, int sizeRAM, boolean hasNFC) {
		super(brand, model, price, color);
		
		this.os = os;
		this.sizeMemory = sizeMemory;
		this.sizeRAM = sizeRAM;
		this.hasNFC = hasNFC;
	}


	public String getOS() {
		return os;
	}
	
	/**
	 * встановлює операційну систему телефона
	 * @param os - операційна система телефона
	 * @throws Exception - якщо os порожній рядок
	 */
	public void setOS(String os) throws Exception {
		if(os.length() != 0) {	
			this.os = os;
		}
		else {
			throw new Exception("Назва операційної системи не повинна бути порожньою!");
		}
	}
	
	
	public int getSizeMemory() {
		return sizeMemory;
	}
	
	/**
	 * встановлює об'єм внутрішньої пам'яті
	 * @param sizeMemory - об'єм оперативної пам'яті у гігабайтах
	 * @throws Exception - якщо sizeMemory рівний або менше за нуль
	 */
	public void setSizeMemory(int sizeMemory) throws Exception {
		if(sizeMemory > 0) {	
			this.sizeMemory = sizeMemory;
		}
		else {
			throw new Exception("Об'єм внутрішної пам'яті повинен бути більшим за нуль!");
		}
	}
	
	public int getSizeRAM() {
		return sizeRAM;
	}
	
	/**
	 * встановлює об'єм оперативної пам'яті
	 * @param sizeRAM - об'єм оперативної пам'яті у гігабайтах
	 * @throws Exception - якщо sizeRAM рівний або менше за нуль
	 */
	public void setSizeRAM(int sizeRAM) throws Exception {
		
		if(sizeRAM > 0) {	
			this.sizeRAM = sizeRAM;
		}
		else {
			throw new Exception("Об'єм оперативної пам'яті повинен бути більшим за нуль!");
		}
	}

	/**
	 * @return the hasNFC
	 */
	public boolean getHasNFC() {
		return hasNFC;
	}

	/**
	 * @param hasNFC the hasNFC to set
	 */
	public void setHasNFC(boolean hasNFC) {
		this.hasNFC = hasNFC;
	}

	@Override
	public String toString() {
		return super.toString() + "\n"
		+ "Операційна система: "+ this.os + "\n"
		+ "Внутрішня пам'ять: " + this.sizeMemory + " ГБ\n"
		+ "Оперативна пам'ять: " + this.sizeRAM + " ГБ\n"
		+ "NFC-модуль: " + (this.hasNFC ? "є" : "відсутнє");
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!super.equals(obj)) return false;
		
		Smartphone smartphone = (Smartphone)obj;
		
		return this.os.equals(smartphone.os)
				&& this.sizeMemory == smartphone.sizeMemory
				&& this.sizeRAM == smartphone.sizeRAM
				&& this.hasNFC == smartphone.hasNFC;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), os, sizeMemory, sizeRAM, hasNFC);
	}
}
