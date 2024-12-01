package AB.Data;

import java.util.ArrayList;
import java.util.List;

public class KeyboardSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private char currentKey = ' ';

    @Override
    public void attach(Observer observer){
        this.observers.add(observer);
    }
    
    @Override
    public void detach(Observer observer){
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(currentKey);
        }
    }

    public void setCurrentKey(char key){
        this.currentKey = key;
        notifyObservers();
    }
}
