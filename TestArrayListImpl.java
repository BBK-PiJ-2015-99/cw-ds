class TestArrayListImpl {
    public static void main(String[] input){
        ArrayListImpl testArray = new ArrayListImpl();
        System.out.println("Starting tests for TestArrayListImpl");
        if(!testArray.isEmpty())
            System.out.println("TestArrayListImpl-Failed: !.isEmpty() returned true after object creation");
        System.out.println("Finished tests for TestArrayListImpl");
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
        if(testArray.get(0).getReturnValue() != "Hello," && testArray.get(500000).getReturnValue() != "Element:500000" && testArray.get(testArray.size()).getReturnValue() != "Will I fit?")
            System.out.println(testArray.get(500000).getReturnValue());    
            System.out.println("TestArrayListImpl-Failed: get() not re11turning first, middle and last elements correctly");
    }

}
