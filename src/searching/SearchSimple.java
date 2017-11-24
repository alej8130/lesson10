
package searching;

public class SearchSimple {

    static int attemps;
   
    public static void main(String[] args) {
        String names[]={"Cindy","Fred","Nancey","Steve","Tom","victor","Yolanda"};
        //search for steve
        String name="Zeddy";
        int loc = search(names,name);
        System.out.println(name + " is found at " + loc + " after " + attemps + " tries.");
    }
    public static int search (Object[] a, Object searchValue){
	   int left = 0;
	   int right = a.length-1;
           attemps=0;
	   while (left <= right){
               attemps++;
	      int midpoint = (left + right) / 2;
	      int result = ((Comparable)a[midpoint]).compareTo(searchValue); 
	      if (result == 0)
	         return midpoint;
	      else if (result < 0)
	         left = midpoint + 1;
	      else
	         right = midpoint-1;///bo;wibeeo
	   }
	   return -1;	
		   
  }
}
