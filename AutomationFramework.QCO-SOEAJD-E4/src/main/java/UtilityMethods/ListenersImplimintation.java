package UtilityMethods;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplimintation implements ITestListener
{

	public void onTestStart(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----Test Execution started----");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----Test passed----");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----Test failed----");
		System.out.println(result.getThrowable());
		SeleniumUtilities s=new SeleniumUtilities();
		JavaUtility j=new JavaUtility();
		String ScreenShotName=methodName+"-"+j.getSystemDate();
		try {
			s.captureScreenshot(BaseClass.sDriver, ScreenShotName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----Test skipped----");
		System.out.println(result.getThrowable());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("---suite execution started");
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("---suite execution finished");
		
	}

}
