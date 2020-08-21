package tree_graph;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // equations = [ ["a", "b"], ["b", "c"] ],
        // values = [2.0, 3.0],
        // queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

        // build the map - graph
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            if (!map.containsKey(equations.get(i).get(0))) map.put(equations.get(i).get(0), new HashMap<>());
            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);

            if (!map.containsKey(equations.get(i).get(1))) map.put(equations.get(i).get(1), new HashMap<>());
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }

        // search dividend and divisor using DFS
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            double[] para = new double[]{1.0};
            if (calculate(map, queries.get(i).get(0), queries.get(i).get(1), para, new HashSet<>(), 1.0))
                res[i] = para[0];
            else res[i] = -1.0;
        }
        return res;
    }

    // DFS
    private boolean calculate(Map<String, Map<String, Double>> map, String num1, String num2,
                              double[] para, Set<String> visited, double res) {

        // visited.contains() => cyclic
        if (!map.containsKey(num1) || !map.containsKey(num2) || visited.contains(num1)) return false;

        if (num1.equals(num2)) {
            para[0] = res;
            return true;
        }

        visited.add(num1);

        for (Map.Entry<String, Double> entry : map.get(num1).entrySet()) {
            if (calculate(map, entry.getKey(), num2, para, visited, res * entry.getValue())) return true;
        }
        return false;
    }
}
