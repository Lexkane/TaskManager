package com.epam.ui;

import com.epam.states.State;

public class Task {
    private State state;
    private String description;
    private String/*enum*/ difficulty;

    public Task(){
    }

    public Task(State state, String description, String difficulty){
        this.state = state;
        this.state.setTask(this);
        this.description = description;
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public State getState(){
        return state;
    }

    public void changeState(State newState){
        this.state = newState;
        this.state.setTask(this);
    }

    @Override
    public String toString() {
        return "Task{" +
            "state=" + state +
            ", description='" + description + '\'' +
            ", difficulty='" + difficulty + '\'' +
            '}';
    }
}
