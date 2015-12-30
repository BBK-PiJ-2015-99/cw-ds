class ArrayListImpl implements List{
	
	private Object[] internalArray;
	private int internalArrayCount;
	public static final int ARRAY_SIZE_START  = 1000000;
	private int internalArrayCapacity;
    
	public ArrayListImpl(){
		this.internalArray = new Object[this.ARRAY_SIZE_START];
		this.internalArrayCount = 0;
        this.internalArrayCapacity = this.ARRAY_SIZE_START;
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
        if (index < 0 || index > this.internalArrayCapacity ){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }

        ReturnObjectImpl roi = new ReturnObjectImpl(this.internalArray[index]);
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

   public ReturnObjectImpl add(Object item){
        if (item == null) {
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return roi;
        }else{
           if(this.internalArrayCapacity==this.internalArrayCount){
                this.internalArrayCapacity *= 2;
                Object[] newInternalArray = new Object[this.internalArrayCapacity];
                for(int i =0; i<=this.internalArray.length-1; i++){
                    newInternalArray[i] = this.internalArray[i];
                }     
                this.internalArray = newInternalArray;
           }
           this.internalArray[this.internalArrayCount] = item; 
           this.internalArrayCount+=1;
            
        } 
        return null;
   }
   
   private void doubleCapacity(){
    // Double the capacity of the array
   }
}    
	
	
