class TestArrayListImpl {
    public static void main(String[] input){
        ArrayListImpl testArray = new ArrayListImpl();
        System.out.println("Starting tests for TestArrayListImpl");
        if(!testArray.isEmpty())
            System.out.println("TestArrayListImpl-Failed: !.isEmpty() returned true after object creation");
        System.out.println("Finished tests for TestArrayListImpl");
        if(testArray.size()!=0)
            System.out.println("TestArrayListImpl-Failed: size()!=0 after object creation");
    }

}
