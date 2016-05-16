package keyauto;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotExec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Robot robot = new Robot();
			while (true) {
				pressKey(robot, KeyEvent.VK_DOWN);
				robot.delay(1000 * 2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void pressKey(Robot robot, int keyvalue) {
		robot.keyPress(keyvalue);
		robot.keyRelease(keyvalue);
	}
}
