import java.io.*;
import java.util.*;


class Activity {
	int start, finish;
	Activity(int start, int finish)	{
		this.start = start;
		this.finish = finish;
	}
}

class Compare {
	Activity[] a;
	Compare(Activity[] a)	{
		this.a = a;
	}	
	public void select()	{
		Arrays.sort(a, Comparator.comparingInt(activity -> activity.finish));
		int i = 0;
		System.out.print("(" + a[i].start + ", " + a[i].finish + ") ");
		for (int j = 1; j < a.length; j++)	{
			if (a[j].start >= a[i].finish)	{
				System.out.print("(" + a[j].start + ", " + a[j].finish + ") ");
				i = j;
			}
		}
	}
}

class ActivitySelection {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter total activities : ");
		int n = input.nextInt();
		Activity[] a = new Activity[n];
		System.out.println("Enter in (start, finish) order");
		for (int i = 0; i < n; i++)	{
			int s = input.nextInt();
			int f = input.nextInt();
			a[i] = new Activity(s, f);
		}
		Compare c = new Compare(a);
		c.select();
	}
}