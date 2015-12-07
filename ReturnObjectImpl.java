public class ReturnObjectImpl implements ReturnObject {
	
	private Object retObject;
	private ErrorMessage errMessage;
	
	public ReturnObjectImpl(ErrorMessage errMessage){
		this.errMessage = errMessage;
		this.retObject = null;
	}
	
	public ReturnObjectImpl(Object retObject){
		this.retObject = retObject;
		this.errMessage = ErrorMessage.NO_ERROR;
	}
	
	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError(){
		return this.errMessage != ErrorMessage.NO_ERROR;	
	}

	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError(){
		return this.errMessage;
	}

	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an error
	 */
	public Object getReturnValue(){
		return this.retObject;
	}
}
