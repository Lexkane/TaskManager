package com.epam.states;

import com.epam.ui.Task;

public abstract class State {

  private Task task;

  public State(Task task) {
    this.task = task;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public String open() {

    return "locked";
  }

  public String inProgress() {

    return "locked";
  }

  public String resolve() {

    return "locked";
  }

  public String reopen() {

    return "locked";
  }

  public String close() {

    return "locked";
  }
}
