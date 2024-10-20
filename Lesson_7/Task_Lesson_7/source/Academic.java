public class Academic extends Person{
    public Academic(String name){
        super(name);
    }

    @Override
    public String toString(){
        return "Academic [name=" + getName() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Academic)) {
            return false;
        }
        Academic other = (Academic) obj;
        return super.equals(other);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
