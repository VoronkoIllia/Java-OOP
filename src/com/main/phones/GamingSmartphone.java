package com.main.phones;

import java.util.Objects;

/**
 * ігровий смартфон
 */
public class GamingSmartphone extends Smartphone {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * частота оновлення екрану у Гц
	 */
    private int refreshRate;
    /**
     * чи має охолоджувальну систему
     */
    private boolean hasCoolingSystem;

    public GamingSmartphone(String brand, String model, double price, String color, String os, 
    		int sizeMemory, int sizeRAM, boolean hasNFC, int refreshRate, boolean hasCoolingSystem) {

        super(brand, model, price, color, os, sizeMemory, sizeRAM, hasNFC);

        this.refreshRate = refreshRate;
        this.hasCoolingSystem = hasCoolingSystem;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public boolean isHasCoolingSystem() {
        return hasCoolingSystem;
    }

    /**
     * запускає гру на пристрої
     * @param gameName - назва гри
     */
    public void playGame(String gameName) {
    	System.out.printf("На пристрої %s %s запущено гру %s\n", this.getBrand(), this.getModel(), gameName);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Частота оновлення: " + refreshRate + " Гц\n" +
               "Система охолодження: " + (hasCoolingSystem ? "є" : "немає");
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(!super.equals(obj)) return false;
    	
    	GamingSmartphone gs = (GamingSmartphone)obj;
    	
    	return this.refreshRate == gs.refreshRate && this.hasCoolingSystem == gs.hasCoolingSystem;
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(super.hashCode(), refreshRate, hasCoolingSystem);
    }
}