public class cars {

    int price;
    int speed;
    String color;

    public cars(){

    }

    public cars(int price, int speed, String color){
        this.price = price;
        this.speed = speed;
        this.color = color;
    }

    public String toString(){
        return "Price: " + price + ", Speed: " + speed + ", Color: " + color;
    }

    public int compareTo(cars o){
        // if we want to keep our sorting RANK type(means less the rank, more the priority), then we will use "this.price - o.price"
        // if we want to keep our sorting MARKS type(means less the marks, less the priority), then we will use "o.price - this.price"
        return o.speed - this.speed;
    }
}