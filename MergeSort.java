class MergeSort {
  void merge(int numbers[], int left, int middle, int right) {

    int num1 = middle - left + 1;
    int num2 = right - middle;

    int L[] = new int[num1];
    int R[] = new int[num2];

    for (int i = 0; i < num1; ++i) 
        L[i] = numbers[left + i];
    for (int j = 0; j < num2; ++j) 
        R[j] = numbers[middle + 1 + j];

    int i = 0, j = 0;

    int k = left;
    while (i < num1 && j < num2) {
      if (L[i] <= R[j]) {
        numbers[k] = L[i];
        i++;
      } else {
        numbers[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < num1) {
      numbers[k] = L[i];
      i++;
      k++;
    }

    while (j < num2) {
      numbers[k] = R[j];
      j++;
      k++;
    }
  }

  void sort(int numbers[], int left, int right) {
    if (left < right) {
      int m = left + (right - left) / 2;
      sort(numbers, left, m);
      sort(numbers, m + 1, right);
      
      merge(numbers, left, m, right);
    }
  }
}
