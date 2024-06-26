import java.util.concurrent.atomic.AtomicInteger;

public class Dessert {
    public int flavour;
    public int price;

    private static final AtomicInteger numDessert = new AtomicInteger(0);

    public Dessert(int startingFlavour, int startingPrice){
        flavour = startingFlavour;
        price = startingPrice;
        numDessert.incrementAndGet();
    }

    public void printDessert(){
        int printFlavour = this.flavour;
        int printPrice = this.price;
        int currentNum = numDessert.get();

        System.out.println(printFlavour +" " + printPrice + " " + currentNum);
    }

    public static void main(String[] args){
        System.out.println("I love dessert!");
    }




}
