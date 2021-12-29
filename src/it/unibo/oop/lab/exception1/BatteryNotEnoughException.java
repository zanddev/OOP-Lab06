package it.unibo.oop.lab.exception1;

/**
 * Represents an exception that occurs when a robot tries to move in its
 * environment when the battery is not enough for the movement.
 * 
 */
public final class BatteryNotEnoughException extends IllegalStateException {

    /**
     * 
     */
    private static final long serialVersionUID = 5322262957171100503L;
    private final int x;
    private final int y;
    private final double level;

    /**
     * Construct new instance of the exception.
     * 
     * @param newX
     *            position on X where the robot tried to go when the exception occurred
     * @param newY
     *            position on Y where the robot tried to go when the exception occurred
     * @param batteryLevel
     *            battery level that caused the exception
     */
    public BatteryNotEnoughException(final int newX, final int newY, final double batteryLevel) {
        super();
        this.x = newX;
        this.y = newY;
        this.level = batteryLevel;
    }

    /**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "Can not move to pos(" + this.x + "," + this.y + "). Not enough battery (" + this.level + ").";
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
