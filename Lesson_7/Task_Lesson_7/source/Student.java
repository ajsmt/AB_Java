public class Student extends Person  implements Notifier.Notifiable{
    private String login;
    private String email;

    public Student(String name, String login, String email) {
        super(name);
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString() + ", login: " + login + ", email: " + email;
    }

    @Override
    public void notify(String message) {
        System.out.println("<" + this.getName() + "> got message: " + message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;
        return super.equals(other) && 
                login.equals(other.login) &&
                email.equals(other.email);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += login.hashCode();
        result += email.hashCode();
        return result;
    }
}
