/**
 * Created By Chase Rivera
 * Tested By Chase Rivera
 */
package hw1;

public class Cab {
    /**
     * Base Cab Fare
     */
    private double givenBaseFare;

    /**
     * Base Cash Rate Per Mile
     */
    private double givenPerMileRate;

    /**
     * true if pickUp() is called
     */
    private boolean hasPassenger;

    /**
     * The total miles driven and cash collected over this cabs life time
     */
    private double totalMiles, totalCash;

    /**
     * The distance traveled, cash collected, and rate of this drive
     */
    private double currentMiles, currentCash, currentRate;

    /**
     * Sets the base fare and cash per mile rate
     * @param givenBaseFare the base fare for this cab
     * @param givenPerMileRate the cash per mile rate of this cab
     */
    public Cab(double givenBaseFare, double givenPerMileRate) {
        this.givenBaseFare = givenBaseFare;
        this.givenPerMileRate = givenPerMileRate;

        this.hasPassenger = false;
        this.currentMiles = 0;
        this.totalMiles = 0;
        this.currentCash = 0;
        this.totalCash = 0;
        this.currentRate = 0;
    }

    /**
     * Drives the cab the given number of miles, updating the total miles
     * and possibly updating the meter
     * @param miles distance to drive
     */
    public void drive(double miles) {
    	if(this.hasPassenger()) {
    		this.currentMiles += miles;
        	this.currentCash += miles * this.currentRate;
    	} else this.totalMiles += miles;
    }

    /**
     * Starts a new ride, setting the meter to the base fare
     * and setting the current rate to the per mile charge
     */
    public void pickUp(){
        this.currentRate = givenPerMileRate;
        if(this.hasPassenger()) {
        	this.currentCash = this.givenBaseFare;
        } else {
            this.currentCash += this.givenBaseFare;
        	this.hasPassenger = true;
        }
    }

    /**
     * Ends the current ride, updating the total cash collected and resetting the meter
     * and current rate to 0
     */
    public void dropOff() {
        this.hasPassenger = false;
        this.totalCash += this.currentCash;
        this.totalMiles += this.currentMiles;

        this.currentCash = 0;
        this.currentRate = 0;
        this.currentMiles = 0;
    }

    /**
     * Returns the average income earned by this cab per mile driven
     * @return average income earned by this cab
     */
    public double getAverageIncomePerMile() {
    	if(totalMiles != 0) {
    		return this.totalCash / this.totalMiles;
    	} else return 0;
    }

    /**
     * Returns the current per-mile rate, which is always either zero or
     * the per-mile rate given in the constructor
     * @return current per-mile rate
     */
    public double getCurrentRate() {
        return this.currentRate;
    }

    /**
     * Returns the amount of money shown on the meter for the current ride
     * @return amount of money shown on meter
     */
    public double getMeter() {
    	if(hasPassenger()) {
    		return this.currentCash;
    	} else return 0;
    }

    /**
     * Returns the total cash collected by this cab during its lifetime
     * @return total lifetime cash
     */
    public double getTotalCash() {
        return this.totalCash;
    }

    /**
     * Returns the total miles driven by this cab over its lifetime
     * @return total lifetime miles
     */
    public double getTotalMiles() {
        if(this.totalMiles == 0){
            return this.currentMiles;
        } else return this.totalMiles;
    }

    /**
     * Determines whether the cab currently has a passenger
     * @return true if cab has passenger
     */
    public boolean hasPassenger() {
        return this.hasPassenger;
    }
}
