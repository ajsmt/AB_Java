class Exponential extends Series {
    public Exponential(double firstElement, double difference) {
        super(firstElement, difference);
    }

    @Override
    public double getJthElement(int j) {
        return firstElement * Math.pow(difference, j - 1);
    }

}