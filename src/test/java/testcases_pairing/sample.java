package testcases_pairing;

import utils.ContinuousLogReceiver;
import utils.PassSTComment;
import wrappers.GenericWrappers;

public class sample extends GenericWrappers {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ContinuousLogReceiver lr=new ContinuousLogReceiver();
		//lr.logrReceiver();
		PassSTComment.stcomment("button_press\r");
		Thread.sleep(2000);
		PassSTComment.stcomment("button_press\r");
		Thread.sleep(2000);
		PassSTComment.stcomment("button_press\r");
		Thread.sleep(2000);
		PassSTComment.stcomment("button_press\r");
	}

}
