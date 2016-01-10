class TestStackImpl {
    public static void main(String[] args){
        
        Stack si_null_list = new StackImpl(null);
        System.out.println("Running here");
        boolean noException=true;
        try {
            si_null_list.pop(); 
        } catch (NullPointerException e){
             noException=false;
        }
        if(noException){
            System.out.println("TestStackImpl - no exception when operating on Stack with null list");
        }
        StackImpl si = new StackImpl(new LinkedListImpl());
        
        si.push("1");
        si.push("2");
        si.push("3");
      
        System.out.println("Starting TestStackImpl"); 
        if (si.isEmpty() || !(si.size()==3))
            System.out.println("TestStackImpl-Failed- isEmpty() or size() are wrong aftera adding 3 elements");
        
        ReturnObject r1, r2,r3; 
        r1 = si.pop();
        r2 = si.pop();
        if (si.isEmpty() ||  !r1.getReturnValue().equals("3") || !r2.getReturnValue().equals("2") )
            System.out.println("TestStackImpl-Failed-Popping 2 values from the list caused an error");
        r3 = si.top();
        if(!r3.getReturnValue().equals("1") || si.isEmpty())
            System.out.println("TestStackImp-Failed- top() not returning corret value and/or emptying the stack");
        r1 = si.pop();
        r2 = si.pop();
        if(!r2.hasError() || !(r2.getError()==ErrorMessage.EMPTY_STRUCTURE)){
            System.out.println("TestStackImp-Failed- pop() on empty list doesn't produce an error or error isn't correct");
            System.out.println(r2.getError());
        }
        r1 = si.top();
        System.out.println(r1.getError());
        System.out.println("Finished TestStackImpl"); 

    }
}
