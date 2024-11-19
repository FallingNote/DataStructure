public class SinglyLinkedListSentinel {
    //带哨兵单向链表
    private Node head = new Node(114,null);//头结点指向哨兵

    private static class Node{
        int value;//节点存储的值
         Node next;//指向下一个节点

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value){
        //链表为空
        //head节点指向新节点
        //head = new Node(value,null);


        //链表非空
        //新节点指向原head节点
        //head节点再指向新节点
        //此时这段代码也适用于链表为空的情况
        head = new Node(value,head);

    }

    //便利链表
    public void loop() {
        Node p = head;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }

    //寻找尾部节点
    public Node findLast(){
//        if(head == null)
//            return null;
//        else {
//            Node p;
//            for (p = head;p != null;p = p.next);
//            return p;
//        }
        Node p;
        for (p = head;p != null;p = p.next);
        return p;
    }

    //尾部添加
    public void addLast(int value){
//        Node newNode = new Node(value, null);
//        Node p = head;
//        while (p != null){
//            if(p == null)
//                p = newNode;
//            else
//                p = p.next;
//        }
        Node last = findLast();
//        if(last == null){
//            addFirst(value);
//            return;
//        }
        last.next = new Node(value,null);
    }

    //根据索引查找节点
    private Node findNode(int index){
        int i = 0;
        for (Node p = head; p != null; p = p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null;
    }

    //根据索引获得节点值
    public int get(int index){
        Node node = findNode(index);
        if(node == null){
            throw illegalIndex(index);

        }
        return node.value;
    }

    //向索引位置插入
    public void insert(int index,int value){
        if(index == 0){
            addFirst(value);
            return;
        }
        Node before = findNode(index - 1);
        if(before == null){
            throw illegalIndex(index);
        }
        before.next = new Node(value,before.next);

    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }

    //删除首个节点
    public void removeFirst(){
        if(head == null){
            throw illegalIndex(0);
        }
        head = head.next;
    }

    //按照索引删除节点
    public void remove(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        Node before = findNode(index - 1);
        if(before.next == null){
            illegalIndex(index);
        }
        before.next = before.next.next;
    }

}
