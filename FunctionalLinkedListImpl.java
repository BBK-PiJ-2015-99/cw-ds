class FunctionalLinkedList extends LinkedListImpl {
    public ReturnObjectImpl head(){
        if( this.size() == 0){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }
        ReturnObjectImpl head = new ReturnObjectImpl(this.listStart.getValue());
        return roi;
    }


    public FunctionalLinkedList rest(){
        FunctionalLinkedList retFL = new FunctionalLinkedList();
        return retFL;

    }

}
