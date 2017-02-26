/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author Vika$h
 */
import java.util.Random;
public class MyRandom {

    public static final MyRandom myRandom = new MyRandom();

    private Random randomGenerator = new Random();

    public int makeRandom() {

        return 1+ randomGenerator.nextInt(100);
    }
}
