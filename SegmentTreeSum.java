class SegmentTree
{
    int segTree[];

    SegmentTree(int numbers[], int size)
    {
        int x = (int) (Math.ceil(Math.log(size) / Math.log(2)));
        int maximumSize = 2 * (int) Math.pow(2, x) - 1;
        segTree = new int[maximumSize];
        createSegTree(numbers, 0, size - 1, 0);
    }

    int calcSum(int n, int qs, int qe)
    {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return sumHelperFunction(0, n - 1, qs, qe, 0);
    }

    int createSegTree(int arr[], int ss, int se, int si)
    {
        if (ss == se) {
            segTree[si] = arr[ss];
            return arr[ss];
        }
        int mid = midElt(ss, se);
        segTree[si] = createSegTree(arr, ss, mid, si * 2 + 1) +
                createSegTree(arr, mid + 1, se, si * 2 + 2);
        return segTree[si];
    }

    int midElt(int start, int end) {
        return start + (end - start) / 2;
    }

    int sumHelperFunction(int sStart, int sEnd, int qStart, int qEnd, int sIndex)
    {
        if (qStart <= sStart && qEnd >= sEnd) {
            return segTree[sIndex];
        }
        if (sEnd < qStart || sStart > qEnd) return 0;
        int mid = midElt(sStart, sEnd);
        return sumHelperFunction(sStart, mid, qStart, qEnd, 2 * sIndex + 1) +
                sumHelperFunction(mid + 1, sEnd, qStart, qEnd, 2 * sIndex + 2);
    }
    void updateValHelper(int ss, int se, int i, int diff, int si)
    {
        if (i < ss || i > se)
            return;
        segTree[si] = segTree[si] + diff;
        if (se != ss) {
            int mid = midElt(ss, se);
            updateValHelper(ss, mid, i, diff, 2 * si + 1);
            updateValHelper(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    void updateValue(int arr[], int n, int i, int new_val)
    {
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }
        int diff = new_val - arr[i];
        arr[i] = new_val;
        updateValHelper(0, n - 1, i, diff, 0);
    }
}

