public class FunctionalArrayListImpl extends ArrayListImpl {

    public ReturnObjectImpl head(){

        if(this.size() == 0  ){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }

        ReturnObjectImpl headItem = new ReturnObjectImpl(this.internalArray[0]);
        return headItem;
    }
    
    public FunctionalArrayListImpl rest(){
        FunctionalArrayListImpl retFALI= new FunctionalArrayListImpl();
        for(int i=1; i<=this.internalArrayCount ; i++){
            retFALI.add(this.internalArray[i]);
        }
        return retFALI;
    }
}
