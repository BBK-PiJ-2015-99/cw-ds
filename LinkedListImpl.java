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
class LinkedListImpl implements List {

    private LinkedListItem listEnd;
    public LinkedListItem listStart;
    public int listCount = 0;
    
    /**
     * Returns true if the list is empty, false otherwise. 
     * 
     * @return true if the list is empty, false otherwise. 
     */
    public boolean isEmpty(){
        return this.listCount == 0;
    }
    /**
     * Returns the number of items currently in the list.
     * 
     * @return the number of items currently in the list
     */
    public int size(){
        return this.listCount;
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
        if (index < 0 || index >= this.listCount ){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }
        if(this.size()==0){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }      
        LinkedListItem pointer = this.listStart;
        if(index != 0) {
            for(int i = 0; i < index; i++){
                //System.out.println("Linked List Get Item:" + i + "---" + index + "---" + this.listCount + "--" + pointer.getValue());
                //System.out.println("Pointer next item" + pointer.getNextItem());
                pointer = pointer.getNextItem();    
            }
        } 
        ReturnObject roi = new ReturnObjectImpl(pointer.getValue());
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
        if (index < 0 || index >= this.listCount ){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }
        if(this.size()==0){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }      
        LinkedListItem pointer = this.listStart;
        LinkedListItem returnDeletedItem;
        if(index != 0) {
            LinkedListItem nextItemPointer = pointer.getNextItem();
            for(int i = 1; i < index; i++){
                pointer = pointer.getNextItem();    
                nextItemPointer = pointer.getNextItem();
            }
            //if for loop finished/didn't run then nextItemPointer is the item to remove
            returnDeletedItem = nextItemPointer;
            if(nextItemPointer.getNextItem() != null){
                pointer.setNextItem(nextItemPointer.getNextItem() );
            }else{
                pointer.setNextItem(null);
            }
        }else{
            returnDeletedItem = pointer;
            pointer = pointer.getNextItem();
            this.listStart = pointer;
        } 
        System.out.println("LL Remove--->" + index + returnDeletedItem.getValue());
        this.listCount--;
        ReturnObjectImpl roi = new ReturnObjectImpl(returnDeletedItem.getValue());
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
    public ReturnObject add(int index, Object item){
        if (index < 0 || index >= this.listCount ){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }
        if(this.size()==0){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }      
        if (item == null) {
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return roi;
        }
        LinkedListItem newItem = new LinkedListItem(item);
        LinkedListItem pointer = this.listStart;

        if(pointer.getNextItem() != null){
            LinkedListItem nextItemPointer = pointer.getNextItem();
        }
        if(index != 0) {
            LinkedListItem nextItemPointer = pointer.getNextItem();
            for(int i = 1; i <= index; i++){
                pointer = pointer.getNextItem();    
                nextItemPointer = pointer.getNextItem();
            }
            //if for loop finished/didn't run then nextItemPointer is the item to remove
            if(nextItemPointer != null){
                //If the element to be removed (nextItemPointer) points at another element get that reference and make next of newItem
                    System.out.println("Inserting at OTHER THAN head: " + newItem.getValue());
                LinkedListItem nextNextItemPointer = nextItemPointer.getNextItem();
                newItem.setNextItem(nextNextItemPointer);
            }
            pointer.setNextItem(newItem);
        }else{
            //if new item is to be inserted at index 0 then pointer will already be set to head
            System.out.println("Inserting at head: " + newItem.getValue());
            newItem.setNextItem(pointer);
            this.listStart = newItem;
        } 
        this.listCount++;
        ReturnObject roi = new ReturnObjectImpl(null);
        return roi;
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
    public ReturnObject add(Object item){
        if (item == null) {
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return roi;
        }
        if (this.isEmpty()){
            LinkedListItem newListItem = new LinkedListItem(item);        
            this.listStart = newListItem;
            this.listEnd = newListItem;
        }else{
            LinkedListItem newListItem = new LinkedListItem(item);
            this.listEnd.setNextItem(newListItem);
            this.listEnd = newListItem;
        }
        this.listCount += 1;
        ReturnObject roi = new ReturnObjectImpl(null);
        return roi;
    }
}
