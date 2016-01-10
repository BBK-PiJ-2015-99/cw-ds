public class FunctionalLinkedListImpl extends LinkedListImpl implements FunctionalList {
    private FunctionalListAbstract fla = new FunctionalListAbstract();
    /*
     *  Most of the functionality in FunctionalList is common to both types of list, except returning a new list in rest.
     *  So the implementation specific functional lists are responsible for creating new lists of its own kind and dispatch
     *  all common functionality to FunctionalListAbstract, which they can access through composition.
     *                     */ 
    /**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
    public FunctionalList rest(){
        FunctionalList newList = new FunctionalLinkedListImpl();
        this.fla.internalRest(this, newList);
        return newList;
    }    
    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
    public ReturnObject head(){
        ReturnObject roi = this.fla.internalHead(this);
        return roi;
    }
    
}
