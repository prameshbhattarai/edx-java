package maze.lab5;

import java.util.ArrayList;
import java.util.Collections;

public class MazeSortedPaths {

    /**
     * List of paths through the maze,
     * sorted from shortest (first position) to longest (last position)
     */
    ArrayList<Path> sortedPaths;

    public MazeSortedPaths(ArrayList<Path> paths) {
        this.sortedPaths = paths;
        sort();
    }

    public ArrayList<Path> getSortedPaths() {
        return sortedPaths;
    }

    /**
     * Sorts the list of paths
     */
    public void sort() {
        /**
         * The sort method in class Collection orders a collection of elements based on the Comparator provided as second argument.
         * The lambda expression for the Comparator represents a function that receives two parameters, a and b, and returns:
         *    -1 if a.size() is less than b.size()
         *     1 if a.size() is greater than b.size()
         *     0 if a.size() is equals to b.size()
         * Lambda expressions are available in Java since Java 8.
         * In previous versions, a class implementing the Comparator interface should be provided
         */
        Collections.sort(sortedPaths, (a, b) -> a.size() < b.size() ? -1 : a.size() == b.size() ? 0 : 1);
    }

    /**
     * Returns the shortest path (one of them if several)
     */
    public Path getShortestPath() {
        if (sortedPaths != null) {
            return sortedPaths.get(0);
        } else {
            return null;
        }
    }

    /**
     * Returns the longest path (one of them if several)
     */
    public Path getLongestPath() {
        if (sortedPaths != null) {
            return sortedPaths.get(sortedPaths.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * Returns the list of shortest paths (all paths with minimum length)
     */
    public ArrayList<Path> getShortestPaths() {
        if (sortedPaths == null) {
            return null;
        }

        ArrayList<Path> p = new ArrayList<Path>();

        int minLength = sortedPaths.get(0).size();
        int pos;
        for (pos = 0; pos < sortedPaths.size() && sortedPaths.get(pos).size() == minLength; pos++) {
            // traverse while paths have minimum length
            p.add(sortedPaths.get(pos));
        }

        return p;
    }

    /**
     * Returns the list of longest paths (all paths with maximum length)
     */
    public ArrayList<Path> getLongestPaths() {
        if (sortedPaths == null) {
            return null;
        }

        ArrayList<Path> p = new ArrayList<Path>();

        int maxLength = sortedPaths.get(sortedPaths.size() - 1).size();
        int pos;
        for (pos = sortedPaths.size() - 1; pos >= 0 && sortedPaths.get(pos).size() == maxLength; pos--) {
            // Traverse from end backwards while paths have maximum length
            // Adding elements at the beginning is not efficient, as it forces
            // shifting already inserted elements.
            // However, adding elements in order requires traversing the subset twice.
            p.add(0, sortedPaths.get(pos));
        }

        return p;

    }

    /**
     * Prints paths
     */
    public void print() {
        int i = 0;
        for (Path p : sortedPaths) {
            System.out.println("Path " + i++ + " (length=" + p.size() + "): " + p);
        }
    }
}
