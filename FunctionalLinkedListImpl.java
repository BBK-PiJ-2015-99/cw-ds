public class FunctionalLinkedListImpl extends LinkedListImpl implements FunctionalList {

    private FunctionalListAbstract fla = new FunctionalListAbstract();
    
    public FunctionalList rest(){
        FunctionalList newList = new FunctionalLinkedListImpl();
        this.fla.internalRest(this, newList);
        return newList;
    }    
    public ReturnObject head(){
        ReturnObject roi = this.fla.internalHead(this);
        return roi;
    }
    
}
