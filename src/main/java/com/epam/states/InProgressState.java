package com.epam.states;

import com.epam.ui.Task;

public class InProgressState extends State {

  public InProgressState(Task task) {
    super(task);
  }

  @Override
  public String resolve() {
    return "resolve";
  }

  @Override
  public String toString() {
    return "in progress";
  }
}
