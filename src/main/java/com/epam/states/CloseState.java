package com.epam.states;

import com.epam.ui.Task;

public class CloseState extends State {

  public CloseState(Task task) {
    super(task);
  }

  @Override
  public String open() {
    return "open";
  }

  @Override
  public String toString() {
    return "closed";
  }
}
