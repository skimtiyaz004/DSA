package generics;

import java.util.Arrays;

public class GenericsCustomArrayList<T> {
    /*
    1.Initialize array with default size
    2.If size full then double the array
    3.copy the old array data and assign to new array

   */
    private Object[] arr;
    private static int DEFAULT_SIZE=7;
    private int size=0;

    // initialize the array size in the constructor
    public GenericsCustomArrayList(){
        this.arr=new Object[DEFAULT_SIZE];
    }

    public void add(T value){
        System.out.println("isFull()"+isFull());
        System.out.println("value"+value);
        System.out.println("size"+size);
        if(isFull()){

            System.out.println("Working here");
            resize();
        }
        arr[size++]=value;
    }

    private void resize() {
        Object [] temp=new Object[arr.length *2];
        for(int i =0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        arr=temp;
        System.out.println("arr"+arr.length);
    }

    private boolean isFull() {
        return size==arr.length;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        GenericsCustomArrayList<Integer> customArrayList=new GenericsCustomArrayList<>();
        for(int i=0;i<15;i++){
            customArrayList.add(i*3);
        }
        System.out.println(customArrayList);
    }
}
