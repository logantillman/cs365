// Author: Logan Tillman

package race;

import java.util.ArrayDeque;
import java.util.ArrayList;

class TimeKeeper {
    // ArrayList<Integer> cumulativeTime; = new ArrayList<Integer>();
    // ArrayList<Integer> numSegments; = new ArrayList<Integer>();
    // ArrayList<Integer> newSegment; = new ArrayList<Integer>();
    // ArrayList<Integer> timeRequired; = new ArrayList<Integer>();
    int cumulativeTime[];
    int numSegments[];
    int newSegment[];
    int lastSegment[];
    ArrayDeque<Contestant> finalQueue = new ArrayDeque<Contestant>();

    TimeKeeper(int numContestants) {
        cumulativeTime = new int[numContestants];
        numSegments = new int[numContestants];
        newSegment = new int[numContestants];
        lastSegment = new int[numContestants];

        for (int i = 0; i < numContestants; i++) {
            cumulativeTime[i] = 0;
            numSegments[i] = 0;
            newSegment[i] = 0;
            lastSegment[i] = 0;
        }
    }
}