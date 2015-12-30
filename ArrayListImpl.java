class ArrayListImpl implements List{
	
	private Object[] internalArray;
	private int internalArrayCount;
	public static final int ARRAY_SIZE_START  = 1000000;
	
	public ArrayListImpl(){
		this.internalArray = new Object[this.ARRAY_SIZE_START];
		this.internalArrayCount = 0;
	}

    public boolean isEmpty(){
        if(this.internalArrayCount == 0)
            return true;
        else
             return false;
    }

    public int size(){
        return this.internalArrayCount;
    }

    
    public ReturnObject get(int index){
        ReturnObjectImpl roi = new ReturnObjectImpl("I'M A DUMMY - IMPLEMENT ME!");
        return roi;
    }

    public ReturnObject remove(int index){
        ReturnObjectImpl roi = new ReturnObjectImpl("I'M A DUMMY - IMPLEMENT ME!");
        return roi;
    }

    public ReturnObject add(int index, Object item){
        ReturnObjectImpl roi = new ReturnObjectImpl("I'M A DUMMY - IMPLEMENT ME!");
        return roi;
    }

   public ReturnObject add(Object item){
        ReturnObjectImpl roi = new ReturnObjectImpl("I'M A DUMMY - IMPLEMENT ME!");
        return roi;
   } 
}    
	
	
