/**
 * Problem: To find if 2 elements are connected to each other via any route.
 * Solution: 1) Constructor takes the size and builds an id array with the value equals to the index.
 * 			 2) If the value of 2 indexes are equal that implies they are connected. The method 'connected' solves this purpose.
 * 			 3) To merge an item into a connected group, all the items of the previous group should now have value equal to the 
 * 				value that the second group indices have. The method 'union' solves this purpose.
 * Complexity is N for initialization, N for union, 1 for find (i.e. connected)
 * Issue -> union operation is too expensive : takes N^2 array accesses to process sequence of N union commands on N objects
 * Quadratic algorithms don't scale with technology
 */
package problemsolving.practice;

/**
 * @author sonin
 *
 */
public class QuickFind {
	private int[] id;

	public QuickFind(int N) {
		id = new int[N];
		for (int i=0; i<N; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		if (id[p] == id[q]) {
			return true;
		}
		return false;
	}

	public void union(int p, int q) {
		if (connected(p,q)) {
			return;
		}
		else {
			int pTemp = id[p];
			int qTemp = id[q];
			for (int i=0; i<id.length; i++) {
				if (id[i] == pTemp) {
					id[i] = qTemp;
				}
			}
		}
	}

}
