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

    public ArrayList<Integer> getRandomList(int limit) {
        ArrayList<Integer> index = new ArrayList<>();
        int pos;
        Stack< Integer> pCartas = new Stack< Integer>();
        for (int i = 0; i < limit; i++) {
            pos = (int) Math.floor(Math.random() * limit);
            while (pCartas.contains(pos)) {
                pos = (int) Math.floor(Math.random() * limit);
            }
            pCartas.push(pos);
        }
        while (!pCartas.isEmpty()) {
            index.add(pCartas.pop());
        }
        return index;
    }
}
