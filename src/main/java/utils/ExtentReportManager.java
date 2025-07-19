package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    public static ExtentReports getReportObject(){
        String filePath = System.getProperty("user.dir") + "/extentreports/index.html";
        ExtentSparkReporter report = new ExtentSparkReporter(filePath);
        report.config().setReportName("Kunal Selenium 2025");
        report.config().setDocumentTitle("Automation Report");
        report.config().setTheme(Theme.STANDARD);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Tester","Kunal Chavan");
        extent.setSystemInfo("System","Mac");
        extent.setSystemInfo("Browser","Chrome");
        return extent;
    }

}
