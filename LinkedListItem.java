/*
This is a clqss of nodes for list list implementation of List

@author David Asfaha
*/

class LinkedListItem {
    
    private Object valueStore ;
    private LinkedListItem nextItem;

    public LinkedListItem(Object value){
        this.valueStore = value;    
    }
    /**
    * Returns the value held in this node
    *
    * @return Object held in node
    **/
    public Object getValue(){
        return this.valueStore;
    }    
    /**
    * Returns the next node in the list
    *
    * @return Next linked list node
    **/
    public LinkedListItem getNextItem(){
        return this.nextItem;
    }
    /**
    * Set next node in the list
    *
    * @return Set next linked list node
    **/
    public void setNextItem(LinkedListItem nextItem){
        this.nextItem = nextItem;
    }

}
