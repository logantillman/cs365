// Author: Logan Tillman

package race;

import java.util.ArrayList;

class Contestant extends Thread {
    int contestantNumber;
    SynchronizedRandom random;
    TimeKeeper timeKeeper;

    public void run() {

        /* Running the 4 segments of the race */
        for (int i = 0; i < 4; i++) {
            int time = this.race();

            /* Reporting the time after the segment is finished */
            timeKeeper.reportTime(this.contestantNumber, time);
        }

        /* Reporting that the contestant has finished the race */
        timeKeeper.finish(this);
    }

    /* Method that performs one segment of the race */
    public synchronized int race() {

        /* Generating a random number from 1000-8000 and sleeping for that amount of time */
        int time = this.random.nextInt();
        try {
            this.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        return time;
    }

    Contestant(int contestantNumber, SynchronizedRandom random, TimeKeeper timeKeeper) {
        this.contestantNumber = contestantNumber;
        this.random = random;
        this.timeKeeper = timeKeeper;
        this.start();
    }
}