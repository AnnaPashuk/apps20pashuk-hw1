package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {

    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
    }

    public double average() {
        /**
         * This method is used to calculate the average value of
         * elements in double list.
         * @param sum This is the parameter for sum of all elements
         * @param res  This is the parameter to represent the result
         *             of the method
         * @return double This returns average value.
         */
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Empty array");
        } else {
            double sum = 0.0;
            for (int i = 0; i < temperatureSeries.length; i++) {
                sum += temperatureSeries[i];
            }
            double res = sum / temperatureSeries.length;
            return res;
        }
    }

    public double deviation() {
        /**
         * This method is used to find a deviation of all of
         * elements in double list.
         * @param standardDeviation This is the parameter to represent the
         *                          result of  calculating deviation.
         * @param avg  This is the parameter to represent the average value.
         * @return double This returns deviation.
         */
        double standardDeviation = 0.0;
        double avg = average();
        for (double num:temperatureSeries) {
            standardDeviation += (num - avg)*(num - avg);
        }
        return Math.sqrt(standardDeviation/temperatureSeries.length);

    }

    public double min() {
        /**
         * This method is used to find a minimal value among all of
         * elements in double list.
         * If array is empty, it throws an exception IllegalArgumentException.
         * @param minTemp This is the parameter to represent minimal element.
         * @param minI  This is the parameter to represent current minimal
         *              element in the loop.
         * @return double This returns minimal element.
         */
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Empty array");
        } else {
            double minTemp = temperatureSeries[0];
            int i = 0;
            while (i < temperatureSeries.length - 1) {
                double minI = Math.min(temperatureSeries[i],
                        temperatureSeries[i + 1]);
                if (minI < minTemp) {
                    minTemp = minI;
                }
                i++;
            }
            return minTemp;
        }
    }

    public double max() {
        /**
         * This method is used to find a maximal value among all of
         * elements in double list.
         * If array is empty, it throws an exception IllegalArgumentException.
         * @param maxTemp This is the parameter to represent maximal
         *                element.
         * @param maxI  This is the parameter to represent current minimal
         *              element in the loop.
         * @return double This returns maximal element.
         */
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Empty array");
        } else {
            double maxTemp = temperatureSeries[0];
            int i = 0;
            while (i < temperatureSeries.length - 1) {
                double maxI = Math.max(temperatureSeries[i],
                        temperatureSeries[i + 1]);
                if (maxI > maxTemp) {
                    maxTemp = maxI;
                }

                i++;

            }
            return maxTemp;
        }
    }

    public double findTempClosestToZero() {
        /**
         * This method is used to find element from the array,
         * which value is closest to zero.
         * @return double This returns result of method
         * findTempClosestToValue with value 0..
         */
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        /**
         * This method is used to find element from the array,
         * which value is closest to given double value.
         * If array is empty, it throws an exception
         * IllegalArgumentException.
         * @param closestDist This is the parameter to represent
         *                    closest distance to given value.
         * @param closest  This is the parameter to represent
         *                 closest element to given value.
         * @return double This returns closest element.
         */
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Empty array");
        } else {
            double closestDist = Math.abs(temperatureSeries[0] - tempValue);
            double closest = temperatureSeries[0];
            for (int i = 1; i < temperatureSeries.length; i++) {
                double closestI = Math.abs(temperatureSeries[i] - tempValue);
                if (closestI < closestDist || closestI == closestDist
                        & temperatureSeries[i] > closest) {
                    closestDist = closestI;
                    closest = temperatureSeries[i];
                }
            }
            return closest;
        }

    }

    public double[] findTempsLessThen(double tempValue) {
        /**
         * This method is used to find all elements from the array,
         * which value is less than given double value.
         * If array is empty, it throws an exception
         * IllegalArgumentException.
         * @param counter This is the parameter to number of such
         *                elements.
         * @param newCounter  This is the parameter to represent
         *                    the current position in new array.
         * @param less This is the parameter to represent double
         *             array of such elements.
         * @return double This returns array of these elements.
         */
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Empty array");
        } else {
            int counter = 0;
            for (int i = 0; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] < tempValue) {
                    counter += 1;
                }
            }
            int newCounter = 0;
            double[] less = new double[counter];
            for (int i = 0; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] < tempValue) {
                    less[newCounter] = temperatureSeries[i];
                    newCounter += 1;
                }

            }
            return less;
        }
    }

    public double[] findTempsGreaterThen(double tempValue) {
        /**
         * This method is used to find all elements from the array,
         * which value is greater or equal to given double value.
         * If array is empty, it throws an exception
         * IllegalArgumentException.
         * @param counter This is the parameter to number of such
         *                elements.
         * @param newCounter  This is the parameter to represent
         *                    the current position in new array.
         * @param more This is the parameter to represent double
         *             array of such elements.
         * @return double This returns array of these elements.
         */
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Empty array");
        } else {
            int counter = 0;
            for (int i = 0; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] >= tempValue) {
                    counter += 1;
                }
            }
            int newCounter = 0;
            double[] more = new double[counter];
            for (int i = 0; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] >= tempValue) {
                    more[newCounter] = temperatureSeries[i];
                    newCounter += 1;
                }

            }
            return more;
        }
    }

    public TempSummaryStatistics summaryStatistics() {
        /**
         * This method is used to create an immutable
         * instance of the
         * TempSummaryStatistics class that contains
         * information: double avgTemp,
         * double devTemp, double minTemp, double maxTemp;
         * If array is empty, it throws an exception
         * IllegalArgumentException.
         * @param temp This is the parameter of new immutable
         *             instance of the
         *             TempSummaryStatistics class.
         * @return TempSummaryStatistics class.
         */
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Empty array");
        } else {
            TempSummaryStatistics temp = new TempSummaryStatistics(
                    this.average(), this.deviation(),
                    this.min(), this.max());
            return temp;
        }
    }


    public int addTemps(double... temps) {
        /**
         * This method is used to Adds new temperature values to the end of
         * existing data, and returns the total number of temperature values.
         * If array is empty, it throws an exception IllegalArgumentException.
         * @param newLength This is the parameter of new length of array.
         * @param newTemp  This is the parameter to represent the new array
         *                 of size newLength.
         * @param counter This is the parameter to represent the current
         *                position in new array.
         * @return int This returns the total number of temperature values.
         */
        int newLength = temperatureSeries.length;
        if (newLength == 0) {
            newLength += 1;
        }
        while (newLength < temps.length + temperatureSeries.length) {
            newLength *= 2;
        }
        double[] newTemp = new double[newLength];
        int counter = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {

            newTemp[counter] = temperatureSeries[i];
            counter++;
        }
        for (int i = 0; i < temps.length; i++) {

            newTemp[counter] = temps[i];
            counter++;
        }
        return counter;
    }
}

