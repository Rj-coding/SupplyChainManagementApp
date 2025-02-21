package jsp.supplychainmanagementsystem.exception;

public class IdNotFoundException extends RuntimeException {
	 @Override
	   public String getMessage() {
		   return "Id is not found in DB";
	   }

}
