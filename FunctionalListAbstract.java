/**
* FunctionalList code that is shared between 
* both types of list (linked list and array list)
*
* @author David Asfaha
**/


public class FunctionalListAbstract  {
    
    /**
    * Implementation of head from FunctionalList interface for code that is 
    * shared between both types of lists
    * @param list to apply  head to
    * @return first element of list
    **/  
    public ReturnObject internalHead( FunctionalList list){
        if(list.size() == 0  ){
            ReturnObjectImpl roi = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return roi;
        }
        ReturnObject headItem = list.get(0);
    return headItem;
    }
    /**
    * Implementation of rest from FunctionalList interface for code that is 
    * shared between both types of lists
    * @param list to apply  head to, and new list
    * @return return the new list
    **/  
    public FunctionalList  internalRest(FunctionalList list, FunctionalList newList){
        for(int i=1; i<=list.size()-1 ; i++){
            newList.add(list.get(i).getReturnValue());
        }
        return newList;
    }
}
