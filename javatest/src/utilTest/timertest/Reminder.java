package utilTest.timertest;

import java.util.Timer;
import java.util.TimerTask;

public class Reminder {

	Timer timer;

	public Reminder(int seconds) {
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000);
	}

	class RemindTask extends TimerTask {
		public void run() {
			System.out.println("Time's up!");
			timer.cancel(); // Terminate the timer thread
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("About to schedule task.");
		new Reminder(5);
		System.out.println("Task scheduled.");
	}

}
