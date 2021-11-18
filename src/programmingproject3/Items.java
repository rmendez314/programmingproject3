package programmingproject3;

public class Items {
    String name;
    int price;
    int value;

    public Items(String name, int price, int value) {
        setName(name);
        setPrice(price);
        setValue(value);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
         return this.name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }

}
