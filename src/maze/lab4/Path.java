package maze.lab4;

public class Path {

    /** First position in the path */
    private PathStep first;

    /** Last position in the path */
    private PathStep last;

    /**
     * Initializes empty path
     */
    public Path() {
        this.first = null;
        this.last = null;
    }


    /**
     * Insert the given coordinates as a new step in the first position of the path
     */
    public void insertFirst(int row, int col) {
        PathStep n = new PathStep(row, col);
        if (this.first == null) {  // empty list
            this.first = n;
            this.last = n;
        } else {  // non-empty list
            n.setNext(first);
            first.setPrev(n);
            first = n;
        }
    }

    /**
     * Insert the given coordinates as a new step in the last position of the path
     */
    public void insertLast(int row, int col) {
        PathStep n = new PathStep(row, col);
        if (this.last == null) {  // empty list
            this.first = n;
            this.last = n;
        } else {  // non-empty list
            last.setNext(n);
            n.setPrev(last);
            last = n;
        }
    }

    /**
     * Returns the coordinates of the first step in the path and removes it from the path.
     * If the Path is empty, returns null.
     */
    public int[] extractFirst() {
        int[] coords = null;
        if (first != null) {
            coords = new int[] { first.getRow(), first.getCol() };
            first = first.getNext();
            if (first != null) {
                first.setPrev(null);
            } else {
                last = null;
            }
        }
        return coords;
    }

    /**
     * Returns the coordinates of the last step in the path and removes it from the path.
     * If the Path is empty, returns null.
     */
    public int[] extractLast() {
        int[] coords = null;
        if (last != null) {
            coords = new int[] { last.getRow(), last.getCol() };
            last = last.getPrev();
            if (last != null) {
                last.setNext(null);
            } else {
                first = null;
            }
        }
        return coords;
    }

    /**
     * Returns a String based representation of the Path.
     * If the Path is empty, returns an empty String ("")
     * If the Path is not empty, returns an String with the format:
     * (row1, col1), (row2, col2), ..., (rowN, colN)
     */
    public String toString() {

        String sPath = "";
        PathStep s = null;

        if (first != null) {
            sPath = "(" + first.getRow() + ", " + first.getCol() + ")";
            s = first.getNext();
        }
        while (s != null) {
            sPath = sPath + ", " + "(" + s.getRow() + ", " + s.getCol() + ")";
            s = s.getNext();
        }

        return sPath;
    }


    /*
     * Checks whether two paths are equals.
     * Two paths are equals if they consist of the same sequence of steps.
     */
    public boolean equals(Object o) {

        Path otherPath = (Path) o;
        PathStep s = first;
        PathStep os = otherPath.first;

        // Strictly, it should also check that s.prev and os.prev are null
        // but we are assuming the path is correctly built

        while ((s != null) && (os != null)) {
            if ((s.getRow() != os.getRow()) || (s.getCol() != os.getCol())) {
                return false;
            }
            s = s.getNext();
            os = os.getNext();
        }

        // If both paths are equal, both s and os should be null
        return s == os;

    }

}
