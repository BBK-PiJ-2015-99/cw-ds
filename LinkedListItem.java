class LinkedListItem {
    
    private Object valueStore ;
    private LinkedListItem nextItem;

    public LinkedListItem(Object value){
        this.valueStore = value;    
    }
    
    public LinkedListItem getNextItem(){
        return this.nextItem;
    }

    public void setNextItem(LinkedListItem nextItem){
        this.nextItem = nextItem;
    }

}
