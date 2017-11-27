
package arraylists;

import java.util.ArrayList;


public class PersonArrayList {

    
    public static void main(String[] args) {
       ArrayList<Person> p = new ArrayList<Person>();
       p.add(new Person("Anderson, Joe",34));
       p.add(new Person("Miller, Amy",52));
       p.add(new Person("Stevens, Sara",17));
       showList(p);
       System.out.println("Insert Baily, Bill");
        Person temp = new Person("Bailey, Bill",26);
        int loc = findInsertPoint(p,temp);
        p.add(loc, temp);//insert directly int list, not method needed
        
        System.out.println("Insert Markle, Megan");
        temp = new Person("Markle, Megan",32);
        loc = findInsertPoint(p,temp);
        p.add(loc, temp);//insert directly int list, not method needed
    
        showList(p);
        
        System.out.println("Remove Miller, Amy");
        temp=new Person("Miller, Amy",52);
        
        loc=search(p,temp);        
        p.remove(loc);
        
        showList(p);
    }
    
    public static void showList(ArrayList<Person> a){
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getName());
        }
    }
    public static int search (ArrayList a, Object searchValue){
	   int left = 0;
	   int right = a.size()-1;
	   while (left <= right){
	      int midpoint = (left + right) / 2;
	      int result = ((Comparable)a.get(midpoint)).compareTo(searchValue); 
	      if (result == 0)
	         return midpoint;
	      else if (result < 0)
	         left = midpoint + 1;
	      else
	         right = midpoint-1;
	   }
	   return -1;	
		   
}
    public static int findInsertPoint (ArrayList a, Object searchValue){
	   int left = 0;
	   int right = a.size()-1;
	   int midpoint=0;
	   
	   while (left <= right){
	      midpoint = (left + right) / 2;
	   
	      int result = ((Comparable)a.get(midpoint)).compareTo(searchValue); 
	   
	     if (result < 0)
	         left = midpoint + 1;
	      else
	         right = midpoint-1;
	   }
	   if(((Comparable)a.get(midpoint)).compareTo(searchValue) < 0)
	   midpoint++;
	   return midpoint;	   
}
    
}
