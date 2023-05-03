import java.util.List;
import java.util.Iterator;

public class Blink {
    private static String sep = System.lineSeparator();

    private long startTime;
    private int fiftyPercentStartTime;
    private int fiftyPercentEndTime;
    private int amplitude;
    private BlinkStyle style;
    private BlinkGazeAssociation gazeAssociation;

    public Blink(long startTime, int fiftyPercentStartTime, int fiftyPercentEndTime, int amplitude, 
                 BlinkStyle style, BlinkGazeAssociation gazeAssociation) {
        this.startTime = startTime;
        this.fiftyPercentStartTime = fiftyPercentStartTime;
        this.fiftyPercentEndTime = fiftyPercentEndTime;
        this.amplitude = amplitude;
        this.style = style;
        this.gazeAssociation = gazeAssociation;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getFiftyPercentStartTime() {
        return this.fiftyPercentStartTime;
    }

    public int getFiftyPercentEndTime() {
        return this.fiftyPercentEndTime;
    }

    public int getAmplitude() {
        return this.amplitude;
    }

    public BlinkStyle getStyle() {
        return this.style;
    }

    public BlinkGazeAssociation getGazeAssociation() {
        return this.gazeAssociation;
    }

    public String toString() {
        String returnString = "BLINK" + "\n" +
            "\tStartTime:   " + this.getStartTime() + sep +
            "\t50% Start:   " + this.getFiftyPercentStartTime() + sep +
            "\t50% End:     " + this.getFiftyPercentEndTime() + sep +
            "\tAmplitude:   " + this.getAmplitude() + sep +
            "\tStyle:       " + this.getStyle() + sep +
            "\tAssociation: " + this.getGazeAssociation();

        return returnString;
    }

    public boolean matches(List<BlinkSelectionCriterion> selectionCriteria) {

        for (Iterator<BlinkSelectionCriterion> iter = selectionCriteria.iterator(); iter.hasNext(); ) {
            BlinkSelectionCriterion criterion = iter.next();
            if (!criterion.doesBlinkMatch(this)) {
                return false;
            }
        }

        // If we get here, this Blink has passed all the criteria checks
        // and therefore matches.
        return true;
    }

}