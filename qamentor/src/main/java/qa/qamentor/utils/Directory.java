package qa.qamentor.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

import qa.qamentor.QAmentorReports;
import qa.qamentor.enums.ReportLabels;
import qa.qamentor.exceptions.QAmentorReporterException;
import qa.qamentor.writers.HTMLDesignFilesWriter;
/**
 * Configurations
 * @author Babu 
 *
 */
public class Directory {

	static Logger log = Logger.getLogger(Directory.class.getName());
	public static final String CURRENTDir = System.getProperty("user.dir");
	public static final String SEP = System.getProperty("file.separator");
	public static String REPORTSDIRName = "QAmentor Reports";
	public static String REPORTSDir = CURRENTDir + SEP + REPORTSDIRName;
	public static String RESULTSDir = REPORTSDir + SEP + "Results";
	public static String HTMLDESIGNDIRName = "HTML_Design_Files";
	public static String HTMLDESIGNDir = REPORTSDir + SEP + HTMLDESIGNDIRName;
	public static String CSSDIRName = "CSS";
	public static String CSSDir = HTMLDESIGNDir + SEP + CSSDIRName;
	public static String IMGDIRName = "IMG";
	public static String IMGDir = HTMLDESIGNDir + SEP + IMGDIRName;
	public static String JSDIRName = "JS";
	public static String JSDir = HTMLDESIGNDir + SEP + JSDIRName;
	public static String RUNName = "Test Execution_1"; // Babu
	public static String RUNDir = RESULTSDir + SEP + RUNName;
	public static String SETTINGSFile = RESULTSDir + SEP + "Settings.properties";
	public static final char JS_SETTINGS_DELIM = ';';
	public static final String REPO_DELIM = "##@##@##";
	public static final char JS_FILE_DELIM = ',';
	public static final String MENU_LINK_NAME = "Run ";
	public static final String SCREENSHOT_TYPE = "PNG";
	public static final String SCREENSHOT_EXTENSION = ".PNG";
	private static String logo = null;
	public static String SCREENSHOT_DIRName = "img";
	public static boolean generateConfigReports = true;
	public static boolean generateExcelReports = false;
	public static boolean takeScreenshot = false;
	public static boolean continueExecutionAfterStepFailed = false;
	public static boolean recordExecutionAvailable = false;
	public static boolean recordSuiteExecution = false;
	public static boolean recordTestMethodExecution = false;
	public static final String MAIN_RECORD_FILE_NAME = "ATU_CompleteSuiteRecording";
	public static String userName=null;
	public static String password=null;
	public static String smtpHost=null;
	public static String fromAddress=null;
	public static String toAddress=null;
	public static String ccAddress=null;
	//public static String bccAddress=null;
	public static String testCasePath=null;
	public static String ORSheetPath=null;
	public static String browser=null;
	public static String Subject=null;
	public static String Reports_Path=null;
	public static String Zipfolder_Path=null;
	public static String WaitFor=null;
	public static String uploadFilePath=null;
	public static String DEMO_URL=null;
	public static String URL_PROPERTIES=null;
	public static boolean reexecution=true;
	//Mobile Configuration
	public static String MOBILE_APPPATH=null;
	public static String MOBILEAPP_APK_NAME=null;
	public static String MOBILE_DEVICE_NAME=null;
	public static String MOBILE_DEVICE_VERSION=null;
	public static String MOBILE_APK_APPPACKAGE=null;
	public static String MOBILE_DEVICE_TYPE=null;
	public static String MOBILE_IOSDEVICE_UDID= null;
	public static String MOBILE_APP_TYPE=null;
	public static String MOBILE_WEB_BROWSER_NAME=null;
	public static String MOBILE_WEB_URL=null;
	//Resolution
	public static String MOBILE_SCREEN_RESOLUTION_SIZE=null;
	public static String WEB_SCREEN_RESOLUTION_SIZE=null;
	//CamSoda
	public static String CAM_SODA_URL=null;
	public static String CAM_SODA_USERNAME=null;
	public static String CAM_SODA_PASSWORD=null;
 
	
	/**
	 * Retrieve values from custom properties
	 * @throws QAmentorReporterException
	 * @throws Exception 
	 */
	public static void init() throws QAmentorReporterException, Exception {
		if (getCustomProperties() != null) {
			log.info("Reading from custom properties");
			Properties localProperties = new Properties();

			try {
				localProperties.load(new FileReader(getCustomProperties()));
				String reportsDir = localProperties.getProperty("qamentor.reports.dir")			.trim();
				String headerText = localProperties.getProperty(			"qamentor.proj.header.text").trim();
				logo = localProperties.getProperty("qamentor.proj.header.logo")			.trim();
				String projectDescription = localProperties.getProperty(			"qamentor.proj.description").trim();
				String takeScreenShot = localProperties.getProperty(			"qamentor.reports.takescreenshot").trim();
				String configReports = localProperties.getProperty(			"qamentor.reports.configurationreports").trim();
				String excelReport = localProperties.getProperty("qamentor.reports.excel")			.trim();
				String contExectution = localProperties.getProperty(			"qamentor.reports.continueExecutionAfterStepFailed").trim();
				String reExecution = localProperties.getProperty(			"qamentor.failures.reexecution").trim();

				userName = localProperties.getProperty(			"qamentor.mail.username").trim();
				password = localProperties.getProperty(			"qamentor.mail.password").trim();
				smtpHost = localProperties.getProperty(			"qamentor.mail.smtp.host").trim();
				fromAddress = localProperties.getProperty(			"qamentor.mail.from.address").trim();
				toAddress = localProperties.getProperty(			"qamentor.mail.to.address").trim();
				ccAddress = localProperties.getProperty(				"qamentor.mail.cc.address").trim();	
				Subject = localProperties.getProperty(				"qamentor.mail.subject").trim();
				Reports_Path = localProperties.getProperty(				"qamentor.reports.dir").trim();
				Zipfolder_Path = localProperties.getProperty(				"qamentor.mail.zipfolder").trim();
				testCasePath = localProperties.getProperty(			"qamentor.proj.testcasePath").trim();
				ORSheetPath = localProperties.getProperty(			"qamentor.proj.ORSheet.path").trim();
				browser = localProperties.getProperty(			"qamentor.browser.name").trim().toLowerCase();
				WaitFor = localProperties.getProperty(			"qamentor.proj.waitSec").trim().toLowerCase();
				uploadFilePath=localProperties.getProperty(			"qamentor.proj.upload").trim();

				//Mobile Configuration
				MOBILE_APPPATH=localProperties.getProperty(			"qamentor.mobileapp.apk.path").trim();
				MOBILEAPP_APK_NAME=localProperties.getProperty(			"qamentor.mobile.apk.name").trim();
				MOBILE_DEVICE_NAME=localProperties.getProperty(			"qamentor.mobile.devicename").trim();
				MOBILE_DEVICE_VERSION=localProperties.getProperty(			"qamentor.mobile.version").trim();
				MOBILE_APK_APPPACKAGE=localProperties.getProperty(			"qamentor.mobile.apppackage.name").trim();
				MOBILE_APP_TYPE = localProperties.getProperty(			"qamentor.mobile.app.type").trim();
				MOBILE_WEB_BROWSER_NAME = localProperties.getProperty(			"qamentor.mobile.web.browser").trim();
				MOBILE_WEB_URL = localProperties.getProperty(			"qamentor.mobile.web.Url").trim();
				MOBILE_DEVICE_TYPE = localProperties.getProperty(			"qamentor.mobile.device.type").trim();
				MOBILE_IOSDEVICE_UDID = localProperties.getProperty(			"qamentor.ios.mobile.udid").trim();
				//Resolution
				MOBILE_SCREEN_RESOLUTION_SIZE = localProperties.getProperty(			"qamentor.mobile.screen.resolution").trim();
				WEB_SCREEN_RESOLUTION_SIZE=localProperties.getProperty(			"qamentor.web.screen.resolution.size").trim();

				Properties urlProperties = new Properties();
				InputStream input = new FileInputStream(testCasePath+"/URL.properties");
				urlProperties.load(input);		
				CAM_SODA_URL = urlProperties.getProperty("qamentor.camsoda.url").trim();
				CAM_SODA_USERNAME = urlProperties.getProperty("qamentor.camsoda.username").trim();
				CAM_SODA_PASSWORD = urlProperties.getProperty("qamentor.camsoda.password").trim();

				try {
					if ((headerText != null) && (headerText.length() > 0)) {
						ReportLabels.HEADER_TEXT.setLabel(headerText);
					}
					if ((takeScreenShot != null) && (takeScreenShot.length() > 0)) {
						try {
							takeScreenshot = Boolean.parseBoolean(takeScreenShot);
						} catch (Exception localException1) {
						}
					}
					if ((reExecution != null) && (reExecution.length() > 0)) {
						try {
							reexecution = Boolean.parseBoolean(reExecution);
						} catch (Exception localException1) {
						}
					}
					if ((configReports != null) && (configReports.length() > 0)) {
						try {
							generateConfigReports = Boolean.parseBoolean(configReports);
						} catch (Exception localException2) {
						}
					}
					if ((excelReport != null) && (excelReport.length() > 0)) {
						try {
							generateExcelReports = Boolean.parseBoolean(excelReport);
						} catch (Exception localException3) {
						}
					}
					if ((contExectution != null) && (contExectution.length() > 0)) {
						try {
							continueExecutionAfterStepFailed = Boolean
									.parseBoolean(contExectution);
						} catch (Exception localException4) {
						}
					}
					/*if ((recordExecution != null) && (recordExecution.length() > 0)) {
			try {
			    RecordingFor localRecordingFor = RecordingFor
				    .valueOf(recordExecution.toUpperCase());
			    if (localRecordingFor == RecordingFor.SUITE) {
				recordSuiteExecution = true;
			    } else if (localRecordingFor == RecordingFor.TESTMETHOD) {
				recordTestMethodExecution = true;
			    }
			} catch (Throwable localThrowable) {
			}
		    }*/
					File outputFile = new File(Directory.Zipfolder_Path);
					if(!outputFile.exists()){
						outputFile.mkdir();
					}
					File file = new File(reportsDir);
					if(file.exists())
					{
						/*FileUtils.cleanDirectory(file); //clean out directory (this is optional -- but good know)
			            FileUtils.forceDelete(file);
						System.out.println("Report directory deleted");*/
					}
					if ((projectDescription != null) && (projectDescription.length() > 0)) {
						QAmentorReports.indexPageDescription = projectDescription;
					}
					if ((reportsDir != null) && (reportsDir.length() > 0)) {
						REPORTSDir = reportsDir;
						REPORTSDIRName = new File(REPORTSDir).getName();
						RESULTSDir = REPORTSDir + SEP + "Results";
						HTMLDESIGNDIRName = "HTML_Design_Files";
						HTMLDESIGNDir = REPORTSDir + SEP + HTMLDESIGNDIRName;
						CSSDIRName = "CSS";
						CSSDir = HTMLDESIGNDir + SEP + CSSDIRName;
						IMGDIRName = "IMG";
						IMGDir = HTMLDESIGNDir + SEP + IMGDIRName;
						JSDIRName = "JS";
						JSDir = HTMLDESIGNDir + SEP + JSDIRName;
						RUNName = "Run_";
						RUNDir = RESULTSDir + SEP + RUNName;
						SETTINGSFile = RESULTSDir + SEP + "Settings.properties";
					}
				} catch (Exception localException5) {
					throw new QAmentorReporterException(localException5.toString());
				}
			} catch (FileNotFoundException localFileNotFoundException) {
				throw new QAmentorReporterException(
						"The Path for the Custom Properties file could not be found");
			} catch (IOException localIOException) {
				throw new QAmentorReporterException(
						"Problem Occured while reading the qamentor Reporter Config File");
			}
		}
	}

	public static void mkDirs(String paramString) {
		File localFile = new File(paramString);
		if (!localFile.exists()) {
			localFile.mkdirs();
		}
	}

	public static boolean exists(String paramString) {
		File localFile = new File(paramString);
		return localFile.exists();
	}
	/**
	 * Verifying required files for report generation
	 * @throws Exception 
	 */
	public static void verifyRequiredFiles() throws Exception {
		init();
		log.info("Setting Reports Dir---"+REPORTSDir);
		log.info("Setting Results Dir---"+RESULTSDir);
		mkDirs(REPORTSDir);
		if (!exists(RESULTSDir)) {
			mkDirs(RESULTSDir);
			SettingsFile.initSettingsFile();
		}
		if (!exists(HTMLDESIGNDir)) {
			mkDirs(HTMLDESIGNDir);
			mkDirs(CSSDir);
			mkDirs(JSDir);
			mkDirs(IMGDir);
			HTMLDesignFilesWriter.writeCSS();
			HTMLDesignFilesWriter.writeIMG();
			HTMLDesignFilesWriter.writeJS();
		}
		if ((logo != null) && (logo.length() > 0)) {
			String str = new File(logo).getName();
			if (!new File(IMGDir + SEP + str).exists()) {
				copyImage(logo);
			}
			ReportLabels.PROJ_LOGO.setLabel(str);
		}
	}

	private static void copyImage(String paramString) throws QAmentorReporterException {
		File localFile = new File(paramString);
		if (!localFile.exists()) {
			return;
		}
		FileImageInputStream localFileImageInputStream = null;
		FileImageOutputStream localFileImageOutputStream = null;
		try {
			localFileImageInputStream = new FileImageInputStream(new File(
					paramString));
			localFileImageOutputStream = new FileImageOutputStream(new File(
					IMGDir + SEP + localFile.getName()));
			int i = 0;
			while ((i = localFileImageInputStream.read()) >= 0) {
				localFileImageOutputStream.write(i);
			}
			localFileImageOutputStream.close();
			return;
		} catch (Exception localException2) {
		} finally {
			try {
				localFileImageInputStream.close();
				localFileImageOutputStream.close();
				localFile = null;
			} catch (Exception localException4) {
				localFileImageInputStream = null;
				localFileImageOutputStream = null;
				localFile = null;
			}
		}
	}

	public static String getCustomProperties() {
		return System.getProperty("qamentor.reporter.config");
	}

	public static String createTestRunDateTime() {
		Calendar cal = Calendar.getInstance();
		return DateFormatUtils.format(cal, "dd-MM-yy, hh.mm aa");
	}

	public static String getTestRunDateTime(int run) {
		try {
			String testRun = SettingsFile.get("testRunDT");
			String timeArray [] = testRun.split(";");
			return timeArray[run-1];
		} catch (QAmentorReporterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return " ";
	}
}
