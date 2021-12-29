package it.unibo.oop.lab.exception1;

/**
 * Models a generic Robot.
 * 
 */
public class Robot {

    private static final int BATTERY_EMPTY = 0;
    private static final int MOVEMENT_DELTA = 1;
    private static final double MOVEMENT_DELTA_CONSUMPTION = 0.1;
    private static final double BATTERY_FULL = 100;

    private double batteryLevel;
    private final RobotEnvironment environment;
    private final String robotName;

    /**
     * 
     * @param robotName
     *            name of the robot
     * @param batteryLevel
     *            initial battery level
     * @throws Exception
     */
    public Robot(final String robotName, final double batteryLevel) {
        this.batteryLevel = batteryLevel;
        this.environment = new RobotEnvironment(new RobotPosition(0, 0));
        this.robotName = robotName;
    }

    /**
     * Moves the robot up by one unit.
     * 
     * @throws PositionOutOfBoundsException
     *            if the robot tries to move out of the top bound
     * @throws BatteryNotEnoughException
     *            if the robot tries to move when the battery is exhausted
     */
    public void moveUp() throws PositionOutOfBoundsException, BatteryNotEnoughException {
        this.moveToPosition(this.environment.getCurrPosX(),
                this.environment.getCurrPosY() + Robot.MOVEMENT_DELTA);
    }

    /**
     * Moves the robot down by one unit.
     * 
     * @throws PositionOutOfBoundsException
     *            if the robot tries to move out of the bottom bound
     * @throws BatteryNotEnoughException
     *            if the robot tries to move when the battery is exhausted
     */
    public void moveDown() throws PositionOutOfBoundsException, BatteryNotEnoughException {
        this.moveToPosition(this.environment.getCurrPosX(),
                this.environment.getCurrPosY() - Robot.MOVEMENT_DELTA);
    }

    /**
     * Moves the robot left by one unit.
     * 
     * @throws PositionOutOfBoundsException
     *            if the robot tries to move out of the left bound
     * @throws BatteryNotEnoughException
     *            if the robot tries to move when the battery is exhausted
     */
    public void moveLeft() throws PositionOutOfBoundsException, BatteryNotEnoughException {
        this.moveToPosition(this.environment.getCurrPosX() - Robot.MOVEMENT_DELTA,
                this.environment.getCurrPosY());
    }

    /**
     * Moves the robot right by one unit.
     * 
     * @throws PositionOutOfBoundsException
     *            if the robot tries to move out of the right bound
     * @throws BatteryNotEnoughException
     *            if the robot tries to move when the battery is exhausted
     */
    public void moveRight() throws PositionOutOfBoundsException, BatteryNotEnoughException {
        this.moveToPosition(this.environment.getCurrPosX() + Robot.MOVEMENT_DELTA,
                this.environment.getCurrPosY());
    }

    /**
     * Fully recharge the robot.
     */
    public void recharge() {
        this.batteryLevel = Robot.BATTERY_FULL;
    }

    /**
     * move a robot to the specified position.
     * 
     * @param newX
     *            the new X position to move the robot to
     * @param newY
     *            the new Y position to move the robot to
     * @throws PositionOutOfBoundsException
     *            if the robot tries to move out of bounds
     * @throws BatteryNotEnoughException
     *            if the robot tries to move when the battery is exhausted
     */
    private void moveToPosition(final int newX, final int newY) throws
            PositionOutOfBoundsException, BatteryNotEnoughException {
        if (this.isBatteryEnoughToMove()) {
            this.environment.move(newX, newY);
            this.consumeBatteryForMovement();
            this.log("Moved to position(" + newX + "," + newY + ").");
        } else {
            throw new BatteryNotEnoughException(newX, newY, this.batteryLevel);
        }
        return;
    }

    /**
     * Consume the amount of energy required to move the robot subtracting it
     * from the current battery level.
     */
    protected void consumeBatteryForMovement() {
        this.consumeBattery(Robot.MOVEMENT_DELTA_CONSUMPTION);
    }

    /**
     * Consume the amount of energy provided in input from the battery.
     * 
     * @param amount
     *            the amount of battery energy to consume
     */
    protected void consumeBattery(final double amount) {
        if (batteryLevel >= amount) {
            this.batteryLevel -= amount;
        } else {
            this.batteryLevel = Robot.BATTERY_EMPTY;
        }
    }

    /**
     * 
     * @return A boolean indicating if the robot has enough energy to move
     */
    protected boolean isBatteryEnoughToMove() {
        return this.getBatteryLevel() >= Robot.MOVEMENT_DELTA_CONSUMPTION;
    }

    /**
     * 
     * @return The robot's current battery level
     */
    public double getBatteryLevel() {
        return (double) Math.round(this.batteryLevel * 100) / 100;
    }

    /**
     * 
     * @return The robot environment
     */
    public RobotEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * Log to stdout the string provided in input.
     * 
     * @param msg
     *            the msg to print
     */
    protected void log(final String msg) {
        System.out.println("[" + this.robotName + ":]" + msg);
    }
}
