package example.imooc;

public class JoinClient {
    public static void main(String[] args) throws InterruptedException {
        Thread backEndDev = createWork("backed dev","backend Coding");
        Thread frontEndDev = createWork("fronted dev","frontend Coding");
        Thread tester = createWork("tester", "testing");



        backEndDev.start();
        frontEndDev.start();
        backEndDev.join();
        frontEndDev.join();

        tester.start();


    }

    private static Thread createWork(String role ,String work){
        return new Thread(()->{
            System.out.println("I finished " + work + " as a " + role);
        });
    }
}
