package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.main.phones.GamingSmartphone;
import com.main.phones.KeypadPhone;
import com.main.phones.Phone;
import com.main.phones.RuggedKeypadPhone;
import com.main.phones.Smartphone;


public class PhoneRepository {
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	
	public PhoneRepository(String dbUrl, String dbUsername, String dbPassword) {
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	
	/**
	 * записує об'єкт Phone до БД
	 * @param phone - об'єкт для запису
	 * @throws SQLException - у випадку помилки підключення до БД
	 */
	public void insert(Phone phone) throws SQLException
	{
		String query = """
				INSERT INTO phones (
			        type,
			        brand,
			        model,
			        price,
			        color,
			        has_physical_keyboard,
			        has_radio,
			        battery_capacity,
			        os,
			        size_memory,
			        size_ram,
			        has_nfc,
			        refresh_rate,
			        has_cooling_system,
			        is_waterproof,
			        is_shockproof
			    )
			    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
				""";
		
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)){
			PreparedStatement ps = conn.prepareStatement(query);
			
			// обнулення усіх специфічних полів
			
			// KeypadPhone
			ps.setNull(6, Types.BOOLEAN);
			ps.setNull(7, Types.BOOLEAN);
			ps.setNull(8, Types.INTEGER);

			// Smartphone
			ps.setNull(9, Types.VARCHAR);
			ps.setNull(10, Types.INTEGER);
			ps.setNull(11, Types.INTEGER);
			ps.setNull(12, Types.BOOLEAN);

			// GamingSmartphone
			ps.setNull(13, Types.INTEGER);
			ps.setNull(14, Types.BOOLEAN);

			// RuggedKeypadPhone
			ps.setNull(15, Types.BOOLEAN);
			ps.setNull(16, Types.BOOLEAN);
			
			
			// заповнюємо спільні поля
			ps.setString(1, detectType(phone).getString());
			ps.setString(2, phone.getBrand());
			ps.setString(3, phone.getModel());
			ps.setDouble(4, phone.getPrice());
			ps.setString(5, phone.getColor());
			
			// заповнення специфічних полів
			if(phone instanceof KeypadPhone kp) {
				ps.setBoolean(6, kp.isHasPhysicalKeyboard());
				ps.setBoolean(7, kp.isHasRadio());
				ps.setInt(8, kp.getBatteryCapacity());
			}
			if(phone instanceof Smartphone sp) {
				ps.setString(9, sp.getOS());
				ps.setInt(10, sp.getSizeMemory());
				ps.setInt(11, sp.getSizeRAM());
				ps.setBoolean(12, sp.getHasNFC());
			}
			if(phone instanceof GamingSmartphone gs) {
				ps.setInt(13, gs.getRefreshRate());
				ps.setBoolean(14, gs.isHasCoolingSystem());
			}
			if(phone instanceof RuggedKeypadPhone rk) {
				ps.setBoolean(15, rk.isWaterproof());
				ps.setBoolean(16, rk.isShockproof());
			}
			
			// запуск запиту
			ps.executeUpdate();
			
		}
		
		
	}
	
	/**
	 * визначення типу на основі класу об'єкта
	 * @param phone об'єкт Phone, тип якого потрібно визначити
	 * @return відповідний тип з enum PhoneTypes
	 */
	private static PhoneTypes detectType(Phone phone) {
		if(phone instanceof GamingSmartphone) {
			return PhoneTypes.GAMING_SMARTPHONE;
		}
		if(phone instanceof RuggedKeypadPhone) {
			return PhoneTypes.RUGGED_KEYPAD_PHONE;
		}
		if(phone instanceof Smartphone) {
			return PhoneTypes.SMARTPHONE;
		}
		if(phone instanceof KeypadPhone) {
			return PhoneTypes.KEYPAD_PHONE;
		}
		
		return PhoneTypes.PHONE;
	}
}
