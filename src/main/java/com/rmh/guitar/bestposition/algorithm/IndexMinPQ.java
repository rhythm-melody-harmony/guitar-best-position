package com.rmh.guitar.bestposition.algorithm;

public class IndexMinPQ<Key extends Comparable<Key>> {
	
	private int N;	// number of elements on PQ
	private int[] pq;	// binary heap using 1-based indexing
	private int[] qp;	// inverse: qp[pq[i]] = pq[qp[i]] = i
	private Key[] keys;	// items with priorities

	@SuppressWarnings("unchecked")
	public IndexMinPQ(int maxN) {
		
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		
		for (int i = 0; i <= maxN; i++) {
			qp[i] = -1;
		}
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public boolean contains(int k) {
		return qp[k] != -1;
	}
	
	public void insert(int k, Key key) {
		N++;
		qp[k] = N;
		pq[N] = k;
		keys[k] = key;
		swim(N);
	}
	
	public Key min() {
		return keys[pq[1]];	
	}
	
	public int delMin() {
		int indexOfMin = pq[1];
		exch(1, N--);
		sink(1);
		keys[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
		return indexOfMin;
	}
	
	private void exch(int i, int j) {
//		Key t = pq[i];
		int t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private boolean less(int i, int j) {
//		return pq[i].compareTo(pq[j]) < 0;
		return pq[i] < pq[j];
	}
	
	private void sink(int k) {
		while (2*k <= N) {
			int j = 2*k;
			
			if (j < N && less(j, j+1)) {
				j++;
			}
			
			if (!less(k, j)) {
				break;
			}
			
			exch(k, j);
			k = j;
		}
	}
	
	public int minIndex() {
		return pq[1];
	}
	
	public void change(int k, Key key) {
		keys[k] = key;
		swim(qp[k]);
		sink(qp[k]);
	}
	
	public void delete(int k) {
		exch(k, N--);
		swim(qp[k]);
		sink(qp[k]);
		keys[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
	}

}
