// Author: Logan Tillman

package race;

import java.util.Random;

class SynchronizedRandom {
    Random random;

    SynchronizedRandom() {
        this.random = new Random();
    }

    public synchronized int nextInt() {
        return this.random.nextInt(7001) + 1000;
    }
}