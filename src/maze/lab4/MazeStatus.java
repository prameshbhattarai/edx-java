package maze.lab4;

public enum MazeStatus {
    OPEN(' '), OBSTACLE('#'), GOAL('x'), VISITED('.');

    private char text;

    MazeStatus(char s) {
        this.text = s;
    }

    public char text() {
        return this.text;
    }
}
