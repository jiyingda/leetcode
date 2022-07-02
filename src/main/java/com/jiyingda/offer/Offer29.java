/**
 * @(#)Offer29.java, 1月 28, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        List<Integer> reList = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        if(matrix.length == 1){
            for(int i = 0; i < matrix[0].length; i++){
                reList.add(matrix[0][i]);
            }
            int[] re = new int[reList.size()];
            for (int p = 0; p < reList.size(); p++) {
                re[p] = reList.get(p);
            }

            return re;
        }
        if(matrix[0].length == 1){
            for(int i = 0; i < matrix.length; i++){
                reList.add(matrix[i][0]);
            }
            int[] re = new int[reList.size()];
            for (int p = 0; p < reList.size(); p++) {
                re[p] = reList.get(p);
            }
            return re;
        }
        int nl = 0;
        int nr = matrix[0].length - 1;
        int ml = 0;
        int mr = matrix.length -1;
        int i = 0;
        int j = 1;
        int fx = 0;

        reList.add(matrix[0][0]);
        while ((nl <= j && j <= nr) && (ml <=i && i <= mr)){
            if(fx == 0){
                while (j < nr){
                    reList.add(matrix[i][j]);
                    j++;
                }
                reList.add(matrix[i][j]);
                fx = 1;
                ml++;
                i++;
            }else if(fx == 1){
                while(i < mr){
                    reList.add(matrix[i][j]);
                    i++;
                }
                reList.add(matrix[i][j]);
                fx = 2;
                nr--;
                j--;
            }else if(fx == 2){
                while (j > nl){
                    reList.add(matrix[i][j]);
                    j--;
                }
                reList.add(matrix[i][j]);
                fx = 3;
                mr--;
                i--;
            }else {
                //fx == 3
                while (i > ml){
                    reList.add(matrix[i][j]);
                    i--;
                }
                reList.add(matrix[i][j]);
                fx = 0;
                nl++;
                j++;
            }
        }
        int[] re = new int[reList.size()];
        for (int p = 0; p < reList.size(); p++) {
            re[p] = reList.get(p);
        }

        return re;
    }
}
