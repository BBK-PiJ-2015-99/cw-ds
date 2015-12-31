class LinkedListImpl implements List {

    private LinkedListItem listStart;
    private int listCount = 0;

    public boolean isEmpty(){
        if (this.listCount() == 0)
            return true;
        else
            return false;
    }

    public int size(){
        return this.listCount;
    }

    public ReturnObjectImpl get(int index){
        ReturnObjectImpl roi = new ReturnObjectImpl("TODO - IMPLEMENT ME");
        return roi;
    }

    public ReturnObjectImpl remove(int index){
        ReturnObjectImpl roi = new ReturnObjectImpl("TODO - IMPLEMENT ME");
        return roi;
    }

    public ReturnObjectImpl add(int index, Object item){
        ReturnObjectImpl roi = new ReturnObjectImpl("TODO - IMPLEMENT ME");
        return roi;
    }

    public ReturnObjectImpl add(Object item){
        if (item == null) {
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return roi;
        }

        if (this.isEmpty()){
            this.listStart = new ListArrayItem(item);        
        }else{
            LinkedListItem pointer = this.nextItem;
            while(pointer.getNextItem != null){
                pointer = pointer.getNextItem();
            }
            pointer.setNextItem( ListArrayItem(item))
        }
    }        

        
        ReturnObjectImpl roi = new ReturnObjectImpl("TODO - IMPLEMENT ME");
        return roi;
    }
}
