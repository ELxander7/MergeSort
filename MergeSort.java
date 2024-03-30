package ru.itis.aisd304.mergesort2;

public class MergeSort {
    public static int mergeSort(int[] a, int n) {
        if (n < 2) {
            return 0;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        int iterations = 0;
        iterations += mergeSort(l, mid);
        iterations += mergeSort(r, n - mid);
        iterations += merge(a, l, r, mid, n - mid);

        return iterations;
    }
    public static int merge(
            int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        int iterations = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
            iterations++;
        }
        while (i < left) {
            a[k++] = l[i++];
            iterations++;
        }
        while (j < right) {
            a[k++] = r[j++];
            iterations++;
        }
        return iterations;
    }
}

