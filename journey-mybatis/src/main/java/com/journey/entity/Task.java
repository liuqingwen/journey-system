package com.journey.entity;

/**
 * @author liuqingwen
 * @date 2018/12/23.
 */
public class Task implements java.io.Serializable {

    private static final long serialVersionUID = -7642572927508930781L;
    public int id;
    private String taskName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
