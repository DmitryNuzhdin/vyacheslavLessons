package WebToDoList.DataBase;
import WebToDoList.Models.Task.Task;
import WebToDoList.Models.User.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//@Scope(scopeName = "prototype")
public class Db{
    Map<String,Task> taskMap = new HashMap<>();
    Map<String, User> userMap = new HashMap<>();
}
