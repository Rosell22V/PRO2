package exc02;

public class Main {
    public static void main(String[] args) {
        binaryTree<Integer> t25 = new binaryTree<>(25);
        binaryTree<Integer> t30 = new binaryTree<>(30, t25, null);

        binaryTree<Integer> t15 = new binaryTree<>(15);
        binaryTree<Integer> t11 = new binaryTree<>(11, null, t15);

        binaryTree<Integer> t22 = new binaryTree<>(22,t11,t30);

        binaryTree<Integer> t88 = new binaryTree<>(88);
        binaryTree<Integer> t90 = new binaryTree<>(90, t88, null);

        binaryTree<Integer> t77 = new binaryTree<>(77, null, t90);

        binaryTree<Integer> t45 = new binaryTree<>(45,t22,t77);

        System.out.println(t45.getHeight());

        System.out.println(t45.getSize());

        System.out.println(t45.getLeafCount());

        t45.printPreorder();
        System.out.println();
        t45.printInorder();
        System.out.println();
        t45.printPostorder();
        System.out.println();
        // t45.printLevelOrder();
        System.out.println();
        System.out.println(t45.listInorder());
    }
}
