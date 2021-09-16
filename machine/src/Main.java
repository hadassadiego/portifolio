public class Main {

    public static void main(String[] args) {

        Machine<Integer> machine = new Machine<>();

        MonoOperation <Integer> monoOperation = (x -> x * x);
        System.out.println(machine.action(monoOperation, 3));

        BiOperation <Integer> biOperation = ((x, y) -> x + y);
        System.out.println(machine.action(biOperation, 5,9));

       // Car fiat = new Car("fiat", "blue");

        Machine<Car> carMachine = new Machine<>();

       /* BiOperation<Car> carBiOperation = (c1, c2) {
            c1.setColor(c2.getColor());
            return c1
        }*/

    }
}
