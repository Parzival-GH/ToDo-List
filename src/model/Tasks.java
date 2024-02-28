package model;

import enums.TaskStatus;

public class Tasks {

    public int id;
    private String description;
    private TaskStatus status;

    public Tasks(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Tasks() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + status + "] " + description;
    }
}
