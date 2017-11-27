
package arraylists;


public class PersonList {

    static int logicalSize=3;
    public static void main(String[] args) {
        Person p[]= new Person[5];
        p[0]=new Person("Anderson, Joe",34);
        p[1]=new Person("Millen, Amy",52);
        p[2]=new Person("Stevens, Sara",17);
        showList(p);
        System.out.println("Insert Baily, Bill");
        Person temp = new Person("Bailey, Bill",26);
        int loc = findInsertPoint(p,temp);
        insert(p,temp,loc);
        
        System.out.println("Insert Peterson, Pete");
        temp=new Person ("Peterson, Pete",61);
        loc = findInsertPoint(p,temp);
        insert(p,temp,loc);
        showList(p);
        
        System.out.println("Deleting Miller, Amy");
        temp=new Person ("Miller, Amy", 52);
        loc = findInsertPoint(p,temp);
        boolean ok = delete(p,loc);//get back true if ok, false if not
        
        if(ok)System.out.println("Delete sucessful");
        else System.out.println("Delete failed");
        showList(p);
    }
    public static void showList(Person p[]){
        for (int i = 0; i < logicalSize; i++) {
            System.out.println(p[i].getName());
        }
    }
    
    public static int search (Object[] a, Object searchValue){
	   int left = 0;
	   int right = logicalSize-1;
	   while (left <= right){
	      int midpoint = (left + right) / 2;
	      int result = ((Comparable)a[midpoint]).compareTo(searchValue); 
	      if (result == 0)
	         return midpoint;
	      else if (result < 0)
	         left = midpoint + 1;
	      else
	         right = midpoint-1;
	   }
	   return -1;	
		   
}

//////////////////////////////////////////////////////////////////////////////////

public static boolean insert(Object array[], Object newItem, int targetIndex)
{
	// Check for a full array and return false if full
	if (logicalSize == array.length)
	   return false;
	// Check for valid target index or return false 
	if (targetIndex < 0 || targetIndex > logicalSize)
	   return false;
	// Shift items down by one position
	for (int i = logicalSize; i > targetIndex; i--)      
	   array[i] = array[i - 1];
	// Add new item, increment logical size,return true                       
	array[targetIndex] = newItem; 
	logicalSize++;
	return true; 
}

//////////////////////////////////////////////////////////////////////////////////
	
public static boolean delete(Object array[], int targetIndex)
{
	if (targetIndex < 0 || targetIndex >= logicalSize)
		   return false;
		 
		// Shift items up by one position
		for (int i = targetIndex; i < logicalSize - 1; i++)       
		   array[i] = array[i + 1];
		 
		// Decrement logical size and return true 
		logicalSize--; 
		return true;                                   
}

/////////////////////////////////////////////////////////////////////////////////
	
public static int findInsertPoint (Object a[], Object searchValue){
	   int left = 0;
	   int right = logicalSize-1;
	   int midpoint=0;
	   
	   while (left <= right){
	      midpoint = (left + right) / 2;
	   
	      int result = ((Comparable)a[midpoint]).compareTo(searchValue); 
	   
	     if (result < 0)
	         left = midpoint + 1;
	      else
	         right = midpoint-1;
	   }
	   if(((Comparable)a[midpoint]).compareTo(searchValue) < 0)
	   midpoint++;
	   return midpoint;	   
}
    
}
