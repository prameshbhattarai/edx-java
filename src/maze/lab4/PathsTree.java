package maze.lab4;

import java.util.ArrayList;

public class PathsTree {

    private PathsTreeNode root;

    /**
     * Initializes an empty tree
     */
    public PathsTree() {
        this.root = null;
    }

    /**
     * Initializes a tree starting at position (0, 0) of Maze maze
     */
    public PathsTree(Maze maze) {
        this.root = new PathsTreeNode(maze, new MazePosition(0, 0, null));
    }

    /**
     * Initializes a tree with root at position pos of Maze maze
     */
    public PathsTree(Maze maze, MazePosition pos) {
        this.root = new PathsTreeNode(maze, pos);
    }


    public void print() {
        print(0);
    }

    private void print(int indent) {
        if (root != null) {
            String strIndent = new String(new char[indent]).replace("\0", " "); // indentation
			/*
			// Alternative for indentation
			char[] chars = new char[indent];
			Arrays.fill(chars, ch);
			String s = new String(chars);
			*/
            System.out.println(strIndent + root.pos.toString());
            for (PathsTree c : root.children) {
                c.print(indent + 2);
            }


        }
    }

    public ArrayList<Path> findAllPaths() {
        ArrayList<Path> paths = new ArrayList<Path>();
        return findAllPaths(paths);
    }

    public ArrayList<Path> findAllPaths(ArrayList<Path> paths) {

        if (root != null) {
            if (root.children.isEmpty()) { // this is a leaf
                if (root.maze.getPosStatus(root.pos) == MazeStatus.GOAL) {
                    /*
                     * if this is a leaf and it is the GOAL
                     * the path finish successfully:
                     * build path and add it to the list of solutions
                     */

                    Path newPath = new Path();
                    MazePosition p = root.pos;
                    while (p != null) {
                        /*
                         * Notice that cells must be reversed when building the path
                         * as we are traversing backwards from the goal towards the initial position
                         */
                        newPath.insertFirst(p.getCoords()[0], p.getCoords()[1]);
                        p = p.getFrom();
                    }

                    paths.add(newPath);

                }

                /*
                 * if it is a leaf but it is not the GOAL
                 * this path leads to a dead end:
                 * ignore and continue exploring other branches
                 */

            } else {
                /*
                 * not a leaf: continue deeper with its children
                 */
                for (PathsTree c : root.children) {
                    paths = c.findAllPaths(paths);
                }
            }
        }
        return paths;
    }

    /**
     * Models each node in the paths tree
     * Contains the position of the current step
     * and references to the next possible steps
     */
    private class PathsTreeNode {

        private Maze maze;
        private MazePosition pos;
        private ArrayList<PathsTree> children;

        PathsTreeNode(Maze maze, MazePosition pos) {
            this.maze = maze;
            this.pos = pos;
            this.children = new ArrayList<PathsTree>();
            this.stepForward();
        }

        void stepForward() {

            if (maze.getPosStatus(pos) != MazeStatus.GOAL) {
                // if GOAL reached, nowhere to go

                MazePosition next;
                for (Movement mov : Movement.values()) {
                    next = maze.getNeighbour(pos, mov);
                    if ((next != null)
                            && (maze.getPosStatus(next) == MazeStatus.OPEN || maze.getPosStatus(next) == MazeStatus.GOAL) // valid position
                            && !this.isAncestor(next)) // not already visited in this path
                    {
                        children.add(new PathsTree(maze, next));
                    }
                }
            }

        }

        /**
         * Checks whether pos is an ancestor of this
         */
        boolean isAncestor(MazePosition pos) {

            boolean res = false;
            MazePosition p = this.pos;
            while (p != null) {
                if (p.equals(pos)) {
                    return true;
                }
                p = p.getFrom();
            }
            return res;

        }

    }
}
