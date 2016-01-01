public class TestSampleableListImpl {
    public static void main(String[] args){
        System.out.println("Starting tests for SampleableListImpl");
        SampleableList sli = new SampleableListImpl();
        sli.add("Item1");
        sli.add("Item2");
        sli.add("Item3");
        sli.add("Item4");
        sli.add("Item5");
        sli.add("Item6");
        sli.add("Item7");
        sli.add("Item8");
        sli.add("Item9");
        sli.add("Item10");
        SampleableList sli_sampled = sli.sample();
        /*for (int i=0; i<=sli_sampled.size()-1; i++){
            System.out.println(sli_sampled.get(i).getReturnValue());
        }
        System.out.println(sli_sampled.get(4).getReturnValue().equals("Item9"));
        */
        if(!(sli_sampled.size()== 5) || !sli_sampled.get(0).getReturnValue().equals("Item1") || !sli_sampled.get(4).getReturnValue().equals("Item9"))
                System.out.println("SampleableListImpl-Failed- Sampled list does not contain expected values");
        System.out.println("Finished tests for SampleableListImpl");
    }
}
