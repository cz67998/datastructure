package com.wangzhou.datastructure.unionfind;

import java.util.Random;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/7
 * Time:8:59
 **/
public class Main {
    private static double testUnionFind(UnionFind unionFind, int m) {
        int size = unionFind.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();


        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        // ArrayUnionFind 慢于 TreeUnionFind  TreeUnionFindSize慢于TreeUnionFind
//        int size = 100000;
//        int m = 10000;
        // TreeUnionFind 慢于 ArrayUnionFind, TreeUnionFindSize最快
        int size = 10000000;
        int m = 10000000;

//        ArrayUnionFind uf1 = new ArrayUnionFind(size);
//        System.out.println("ArrayUnionFind : " + testUnionFind(uf1, m) + " s");
//
//        TreeUnionFind uf2= new TreeUnionFind(size);
//        System.out.println("TreeUnionFind : " + testUnionFind(uf2, m) + " s");
//
        TreeUnionFindSize uf3 = new TreeUnionFindSize(size);
        System.out.println("TreeUnionFindSize : " + testUnionFind(uf3, m) + " s");

        TreeUnionFindRank uf4 = new TreeUnionFindRank(size);
        System.out.println("TreeUnionFindRank : " + testUnionFind(uf4, m) + " s");

        TreeUnionFindPathCompression uf5 = new TreeUnionFindPathCompression(size);
        System.out.println("TreeUnionFindPathCompression : " + testUnionFind(uf5, m) + " s");

        TreeUnionFindPathCompressionRecur uf6 = new TreeUnionFindPathCompressionRecur(size);
        System.out.println("TreeUnionFindPathCompressionRecur : " + testUnionFind(uf6, m) + " s");
    }

}
