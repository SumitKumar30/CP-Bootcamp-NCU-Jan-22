// Wifi Installation Problem
/* So, as you all know free WiFis are being installed in our institute. These are a special type of WiFi and
they start to interfere when there is a signal coming from two different WiFis at a single location. The WiFi
installation task is given to you. There are N suitable locations for the installation of WiFi. These locations
are located along straight line positions x1,x2,...,xN (0<=xi<=1000000000).
You have to install C WiFis. You have to install the WiFis at locations such that the minimum distance
between any two of them is as large as possible. What is the largest minimum distance?
*/
import java.util.Arrays;

class WifiDistance {
	// Returns true if it is possible to
	// arrange k wifi's of arr[0..n-1]
	// with minimum distance given as mid.
	static boolean isFeasible(int mid, int arr[], int n,
							int k)
	{
		// Place the first wifi at arr[0] position
		int pos = arr[0];

		// Initialize count of wifi's placed.
		int wifi = 1;

		// Try placing k wifi's with minimum distance mid.
		for (int i = 1; i < n; i++) {
			if (arr[i] - pos >= mid) {
				// Place next wifi if its
				// distance from the previously
				// placed wifi is greater
				// than current mid
				pos = arr[i];
				wifi++;

				// Return if all wifi's are
				// placed successfully
				if (wifi == k)
					return true;
			}
		}
		return false;
	}

	// Returns largest minimum distance for
	// k elements in arr[0..n-1]. If elements
	// can't be placed, returns -1.
	static int largestMinDist(int arr[], int n, int k)
	{
		// Sort the positions
		Arrays.sort(arr);

		// Initialize result.
		int res = -1;

		// Consider the maximum possible distance
		int left = 1, right = arr[n - 1];

		// left is initialized with 1 and not with arr[0]
		// because, minimum distance between each element
		// can be one and not arr[0]. consider this example:
		// arr[] = {9,12} and you have to place 2 element
		// then left = arr[0] will force the function to
		// look the answer between range arr[0] to arr[n-1],
		// i.e 9 to 12, but the answer is 3 so It is
		// required that you initialize the left with 1

		// Do binary search for largest
		// minimum distance
		while (left < right) {
			int mid = (left + right) / 2;

			// If it is possible to place k
			// elements with minimum distance mid,
			// search for higher distance.
			if (isFeasible(mid, arr, n, k)) {
				// Change value of variable max to
				// mid if all elements can be
				// successfully placed
				res = Math.max(res, mid);
				left = mid + 1;
			}

			// If not possible to place k elements,
			// search for lower distance
			else
				right = mid;
		}

		return res;
	}

	// driver code
	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 8, 4, 9 };
		int n = arr.length;
		int k = 3;
		System.out.print(largestMinDist(arr, n, k));
	}
}

