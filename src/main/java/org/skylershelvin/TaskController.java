package org.skylershelvin;
import io.javalin.http.Context;
import java.util.ArrayList;
import java.util.List;
public class TaskController {
    //create a list of strings to hold task
    private static List<String> task = new ArrayList<>();
    //create a method to take the context and of the HTTP request and response
    public static void getAllTasks(Context ctx){
        //set the response body
        ctx.json(task);
    }

    // Create CRUD endpoint for task
    public static void getTask(Context ctx) {
        int taskId = Integer.parseInt(ctx.pathParam("id"));
        if (taskId >= 0 && taskId < task.size()) {
            ctx.json(task.get(taskId));
        } else {
            ctx.status(404).result("Task not found");
        }
    }
    public static void createTask(Context ctx){
       String newTask = ctx.formParam("task");
       task.add(newTask);
       ctx.status(201).result("Task created successfully");
        }
        public static void updateTask(Context ctx){
        int taskId = Integer.parseInt(ctx.pathParam("id"));
        if ( taskId >= 0 && taskId < task.size()) {
            String updatedTask = ctx.formParam("task");
            task.set(taskId, updatedTask);
        } else {
            ctx.status(404).result("Task not found");
        }
    }
    public static void deleteTask(Context ctx){
        int taskId = Integer.parseInt(ctx.pathParam("id"));
        if (taskId >= 0 && taskId < task.size()) {
            task.remove(taskId);
            ctx.result("Task deleted successfully");
        } else {
            ctx.status(404).result("Task not found");
        }
    }
}
