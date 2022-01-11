// Greedy Game
/*You are playing a game with your k friends. You've an array of N coins at each index 'i' you've a coin of
value a[i]. Your task is to divide the coins among a group of k friends by doing consecutive segments (ksubarrays) of the array. Each friend will get a total sum of the coins in that subarray. Since all your friends
are greedy, and they will pick the largest k-1 segments and you will get the smallest segment. Find out the
maximum value you can make by making an optimal partition. */

public class GreedyGame{
    
    static boolean divideAmongK(int[] arr, int n, int k, int min_coins){
        int friends = 0;
        int current_friend = 0;
        int partitions = 0;
        for(int i = 0; i < n; i++){
            if(current_friend + arr[i] >= min_coins){
                partitions += 1;
                current_friend = 0;
            }
            else{
                current_friend += arr[i];
            }
        }
        return partitions >= k;
    }
    
    static int k_partition(int[] arr, int n, int k){
        int start = 0;
        int end = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            end += arr[i];
        }

        while(start <= end){
            int mid = (start+end)/2;
            boolean isPossible = divideAmongK(arr, n, k, mid);
            if(isPossible){
                start = mid+1;
                ans = mid;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args){
        int[] arr = {10,20,30,40};
        int n = arr.length;
        int k = 3;

        System.out.println(k_partition(arr,n,k));
    }
}