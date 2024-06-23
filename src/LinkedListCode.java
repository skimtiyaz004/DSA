public class LinkedListCode {
    static class Ll{
        private Node head;
        private Node tail;
        private int size;
        private class Node{
            private int val;
            private Node next;
            public Node(int val) {
                this.val = val;
            }
            public Node(){
                size = 0;
            }
            @Override
            public String toString() {
                return "Node{" +
                        "val=" + val +
                        ", next=" + next +
                        '}';
            }
        }
        public void insertFirst(int val){
            Node node=new Node(val);
            node.next=head;
            head=node;
            if(tail==null){
                tail=head;
            }
            size += 1;
        }
        public void insertLast(int val){
            if(tail==null){
                insertFirst(val);
                return;
            }
            Node node=new Node(val);
            tail.next=node;
            tail=node;
            size++;
        }

        public void insert(int val, int index){
            if(index==0){
                insertFirst(val);
                return;
            }
            Node temp=head;
            for (int i=1;i<index;i++){
                temp=temp.next;
            }
            Node node=new Node(val);
            node.next=temp.next;
            temp.next=node;
            size++;
        }
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.val+" ->");
                temp=temp.next;
            }
            System.out.print("END");
            System.out.println();
        }

        public void deleteFirst(){
            head=head.next;
            size--;
        }
        public void deleteLast(){
            Node node=getNodeByIndex(size-1);
            System.out.println("node"+node);
            node.next=null;
            tail=node;
            size--;
        }
        public void delete(int index){
            if(index==0){
                deleteFirst();
                return;
            }
            Node node=getNodeByIndex(index);
            node.next=node.next.next;

            size--;
        }

        public Node getNodeByIndex(int index){
            Node temp=head;
            for(int i=1;i<index;i++){
                temp=temp.next;
            }
            return temp;
        }
    }


    public static void main(String[] args) {
        Ll ll=new Ll();
        ll.insertFirst(3);
        ll.insertFirst(4);
        ll.insertFirst(7);
        ll.insertLast(9);
        ll.insertLast(10);
        ll.insert(8,3);
        ll.display();
        ll.deleteFirst();
        ll.deleteLast();
        ll.insertFirst(12);
        ll.display();
        ll.delete(2);
        ll.display();

    }
}
