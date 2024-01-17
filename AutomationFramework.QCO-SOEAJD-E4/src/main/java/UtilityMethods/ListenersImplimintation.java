package UtilityMethods;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimintation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----Test Execution started----");
		
		test=report.createTest(methodName);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----Test passed----");
		test.log(Status.PASS, methodName+" ###TEST PASSED### ");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----Test failed----");
		System.out.println(result.getThrowable());
		
		test.log(Status.FAIL, methodName+"###TestFailed###");
		test.log(Status.INFO, result.getThrowable());
		
		SeleniumUtilities s=new SeleniumUtilities();
		JavaUtility j=new JavaUtility();
		String ScreenShotName=methodName+"-"+j.getSystemDate();
		
		try 
		{
			String path=s.captureScreenshot(BaseClass.sDriver, ScreenShotName);
			test.addScreenCaptureFromPath(path);
		} 
		
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----Test skipped----");
		System.out.println(result.getThrowable());
		
		test.log(Status.SKIP,methodName+"###Test Skipped###");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("---suite execution started");
		

		ExtentSparkReporter htmlrep=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlrep.config().setDocumentTitle("Execution Report");
		htmlrep.config().setTheme(Theme.DARK);
		htmlrep.config().setReportName("VTiger execution Report");
		
	    report=new ExtentReports();
		report.attachReporter(htmlrep);
		report.setSystemInfo("BasePlatform", "Windows");
		report.setSystemInfo("Base Browser","Edge");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Manisha");
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("---suite execution finished");
		report.flush();
		
	}

}
