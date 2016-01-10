class LinkedListImpl implements List {

    private LinkedListItem listEnd;
    public LinkedListItem listStart;
    public int listCount = 0;
    
    public boolean isEmpty(){
        return this.listCount == 0;
    }

    public int size(){
        return this.listCount;
    }

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
                //System.out.println("-->" + pointer.getValue());
                pointer = pointer.getNextItem();    
            }
        } 
        ReturnObject roi = new ReturnObjectImpl(pointer.getValue());
        return roi;
    }

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
        this.listCount--;
        ReturnObjectImpl roi = new ReturnObjectImpl(returnDeletedItem.getValue());
        return roi;
    }

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
            for(int i = 1; i < index; i++){
                pointer = pointer.getNextItem();    
                nextItemPointer = pointer.getNextItem();
            }
            //if for loop finished/didn't run then nextItemPointer is the item to remove
            if(nextItemPointer.getNextItem() != null){
                //If the element to be removed (nextItemPointer) points at another element get that reference and make next of newItem
                LinkedListItem nextNextItemPointer = nextItemPointer.getNextItem();
                newItem.setNextItem(nextNextItemPointer);
            }
            pointer.setNextItem(newItem);
        }else{
            //if new item is to be inserted at index 0 then pointer will already be set to head
            newItem.setNextItem(pointer);
            this.listStart = newItem;
        } 
        this.listCount++;
        ReturnObject roi = new ReturnObjectImpl(null);
        return roi;
    }

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
