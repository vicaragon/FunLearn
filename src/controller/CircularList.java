/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author me
 */

    public class CircularList<E> extends ArrayList<E> {

        @Override
        public E get(int index) {
            return super.get(index % size());
        }
    }
