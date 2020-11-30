import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080); // OPTIONAL: By default Spark runs on port 4567, so we manually set it to 8080
        new Routes();
    }
}