package Q1;
import java.util.Random;
public class MyRandom {

    public static final MyRandom myRandom = new MyRandom();

    private Random randomGenerator = new Random();

    public int makeRandom() {

        return 1+ randomGenerator.nextInt(100);
    }
}