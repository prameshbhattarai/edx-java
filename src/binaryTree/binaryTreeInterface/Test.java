package binaryTree.binaryTreeInterface;

public class Test {

    public static void main(String args[]) {
        try {
            BTree<String> colorGreen = new DummyTree<String>("color=GREEN");
            BTree<String> colorYellow = new DummyTree<String>("color=YELLOW");
            BTree<String> sizeBig = new DummyTree<String>("size=BIG");
            BTree<String> sizeMedium = new DummyTree<String>("size=MEDIUM");
            BTree<String> sizeSmall = new DummyTree<String>("size=SMALL");
            BTree<String> shapeRound = new DummyTree<String>("shape=ROUND");
            BTree<String> tasteSweet = new DummyTree<String>("taste=SWEET");

            BTree<String> watermelon = new DummyTree<String>("watermelon");
            BTree<String> apple = new DummyTree<String>("apple");
            BTree<String> grape = new DummyTree<String>("grape");
            BTree<String> lemon = new DummyTree<String>("lemon");
            BTree<String> banana = new DummyTree<String>("banana");
            BTree<String> cherry = new DummyTree<String>("cherry");
            BTree<String> berry = new DummyTree<String>("berry");
            BTree<String> orange = new DummyTree<String>("orange");

            colorGreen.insert(sizeBig, BTree.LEFT);
            colorGreen.insert(colorYellow, BTree.RIGHT);

            sizeBig.insert(watermelon, BTree.LEFT);
            sizeBig.insert(sizeMedium, BTree.RIGHT);

            colorYellow.insert(shapeRound, BTree.LEFT);
            colorYellow.insert(sizeSmall, BTree.RIGHT);

            sizeMedium.insert(apple, BTree.LEFT);
            sizeMedium.insert(grape, BTree.RIGHT);
            shapeRound.insert(lemon, BTree.LEFT);
            shapeRound.insert(banana, BTree.RIGHT);
            sizeSmall.insert(tasteSweet, BTree.LEFT);
            sizeSmall.insert(orange, BTree.RIGHT);

            tasteSweet.insert(cherry, BTree.LEFT);
            tasteSweet.insert(berry, BTree.RIGHT);

            System.out.println(colorGreen.toStringPreOrder());
            System.out.println(colorGreen.size());
            System.out.println(colorGreen.height());

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
