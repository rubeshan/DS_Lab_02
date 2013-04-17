import java.util.EventObject;

import javax.swing.JOptionPane;

public class ServiceMyEventThread implements MyEventClassListener {

	public static void main(String args[]) {
		ServiceMyEventThread sv = new ServiceMyEventThread();
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
		MyGUI hello = new MyGUI();
		hello.inputText.setText("Action happned");
		//JOptionPane.showMessageDialog(null, "A custom event occurred",	"Team Jobbs Message", JOptionPane.PLAIN_MESSAGE);
	}

}
