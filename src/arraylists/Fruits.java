package arraylists;

public class Fruits {

    public static int logicalSize = 4;

    public static void main(String[] args) {
        String fruit[] = new String[10];
        fruit[0] = "Banana";
        fruit[1] = "Grapes";
        fruit[2] = "Lemon";
        fruit[3] = "Pineapple";
        fruit[4] = "Strawberry";
        System.out.println("Inserting Mango");
        //where does mango go?
        int loc = findInsertPoint(fruit,"Mango");
        //insert at loc
        insert(fruit,"Mango",loc);
        printList(fruit);
        System.out.println("Inserting Orange");
        loc=findInsertPoint(fruit,"Orange");
        insert(fruit,"Orange",loc);
        printList(fruit);
        System.out.println("Deleting Lemon");
        //where is Lemon?
        loc = search(fruit,"Lemon");
        delete(fruit,loc);
        printList(fruit);
    }
    
    public static void printList(String f[]){
        for (int i = 0; i < logicalSize; i++) {
            System.out.println(i +">" + f[i]);
        }
    }

    public static int search(Object[] a, Object searchValue) {
        int left = 0;
        int right = logicalSize - 1;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            int result = ((Comparable) a[midpoint]).compareTo(searchValue);
            if (result == 0) {
                return midpoint;
            } else if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return -1;

    }

//////////////////////////////////////////////////////////////////////////////////
    public static boolean insert(Object array[], Object newItem, int targetIndex) {
        // Check for a full array and return false if full
        if (logicalSize == array.length) {
            return false;
        }
        // Check for valid target index or return false 
        if (targetIndex < 0 || targetIndex > logicalSize) {
            return false;
        }
        // Shift items down by one position
        for (int i = logicalSize; i > targetIndex; i--) {
            array[i] = array[i - 1];
        }
        // Add new item, increment logical size,return true                       
        array[targetIndex] = newItem;
        logicalSize++;
        return true;
    }

//////////////////////////////////////////////////////////////////////////////////
    public static boolean delete(Object array[], int targetIndex) {
        if (targetIndex < 0 || targetIndex >= logicalSize) {
            return false;
        }

        // Shift items up by one position
        for (int i = targetIndex; i < logicalSize - 1; i++) {
            array[i] = array[i + 1];
        }

        // Decrement logical size and return true 
        logicalSize--;
        return true;
    }

/////////////////////////////////////////////////////////////////////////////////
    public static int findInsertPoint(Object a[], Object searchValue) {
        int left = 0;
        int right = logicalSize - 1;
        int midpoint = 0;

        while (left <= right) {
            midpoint = (left + right) / 2;

            int result = ((Comparable) a[midpoint]).compareTo(searchValue);

            if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        if (((Comparable) a[midpoint]).compareTo(searchValue) < 0) {
            midpoint++;
        }
        return midpoint;
    }

}
