
package com.homecontroller.models;

import java.util.ArrayList;

public class Player {

	public Integer gold;
	public ArrayList<String> tasks;

	public Player() {
		this.gold = 0;
		this.tasks = new ArrayList<String>();
	}

	public void addToTasks(String task) {
		tasks.add(task);
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public ArrayList<String> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<String> task) {
		this.tasks = task;
	}
}