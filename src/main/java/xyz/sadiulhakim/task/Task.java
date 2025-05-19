package xyz.sadiulhakim.task;

import jakarta.persistence.*;
import xyz.sadiulhakim.enumeration.Priority;
import xyz.sadiulhakim.enumeration.TaskStatus;
import xyz.sadiulhakim.user.User;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Integer id;

    @Lob
    private String instruction;

    @ManyToOne
    private User assignee;

    private Long estimateTime;

    private Instant startTime;

    private Instant endTime;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Task parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Task> subtasks;

    private String remark;

    public boolean isRoot() {
        return this.parent == null;
    }

    public Task() {
    }

    public Task(Integer id, String instruction, User assignee, Long estimateTime, Instant startTime, Instant endTime,
                Priority priority, TaskStatus status, Task parent, List<Task> subtasks, String remark) {
        this.id = id;
        this.instruction = instruction;
        this.assignee = assignee;
        this.estimateTime = estimateTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.status = status;
        this.parent = parent;
        this.subtasks = subtasks;
        this.remark = remark;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Long getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(Long estimateTime) {
        this.estimateTime = estimateTime;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Task getParent() {
        return parent;
    }

    public void setParent(Task parent) {
        this.parent = parent;
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Task> subtasks) {
        this.subtasks = subtasks;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(instruction, task.instruction) &&
                Objects.equals(assignee, task.assignee) && Objects.equals(estimateTime, task.estimateTime) &&
                Objects.equals(startTime, task.startTime) && Objects.equals(endTime, task.endTime) &&
                status == task.status && Objects.equals(parent, task.parent) && Objects.equals(subtasks, task.subtasks)
                && Objects.equals(remark, task.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instruction, assignee, estimateTime, startTime, endTime, status, parent, subtasks, remark);
    }
}
