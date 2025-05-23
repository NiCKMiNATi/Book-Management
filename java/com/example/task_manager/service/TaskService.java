package com.example.task_manager.service;

import com.example.task_manager.model.Task;
import com.example.task_manager.model.TaskPriority;
import com.example.task_manager.model.TaskStatus;
import com.example.task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    public List<Task> getAllTasks(){
        return taskRepo.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public Task saveTask(Task task){
        return taskRepo.save(task);
    }

    public void deleteTask(Long id){
        taskRepo.deleteById(id);
    }

    //Injecting the Repo Interface, so will have to use the below method
    public List<Task> getTasksByMemberId(Long memberId){
        return taskRepo.findByMemberId(memberId);
    }

    public List<Task> findTasksByStatus(TaskStatus status){
        return taskRepo.findByStatus(status);
    }

    public List<Task> findTasksByPriority(TaskPriority priority){
        return taskRepo.findByPriority(priority);
    }

}
