/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 *
 * @author me
 */
public class MyRandom extends Random {

    LinkedHashSet<Integer> randomPool;
    Iterator<Integer> poolIter;

    public MyRandom(int n) {
        randomPool = new LinkedHashSet<Integer>();
        while (randomPool.size() < (n)) {
            Integer next = super.nextInt(n);
            if (!randomPool.contains(next)) {
                randomPool.add(next);
            }
        }
        poolIter = randomPool.iterator();
    }

    public int nextInt() {
        if (!poolIter.hasNext()) {
            poolIter = randomPool.iterator();
        }
        Integer val = poolIter.next();
        poolIter.remove();
        return val;
    }
}
