// Author: Logan Tillman

package race;

import java.util.Random;

class SynchronizedRandom {
    Random random;

    SynchronizedRandom() {
        this.random = new Random();
    }

    /* Generating a random number between 1000 and 8000 */
    public synchronized int nextInt() {
        return this.random.nextInt(7001) + 1000;
    }
}