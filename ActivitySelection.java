import java.io.*;
import java.util.*;

class Activity {
    int start, end;
    Activity(int start, int end)    {
        this.start = start;
        this.end = end;
    }
}

class ActivitySelection     {
    static void select(int[] s, int[] f, int n)    {
        Activity[] a = new Activity[n];
        for (int i = 0; i < n; i++) 
            a[i] = new Activity(s[i], f[i]);
        Arrays.sort(a, Comparator.comparingInt(ac -> ac.end));
        int i = 0;
        System.out.println("Selected Activities: ");
		System.out.println("(" + a[i].start + " " + a[i].end+ ")");
        for (int j = 1; j < n; j++) {
            if (a[j].start > a[i].end)   {
                System.out.println("(" + a[j].start + " " + a[j].end+ ")");
                i = j;
            }
        }
    }
    public static void main(String[] args) {
        int[] s = {1,4,7,10,14,18};
        int[] f = {3,6,9,12,15,20};
        select(s, f, s.length);
    }
}
