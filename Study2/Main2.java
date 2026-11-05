public class Main2 {
    public void main(String[] args){
        MyHashMap<Integer, String> myHashMap= new MyHashMap<>();
        myHashMap.put(1, "one");
        myHashMap.put(2, "two");
        myHashMap.put(0, "zero");
        myHashMap.put(3, "three");
        myHashMap.put(4, "four");
        myHashMap.put(5, "five");
        System.out.println(myHashMap.get(4));

    }
}
