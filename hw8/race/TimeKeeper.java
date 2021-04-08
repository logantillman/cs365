// Author: Logan Tillman

package race;

import java.util.ArrayDeque;
import java.util.ArrayList;

class TimeKeeper {
    int cumulativeTime[];
    int numSegments[];
    int newSegment[];
    int lastSegment[];
    ArrayDeque<Contestant> finalQueue = new ArrayDeque<Contestant>();

    TimeKeeper(int numContestants) {
        this.cumulativeTime = new int[numContestants];
        this.numSegments = new int[numContestants];
        this.newSegment = new int[numContestants];
        this.lastSegment = new int[numContestants];

        /* Initializing the data */
        for (int i = 0; i < numContestants; i++) {
            this.cumulativeTime[i] = 0;
            this.numSegments[i] = 0;
            this.newSegment[i] = 0;
            this.lastSegment[i] = 0;
        }
    }

    /* Method for contestants reporting their time */
    public synchronized void reportTime(int contestantNumber, int time) {
        this.cumulativeTime[contestantNumber - 1] += time;
        this.numSegments[contestantNumber - 1] += 1;
        this.newSegment[contestantNumber - 1] = 1;
        this.lastSegment[contestantNumber - 1] = time;
    }

    /* Method for the contestants to report when they've finished the race */
    public void finish(Contestant contestant) {
        this.finalQueue.addLast(contestant);
    }
}