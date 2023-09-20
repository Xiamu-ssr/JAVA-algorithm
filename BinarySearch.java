import java.util.List;

public class BinarySearch {
    private int[] arr = {1, 2, 4, 6, 7, 9};
    private int target = 6;
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int res = bs.Main();
        System.out.println(res);
    }
    private int Main(){
        int i=0, j=arr.length-1;
        while (i<=j){
            int m = (i+j) / 2;
            if(target<arr[m]){
                j=m-1;
            }else if (target>arr[m]){
                i=m+1;
            }else {
                return m;
            }
        }
        return -1;
    }
}
