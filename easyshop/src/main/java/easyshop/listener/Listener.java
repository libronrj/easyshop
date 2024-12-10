package easyshop.listener;

import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import easyshop.genericutility.ThreadLocalManager;

/*
 * Author: Libron John
 * Created: 2024 November 9
 * 
 * Description: This is the ITestListener and ISuiteListener implementation class required to monitor the actions of the test scripts
 * This class will present the info in the generated reports and take a screenshot if a test fails
 */

public class Listener implements ITestListener, ISuiteListener {

	private ExtentSparkReporter sparkreporter;
	private ExtentReports reports;
	private ExtentTest test;

	@Override
	public void onStart(ISuite suite) {

		String time = Calendar.getInstance().getTime().toString().replace(" ", "_").replace(":", "_");
		sparkreporter = new ExtentSparkReporter("./target/advance-report/Report" + time + ".html");
		sparkreporter.config().setDocumentTitle("EasyShop ECommerce Project Report");
		sparkreporter.config().setReportName("EasyShop ECommerce Test Reports");
		sparkreporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(sparkreporter);
		reports.setSystemInfo("OS", "Ubuntu");
		reports.setSystemInfo("Browsers", "Chrome and Edge");
		reports.setSystemInfo("Environment", "Test Environment");
	}

	@Override
	public void onFinish(ISuite suite) {
		reports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {

		String testname = result.getMethod().getMethodName();
		test = reports.createTest(testname);
		ThreadLocalManager.setTest(test);
		test.log(Status.INFO, testname + " has STARTED");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testname = result.getMethod().getMethodName();
		ExtentTest test = ThreadLocalManager.getTest(); 
		test.log(Status.PASS, testname + " has PASSED");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String time = Calendar.getInstance().getTime().toString().replace(" ", "_").replace(":", "_");
		String testname = result.getMethod().getMethodName();
		ExtentTest test = ThreadLocalManager.getTest();
		test.log(Status.FAIL, testname + " has FAILED");

		TakesScreenshot takesscreenshot = (TakesScreenshot) ThreadLocalManager.getDriver();
		String filepath = takesscreenshot.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, testname + "_" + time);

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String testname = result.getMethod().getMethodName();
		ExtentTest test = ThreadLocalManager.getTest();
		test.log(Status.SKIP, testname + " has SKIPPED");
	}

}
