package qa.qamentor.exceptions;

public class QAmentorReporterStepFailedException
extends RuntimeException {

	public QAmentorReporterStepFailedException() {}

	public QAmentorReporterStepFailedException(String paramString) {}

	public String toString()  {
		return "[Custom Reporter Step Failed Exception]";
	}
}

