class Solution {
   
    List<Integer>[] g;
    int[] id;
    int[] low;
    int time;
    List<List<Integer>> result;
     public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        g = new ArrayList[n];
        id = new int[n];
        low = new int[n];
        time = 0;
        result = new ArrayList<>();
        Arrays.fill(id, - 1);
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (List<Integer> c : connections) {
            int from = c.get(0), to = c.get(1);
            g[from].add(to);
            g[to].add(from);
        }
        for (int i = 0; i < n; i++) {
            if (id[i] == -1) dfs(i, i);
        }
        return result;
    }
    
    private void dfs(int u, int same) {
        id[u] = low[u] = ++time;
        for (int v : g[u]){
            if (v == same) continue; 
            if (id[v] == -1) {
                dfs(v, u);
                if (low[v] > id[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } 
            low[u] = Math.min(low[u], low[v]);
        }
    } 

}