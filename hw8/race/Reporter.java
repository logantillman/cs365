// Author: Logan Tillman

package race;

class Reporter extends Thread {
    TimeKeeper timeKeeper;
    int numContestants;

    public void run() {
        while (timeKeeper.finalQueue.size() < numContestants) {
            try {
                sleep(2000);
                printInfo();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }

    void printInfo() {
        for (int i = 0; i < timeKeeper.cumulativeTime.length; i++) {
            System.out.printf("REPORTER: %d %d %d %d %d%n", i+1, timeKeeper.numSegments[i], timeKeeper.cumulativeTime[i], timeKeeper.newSegment[i], timeKeeper.lastSegment[i]);
            timeKeeper.newSegment[i] = 0;
        }
    }

    Reporter(TimeKeeper timeKeeper, int numContestants) {
        this.timeKeeper = timeKeeper;
        this.numContestants = numContestants;
        this.start();
    }
}