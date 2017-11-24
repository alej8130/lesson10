package searching;

public class ISSStudent implements Comparable {

    private String name, address;
    private int id;

    public ISSStudent(String n, String a, int i) {
        name = n;
        address = a;
        id = i;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        String str = "Name:\t" + name;
        str += "\nAdress:\t" + address;
        str += "\nStudent ID:\t" + id;
        return str;
    }

    @Override
    public int compareTo(Object t){
        int otherid = ((ISSStudent) t).getId();
        if (otherid > this.id) {
            return -1;
        } 
        else if (otherid < id) {
            return 1;
        } 
        else {
            return 0;
        }

    }

}
