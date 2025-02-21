package jsp.supplychainmanagementsystem.exception;

public class NoRecordFoundException extends RuntimeException {
	 @Override
	   public String getMessage() {
		   return "No Record found in DB";
	   }
}
