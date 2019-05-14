package com.epam.states;

import com.epam.ui.Task;

public class ReopenState extends State {

  public ReopenState(Task task) {
    super(task);
  }

  @Override
  public String inProgress() {
    return "in progress";
  }

  @Override
  public String toString() {
    return "reopened";
  }
}
