package Arrays.TwoDArray;

public class TwoDimensionalArray {
    int arr[][]=null;

    public TwoDimensionalArray(int numberOfRow, int numberOfCol) {
         this.arr=new int[numberOfRow][numberOfCol];
         for(int row=0;row<arr.length;row++){
             for(int col=0;col<numberOfCol;col++){
                 this.arr[row][col]=Integer.MIN_VALUE;
             }
         }
    }

    public void interValueToArray(int row,int col,int value){
        if(this.arr[row][col]==Integer.MIN_VALUE){
            this.arr[row][col]=value;
            System.out.println("Value inserted");
        }else{
            System.out.println("Index already occupied");
        }
    }
    public void traverseArray(){
        for(int row=0;row<this.arr.length;row++){
            for(int col=0;col<this.arr[0].length;col++){
                System.out.println(this.arr[row][col]);
            }
        }
    }
}
