package com.main.phones;

import java.util.Objects;

public class KeypadPhone extends Phone {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * чи має клавіатуру
	 */
	private boolean hasPhysicalKeyboard;
	/**
	 * чи має радіо
	 */
	private boolean hasRadio;
	/**
	 * ємність батареї
	 */
    private int batteryCapacity;
    

    public KeypadPhone() {}
    
	public KeypadPhone(String brand, String model, double price, String color, boolean hasPhysicalKeyboard, boolean hasRadio, int batteryCapacity) {
		super(brand, model, price, color);
		
		this.hasPhysicalKeyboard = hasPhysicalKeyboard;
		this.hasRadio = hasRadio;
		this.batteryCapacity = batteryCapacity;
	}


	/**
	 * @return the hasPhysicalKeyboard
	 */
	public boolean isHasPhysicalKeyboard() {
		return hasPhysicalKeyboard;
	}


	/**
	 * @param hasPhysicalKeyboard the hasPhysicalKeyboard to set
	 */
	public void setHasPhysicalKeyboard(boolean hasPhysicalKeyboard) {
		this.hasPhysicalKeyboard = hasPhysicalKeyboard;
	}


	/**
	 * @return the hasRadio
	 */
	public boolean isHasRadio() {
		return hasRadio;
	}


	/**
	 * @param hasRadio the hasRadio to set
	 */
	public void setHasRadio(boolean hasRadio) {
		this.hasRadio = hasRadio;
	}


	/**
	 * @return the batteryCapacity
	 */
	public int getBatteryCapacity() {
		return batteryCapacity;
	}


	/**
	 * @param batteryCapacity the batteryCapacity to set
	 * @throws Exception if batteryCapacity less or equal zero
	 */
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public String toString() {
		return super.toString() + "\n"
		+ "Ємність батареї: " + this.batteryCapacity + " mAh\n"
		+ "Радіо: " + (this.hasRadio ? "є" : "відсутнє") + "\n"
		+ "Фізична клавіатура: " + (this.hasPhysicalKeyboard ? "є" : "відсутня");
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		
		KeypadPhone keypadPhone = (KeypadPhone)obj;
		
		return this.hasPhysicalKeyboard == keypadPhone.hasPhysicalKeyboard
				&& this.hasRadio == keypadPhone.hasRadio
				&& this.batteryCapacity == keypadPhone.batteryCapacity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), hasPhysicalKeyboard, hasRadio, batteryCapacity);
	}
}
