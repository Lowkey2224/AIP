package Dashboard;
import mps.MPSInstance;

public class Dispatcher {
	
	public int      counterCalls = 0;
	public Monitor  monitor;
	
	public Dispatcher(Monitor frame) {
		monitor = frame;
	}

	public MPSInstance getRunningMPS()
	{
		return monitor.getRunningMPS();
	}
	
}
