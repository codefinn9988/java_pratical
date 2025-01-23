//Create a class Distance with private variables feet of type integer
//and inches of type floating point.
//Use suitable constructor, and methods for adding 
//and comparing two distance objects. [Hint: 1 feet = 12 inches]
//for 6 marks in 2079

class Distance {
  private int feet; // Private variable for feet
  private float inches; // Private variable for inches

  // Constructor to initialize feet and inches
  public Distance(int feet, float inches) {
    this.feet = feet;
    this.inches = inches;
    normalize(); // Ensure inches are less than 12
  }

  // Method to add two Distance objects
  public Distance add(Distance d) {
    int totalFeet = this.feet + d.feet;
    float totalInches = this.inches + d.inches;
    return new Distance(totalFeet, totalInches);
  }

  // Method to compare two Distance objects
  public boolean isGreaterThan(Distance d) {
    if (this.feet > d.feet || (this.feet == d.feet && this.inches > d.inches)) {
      return true;
    }
    return false;
  }

  // Method to display distance
  public void display() {
    System.out.println(feet + " feet " + inches + " inches");
  }

  // Private method to normalize inches to less than 12
  private void normalize() {
    if (inches >= 12) {
      feet += (int) inches / 12;
      inches = inches % 12;
    }
  }

  public static void main(String[] args) {
    // Create two Distance objects
    Distance d1 = new Distance(5, 10.5f);
    Distance d2 = new Distance(3, 11.8f);

    // Add the two distances
    Distance d3 = d1.add(d2);
    System.out.print("Sum of distances: ");
    d3.display();

    // Compare the distances
    if (d1.isGreaterThan(d2)) {
      System.out.println("Distance 1 is greater than Distance 2.");
    } else {
      System.out.println("Distance 2 is greater than or equal to Distance 1.");
    }
  }
}
