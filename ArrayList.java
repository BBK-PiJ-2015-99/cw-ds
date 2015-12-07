class ArrayList implements List{
	
	private Object[] internalArray;
	private int internalArrayCount;
	public static final int ARRAY_SIZE_START  = 1000000;
	
	public ArrayList(){
		this.internalArray = new Object[this.ARRAY_SIZE_START];
		this.internalArrayCount = 0;
	}
	
	
	
}