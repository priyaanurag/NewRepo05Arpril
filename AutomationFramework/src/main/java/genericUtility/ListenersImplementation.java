package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	
	ExtentReports reports;// Global variable 
	ExtentTest test;// Global variable

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "=======OnTestStarted");
		reports.createTest(methodname);// New added 
		test= reports.createTest(methodname);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "=======OnTestPassed===============");
		test.log(Status.PASS, methodname +"======Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "=======OnTestFailure");
		test.log(Status.FAIL, methodname +"==========Failed");
		test.log(Status.INFO,result.getThrowable());
		
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();

		String screenshotname1 = methodname + "- " + jutil.toGetSystemDateAndTime();
		try {
			String path =wutil.takescreenshot(BaseClass.sdriver, screenshotname1);// store the path of sc in one reference.
			test.addScreenCaptureFromPath(path);// path reference 
		} catch (IOException e) {
			// TODO Auto-generated catch block++
			e.printStackTrace();
			
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "=======Skipped");
		test.log(Status.SKIP, methodname +"Skipped");
		test.log(Status.INFO,result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("====Suite Execution Stared");
		
		
		// ExtentsReports
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReports/Reports-"+new JavaUtility().toGetSystemDateAndTime()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution Report")  ;
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTIGER EXECUTION REPORT");
		
		
		 reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		reports.setSystemInfo("BaseUrl", "gttps://localhost:8888/");
		reports.setSystemInfo("UserName", "admin");
		reports.setSystemInfo("Password", "password");
		reports.setSystemInfo("Reporter Name", "Anurag ");
		
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("=======Suite Execution Finished");
		reports.flush();

	}

}
