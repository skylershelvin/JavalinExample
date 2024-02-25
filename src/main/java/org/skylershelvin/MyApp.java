package org.skylershelvin;
import io.javalin.Javalin;
public class MyApp {
    public static void main(String[] args){
        //using Javalin to create and start and define your port
        Javalin app = Javalin.create().start(8080);
        // Define your routes and handlers
        app.get("/", ctx -> ctx.result("Hello, Javalin"));

        app.get("/tasks", TaskController::getAllTasks);
        app.get("/tasks/:id", TaskController::getTask);
        app.post("/tasks", TaskController::createTask);
        app.put("/tasks/:id", TaskController::updateTask);
        app.delete("/tasks/:id", TaskController::deleteTask);
    }
}
