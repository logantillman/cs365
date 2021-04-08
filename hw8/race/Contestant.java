// Author: Logan Tillman

package race;

import java.util.ArrayList;

class Contestant extends Thread {
    int contestantNumber;
    SynchronizedRandom random;
    TimeKeeper timeKeeper;

    public void run() {
        // System.out.printf("Contestant %d Running!!%n", this.contestantNumber);
        for (int i = 0; i < 4; i++) {
            int time = this.race();
            System.out.printf("%d %d\n", this.contestantNumber, time);

            timeKeeper.cumulativeTime[this.contestantNumber - 1] += time;
            timeKeeper.numSegments[this.contestantNumber - 1] += 1;
            timeKeeper.newSegment[this.contestantNumber - 1] = 1;
            timeKeeper.lastSegment[this.contestantNumber - 1] = time;
        }
        timeKeeper.finalQueue.push(this);
    }

    public synchronized int race() {
        // System.out.printf("Contestant %d started race%n", this.contestantNumber);
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