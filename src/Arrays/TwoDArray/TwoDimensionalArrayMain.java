package Arrays.TwoDArray;

import java.util.Arrays;

public class TwoDimensionalArrayMain {
    public static void main(String[] args) {
        TwoDimensionalArray twoDimensionalArray =new TwoDimensionalArray(2,2);

        twoDimensionalArray.interValueToArray(0,0,10);
        twoDimensionalArray.interValueToArray(0,1,20);
        System.out.println(Arrays.deepToString(twoDimensionalArray.arr));
        twoDimensionalArray.traverseArray();
    }


}
