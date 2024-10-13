class Linear extends Series{
    public Linear(double firstElement, double difference) {
        super(firstElement, difference);
    }

    @Override
    public double getJthElement(int j) {
        return firstElement + (j - 1) * difference;
    }
}
