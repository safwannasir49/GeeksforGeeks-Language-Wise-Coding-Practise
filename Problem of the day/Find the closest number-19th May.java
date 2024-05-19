//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    
    class IntArray
    {
        public static int[] input(BufferedReader br, int n) throws IOException
        {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
    
            return a;
        }
    
        public static void print(int[] a)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<Integer> a)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                int n;
                n = Integer.parseInt(br.readLine());
                
                
                int k;
                k = Integer.parseInt(br.readLine());
                
                
                int[] arr = IntArray.input(br, n);
                
                Solution obj = new Solution();
                int res = obj.findClosest(n, k, arr);
                
                System.out.println(res);
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    class Solution {
        public static int findClosest(int n, int k, int[] arr) {
            // Perform binary search to find the closest index
            int low = 0, high = n - 1;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == k) {
                    return arr[mid];
                } else if (arr[mid] < k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            // Now, low is the insertion point for k
            // Check the closest value
            int closest = Integer.MAX_VALUE;
            if (low < n) {
                closest = arr[low];
            }
            if (low > 0) {
                int leftNeighbor = arr[low - 1];
                if (closest == Integer.MAX_VALUE ||
                    Math.abs(leftNeighbor - k) < Math.abs(closest - k) ||
                    (Math.abs(leftNeighbor - k) == Math.abs(closest - k) && leftNeighbor > closest)) {
                    closest = leftNeighbor;
                }
            }
            
            return closest;
        }
    }
    