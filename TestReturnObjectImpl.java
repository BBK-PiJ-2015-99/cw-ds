class TestReturnObjectImpl {
	public static void main(String[] input){
		ReturnObjectImpl roVal = new ReturnObjectImpl("Test");
        System.out.println("Starting tests for ReturnObjectImpl");
		if(roVal.hasError())
			System.out.println("TestReturnObjectImpl-Failed: hasError()==True on valid return object");
		if(roVal.getError()!=ErrorMessage.NO_ERROR)
			System.out.println("TestReturnObjectImpl-Failed: getError()!='NO_ERROR' on valid return object");
		if(roVal.getReturnValue()!="Test")
			System.out.println("TestReturnObjectImpl-Failed: getReturnValue() wrong on valid return object");
		
		ReturnObjectImpl roErr = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		if(!roErr.hasError())
			System.out.println("TestReturnObjectImpl-Failed: hasError()==False on error");
		if(roErr.getError()!=ErrorMessage.INDEX_OUT_OF_BOUNDS)
			System.out.println("TestReturnObjectImpl-Failed: getError() wrong error returned on error");
		if(roErr.getReturnValue()!=null)
			System.out.println("TestReturnObjectImpl-Failed: getReturnValue() is not null on error");
        System.out.println("Finished tests for ReturnObjectImpl");
		
	}
	
	
}
