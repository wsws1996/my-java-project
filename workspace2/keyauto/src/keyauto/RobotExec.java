import java.awt.Robot;
import java.awt.event.KeyEvent;
public class RobotExec {

 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
	
  try
  {
   Robot robot=new Robot();
   while (true) {
	   pressKey(robot, KeyEvent.VK_DOWN);
	   robot.delay(1000*5);
   }
  }
  catch(Exception e)
  {
   System.out.println(e.getMessage());
  }

 }
 
 public static void pressKey(Robot robot,int keyvalue)
 {
  robot.keyPress(keyvalue);
  robot.keyRelease(keyvalue);
 }
}
