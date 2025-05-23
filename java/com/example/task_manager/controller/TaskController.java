package com.example.task_manager.controller;

import com.example.task_manager.model.Task;
import com.example.task_manager.model.TaskPriority;
import com.example.task_manager.model.TaskStatus;
import com.example.task_manager.service.MemberService;
import com.example.task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    private final MemberService memberService;

    public TaskController(TaskService taskService, MemberService memberService){
        this.taskService = taskService;
        this.memberService = memberService;
    }

    @GetMapping
    public String getAllTasks(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks/list";
    }

    @GetMapping("/new")
    public String addTask(Model model){
        model.addAttribute("task", new Task());
        model.addAttribute("members", memberService.getAllMembers());
        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());
        return "tasks/add";
    }

    @PostMapping
    public String createTask(@ModelAttribute("task") Task task){
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model){
        model.addAttribute("task", taskService.getTaskById(id));
        model.addAttribute("members", memberService.getAllMembers());
        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());
        return "tasks/add";
    }

    @PostMapping("/edit")
    public String saveTask(@ModelAttribute("task")Task task, Model model){
        taskService.saveTask(task);
        model.addAttribute("members", memberService.getAllMembers());
        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
