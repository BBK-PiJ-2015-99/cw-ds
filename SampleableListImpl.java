/**
 * A sampleable list can be sampled. 
 * 
 * @author David Asfaha
 */
public class SampleableListImpl extends ArrayListImpl implements SampleableList {
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableList sample(){
        SampleableList newSampleableList = new SampleableListImpl();
        for(int i =0; i<=this.size()-1; i+=2){
            newSampleableList.add(this.get(i).getReturnValue());
        }
        return newSampleableList;
    }
}
