class LinkedListImpl implements List {

    private LinkedListItem listEnd;
    private LinkedListItem listStart;
    private int listCount = 0;

    public boolean isEmpty(){
     if (this.listCount == 0)
            return true;
        else
            return false;
    }

    public int size(){
        return this.listCount;
    }

    public ReturnObjectImpl get(int index){
        if (index < 0 || index >= this.listCount ){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }
        
        LinkedListItem pointer = this.listStart;
        if(index != 0) {
            for(int i = 0; i < index; i++){
                //System.out.println("-->" + pointer.getValue());
                pointer = pointer.getNextItem();    
            }
        } 
        ReturnObjectImpl roi = new ReturnObjectImpl(pointer.getValue());
        return roi;
    }

    public ReturnObjectImpl remove(int index){
        if (index < 0 || index >= this.listCount ){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return roi;
        }
        LinkedListItem pointer = this.listStart;
        if(index != 0) {
            LinkedListItem nextItemPointer = pointer.getNextItem();
            for(int i = 1; i < index; i++){
                //System.out.println("-->" + pointer.getValue());
                pointer = pointer.getNextItem();    
                nextItemPointer = pointer.getNextItem();
            }
            //if for loop finished/didn't run then nextItemPointer is the item to remove
            if(nextItemPointer.getNextItem() != null){
                pointer.setNextItem(nextItemPointer.getNextItem() );
            }else{
                pointer.setNextItem(null);
            }
        }else{
            pointer = pointer.getNextItem();
            this.listStart = pointer;
        } 
        this.listCount--;
        return null;
    }

    public ReturnObjectImpl add(int index, Object item){
        if (index < 0 || index >= this.listCount ){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
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
            for(int i = 1; i < index; i++){
                pointer = pointer.getNextItem();    
                nextItemPointer = pointer.getNextItem();
            }
            //if for loop finished/didn't run then nextItemPointer is the item to remove
            if(nextItemPointer.getNextItem() != null){
                //If the element to be removed (nextItemPointer) points at another element get that reference and make next of newItem
                LinkedListItem nextNextItemPointer = pointer.setNextItem(nextItemPointer.getNextItem() );
                nextItem.setNextItem(nextNextItemPointer);
            }
            pointer.setNextItem(nextItem);
        }else{
            //if new item is to be inserted at index 0 then pointer will already be set to head
            newItem.setNextItem(pointer);
            this.listStart = newItem;
        } 
        this.listCount++=;
        return null;
    }

    public ReturnObjectImpl add(Object item){
        if (item == null) {
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return roi;
        }
        //System.out.println("Creating" + item);
        if (this.isEmpty()){
            LinkedListItem newListItem = new LinkedListItem(item);        
            this.listStart = newListItem;
            this.listEnd = newListItem;
        }else{
            LinkedListItem newListItem = new LinkedListItem(item);
            this.listEnd.setNextItem(newListItem);
            this.listEnd = newListItem;

            /*
            LinkedListItem pointer = this.listStart;
              System.out.println(pointer.getValue());
            while(pointer.getNextItem() != null){
                 System.out.print("-->" + pointer.getNextItem().getValue());
                 pointer = pointer.getNextItem();
            }
            System.out.println("===================");
        */
        }
        this.listCount += 1;
        return null;
    }
}
