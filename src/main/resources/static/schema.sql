-- Create the drones table
CREATE TABLE drones (
                        drone_id SERIAL PRIMARY KEY,
                        drone_name VARCHAR(255) NOT NULL
);

-- Create the motors table
CREATE TABLE motors (
                        id SERIAL PRIMARY KEY,
                        drone_id INT REFERENCES drones(drone_id) ON DELETE CASCADE,
                        voltage DOUBLE PRECISION,
                        voltageRef DOUBLE PRECISION,
                        timestamp TIMESTAMPTZ
);

-- Create the sensors table using single table inheritance
CREATE TABLE sensors (
                         id SERIAL PRIMARY KEY,
                         drone_id INT REFERENCES drones(drone_id) ON DELETE CASCADE,
                         timestamp TIMESTAMPTZ,
                         type_sensor VARCHAR(255),

    -- Common columns for all sensor types
                         Wx DOUBLE PRECISION,
                         Wy DOUBLE PRECISION,
                         Wz DOUBLE PRECISION,
                         temperature DOUBLE PRECISION,
                         magX DOUBLE PRECISION,
                         magY DOUBLE PRECISION,
                         magZ DOUBLE PRECISION,
                         gyroX DOUBLE PRECISION,
                         gyroY DOUBLE PRECISION,
                         gyroZ DOUBLE PRECISION,

    -- Discriminator column to specify sensor type
                         CONSTRAINT chk_sensor_type CHECK (type_sensor IN ('IMU', 'Temperature', 'DOF'))
);

-- Add indexes for performance (optional)
CREATE INDEX idx_drone_id ON motors(drone_id);
CREATE INDEX idx_drone_id_sensors ON sensors(drone_id);

-- Add constraints to enforce data integrity
ALTER TABLE sensors ADD CONSTRAINT sensors_wx_null CHECK (type_sensor != 'IMU' OR Wx IS NOT NULL);
ALTER TABLE sensors ADD CONSTRAINT sensors_wy_null CHECK (type_sensor != 'IMU' OR Wy IS NOT NULL);
ALTER TABLE sensors ADD CONSTRAINT sensors_wz_null CHECK (type_sensor != 'IMU' OR Wz IS NOT NULL);

ALTER TABLE sensors ADD CONSTRAINT sensors_grades_null CHECK (type_sensor != 'Temperature' OR temperature IS NOT NULL);

ALTER TABLE sensors ADD CONSTRAINT sensors_mag_x_null CHECK (type_sensor != 'DOF' OR magX IS NOT NULL);
ALTER TABLE sensors ADD CONSTRAINT sensors_mag_y_null CHECK (type_sensor != 'DOF' OR magY IS NOT NULL);
ALTER TABLE sensors ADD CONSTRAINT sensors_mag_z_null CHECK (type_sensor != 'DOF' OR magZ IS NOT NULL);
ALTER TABLE sensors ADD CONSTRAINT sensors_gyro_x_null CHECK (type_sensor != 'DOF' OR gyroX IS NOT NULL);
ALTER TABLE sensors ADD CONSTRAINT sensors_gyro_y_null CHECK (type_sensor != 'DOF' OR gyroY IS NOT NULL);
ALTER TABLE sensors ADD CONSTRAINT sensors_gyro_z_null CHECK (type_sensor != 'DOF' OR gyroZ IS NOT NULL);
