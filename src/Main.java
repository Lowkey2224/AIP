import Dashboard.Dispatcher;
import Dashboard.Monitor;

import java.awt.EventQueue;


public class Main {

	public static void main(String[] args) {
		
		// Monitor GUI starten
		Monitor frame = new Monitor();
		frame.setVisible(true);
		
		Dispatcher dispatcher = new Dispatcher( frame );
		
	}

}
