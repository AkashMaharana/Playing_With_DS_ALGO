import java.util.*;
import java.io.*;

public class Main implements Runnable {

	public void solve() throws IOException {
		int N = nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = nextInt();

		ArrayList<Integer> goodCandidates = new ArrayList<>(); // who can kill
		int[] next = new int[N];
		boolean[] alive = new boolean[N];
		Arrays.fill(alive, true);
		for (int i = 0; i < N - 1; i++) {
			goodCandidates.add(i);
			next[i] = i + 1;
		}
		next[N - 1] = -1;

		int answer = 0;
		while (true) {
			boolean change = false;
			for (int i = 0; i < goodCandidates.size(); i++) {
				int to = next[goodCandidates.get(i)];
				if (a[goodCandidates.get(i)] < a[to]) {
					alive[to] = false;
					change = true;
				}
			}

			ArrayList<Integer> nextGoodCandidates = new ArrayList<>();
			for (int i = goodCandidates.size() - 1; i >= 0; i--) {
				int to = next[goodCandidates.get(i)];
				if (!alive[to]) {
					while (to != -1 && !alive[to])
						to = next[to];
					next[goodCandidates.get(i)] = to;

					if (next[goodCandidates.get(i)] != -1 && alive[goodCandidates.get(i)]) {
						nextGoodCandidates.add(goodCandidates.get(i));
					}
				}

			}

			goodCandidates = nextGoodCandidates;

			if (change)
				answer++;
			else
				break;

		}

		out.println(answer);
	}

	// -----------------------------------------------------------
	public static void main(String[] args) {
		new Main().run();
	}

	public void debug(Object... arr) {
		System.out.println(Arrays.deepToString(arr));
	}

	public void print1Int(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public void print2Int(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			tok = null;
			solve();
			in.close();
			out.close();
		} catch (IOException e) {
			System.exit(0);
		}
	}

	public String nextToken() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	PrintWriter out;
	BufferedReader in;
	StringTokenizer tok;
}
