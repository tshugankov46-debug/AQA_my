package ru.qaway;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


class Shape {
  String color;

  public Shape(String color) {
    this.color = color;
  }

  public double getArea() {
    return 0.0;
  }
}

class Circle extends Shape {
  double radius; // добавляем своё поле

  public Circle(String color, double radius) { // принимаем оба параметра
    super(color); // передаём brand в родителя
    this.radius = radius; // своё поле инициализируем сами
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }
}

class Rectangle extends Shape {
  double height;
  double width; // добавляем своё поле

  public Rectangle(String color, double height, double width) { // принимаем оба параметра
    super(color); // передаём brand в родителя
    this.height = height;
    this.width = width;// своё поле инициализируем сами
  }

  @Override
  public double getArea() {
    return width * height;
  }
}

public class Main {
  public static void main(String[] args) {
    Circle circle = new Circle("Красный", 5.0);
    System.out.println("Цвет: " + circle.color + ", Площадь: " + circle.getArea());
    Rectangle rectangle = new Rectangle("Синий",3.0,5.0);
    System.out.println("Цвет: " + rectangle.color + ", Площадь: " + rectangle.getArea());
  }
}

interface Printable {
  void print();
        }

        class Document implements Printable {
  String title;

  public Document(String title) {
    this.title = title;
  }

  @Override
  public void print() {
    System.out.println("Печатаю документ: " + title);
  }
}

class Photo implements Printable {
  String resolution;

  public Photo(String resolution) {
    this.resolution = resolution;
  }

  @Override
  public void print() {
    System.out.println("Печатаю фото в разрешении: " + resolution);
  }
}

class taska {
  public static void main(String[] args) {
    Document document = new Document("ну и хуйня тайтл");
    Photo photo = new Photo("1000*12384");
    document.print();
    photo.print();
  }
}


class list {
  public static void main(String[] args) {
    List<String> tests = new ArrayList<>();
    tests.add("Login Test");
    tests.add("Checkout Test");
    tests.add("Login Admin Test");
    tests.add("Payment Test");
    tests.add("Login Mobile Test");

    for (String test : tests) {
      if (test.contains("Login")) {
        System.out.println(test);
      }
    }

    Map<String, String> testResults = new HashMap<>();
    testResults.put("Login Test", "PASSED");
    testResults.put("Checkout Test", "FAILED");
    testResults.put("Payment Test", "PASSED");
    testResults.put("Register Test", "FAILED");
    testResults.put("Profile Test", "PASSED");



    for (Map.Entry<String, String> entry : testResults.entrySet()) {
      if (entry.getValue().equals("FAILED")) {
        System.out.println(entry.getKey() + " → FAILED");
      }
    }

    Map<String, Integer> CityCount = new HashMap<>();
    CityCount.put("Алматы", 2000000);
    CityCount.put("Астана", 1200000);
    CityCount.put("Шымкент", 1000000);
    CityCount.put("Караганда", 500000);



    for (Map.Entry<String, Integer> entry : CityCount.entrySet()) {
      if (entry.getValue() > 1000000) {
        System.out.println("город" + entry.getKey() + " с населением больше 1миллиона");
      }
    }
  }
  }