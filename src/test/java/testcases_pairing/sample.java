package testcases_pairing;

import utils.PassSTComment;
import wrappers.GenericWrappers;

public class sample extends GenericWrappers {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		PassSTComment ps=new PassSTComment();
		ps.stcomment("button_press\r");
		Thread.sleep(1000);
		ps.stcomment("button_press\r");
		Thread.sleep(1000);
		ps.stcomment("button_press\r");
		Thread.sleep(1000);
		ps.stcomment("button_press\r");
		

	}

}
