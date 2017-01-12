package qa.qamentor.exceptions;

public class QAmentorReporterException
extends Exception
{
	private String message;

	public QAmentorReporterException() {}

	public QAmentorReporterException(String message)  {
		this.message = message;
	}

	public String toString()  {
		return "[Custom Reporter Exception] " + this.message;
	}
}
