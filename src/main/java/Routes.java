import static spark.Spark.*;

public class Routes {
    public Routes () {
        QueryEngine qe = new QueryEngine();

        get("/employee", (request, response) -> {
            return qe.query(request.queryParams("name"));
        });

        /*
            Examples - for more see https://sparkjava.com/documentation#routes
         */
        /*get("/", (request, response) -> {
            // Show something
            return "OK";
        });

        post("/", (request, response) -> {
            // Create something
            return "OK";
        });*/
    }
}
