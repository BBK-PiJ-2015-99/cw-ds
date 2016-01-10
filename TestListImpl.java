class TestListImpl {
    public static void main(String[] input){
        List testList = new ArrayListImpl();
        System.out.println("Starting  tests for ListImpl:ArrayList");
        runTests(testList);
        testList = new LinkedListImpl();
        System.out.println("Starting  tests for ListImpl:LinkedList");
        runTests(testList);
    }

    private static void runTests(List testList){
        if(!testList.isEmpty() || !(testList.get(0).getError()!= ErrorMessage.EMPTY_STRUCTURE))
            System.out.println("TestArrayListImpl-Failed: !.isEmpty() returned true after object creation  - or wrong error on get");
        if(testList.size()!=0)
            System.out.println("TestArrayListImpl-Failed: size()!=0 after object creation");
        testList.add("Hello,");
        testList.add("is it me");
        testList.add("you're looking for");
        if(testList.isEmpty())
            System.out.println("TestArrayListImpl-Failed: isEmpty() on non empty list");
        if(testList.size()!=3)
            System.out.println("TestArrayListImpl-Failed: size()!=3 when 3 elements are in list");
        ReturnObject errRetObj = testList.add(null);
        if(errRetObj.getError()!=ErrorMessage.INVALID_ARGUMENT)
            System.out.println("TestArrayListImpl-Failed: getError()!=ErrorMessage.INVALID_ARGUMENT when invalid argument was supplied");
        ReturnObject nullRetObj = testList.add("Lionel Richie");
        if(nullRetObj.getReturnValue()!=null)
            System.out.println("TestArrayListImpl-Failed: nullRetObj!=null  when valid argument was supplied");
        int counter = 1000000-4;
        //int counter = 10-4;
        //fill array up to initial capacity
        while (counter>0){
            testList.add("Element:" + counter);
            counter-= 1;
        }
        
        testList.add("Will I fit?");
        /*
        System.out.println(testList.get(0).getReturnValue());
        System.out.println(testList.get(1).getReturnValue());
        System.out.println(testList.get(2).getReturnValue());
        System.out.println(testList.get(3).getReturnValue());
        */
        if(testList.size()!= 1000001)
            System.out.println("TestArrayListImpl-Failed: size()!=1000001 after adding element that expands list beyond default capacity");

        if(!testList.get(0).getReturnValue().equals("Hello,") || !testList.get(500000).getReturnValue().equals("Element:500000") || !testList.get(testList.size()-1).getReturnValue().equals("Will I fit?"))
            System.out.println("TestArrayListImpl-Failed: get() not returning first, middle and last elements correctly");
/*
            System.out.println("First element:" + testList.get( 0 ).getReturnValue().equals("Hello,"));
            System.out.println("Middle element:" + testList.get( 500000 ).getReturnValue().equals("Element:500000"));
            System.out.println("Last element:" + testList.get(testList.size()-1).getReturnValue().equals("Will I fit?"));
                
            System.out.println("First element:" + testList.get( 0 ).getReturnValue());
            System.out.println("Middle element:" + testList.get( 500000 ).getReturnValue());
            System.out.println("Last element:" + testList.get(testList.size()-1).getReturnValue());
*/
        ReturnObject errRoiOutOfBounds = testList.get(-1); 
        ReturnObject errRoiOutOfBounds2 = testList.get(testList.size());
        if (errRoiOutOfBounds.getError() != ErrorMessage.INDEX_OUT_OF_BOUNDS && errRoiOutOfBounds2.getError() != ErrorMessage.INDEX_OUT_OF_BOUNDS   )
            System.out.println("TestArrayListImpl-Failed: get(-1) or get(2000001) did not return an error message");
        ReturnObject roiNullIdxAdd = testList.add(0, "Let me in!");
        if(!testList.get(0).getReturnValue().equals("Let me in!") || !testList.get(testList.size()-1).getReturnValue().equals("Will I fit?") || !testList.get(500001).getReturnValue().equals("Element:500000"))
            System.out.println("TestArrayListImpl-Failed: after insert did not retrieve correct, first, middle and last value");
             //System.out.println("First element:" + testList.get( 0 ).getReturnValue());
             //System.out.println("Middle element:" + testList.get( 500001 ).getReturnValue());
             //System.out.println("Last element:" + testList.get(testList.size()-1).getReturnValue());
             //System.out.println("List Size:" +testList.size());
       if(roiNullIdxAdd != null)
              System.out.println("TestArrayListImpl-Failed: roiNullIdxAdd != null - inserting with index did not return null"); 
        int sizeBeforeRemoving = testList.size();
        ReturnObject roiRemoveLast = testList.remove(testList.size()-1);
        ReturnObject roiRemoveMiddle = testList.remove(500001);
        ReturnObject roiRemoveFirst = testList.remove(0);
        if(!testList.get( 0 ).getReturnValue().equals("Hello,") || !testList.get( 500001 ).getReturnValue().equals("Element:499998") || !testList.get(testList.size()-1).getReturnValue().equals("Element:1")  )
              System.out.println("TestArrayListImpl-Failed: get() AFTER removing items produced unexpected output");  

        if(!roiRemoveFirst.getReturnValue().equals("Let me in!") || !roiRemoveMiddle.getReturnValue().equals("Element:500000") || !roiRemoveLast.getReturnValue().equals("Will I fit?") || !(testList.size() == sizeBeforeRemoving  - 3 ) )
              System.out.println("TestArrayListImpl-Failed: items returned BY remove were not as expected");  

        
    }
}

