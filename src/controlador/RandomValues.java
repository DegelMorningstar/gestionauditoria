/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Yael_
 */
public class RandomValues {

    public ArrayList<Integer> getRandomList(int limit, int muestra) {
        ArrayList<Integer> index = new ArrayList<>();
        int pos;
        Stack< Integer> pRandom = new Stack< Integer>();
        for (int i = 0; i < muestra; i++) {
            pos = (int) Math.floor(Math.random() * limit);
            while (pRandom.contains(pos)) {
                pos = (int) Math.floor(Math.random() * limit);
            }
            pRandom.push(pos);
        }
        while (!pRandom.isEmpty()) {
            index.add(pRandom.pop());
        }
        return index;
    }
}
