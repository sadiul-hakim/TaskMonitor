package xyz.sadiulhakim.task;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.sadiulhakim.user.User;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByAssignee(User user);

    List<Task> findByParent(Task parent);
}