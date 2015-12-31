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
