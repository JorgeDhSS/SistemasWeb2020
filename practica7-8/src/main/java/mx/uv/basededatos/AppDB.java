package mx.uv.basededatos;
import static spark.Spark.*;

import java.util.UUID;

import com.google.gson.*;
public class AppDB {
    private static Gson gson = new Gson();
    
    public static void main( String[] args ){
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
        before((req, res)->res.type("application/json"));
        get("/usuariosget", (req, res)->gson.toJson(DAO.dameUsuarios()));
        post("/usuariosC", (req, res)->{
            String query = req.body();
            System.out.println( "Petición: "+query);
            Usuarios u = gson.fromJson(query, Usuarios.class);
            String id = UUID.randomUUID().toString();
            u.setId(id);
            return DAO.crearUsuarios(u);
        });
        post("/usuariosUpdate", (req, res)->{
            String query = req.body();
            System.out.println( "Petición: "+query);
            Usuarios u = gson.fromJson(query, Usuarios.class);
            return DAO.updateUsuarios(u);
        });
        post("/usuariosDelete", (req, res)->{
            String query = req.body();
            System.out.println( "Petición: "+query);
            Usuarios u = gson.fromJson(query, Usuarios.class);
            return DAO.deleteUsuarios(u);
        });
    }
}
