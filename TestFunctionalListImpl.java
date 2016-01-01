class TestFunctionalListImpl {
    public static void main(String[] input){
        FunctionalList  testFunctionalList = new FunctionalArrayListImpl();
        System.out.println("Starting tests - FunctionalListImpl");
        testFunctionalList.add("1-SimpleChronograph");
        testFunctionalList.add("2-CounterChronograph");
        testFunctionalList.add("3-PerpetualCalendara");
        testFunctionalList.add("4-MoonPhases");
        ReturnObject headItem = testFunctionalList.head();
        FunctionalList newList = testFunctionalList.rest();

        if(!headItem.getReturnValue().equals("1-SimpleChronograph") || newList.size() != 3)
            System.out.println("FunctionalArrayListImpl-Failed- 1st head() and rest() failed");

        headItem = newList.head();
        newList = newList.rest();
        if(!headItem.getReturnValue().equals("2-CounterChronograph") || newList.size() != 2)
            System.out.println("FunctionalArrayListImpl-Failed- 2nd head() and rest() failed");
        System.out.println("Finished tests - FunctionalListImpl");
    }

}
