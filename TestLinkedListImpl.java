class TestArrayListImpl {
    public static void main(String[] input){
        ArrayListImpl testArray = new ArrayListImpl();
        System.out.println("Starting tests for TestArrayListImpl");
        if(!testArray.isEmpty())
            System.out.println("TestArrayListImpl-Failed: !.isEmpty() returned true after object creation");
        if(testArray.size()!=0)
            System.out.println("TestArrayListImpl-Failed: size()!=0 after object creation");
        testArray.add("Hello,");
        testArray.add("is it me");
        testArray.add("you're looking for");
        if(testArray.isEmpty())
            System.out.println("TestArrayListImpl-Failed: isEmpty() on non empty list");
        if(testArray.size()!=3)
            System.out.println("TestArrayListImpl-Failed: size()!=3 when 3 elements are in list");
        ReturnObjectImpl errRetObj = testArray.add(null);
        if(errRetObj.getError()!=ErrorMessage.INVALID_ARGUMENT)
            System.out.println("TestArrayListImpl-Failed: getError()!=ErrorMessage.INVALID_ARGUMENT when invalid argument was supplied");
        ReturnObjectImpl nullRetObj = testArray.add("Lionel Richie");
        if(nullRetObj!=null)
            System.out.println("TestArrayListImpl-Failed: nullRetObj!=null  when valid argument was supplied");
        int counter = 1000000-4;
        //fill array up to initial capacity
        while (counter>0){
            testArray.add("Element:" + counter);
            counter-= 1;
        }
        testArray.add("Will I fit?");
        if(testArray.size()!= 1000001)
            System.out.println("TestArrayListImpl-Failed: size()!=1000001 after adding element that expands list beyond default capacity");
        //System.out.println("Number of elements in array are: " + testArray.size());
        if(!testArray.get(0).getReturnValue().equals("Hello,") || !testArray.get(500000).getReturnValue().equals("Element:500000") || !testArray.get(testArray.size()-1).getReturnValue().equals("Will I fit?"))
            /*System.out.println("First element:" + testArray.get( 0 ).getReturnValue().equals("Hello,"));
            System.out.println("Middle element:" + testArray.get( 500000 ).getReturnValue().equals("Element:500000"));
            System.out.println("Last element:" + testArray.get(testArray.size()-1).getReturnValue().equals("Will I fit?"));*/
                
            System.out.println("TestArrayListImpl-Failed: get() not returning first, middle and last elements correctly");
        ReturnObjectImpl errRoiOutOfBounds = testArray.get(-1); 
        ReturnObjectImpl errRoiOutOfBounds2 = testArray.get(testArray.size());
        if (errRoiOutOfBounds.getError() != ErrorMessage.INDEX_OUT_OF_BOUNDS && errRoiOutOfBounds2.getError() != ErrorMessage.INDEX_OUT_OF_BOUNDS   )
            System.out.println("TestArrayListImpl-Failed: get(-1) or get(2000001) did not return an error message");
        ReturnObjectImpl roiNullIdxAdd = testArray.add(0, "Let me in!");
        if(!testArray.get(0).getReturnValue().equals("Let me in!") || !testArray.get(testArray.size()-1).getReturnValue().equals("Will I fit?") || !testArray.get(500001).getReturnValue().equals("Element:500000"))
            System.out.println("TestArrayListImpl-Failed: after insert did not retrieve correct, first, middle and last value");
             //System.out.println("First element:" + testArray.get( 0 ).getReturnValue());
             //System.out.println("Middle element:" + testArray.get( 500001 ).getReturnValue());
             //System.out.println("Last element:" + testArray.get(testArray.size()-1).getReturnValue());
             //System.out.println("List Size:" +testArray.size());
       if(roiNullIdxAdd != null)
              System.out.println("TestArrayListImpl-Failed: roiNullIdxAdd != null - inserting with index did not return null"); 
        int sizeBeforeRemoving = testArray.size();
        ReturnObjectImpl roiRemoveLast = testArray.remove(testArray.size()-1);
        ReturnObjectImpl roiRemoveMiddle = testArray.remove(500001);
        ReturnObjectImpl roiRemoveFirst = testArray.remove(0);
        if(!testArray.get( 0 ).getReturnValue().equals("Hello,") || !testArray.get( 500001 ).getReturnValue().equals("Element:499998") || !testArray.get(testArray.size()-1).getReturnValue().equals("Element:1")  )
              System.out.println("TestArrayListImpl-Failed: get() AFTER removing items produced unexpected output");  

        if(!roiRemoveFirst.getReturnValue().equals("Let me in!") || !roiRemoveMiddle.getReturnValue().equals("Element:500000") || !roiRemoveLast.getReturnValue().equals("Will I fit?") || !(testArray.size() == sizeBeforeRemoving  - 3 ) )
              System.out.println("TestArrayListImpl-Failed: items returned BY remove were not as expected");  

        System.out.println("Finished tests for TestArrayListImpl");
    }
}
