import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;
        private int N;
        private double K=2.0;
//        private int arr[];
        // this is similar to how we define array
        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                // creating linklist of every index
                this.buckets[i]=new LinkedList<>();
            }
        }

        public void put(K key ,V value){
            int bi=hashFunction(key); // this will give me index of the array
            System.out.println("bi"+bi);
            // di will check the linkedlist of the array
            int di= searchInLinkList(key,bi); // if my di is 0 valid index or else key dose not extis
            if(di==-1){
                buckets[bi].add(new Node(key,value));
                // increase n if new node added
                n++;
            }else{
                // if already exists
                Node oldData=buckets[bi].get(di);
                oldData.value=value;
            }

            double lamda=(double)n/N;
            System.out.println("lamda"+lamda);
            System.out.println("n"+n);
            if(lamda>2.0){
                N=N*2;
                rehash();
            }

        }

        private void rehash() {
            LinkedList<Node> oldBucket[]=buckets;
            buckets=new LinkedList[N*2];
            for(int i=0;i<N*2;i++){
                buckets[i]=new LinkedList<>();
            }
            for(int i =0;i<oldBucket.length;i++){
                LinkedList<Node> li=oldBucket[i];
                for(int j=0;j<li.size();j++){
                    Node node=li.get(j);
                    put(node.key, node.value);
                }
            }
        }

        private int searchInLinkList(K key, int bi) {
            // get the whole linkedList of the bucket index
           LinkedList<Node> li=buckets[bi];
           for(int i = 0;i<li.size();i++){
               if(li.get(i).key==key){
                   return i;// return di
               }
            }
           return -1;
        }

        private int hashFunction(K key) {
            int bi=key.hashCode();
            System.out.println("N is "+N);
            return Math.abs(bi) % N;// get the value
        }
        public V get(K key){
            int bi=hashFunction(key);
            System.out.println("Get BI"+bi);
            int di=searchInLinkList(key,bi);
            System.out.println("di"+di);
            if(di>=0){
                return buckets[bi].get(di).value;
            }else{
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLinkList(key, bi); //di = -1
            if(di == -1) { //key doesn't exist
                return null;
            } else { //key exists
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) { //bi
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++) { //di
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> country=new HashMap<>();
        country.put("India",200);
        country.put("US",100);
        System.out.println(country.get("India"));;
    }
}
