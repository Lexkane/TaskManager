package com.epam.ui;

import com.epam.states.CloseState;
import com.epam.states.InProgressState;
import com.epam.states.OpenState;

import com.epam.states.ReopenState;
import com.epam.states.ResolveState;
import com.epam.states.State;
import java.util.*;

import static com.epam.ui.Util.input;

public class UI {

  private Task currentTask;
  private List<Task> tasks;
  private Map<String, State> changeStateOption;

  private List<String> mainMenu;
  private List<String> adminMenu;
  private List<String> userMenu;
  private List<String> userTaskMenu;
  private Map<String, Performable> mainMenuMethod;
  private Map<String, Performable> adminMenuMethod;
  private Map<String, Performable> userMenuMethod;
  private Map<String, Performable> userTaskMenuMethod;

  public UI() {
    tasks = new ArrayList<>();
    mainMenu = new ArrayList<>();
    mainMenu.add("A. Admin");
    mainMenu.add("U. User");
    mainMenu.add("Q. Exit");
    mainMenuMethod = new HashMap<>();
    mainMenuMethod.put("A", this::showAdminMenu);
    mainMenuMethod.put("U", this::showUserMenu);

    adminMenu = new ArrayList<>();
    adminMenu.add("1. Add task");
    adminMenu.add("2. Delete task");
    adminMenu.add("Q. Exit");
    adminMenuMethod = new HashMap<>();
    adminMenuMethod.put("1", this::addTask);
    adminMenuMethod.put("2", this::deleteTask);

    userMenu = new ArrayList<>();
    userMenu.add("1. Choose task");
    userMenu.add("Q. Exit");
    userMenuMethod = new HashMap<>();
    userMenuMethod.put("1", this::showUserTaskMenu);

    userTaskMenu = new ArrayList<>();
    userTaskMenu.add("1. Change state");
    userTaskMenu.add("Q. Exit");
    userTaskMenuMethod = new HashMap<>();
    userTaskMenuMethod.put("1", this::showUserStateMenu);
  }

  public void setCurrentTask(Task task) {
    this.currentTask = task;
  }

  private void setOptions() {
    if (changeStateOption == null) {
      this.changeStateOption = new HashMap<>();
    }

    changeStateOption.clear();
    changeStateOption
        .put(currentTask.getState().open(), new OpenState(new Task()));
    changeStateOption.put(currentTask.getState().inProgress(),
        new InProgressState(new Task()));
    changeStateOption
        .put(currentTask.getState().resolve(), new ResolveState(new Task()));
    changeStateOption
        .put(currentTask.getState().reopen(), new ReopenState(new Task()));
    changeStateOption
        .put(currentTask.getState().close(), new CloseState(new Task()));
    changeStateOption.remove("locked");
  }

  private void printOptions() {
    setOptions();

    for (String option : changeStateOption.keySet()) {
      if (!option.equals("locked")) {
        System.out.println(option);
      }
    }
  }

  public void chooseMenu(Map<String, Performable> method, List<String> option) {
    String choose;
    while (true) {
      //encapsulate
      for (String o : option) {
        System.out.println(o);
      }

      System.out.println("Please, select menu point:");
      choose = input.nextLine().toUpperCase();
      try {
        method.get(choose).perform();
      } catch (Exception e) {
        if (choose.equals("Q")) {
          break;
        }
      }
    }
  }

  public void showMainMenu() {
    chooseMenu(mainMenuMethod, mainMenu);
  }

  public void showAdminMenu() {
    chooseMenu(adminMenuMethod, adminMenu);
  }

  public void showUserMenu() {
    chooseMenu(userMenuMethod, userMenu);
  }

  public void showUserTaskMenu() {
    if (tasks.isEmpty()) {
      System.out.println("No tasks!");
      chooseMenu(userTaskMenuMethod, userTaskMenu);
    }
    for (int i = 1; i <= tasks.size(); i++) {
      System.out.println(i + " " + tasks.get(i - 1));
    }
    while (true) {
      System.out.println("Input task index:");
      String choose = input.nextLine();
      try {
        currentTask = tasks.get(Integer.parseInt(choose) - 1);
        break;
      } catch (Exception e) {
        System.out.println("Invalid index!!!");
      }
    }
    showUserStateMenu();
  }

  public void showUserStateMenu() {
    String choose;

    while (true) {
      printOptions();
      System.out.println("Q - Exit");
      System.out.println("Please, select menu point:");
      choose = input.nextLine();
      if (changeStateOption.keySet().contains(choose)) {
        currentTask.changeState(changeStateOption.get(choose));
      } else if (choose.equals("Q")) {
        return;
      }
    }
  }

  public void addTask() {
    Task task = new Task();
    task.changeState(new OpenState(new Task()));
    System.out.println("Describe task:");
    task.setDescription(input.nextLine());
    System.out.println("Choose difficulty:");
    task.setDifficulty(input.nextLine());
    tasks.add(task);
  }

  public void deleteTask() {
    //TODO
  }
}