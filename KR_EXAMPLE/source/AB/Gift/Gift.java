package AB.Gift;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import AB.Sweets.Candy;

public class Gift implements Iterable<Candy>{
    private List<Candy> candies;

    public Gift() {
        this.candies = new ArrayList<>();
    }

    public Gift(List<Candy> candies) {
        this.candies = candies;
    }

    public void add(Candy candy) {
        candies.add(candy);
    }

    public Gift(Gift gift) {
        this.candies = new ArrayList<>(gift.candies);
    }

    public double getWeight() {
        double totalWeight = 0;
        for (Candy candy : candies) {
            totalWeight += candy.getWeight();
        }
        return totalWeight;
    }

    public double getSugar() {
        double totalSugar = 0;
        for (Candy candy : candies) {
            totalSugar += candy.getSugarAmount();
        }
        return totalSugar;
    }

    public double getPrice() {
        double totalPrice = 0;
        for (Candy candy : candies) {
            totalPrice += candy.getPrice();
        }
        return totalPrice;
    }

    public void sortCandies(Comparator<Candy> comparator) {
        Collections.sort(candies, comparator);
    }

    public void copyAllCandiesTo(Gift gift) {
        gift.candies.addAll(candies);
    }

    public void setCandies(List<Candy> candies){
        this.candies = candies;
    }

    public List<Candy> findCandiesBySugar(double minSugar, double maxSugar) {
        List<Candy> result = new ArrayList<>();
        for (Candy candy : candies) {
            if ((candy.getSugarAmount() >= minSugar) && (candy.getSugarAmount() <= maxSugar)) {
                result.add(candy);
            }
        }
        return result;
    }

    public List<Candy> findCandiesByPredicate(Predicate<Candy> predicate) {
        List<Candy> result = new ArrayList<>();
        for (Candy candy : candies) {
            if (predicate.test(candy)) {
                result.add(candy);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Candy candy : candies) {
            sb.append(candy).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Candy> iterator() {
        return candies.iterator();
    }

    public void clearGift(){
        candies.clear();
    }
}