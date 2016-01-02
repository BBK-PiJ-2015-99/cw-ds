class TestImprovedStackImpl {
    public static void main(String[] args){
        ImprovedStackImpl si = new ImprovedStackImpl(new LinkedListImpl());

        si.push("1");
        si.push("2");
        si.push("3");
      
        System.out.println("Starting TestImprovedStackImpl"); 
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
        
        si.push("i1");
        si.push("i2");
        si.push("i3");
        si.remove("i1");
        if(!(si.size()==2)  || !si.top().getReturnValue().equals("i3")){
            System.out.println("Size:" + si.size());
            System.out.println("Top valuei:" + si.top().getReturnValue());
            System.out.println("TestStackImp-Failed- pop() - Value not removed correclty. ");    
        }
        ImprovedStackImpl nl = si.reverse();
        r1 = nl.pop();
        r2 = nl.pop();

        if(  !(r1.getReturnValue().equals("i2") && r2.getReturnValue().equals("i3") ))
            System.out.println("TestStackImp-Failed-reverse() not working correctly");
        System.out.println("Finished TestImprovedStackImpl"); 
    }
}
