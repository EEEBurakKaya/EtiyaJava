
public class main {

    public static void main(String[] args) {
        
    	MyList list = new MyList();
    	
    	list.add("Eskisehir");
    	list.add("Ankara");
    	list.add("İstanbul");
        list.write();
        list.remove("Ankara");
        System.out.println("/////////");
        list.write();
        System.out.println("/////////");
        //list.removeindex(2);
        // list.write();
        boolean sonuc = list.Check("Eskisehir");
        System.out.println(sonuc); 		
    }

}
