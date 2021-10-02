class BinarySearch {
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
  
            if (arr[mid] == x)
                return mid;
  
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
  
            return binarySearch(arr, mid + 1, r, x);
        }
  
        return -1;
    }
  
    public static void main(String args[])
    {
        BinarySearch bs = new BinarySearch();
        int arr[] = { 2, 133, 1414, 1510, 512340 };
        int n = arr.length;
        int target = 1234;
        int result = bs.binarySearch(arr, 0, n - 1, target);
        if (result == -1)
            System.out.println("Elt Not found");
        else
            System.out.println("Elt found at: " + result);
    }
}
