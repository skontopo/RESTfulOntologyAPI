import static spark.Spark.*;

public class Routes {
    public Routes () {
        /*get("/hello", (req, res) -> {
            return "Hello World";
        });*/

        /*
            Examples
         */
        /*get("/", (request, response) -> {
            // Show something
            return "OK";
        });

        post("/", (request, response) -> {
            // Create something
            return "OK";
        });*/

        /*get("/hello/:name", (request, response) -> {
            return "Hello " + request.params(":name");
        });*/

        QueryEngine qe = new QueryEngine();

        get("/employee", (request, response) -> {
            return qe.query(request.queryParams("name"));
        });


    }
}
