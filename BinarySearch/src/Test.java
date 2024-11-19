import org.w3c.dom.Node;

import static java.util.Arrays.binarySearch;

public class Test {
    public static void main(String[] args) {
       SinglyLinkedList linkedList = new SinglyLinkedList();
       linkedList.addLast(1);
       linkedList.addLast(2);
       linkedList.addLast(3);
       linkedList.addLast(4);
       linkedList.addLast(5);
//       linkedList.loop(value->{
//           System.out.println(value);
//       });
        for (Integer value : linkedList) {
            System.out.println(value);
        }
    }


}
