CREATE TABLE phones (

    id SERIAL PRIMARY KEY,
    type VARCHAR(30) NOT NULL CHECK (
	    type IN (
	        'PHONE',
	        'KEYPAD_PHONE',
	        'SMARTPHONE',
	        'GAMING_SMARTPHONE',
	        'RUGGED_KEYPAD_PHONE'
	    )
	),

    -- поля базового класу Phone
    brand VARCHAR(50),
    model VARCHAR(50),
    price NUMERIC(10,2),
    color VARCHAR(30),

    -- KeypadPhone
    has_physical_keyboard BOOLEAN,
    has_radio BOOLEAN,
    battery_capacity INTEGER,

    -- Smartphone
    os VARCHAR(30),
    size_memory INTEGER,
    size_ram INTEGER,
    has_nfc BOOLEAN,

    -- GamingSmartphone
    refresh_rate INTEGER,
    has_cooling_system BOOLEAN,

    -- RuggedKeypadPhone
    is_waterproof BOOLEAN,
    is_shockproof BOOLEAN
);