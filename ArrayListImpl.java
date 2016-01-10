/**
 * A list is a collection of objects that are sorted and can be
 * accessed by index. The first element in the list is at index 0.
 *
 * A list can store objects of any kind, and they can be of different
 * types: Integers, Doubles, String, or even other lists. However,
 * this list cannot store null objects.
 * 
 * There is no limit to the number of elements in the list (provided
 * that there is free memory in the Java Virtual Machine).
 * 
 * Not all operations on a list will always be successful. For
 * example, a programmer may try to remove an element from an empty
 * list, or from a position where there is nothing. Since we hace not
 * covered exceptions yet, we need another mechanism to report
 * errors. In order to do that, methods of this list will return a
 * {@see ReturnObject} that will contain either an object or an error
 * value of the right kind (as defined in {@see ErrorMessage}). 
 * 
 * @author David Asfaha
 */
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
    /**
     * Returns true if the list is empty, false otherwise. 
     * 
     * @return true if the list is empty, false otherwise. 
     */
    public boolean isEmpty(){
        return this.internalArrayCount == 0;
    }
    /**
     * Returns the number of items currently in the list.
     * 
     * @return the number of items currently in the list
     */
    public int size(){
        return this.internalArrayCount;
    }
    /**
     * Returns the element at the given position. 
     * 
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     * 
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message, 
     *         encapsulated in a ReturnObject
     */
    public ReturnObject get(int index){
        if (index < 0 || index >= this.internalArrayCount ){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }
        if (this.size()==0){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }

        ReturnObject roi = new ReturnObjectImpl(this.internalArray[index]);
        return roi;
    }
    /**
     * Returns the elements at the given position and removes it
     * from the list. The indeces of elements after the removed
     * element must be updated accordignly.
     * 
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     * 
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message, 
     *         encapsulated in a ReturnObject
     */
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
    /**
     * Adds an element to the list, inserting it at the given
     * position. The indeces of elements at and after that position
     * must be updated accordignly.
     * 
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     * 
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     * 
     * @param index the position at which the item should be inserted in
     *              the list
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         or containing an appropriate error message otherwise
     */
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
    /**
     * Adds an element at the end of the list.
     * 
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     * 
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         or containing an appropriate error message otherwise
     */
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
	
	
