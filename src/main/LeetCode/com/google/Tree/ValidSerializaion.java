package com.google.Tree;

public class ValidSerializaion {
    public static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int count = 1;
        for (int i=0; i<nodes.length; i++) {
            String node = nodes[i];
            if (node.equals("#")) {
                if (--count <= 0 && i!=nodes.length-1)
                    return false;
            } else count++;
        }
        return count == 0;
    }

    public static void main(String... args) {
        boolean res = isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        System.out.println(res);
    }
}
