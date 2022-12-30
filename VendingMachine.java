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
public class VendingMachine {
  String description;
  String expirationDate;
  String[][] items = new String[10000][2];
  int itemsCount = 0;

  /**
   * Adds/appends an item defined by its description and expirationDate to a vending machine
   * represented by an oversize array of strings defined by the two-dimensional array items and its
   * size itemsCount. The item will be added to the end of the array. If the vending machine is
   * full, the new item won't be added and the method returns the items count passed as input
   * without making any changes to the contents of the array items.
   * 
   * @param description    description of the item to be added to the vending machine
   * @param expirationDate a string parsable to a positive integer which represents the expiration
   *                       date of the item. The date "0" represents January 1st 2023.
   * @param items          a two-dimensional of strings storing items. items[i][0] and items[i][1]
   *                       respectively represent the description and the expiration date of the
   *                       item stored at index i
   * @param itemsCount     number of items in the vending machine
   * @return the size of the vending machine after trying to add the new item
   */

  public static int addItem(String description, String expirationDate, String[][] items,
      int itemsCount) {
    // Note that we suppose that the expirationDate is valid, meaning it is
    // correctly
    // parsable to a positive integer
    // {{"Water","10"},{"Water","10"},{"Water","10"},{"Water","10"},null,null} , itemSize= 4
    int l = items.length;
    if (l != 0 && itemsCount == 0) {
      items[itemsCount] = new String[] {description, expirationDate};
      return itemsCount + 1;
    }
    if (itemsCount < l) {
      items[itemsCount] = new String[] {description, expirationDate};
      return itemsCount + 1;
    }

    else {
      return itemsCount;
    }
  }



  /**
   * Returns without removing a string representation of the item at the given index within the
   * vending machine defined by the array items and its size itemsCount. This method does not make
   * any changes to the contents of the vending machine.
   * 
   * @param items      two dimensional array storing items within a vending machine where
   *                   items[i][0] represents the description of the item at index i and items[i][1]
   *                   stores its expiration date.
   * @param itemsCount (size) number of items stored in the vending machine
   * @param index      index of an item within the provided vending machine
   * @return a string representation of the item stored at the given index within the vending
   *         machine defined by items and itemsCount. The returned string must have the following
   *         format: "description (expiration date)". If the provided index is out of the range of
   *         indexes 0..itemsCount-1, the method returns "ERROR INVALID INDEX"
   */
  public static String getItemAtIndex(int index, String[][] items, int itemsCount) {
    if (index >= 0 && index < itemsCount) {
      return items[index][0] + " (" + items[index][1] + ")";
    } else {
      return "ERROR INVALID INDEX";
    }
  }

  /**
   * Returns without removing the index of the item having the provided description and the smallest
   * expiration date within the vending machine defined by the array items and its size itemsCount.
   * 
   * @param description description of the item to get its index
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return the index of the next item, meaning the item with the given description and the
   *         smallest expiration date. If no match found, return -1.
   */
  public static int getIndexNextItem(String description, String[][] items, int itemsCount) {
    // If the vending machine contains more than one item with the given
    // description,
    // return the index o the one with the smallest expiration date.
    int collectindex = -1;
    int lowval = 100000;
    for (int i = 0; i < itemsCount; i++) {
      if (items[i][0].equals(description)) {
        if (Integer.parseInt(items[i][1]) < lowval) {
          collectindex = i;
          lowval = Integer.parseInt(items[i][1]);
        }
      }
    }
    return collectindex;
    // collectindex=-1 when no content value matches "description"
  }

  /**
   * Removes the item having the provided description with the smallest expiration date within the
   * vending machine defined by the array items and its size itemsCount. This method should maintain
   * the order of precedence of items in the vending machine. This means that the remove operation
   * involves a shift operation.
   * 
   * @param description description of the item to remove or dispense
   * @param items       array storing items within a vending machine
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return size of the vending machine after removing the item with the given description and the
   *         smallest expiration date. If no match found, this method must return the provided
   *         itemsCount without making any change to the contents of the vending machine.
   */
  public static int removeNextItem(String description, String[][] items, int itemsCount) {
    int collectindex = getIndexNextItem(description, items, itemsCount);
    if (collectindex != -1) {
      for (int j = collectindex; j < itemsCount - 1; j++) {
        items[j] = items[j + 1];
      }
      items[itemsCount - 1] = null;
      return itemsCount - 1;
    } else {
      return itemsCount;
    }
  }

  /**
   * Returns the number of occurrences of an item with a given description within the vending
   * machine defined by items and itemsCount
   * 
   * @param description description (name) of an item
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return the number of occurrences of an item with a given description within the vending
   *         machine
   */
  public static int getItemOccurrences(String description, String[][] items, int itemsCount) {
    int c = 0;
    for (int i = 0; i < itemsCount; i++) {
      if (items[i][0].equals(description)) {
        c += 1;
      }
    }
    return c;
  }

  /**
   * Checks whether a vending machine defined by the array items and its size itemsCount contains at
   * least an item with the provided description
   * 
   * @param description description (name) of an item to search
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return true if there is a match with description in the vending machine, false otherwise
   */
  public static boolean containsItem(String description, String[][] items, int itemsCount) {
    boolean y = false;
    for (int i = 0; i < itemsCount; i++) {
      if (items[i][0].equals(description)) {
        y = true;
        break;
      }
    }
    return y;
  }

  /**
   * Returns the number of items in the vending machine with a specific description and whose
   * expiration dates are greater or equal to a specific expiration date
   * 
   * @param description    description of the item to find its number of occurrences
   * @param expirationDate specific (earliest) expiration date
   * @param items          two dimensional array storing items within a vending machine where
   *                       items[i][0] represents the description of the item at index i and
   *                       items[i][1] stores its expiration date.
   * @param itemsCount     (size) number of items stored in the vending machine
   * @return the number of items with a specific description and whose expiration date is greater or
   *         equal to the given one
   */
  public static int getItemOccurencesByExpirationDate(String description, String expirationDate,
      String[][] items, int itemsCount) {
    int c = 0;
    for (int i = 0; i < itemsCount; i++) {
      if (items[i][0].equals(description)
          && Integer.parseInt(items[i][1]) >= Integer.parseInt(expirationDate)) {
        c += 1;
      }
    }
    return c;
  }

  /**
   * Returns a summary of the contents of a vending machine in the following format: Each line
   * contains the description or item name followed by one the number of occurrences of the item
   * name in the vending machine between parentheses. For instance, if the vending machine contains
   * five bottles of water, ten chocolates, and seven snacks, the summary description will be as
   * follows. "water (5)\nchocolate (10)\nsnack (7)" If the vending machine is empty, this method
   * returns an empty string ""
   * 
   * @param items      two dimensional array storing items within a vending machine where
   *                   items[i][0] represents the description of the item at index i and items[i][1]
   *                   stores its expiration date.
   * @param itemsCount (size) number of items stored in the vending machine
   * @return a descriptive summary of the contents of a vending machine
   */
  public static String getItemsSummary(String[][] items, int itemsCount) {
    String s = "";
    String[] desarray = new String[itemsCount];
    int[] countarray = new int[itemsCount];
    int z = -1;
    for (int i = 0; i < itemsCount; i++) {
      boolean y = false;
      String checkdes = items[i][0];
      for (int j = 0; j < z + 1; j++) {
        if (desarray[j].equals(checkdes)) {
          y = true;
        }
      }
      if (y == false) {
        z += 1;
        desarray[z] = checkdes;
        int c = getItemOccurrences(checkdes, items, itemsCount);
        countarray[z] = c;
      }
    }
    for (int k = 0; k < z + 1; k++) {
      s = s + "\n" + desarray[k] + " (" + countarray[k] + ")";
    }
    return s;
  }
}


