class MergeSort
{
    public static void merge(int arr1[], int arr2[], int n, int m) 
    {
        // code here 
        //for each element in arr2 from last add it in arr1 using insertion sort
        //and add last elemeent of arr1 in arr2
        
        for(int i=m-1;i>=0 ;i--){
            int last =arr1[n-1];
            int j=n-2;
            while(j>=0 && arr1[j]>arr2[i]){
                arr1[j+1]=arr1[j];
                j--;
            }
            //an element greater than curr is found
            if(j!=n-2 || last>arr2[i]){
                arr1[j+1] = arr2[i];
                arr2[i] =last;
            }
        }
        
    }
}
