package Dashboard;

import Dashboard.Dispatcher;
import Dashboard.Monitor;

import java.awt.EventQueue;


public class Main {

	public static void main(String[] args) {
		
		// Monitor GUI starten
		Monitor frame = new Monitor(args[0], args[1]);
		frame.setVisible(true);
		
		Dispatcher dispatcher = new Dispatcher( frame );
        frame.setDispatcher(dispatcher);
		
	}

}
