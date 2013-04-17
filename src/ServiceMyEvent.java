import java.util.EventObject;

import javax.swing.JOptionPane;

public class ServiceMyEvent implements MyEventClassListener {

	public static void main(String args[]) {
		ServiceMyEvent sv = new ServiceMyEvent();
		sv.startServicing();
	}

	public void startServicing() {
		(new MyEventSource(1000)).addEventListener(this);

		synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void handleMyEventClassEvent(EventObject e) {
		JOptionPane.showMessageDialog(null, "A custom event occurred",
				"Team Jobbs Message", JOptionPane.PLAIN_MESSAGE);
	}

}
