package utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import jssc.SerialPort;
import jssc.SerialPortException;

public class logReadandWrite {
	private SerialPort serialPort;
	private volatile boolean isWriting = false;
	 private final Path logFilePath = Path.of("serial_log.txt");

	public logReadandWrite(String portName) {
		serialPort = new SerialPort(portName);
	}

	public synchronized void openPort() throws SerialPortException {
		serialPort.openPort();
		serialPort.setParams(115200, 8, 1, 0);
	}

	public synchronized void write(String comment) {
		try {
			isWriting = true; // Set writing flag
			serialPort.writeBytes(comment.getBytes());
			System.out.println("Comment sent: " + comment);
		} catch (SerialPortException ex) {
			System.out.println("Error in writing: " + ex);
		} finally {
			isWriting = false; // Reset writing flag
		}
	}

	public void read() {
		new Thread(() -> {
			while (true) {
				if (!isWriting) { // Only read if not writing
					try {
						if (serialPort.isOpened()) { // Check if the port is opened
							String received = serialPort.readString();
							if (received != null) {
								String trimmedResponse = received.trim();
								System.out.println("Received: " + trimmedResponse);
								// Save to file if logging is enabled
								saveToFile(trimmedResponse);
							}
							if (received != null) {
								System.out.println("Received: " + received);
							}
						}
					} catch (SerialPortException ex) {
						System.out.println("Error in reading: " + ex);
					}
				}
			}
		}).start();
	}


	public synchronized void closePort() throws SerialPortException {
		serialPort.closePort();
	}
	
	private void saveToFile(String data) {
        try {
            Files.writeString(logFilePath, data + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
