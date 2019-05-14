package com.epam.states;

import com.epam.ui.Task;

public class ResolveState extends State {

  public ResolveState(Task task) {
    super(task);
  }

  @Override
  public String reopen() {
    return "reopen";
  }

  @Override
  public String close() {
    return "close";
  }

  @Override
  public String toString() {
    return "resolved";
  }
}
