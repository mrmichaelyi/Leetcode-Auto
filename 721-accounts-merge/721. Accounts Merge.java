class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, Set<String>> graph = new HashMap<>();
		Map<String, String> emailToName = new HashMap<>();
		
		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				String email = account.get(i);
				emailToName.put(email, name);
				graph.putIfAbsent(email, new HashSet<>());
				if (i > 1) {
					graph.get(email).add(account.get(i - 1));
					graph.get(account.get(i - 1)).add(email);
				}
			}
		}
		Set<String> visited = new HashSet<>();
		List<List<String>> result = new LinkedList<>();
		for (String email : emailToName.keySet()) {
			if (visited.add(email)) {
				LinkedList<String> list = new LinkedList<>();
				dfs(graph, email, visited, list);
				Collections.sort(list);
				list.offerFirst(emailToName.get(email));
				result.add(list);
			}
		}
		return result;
	}

	private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
		list.add(email);
		for (String neighbor : graph.get(email)) {
			if (visited.add(neighbor)) {
				dfs(graph, neighbor, visited, list);
			}
		}
	}
}