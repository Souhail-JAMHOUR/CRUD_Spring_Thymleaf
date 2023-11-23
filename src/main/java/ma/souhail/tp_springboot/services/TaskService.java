package ma.souhail.tp_springboot.services;

import ma.souhail.tp_springboot.dto.TaskDTO;
import ma.souhail.tp_springboot.entities.Task;
import ma.souhail.tp_springboot.repositories.TaskRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
  private TaskRepositorie taskRepositorie;

  public TaskService(TaskRepositorie taskRepositorie) {
    this.taskRepositorie = taskRepositorie;
  }

  public List<Task> getTasks() {
    return this.taskRepositorie.findAll();
  }

  public Task getTaskById(Long id) {
    return this.taskRepositorie.findById(id).orElse(null);
  }

  public Task createTask(TaskDTO taskDTO) {
    Task newTask = Task.builder()
            .title(taskDTO.getTitle())
            .description(taskDTO.getDescription())
            .build();
    Task saved = this.taskRepositorie.save(newTask);
    return saved;
  }

  public Task updateTask(Long id, Task task) {
    Task taskById = getTaskById(id);
    if (task != null) {
      taskById.setDescription(task.getDescription());
      taskById.setTitle(task.getTitle());
      this.taskRepositorie.save(taskById);
    }
    return null;
  }

  public void deleteTask(Long id){
      Task taskById = this.getTaskById(id);
      if(taskById!=null){
          this.taskRepositorie.delete(taskById);
      }
  }
}
