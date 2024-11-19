import javax.swing.*;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer>{
    private Node head;//头指针


     /**
     * 增强for循环
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = head;
            @Override
            public boolean hasNext() {//是否有下一个元素
                return pointer != null;
            }

            @Override
            public Integer next() {//返回当前值并指向下一个元素
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }


    /**
     * 节点类
     */
    private class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加
     * @param value 待添加值
     */
    public void addFirst(int value){
        //1.链表为空
//        if(head == null){
//            head = new Node(value,null);
//            return;
//        }
        //2.链表非空
        Node node = new Node(value, head);
        head = node;
        return;
    }

    /**
     * 遍历链表
     */
    public void loop(Consumer<Integer> consumer){
        Node pointer = head;
        while (pointer != null){
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    public void addLast(int value){
        //1.链表为空
        if(head == null){
            addFirst(value);
            return;
        }
        //2.链表非空
        Node last = findLast();
        last.next = new Node(value,null);
    }

    private Node findLast(){
        if(head == null)
            return null;
        Node pointer;
        for (pointer = head;pointer.next != null;pointer = pointer.next);
        return pointer;
    }
}


