package jsp.supplychainmanagementsystem.exception;

public class NameNotFoundException extends RuntimeException {
	 @Override
	   public String getMessage() {
		   return "Name is not found in DB";
	   }
}
