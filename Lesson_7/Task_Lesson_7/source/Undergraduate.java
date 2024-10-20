public class Undergraduate extends Student {
    private Academic supervisor;

    public Undergraduate(String name, String login, String email, Academic supervisor) {
        super(name, login, email);
        this.supervisor = supervisor;
    }

    public Academic getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Academic supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return super.toString() + ", supervisor: " + supervisor.toString() + ", Undegraduate";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Postgraduate)) {
            return false;
        }
        Undergraduate other = (Undergraduate) obj;
        return super.equals(obj) && supervisor.equals(other.supervisor);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 3 * supervisor.hashCode();
        return result;
    }
}
