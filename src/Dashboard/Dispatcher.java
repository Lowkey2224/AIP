package Dashboard;
import mps.MPSInstance;
import mps.MPSManager;

public class Dispatcher {

	public Monitor  monitor;
	
	public Dispatcher(Monitor frame) {
		monitor = frame;
	}

    public MPSManager remoteCall()
    {
        return getRunningMPS();
    }

	private MPSManager getRunningMPS()
	{
		return monitor.getRunningMPS();
	}
	
}
