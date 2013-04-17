import java.awt.List;
import java.util.ArrayList;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.Timer;

public class MyEventSource {
	int delay_ms = 1000;
	
	MyEventSource(int delay){
		delay_ms=delay;
		
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fireEvent();
			}
		};
		
		new Timer(delay_ms, taskPerformer).start();
	}
	
	private ArrayList<MyEventClassListener> _listeners = new ArrayList<MyEventClassListener>();
	
	public synchronized void addEventListener(MyEventClassListener listener){
		_listeners.add(listener);
	}
	
	public synchronized void  removeEventListener(MyEventClassListener listener){
		_listeners.remove(listener);
	}

	// call this method whenever you want to notify
	//the event listeners of the particular event
	private synchronized void fireEvent(){
		MyEventClass event = new MyEventClass(this);		
		Iterator<MyEventClassListener> i = _listeners.iterator();		
		while(i.hasNext()){
			((MyEventClassListener) i.next()).handleMyEventClassEvent(event);
		}
	}


}



