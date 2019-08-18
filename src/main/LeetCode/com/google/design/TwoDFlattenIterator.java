package com.google.design;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.PrimitiveIterator;

public class TwoDFlattenIterator {
    static class Vector2D {
        ListIterator<int[]> it;
        Iterator<Integer> inner;
        /*int[][] v;
        int x, y;*/

        public Vector2D(int[][] v) {
            it = Arrays.asList(v).listIterator();
           /* this.v = v;
            x=0; y=0;*/
        }

        public int next() {
            hasNext();
            return inner.next();
            // return v[x][y++];
        }

        public boolean hasNext() {
            // this can cover empty array, as the following test case
            while (inner==null || !inner.hasNext()) {
                if (it.hasNext()) inner = Arrays.stream(it.next()).boxed().iterator();
                else return false;
            }
            return true;
            /*while (x<v.length && y==v[x].length) {
                x++; y=0;
            }
            return x<v.length && y<v[x].length;*/
        }
    }

    public static void main(String... args) {
        // no matter array or list, there can be null for a single entry, as follow
        Vector2D vector2D = new Vector2D(new int[][]{{}, {}, {-1}});
        System.out.println(vector2D.hasNext());
        System.out.println(vector2D.next());
        System.out.println(vector2D.hasNext());
        /*System.out.println(vector2D.next());
        System.out.println(vector2D.next());
        System.out.println(vector2D.hasNext());
        System.out.println(vector2D.hasNext());
        System.out.println(vector2D.next());
        System.out.println(vector2D.hasNext());*/
    }

}
