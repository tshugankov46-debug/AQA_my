package ru.qaway;

public class TestCase {
  String name;
  String status;
  int duration;

  public TestCase(String name, String status, int duration) {
    this.name = name;
    this.status = status;
    this.duration = duration;
  }

  public void printInfo() {
    System.out.println("Тест: " + name + ", статус: " + status + ", время: " + duration + "с");
  }
}