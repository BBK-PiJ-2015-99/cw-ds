public class FunctionalArrayListImpl extends ArrayListImpl {

    public ReturnObjectImpl head(){

        if(this.size() == 0  ){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }

        ReturnObjectImpl headItem = this.get(0);
        return headItem;
    }
    
    public FunctionalArrayListImpl rest(){
        FunctionalArrayListImpl retFALI= new FunctionalArrayListImpl();
        for(int i=1; i<=this.size()-1 ; i++){
            //System.out.println(this.get(i).getReturnValue());
            retFALI.add(this.get(i).getReturnValue());
        }
        return retFALI;
    }
}
