public class Number2 {
    public static void main(String[] args){
        Being p = new Person();
        p.say();
        Being s = new Superhero();
        s.say();
        Being k = new Kryptonian();
        k.say();
        ((Kryptonian)k).fly();
    }

    public abstract static class Being {
        abstract void say();
    }

    public static class Person extends Being{
        public void say(){
            System.out.println("I am a person");
        }
    }

    public static class Superhero extends Being{
        public void say(){
            System.out.println("I am a hero");
        }
    }

    public interface CanFly {
        void fly();
    }

    public static class Kryptonian extends Superhero implements CanFly{
        public void say(){
            System.out.println("I am a hero from Krypton");
        }

        public void fly() {
            System.out.println("I am a flying");
        }
    }
}
