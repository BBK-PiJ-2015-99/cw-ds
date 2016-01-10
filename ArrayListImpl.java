class ArrayListImpl implements List{
	
	private Object[] internalArray;
	private int internalArrayCount;
	private static final int ARRAY_SIZE_START  = 1000000;
	private int internalArrayCapacity;
    
	public ArrayListImpl(){
		this.internalArray = new Object[this.ARRAY_SIZE_START];
		this.internalArrayCount = 0;
        this.internalArrayCapacity = this.ARRAY_SIZE_START;
	}
    public boolean isEmpty(){
        return this.internalArrayCount == 0;
    }

    public int size(){
        return this.internalArrayCount;
    }
    public ReturnObject get(int index){
        //System.out.println(index + "---" + this.internalArrayCount);
        if (index < 0 || index >= this.internalArrayCount ){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }
        if (this.size()==0){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }

        ReturnObject roi = new ReturnObjectImpl(this.internalArray[index]);
        //System.out.println(this.internalArray[index]);
        return roi;
    }

    public ReturnObject remove(int index){
        if (index < 0 || index >= this.internalArrayCount ){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }
        if (this.size()==0){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }
        ReturnObject roi = new ReturnObjectImpl(this.internalArray[index]);
        this.internalArray[index] = null;
        //shift all entries one to the left if the entry to be removed isn't the last one
        if(index != this.internalArrayCount-1){
            // stop at this.internalArrayCount-1 because we go to i+1
            for(int i = index; i < this.internalArrayCount-1; i++){
                 this.internalArray[i] = this.internalArray[i+1];    
            }  
        }
        this.internalArrayCount --;
        return roi;
    }

   public ReturnObject add(Object item){
        if (item == null) {
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return roi;
        }else{
           if(this.internalArrayCapacity==this.internalArrayCount){
               this.increaseCapacity();
           }
           this.internalArray[this.internalArrayCount] = item; 
           this.internalArrayCount+=1;
            
        } 
        ReturnObject roi = new ReturnObjectImpl(null);
        return roi;
   }
   
    private void increaseCapacity(){
        this.internalArrayCapacity *= 2;
        Object[] newInternalArray = new Object[this.internalArrayCapacity];
        for(int i =0; i<=this.internalArray.length-1; i++){
            newInternalArray[i] = this.internalArray[i];
        }     
        this.internalArray = newInternalArray;
    }

    public ReturnObject add(int index, Object item){
        if (item == null) {
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return roi;
        }
        if (index < 0 || index >= this.internalArrayCount ){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }
        if (this.size()==0){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }
        if(index == this.internalArrayCount-1){
            this.add(item);
        }
        //if element is not to be added at the end. insert item.
        //Check that there is enough space
        if(this.internalArrayCount - this.internalArrayCapacity < 1  )
            this.increaseCapacity();
       
        //now that there is enough space. Shift all items, starting at the last one, up by one
        for(int i=this.internalArrayCount-1; i>=index; i--){
            this.internalArray[i+1] = this.internalArray[i]; 
        }
        this.internalArray[index] = item;
        this.internalArrayCount++;
        ReturnObject roi = new ReturnObjectImpl(null);
        return roi;
    }            
}    
	
	
