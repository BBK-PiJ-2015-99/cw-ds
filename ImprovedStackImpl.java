/**
 * An implementation of a stack with additional methods. 
 * 
 * Classes implementing this interface must use a {@see List} as the
 * underlying data structure to store the elements on the stack. 
 * 
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 * 
 * @author David Asfaha
 */
public class ImprovedStackImpl implements ImprovedStack{
    private List internalList;
    public ImprovedStackImpl(List internalList){
        this.internalList = internalList;
    }
	/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	public ImprovedStackImpl reverse(){
        ImprovedStackImpl newList = new ImprovedStackImpl(new LinkedListImpl());
        for(int i =this.size()-1;i>=0; i-- ){
            newList.push(this.internalList.get(i).getReturnValue());
        }
        return newList;
    }
	/**
	 * Removes the given object from the stack if it is
	 * there. Multiple instances of the object are all removed.
	 *
	 * Classes implementing this method must use method .equals() to
	 * check whether the item is in the stack or not.
	 * 
	 * @param object the object to remove
	 */
	public void remove(Object object){
        for (int i=0; i<=this.size()-1; i++){    
            if(this.internalList.get(i).getReturnValue().equals(object)){
                this.internalList.remove(i);
            }
        }
    }
    public boolean isEmpty(){
        return this.internalList.isEmpty();
    }
    public int size(){
        return this.internalList.size();
    }   
    public void push(Object item){
        this.internalList.add(item);
    }
    public ReturnObject top(){
        ReturnObject  roi = this.internalList.get(this.internalList.size()-1);
        return roi;
    }
    public ReturnObject pop(){
        if (this.size()==0){
            ReturnObject roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }
        ReturnObject  retObject = this.internalList.remove(this.internalList.size()-1);
        ReturnObject  roi = retObject; 
        return roi;
    }
}

