import java.util.*;

public class Solution {  // Change class name to Solution
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> inDegree = new HashMap<>(); // Recipe → Needed ingredients count
        Map<String, List<String>> graph = new HashMap<>(); // Ingredient → Recipes

        for (int i = 0; i < recipes.length; i++) {
            inDegree.put(recipes[i], ingredients.get(i).size());
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipes[i]);
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> canMake = new HashSet<>(Arrays.asList(supplies));

        for (String supply : supplies) {
            queue.offer(supply);
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String item = queue.poll();

            if (inDegree.containsKey(item)) {
                result.add(item);
            }

            if (graph.containsKey(item)) {
                for (String dependent : graph.get(item)) {
                    inDegree.put(dependent, inDegree.get(dependent) - 1);
                    if (inDegree.get(dependent) == 0) {
                        queue.offer(dependent);
                        canMake.add(dependent);
                    }
                }
            }
        }

        return result;
    }
}
