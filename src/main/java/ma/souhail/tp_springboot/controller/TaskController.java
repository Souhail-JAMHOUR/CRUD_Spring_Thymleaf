package ma.souhail.tp_springboot.controller;

import ma.souhail.tp_springboot.dto.TaskDTO;
import ma.souhail.tp_springboot.entities.Task;
import ma.souhail.tp_springboot.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TaskController {
  public TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }


  @GetMapping("/all")
  @ResponseBody
  public List<Task> getAllTasks() {
    return this.taskService.getTasks();
  }
  @GetMapping(path="/index")
  public String getAllTask(Model model){
    List<Task> taskList = this.taskService.getTasks();
    model.addAttribute("tasklist",taskList);
    return "task";
  }

  @GetMapping("/{id}")
  @ResponseBody
  public Task getTask(@PathVariable Long id) {
    return this.taskService.getTaskById(id);
  }

  @PutMapping("/update/{id}")
  @ResponseBody
  public Task updateTask(@PathVariable long id, @RequestBody Task task) {
    return this.taskService.updateTask(id, task);
  }

  @PostMapping("/createTask")
  @ResponseBody
  public Task createTask(@RequestBody TaskDTO task) {
    return this.taskService.createTask(task);
  }

  @DeleteMapping("/delete/{id}")
  @ResponseBody
  public void deleteTask(@PathVariable long id){
    this.taskService.deleteTask(id);
  }

  @GetMapping("/delete")
  public String delete(Long id) {
    this.taskService.deleteTask(id);
    return "redirect:/index";
  }

  @GetMapping("/")
  public String home(){
    return "redirect:/index";
  }
}
