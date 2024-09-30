package utils;
import jssc.SerialPort;
import jssc.SerialPortException;

public class PassSTComment {

	public static void stcomment(String comment) {
		try {

		// Open the serial port
		SerialPort serialPort = new SerialPort("COM4");
		serialPort.openPort();
		serialPort.setParams(115200, 8, 1, 0);

		// Send the comment via UART
		serialPort.writeBytes(comment.getBytes());
		System.out.println("Comment sent successfully : "+comment);

		// Read response (if any)
		//byte[] buffer = serialPort.readBytes(1024);
		//String response = new String(buffer).trim();
		//System.out.println("Response: " + response);

		//Close the serial port
		serialPort.closePort();
	} catch (SerialPortException e) {
		System.out.println("Error: " + e.getMessage());
	}
}
}