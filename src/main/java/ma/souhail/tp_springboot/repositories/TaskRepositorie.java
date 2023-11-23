package ma.souhail.tp_springboot.repositories;

import ma.souhail.tp_springboot.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositorie extends JpaRepository<Task,Long> {

}
