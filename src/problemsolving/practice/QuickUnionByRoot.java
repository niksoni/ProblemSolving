/**
 * Problem: To find if 2 elements are connected to each other via any route.
 * Solution: 1) Constructor takes the size and builds an id array with the value equals to the index.
 * 			 2) If the root of 2 indexes are equal that implies they are connected. The method 'connected' solves this purpose.
 * 			 3) To merge an item into a connected group, the root of the first should be changed to the root of the second.
 * 				The method 'union' solves this purpose.
 * 			 4) findRoot takes care of finding the root of an element
 * Complexity is N for Initialization, N for union and N for find (i.e. connected)
 * Issue -> The trees can get too tall (and skinny) - to do a find operation for item at bottom can cost N array accesses which will be too slow if 
 * there are a lot of operations. 
 */
package problemsolving.practice;

/**
 * @author sonin
 *
 */
public class QuickUnionByRoot {
	private int[] id;

	public QuickUnionByRoot(int N) {
		id = new int[N];
		for (int i=0; i<N; i++) {
			id[i] = i;
		}
	}

	private int findRoot(int p) {
		int root = id[p];

		while (root!=p) {
			p = root;
			root = id [p];
		}

		return root;
	}

	public void union(int p, int q) {
		int pRoot = findRoot(p);
		id[pRoot] = findRoot(q);
	}

	public boolean connected(int p, int q) {
		return findRoot(p) == findRoot(q);
	}

}
