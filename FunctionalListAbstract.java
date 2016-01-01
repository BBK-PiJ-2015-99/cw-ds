public class FunctionalListAbstract  {
    
    public ReturnObject internalHead( FunctionalList list){
        if(list.size() == 0  ){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }
        ReturnObject headItem = list.get(0);
    return headItem;
    }
    public FunctionalList  internalRest(FunctionalList list, FunctionalList newList){
        for(int i=1; i<=list.size()-1 ; i++){
            //System.out.println(this.get(i).getReturnValue());
            list.add(newList.get(i).getReturnValue());
        }
        return newList;
    }
}
