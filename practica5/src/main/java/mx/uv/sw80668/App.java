package mx.uv.sw80668;

import static spark.Spark.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });
        // recibe un parámetro llamado "prtemail" con el método get y se lo regresa al
        // cliente junto con "hello"
        get("/queryparams", (request, response) -> {
            return "Hello: " + request.queryParams("prtemail");
        });

        // recibe dos parámetros llamados "PrtEmail" y "PrtPassword" con el método POST
        // y se lo regresa como impresión en consola, adicional regresa la palabra
        // "algo" pero no regresa una respuesta al cliente por lo cual no le permite
        // cambiar el h1
        post("/json", (request, response) -> {
            // enviado con URLSearchParams, es decir los parámetros son sensibles al caso
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(request.body());
            JsonObject peticion = arbol.getAsJsonObject();

            System.out.println("prm: " + peticion.get("PrtEmail"));
            System.out.println("prm: " + peticion.get("PrtPassword"));
            return "algo";
        });
        // recibe dos parámetros llamados "PrtEmail" y "PrtPassword" y en tería imprime
        // ambos parámetros y el body, así como content type
        post("/formdata", (request, response) -> {

            /*
             * tener cuidado de usar request.body antes de request.queryParams o viceversa
             * debido a que el framework consume el contenido al momento de usarlo
             */
            System.out.println("prm1: " + request.queryParams("prtemail"));
            System.out.println("prm2: " + request.queryParams("prtPassword"));

            System.out.println("prm: " + request.body());
            System.out.println("prm: " + request.contentType());

            return "algo";
        });
    }
}
