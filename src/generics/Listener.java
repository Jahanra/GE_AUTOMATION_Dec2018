package generics;

import org.apache.log4j.Logger;
import org.testng.*;

import static base.AutomationConstants.SNAP_PATH;

public class Listener extends TestListenerAdapter
{
	public Logger log;
	public Listener() {

	log=Logger.getLogger(this.getClass());
}

	@Override
	public void onTestStart(ITestResult tr) {

		log.info("Test Started....");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		log.info("Test '" + tr.getName() + "' PASSED");

		// This will print the class name in which the method is present
		log.info(String.valueOf(tr.getTestClass()));

		// This will print the priority of the method.
		// If the priority is not defined it will print the default priority as
		// 'o'
		log.info("Priority of this method is " + tr.getMethod().getPriority());

		System.out.println(".....");
	}

	@Override
	public void onTestFailure(ITestResult tr)
	{

		Utility.getScreenShot1(SNAP_PATH);
		log.info("Test '" + tr.getName() + "' FAILED");
		log.info("Priority of this method is " + tr.getMethod().getPriority());
		System.out.println(".....");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log.info("Test '" + tr.getName() + "' SKIPPED");
		System.out.println(".....");
	}

	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
	}
}


