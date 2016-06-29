package controller;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Test {

	public static void main(String args[]){
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
			
				System.out.println("aaa");
			}
		}, 0, 3000);
	}
}
