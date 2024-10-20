import java.util.HashSet;
import java.util.Set;

public class Notifier {
    private Set<Notifiable> notifiables;

    public Notifier(Set<Student> notifiables){
        this.notifiables = new HashSet<>(notifiables);
        this.notifiables.addAll(notifiables);
    }

    public void doNotifyAll(String message) {
        for (Notifiable notifiable : notifiables) {
            notifiable.notify(message);
        }
    }

    public interface Notifiable {
        void notify(String message);
    }
}
