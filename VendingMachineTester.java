//////////////// FILE HEADER //////////////////////////
//
// Title: VENDING MACHINE
// Course: CS 300 Fall 2022
//
// Author: VARDAAN KAPOOR
// Email: vkapoor5@wisc.edu
// Lecturer: Professor Hobbes LeGault
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;

public class VendingMachineTester {
  // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.
    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;
      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of containsItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testContainsItem() {
    // Define at least two test scenarios: (1) successful search returning true and (2) unsuccessful
    // search returning false.
    // testing scenario 1:object exists in Vending Machine and we try to find it
    {
      String[][] items = new String[][] {{"Water", "20"}, {"Cold Drink", "20"}, {"Water", "34"},
          {"Soda", "134"}, null, null};
      int itemsCount = 4;// keeps track of items we care about
      String ds = "Water";// item we want to search
      if (VendingMachine.containsItem(ds, items, itemsCount) != true) {
        return false;
      }
    }
    // testing scenario 2:object doesn't exist in array and we try to find it
    {
      String[][] items = new String[][] {{"Water", "20"}, {"Cold Drink", "20"}, {"Water", "34"},
          {"Soda", "134"}, null, null};
      int itemsCount = 4;
      String ds = "Biscuit";
      if (VendingMachine.containsItem(ds, items, itemsCount) != false) {
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
                 // Feel free to change it.
  }
  // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected

  public static boolean testGetItemAtIndex() {
    // Define at least two test scenarios: (1) the provided index is out of the range
    // 0..itemsCount-1, (2) the provided index is in bounds [0..itemsCount-1].
    // For each test scenario, ensure that the method returned the exact expected string output
    // without making any changes to the contents of the array.
    // scenario 1:index out of bounds
    {
      String[][] items = new String[][] {{"Water", "20"}, {"Cold Drink", "20"}, {"Water", "34"},
          {"Soda", "134"}, null, null};
      int itemsCount = 4;
      int index = 8;
      if (VendingMachine.getItemAtIndex(index, items, itemsCount) != "ERROR INVALID INDEX") {
        return false;
      }
    }
    // scenario 2:index inside bounds
    {
      String[][] items = new String[][] {{"Water", "20"}, {"Cold Drink", "20"}, {"Water", "34"},
          {"Soda", "134"}, null, null};
      int itemsCount = 4;
      int index = 3;
      if (VendingMachine.getItemAtIndex(index, items, itemsCount) == "ERROR INVALID INDEX") {
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
  public static boolean testGetItemsOccurrences() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    // (2) the items array contains multiple occurrences of the provided item description.

    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.
    // scenario 1:no match found
    {
      String[][] items = new String[][] {{"Water", "20"}, {"Cold Drink", "20"}, {"Water", "34"},
          {"Soda", "134"}, null, null};
      int itemsCount = 4;
      String des = "Tomato";
      if (VendingMachine.getItemOccurrences(des, items, itemsCount) != 0)

      {
        return false;
      }
    }
    // scenario 2:match is found
    {
      String[][] items = new String[][] {{"Water", "20"}, {"Cold Drink", "20"}, {"Water", "34"},
          {"Soda", "134"}, null, null};
      int itemsCount = 4;
      String des = "Water";
      if (VendingMachine.getItemOccurrences(des, items, itemsCount) == 0)

      {
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of addItem defined in the VendingMachine class.
  public static boolean testAddItem() {
    // Define at least three test scenarios: (1) adding a new item to an empty vending machine whose
    // size is zero (provided itemsCount == 0), (2) adding a new item to a non-empty non-full
    // vending machine, and (3) adding a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.
    // scenario 1:add new item to empty array
    {
      String[][] items = new String[10000][2];
      String des = "Water";
      String c = "16";
      int itemsCount = 0;
      if (VendingMachine.addItem(des, c, items, itemsCount) != (itemsCount + 1)) {
        return false;
      }
    }
    // scenario 2:add new item to non-full array
    {
      String[][] items = new String[][] {{"Water", "13"}, {"Cold Drink", "34"}, {"Soda", "56"}};
      int itemsCount = 2;
      String desc = "Biscuit";
      String expdate = "444";
      if (VendingMachine.addItem(desc, expdate, items, itemsCount) != (itemsCount + 1)) {
        return false;
      }
    }
    // scenario 3:add items to full array
    {
      String[][] items = new String[][] {{"Water", "13"}, {"Cold Drink", "34"}, {"Soda", "56"}};
      int itemsCount = 3;
      String desc = "Biscuit";
      String expdate = "444";
      if (VendingMachine.addItem(desc, expdate, items, itemsCount) != itemsCount) {
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of removeNextItem defined in the VendingMachine class.
  public static boolean testRemoveNextItem() {
    // Define at least four test scenarios: (1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not), (2) the next item to be removed matching
    // the provided description is at index 0 of the array, (3) the next item to be removed is at
    // index itemsCount of the array (at the end of the array), and (4) the next item to be removed
    // is at a middle index of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.
    // scenario 1:remove non existent item from not empty array
    {
      String[][] items = new String[][] {{"Water", "23"}, {"Cold Drink", "22"}, {"Soda", "45"},
          {"Water", "78"}, {"Soda", "41"}, {"Cold Drink", "11"}, null, null, null};
      int itemsCount = 6;
      String desc = "Macronni";
      if (VendingMachine.removeNextItem(desc, items, itemsCount) != itemsCount) {
        return false;
      }
    }
    // scenario 2:remove non existent item from empty array
    {
      String[][] items = new String[1000][2];
      int itemsCount = 0;
      String desc = "Macronni";
      if (VendingMachine.removeNextItem(desc, items, itemsCount) != itemsCount) {
        return false;
      }
    }
    // scenario 3:remove item at index 0
    {
      String[][] items = new String[][] {{"Water", "23"}, {"Cold Drink", "22"}, {"Soda", "45"},
          {"Water", "78"}, {"Soda", "41"}, {"Cold Drink", "11"}, null, null};
      String desc = "Water";
      int itemsCount = 6;
      if (VendingMachine.removeNextItem(desc, items, itemsCount) == itemsCount) {
        return false;
      }
    }
    // scenario 4:remove item from last index
    {
      String[][] items = new String[][] {{"Water", "23"}, {"Cold Drink", "22"}, {"Soda", "45"},
          {"Water", "78"}, {"Soda", "41"}, {"Cold Drink", "11"}};
      String desc = "Cold Drink";
      int itemsCount = 6;
      if (VendingMachine.removeNextItem(desc, items, itemsCount) == itemsCount) {
        return false;
      }
    }
    // scenario 5:remove item from middle index
    {
      String[][] items = new String[][] {{"Water", "23"}, {"Cold Drink", "22"}, {"Soda", "45"},
          {"Water", "78"}, {"Soda", "41"}, {"Cold Drink", "11"}};
      String desc = "Soda";
      int itemsCount = 6;
      if (VendingMachine.removeNextItem(desc, items, itemsCount) == itemsCount) {
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemsSummary defined in the VendingMachine class.
  public static boolean testGetItemsSummary() {
    // Define at least three scenarios: (1) the vending machine is empty, (2) the vending machine
    // contains non duplicate items (no multiple items with the same description), (3) the vending
    // machine contains multiple items with the same description at various index locations.
    // scenario 1:empty array
    {
      String[][] items = new String[1000][2];
      int itemsCount = 0;
      if (VendingMachine.getItemsSummary(items, itemsCount) != "") {
        return false;
      }
    }
    // scenario 2:no duplicate entries
    {
      String[][] items = new String[][] {{"Water", "23"}, {"Cold Drink", "22"}, {"Soda", "45"}};
      int itemsCount = 3;
      if (VendingMachine.getItemsSummary(items, itemsCount) == "") {
        return false;
      }
    }
    // scenario 3:duplicate entries
    {
      String[][] items = new String[][] {{"Water", "23"}, {"Cold Drink", "22"}, {"Soda", "45"},
          {"Water", "78"}, {"Soda", "41"}, {"Cold Drink", "11"}};
      int itemsCount = 6;
      if (VendingMachine.getItemsSummary(items, itemsCount) == "") {
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    if (testGetIndexNextItem() != true || testContainsItem() != true || testGetItemAtIndex() != true
        || testGetItemsOccurrences() != true || testAddItem() != true
        || testRemoveNextItem() != true || testGetItemsSummary() != true) {
      return false;
    } else {
      return true;
    }
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
    System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
    System.out.println("runAllTests(): " + runAllTests());
  }
}

