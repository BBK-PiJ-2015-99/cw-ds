class ArrayLinkedListItem {
    
    private Object valueStore ;
    private ArrayLinkedListItem nextItem;

    public ArrayLinkedListItem(Object value){
        this.valueStore = value;    
    }
    
    public ArrayLinkedListItem getNextItem(){
        return this.nextItem;
    }

    public void setNextItem(ArrayLinkedListItem nextItem){
        this.nextItem = nextItem;
    }

}
