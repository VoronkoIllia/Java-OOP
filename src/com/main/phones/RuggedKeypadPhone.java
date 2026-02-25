package com.main.phones;

import java.util.Objects;

/**
 * захищений кнопковий телефон
 */
public class RuggedKeypadPhone extends KeypadPhone {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * чи є водонепроникним
	 */
    private boolean isWaterproof;
    /**
     * чи є ударостійким
     */
    private boolean isShockproof;

    public RuggedKeypadPhone(String brand, String model, double price,
                             String color, boolean hasPhysicalKeyboard,
                             boolean hasRadio, int batteryCapacity,
                             boolean isWaterproof, boolean isShockproof) {

        super(brand, model, price, color, hasPhysicalKeyboard, hasRadio, batteryCapacity);

        this.isWaterproof = isWaterproof;
        this.isShockproof = isShockproof;
    }

    public boolean isWaterproof() {
        return isWaterproof;
    }

    public boolean isShockproof() {
        return isShockproof;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Водонепроникність: " + (isWaterproof ? "є" : "немає") + "\n" +
               "Ударостійкість: " + (isShockproof ? "є" : "немає");
    }
    
    
    @Override
    public boolean equals(Object obj) {
    	if(!super.equals(obj)) return false;
    	
    	RuggedKeypadPhone rp = (RuggedKeypadPhone)obj;
    	
    	return this.isShockproof == rp.isShockproof && this.isWaterproof == rp.isWaterproof;
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(super.hashCode(), isShockproof, isWaterproof);
    }
}