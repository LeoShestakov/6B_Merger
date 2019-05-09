/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
	    ArrayList<String> merged = new ArrayList<String>();
		for (int i = 0; i < start0; i++)
			merged.add(usersData.get(i));
		
		String current0 = usersData.get(start0);
		int index0 = start0;
		String current1 = usersData.get(start1);
		int index1 = start1;
		while (index0 < start1 && index1 < nItems) {
			
			if (current0.compareTo(current1) >= 0) {
				merged.add(current1);
				current1 = usersData.get(++index1);
			}
			else {
				merged.add(current0);
				current0 = usersData.get(++index0);
			}
		}
		while (index0 < start1) {
			merged.add(current0);
			current0 = usersData.get(++index0);
		}
		
		while (index1 < nItems) {
			merged.add(current1);
			current1 = usersData.get(++index1);
		}
		
		for (int i = nItems; i < usersData.size(); i++)
			merged.add(usersData.get(i));
		
		usersData = merged;
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}