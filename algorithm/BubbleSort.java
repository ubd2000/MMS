import java.util.Arrays;

/**
 * @author kdm
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] data_list = {15,13,2,4,5,1, 9, 3, 2, 44};
        int first = 0;
        int last = 0;
        int dataLength = data_list.length;


        for (int i = 0; i < dataLength - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < data_list.length - i - 1; j++) {
                if (data_list[j] > data_list[j + 1]) {
                    first = data_list[j];
                    last = data_list[j + 1];
                    data_list[j + 1] = first;
                    data_list[j] = last;
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
        for (int i = 0; i < data_list.length; i++) {
            System.out.print(data_list[i] + ",");
        }
    }
}
