public class Tern<A,B,C> {
    private A first; //first member of pair
    private B second; //second member of pair
    private C third;
    public Tern(){
    }


    public Tern(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public void setTern(A first, B second, C third){
        this.first= first;
        this.second=second;
        this.third = third;   
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public void setSecond(B second) {
        this.second = second;
    }
    public void setThird (C third){
        this.third=third;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
    public C getThird(){
        return third;
    }
    public String toString(){
        return "("+first+","+ second +","+third+")"; 
    }
}