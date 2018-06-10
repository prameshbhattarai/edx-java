package maze.lab3;

public interface PathFinder {

    /**
     * Finds a path through the maze to the target
     * starting at coordinates (0,0)
     *
     * @param Path the path to the target goal
     */
    Path findPath(Maze maze);
}
