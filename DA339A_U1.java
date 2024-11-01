
/*
  Author: Viktor Vallmark
  Id: aq2560
  Study program: DT
*/
import java.util.Scanner;
import java.util.regex.Pattern;

public class DA339A_U1 {
  static Scanner input = new Scanner(System.in);

  // an array to use for testing, replace as needed to test your code
  static String[][] guestList = {
      { "Adam Ason", "35" },
      { "Berta Bson", "70" },
      { "Ceasar Cson", "12" },
      { "", "" },
      { "", "" },
      { "", "" },
      { "", "" },
      { "", "" },
      { "", "" },
      { "", "" },
  };

  /*
   * Parameters for methods below may NOT be changed and HAVE TO BE USED as
   * intended for a passing grade.
   */

  /**
   * This method makes sure to print the information about the guests (name and
   * age) from the guest
   * list in the terminal for the user. The print out shall show name, age and a
   * number representing
   * the guest's place in the guest list. Empty places in the guest list will NOT
   * be shown.
   */
  public static void printGuestInformation() {
    System.out.println("You chose to print the information of the guests in the guest list");
    for (int i = 0; i < guestList.length; i++) {
      if ((guestList[i][0].isBlank())
          || (guestList[i][0].equals(null))
          || (guestList[i][0].isEmpty())) {
        continue;
      } else {

        System.out.println(
            "Name: " + guestList[i][0] + " Age: " + guestList[i][1] + " Place in guest list: " + i);
      }
    }
  }

  /**
   * This method makes sure to print the whole guest list in the terminal for the
   * user. If a place
   * in the guest list contains data for a guest the guest's name and age is
   * shown. If a place in
   * the guest list is empty a text stating that the place is empty is shown. In
   * both cases a number
   * representing the place in the guest list is shown.
   */
  public static void printGuestList() {
    for (int i = 0; i < guestList.length; i++) {

      if ((guestList[i][0].isBlank())
          || (guestList[i][0].equals(null))
          || (guestList[i][0].isEmpty())) {

        System.out.println("This spot is empty!");
      } else {

        System.out.println(
            "Name: " + guestList[i][0] + " Age: " + guestList[i][1] + " Place in guest list: " + i);
      }
    }
  }

  /**
   * This method makes sure to print statistics about the guest list to the user.
   * The following
   * statistics shall be shown: - Total number guests - Total number of adult
   * guests - Total number
   * of child guests - Who the oldest guest is and their age - Who the youngest
   * guest is and their
   * age
   */
  public static void printStatistics() {
    System.out.println("You chose to print statistics");

    int numGuest = 0;
    int adultGuest = 0;
    int childGuest = 0;
    int indexOldest = 0;
    int indexYoung = 0;

    // does the same but with the rest of the matrix. also checks prev and current
    // to update indexYoung, indexOldest
    for (int i = 0; i < guestList.length; i++) {

      if ((guestList[i][0].isBlank())
          || (guestList[i][0].equals(null))
          || (guestList[i][0].isEmpty())) {

        continue;
      } else {
        numGuest++;

        if (Integer.parseInt(guestList[i][1]) > 13) {
          adultGuest++;
        } else {
          childGuest++;
        }

        if (Integer.parseInt(guestList[i][1]) > Integer.parseInt(guestList[indexOldest][1])) {

          indexOldest = i;
        }
        if (Integer.parseInt(guestList[i][1]) < Integer.parseInt(guestList[indexYoung][1])) {
          indexYoung = i;
        }
      }
    }

    System.out.println(
        "Total number of guests: "
            + numGuest
            + "\n Total adult guests: "
            + adultGuest
            + "\n Total child guests: "
            + childGuest
            + "\n Oldest guests name: "
            + guestList[indexOldest][0]
            + "\n Oldest guests age: "
            + guestList[indexOldest][1]
            + "\n Youngest guests name: "
            + guestList[indexYoung][0]
            + "\n Youngest guests age: "
            + guestList[indexYoung][1]);
  }

  /**
   * This method adds a guest to the guest list. The information that is added to
   * the guest list is
   * defined in the method parameters. If a user tries to add a guest to a full
   * guest list an error
   * messages informing the user about this will be shown and no guest added to
   * the list.
   *
   * @param name The name of the guest to add
   * @param age  The age of the guest to add as a String
   */
  public static void addGuest(String name, String age) {
    for (int i = 0; i < guestList.length; i++) {
      if ((guestList[i][0].isBlank())
          || (guestList[i][0].equals(null))
          || (guestList[i][0].isEmpty())) {
        guestList[i][0] = name;
        guestList[i][1] = age;
        break;
      }
    }
    System.out.println("You have added " + name + ", aged " + age + " to the list.");
  }

  /**
   * This method changes the name of a specific guest in the guest list. Which
   * guest's name is
   * changed is decided by a method parameter. If a user tries to change the name
   * at a place in the
   * list that has no current guest an error message informing the user about this
   * will be shown and
   * no data in the guest list is changed.
   *
   * @param index   The index of the guest whose name shall be changed.
   * @param newName The new name of the guest at place given by index.
   */
  public static void changeNameOfGuest(int index, String newName) {
    if (index <= 10) {
      if ((guestList[index][0].isBlank())
          || (guestList[index][0].equals(null))
          || (guestList[index][0].isEmpty())) {

        System.out.println("No guest can be found at this position in the guest list.");
      } else {

        guestList[index][0] = newName;

        System.out.println("Name of guest at place " + index + " has been changed to " + newName);
      }
    } else {
      System.out.println(
          "The guest list can only contain 10 people so specify a number between 0-9.");
    }
  }

  /**
   * This method changes the age of a specific guest in the guest list. Which
   * guest's age is changed
   * is decided by a method parameter. If a user tries to change the age at a
   * place in the list that
   * has no current guest an error message informing the user about this will be
   * shown and no data
   * in the guest list is changed.
   *
   * @param index  The index of the guest whose age shall be changed.
   * @param newAge The new age, as a String, of the guest at place given by index.
   */
  public static void changeAgeOfGuest(int index, String newAge) {
    System.out.println("You chose to change the age of a guest");
    if (index <= 10) {
      if ((guestList[index][1].isBlank())
          || (guestList[index][1].equals(null))
          || (guestList[index][1].isEmpty())) {
        System.out.println("No guest can be found at this position in the guest list.");
      } else {

        guestList[index][1] = newAge;

        System.out.println("Age of guest at place " + index + " has been changed to " + newAge);
      }
    } else {

      System.out.println("The guest list can only contain 10 people");
    }
  }

  /**
   * This method removes a guest at a given index from the guest list. The data at
   * this index is
   * replaced by empty Strings. If no guest exists at the given index an error
   * message informing the
   * user about this will be shown and no data in the guest list is changed.
   *
   * @param index The index of the place where a guest is to be removed.
   */
  public static void removeGuest(int index) {

    if ((guestList[index][0].isBlank())
        || (guestList[index][0].equals(null))
        || (guestList[index][0].isEmpty())) {

      System.out.println("No guest can be found at this position in the guest list.");

    } else {

      guestList[index][0] = "";
      guestList[index][1] = "";
      System.out.println("Guest with place " + index + " has been removed from the guest list");
    }
  }

  /**
   * This method changes places in the guest list for the data existing at those
   * places given by the
   * parameters. It is possible to change places between data even if one or both
   * places contains
   * empty strings. This gives the user the possibility to change the place of one
   * guest to an empty
   * place in the guest list. If the two parameters have the same value an error
   * message informing
   * the user about this will be shown and no data in the guest list is changed.
   *
   * @param index1 First index involved in the change of places
   * @param index2 Second index involved in the change of places
   */
  public static void changePlaces(int index1, int index2) {
    String tempName;
    String tempAge;
    if ((index1 <= 10) && (index2 <= 10)) {
      if (index1 == index2) {
        System.out.println(
            "Please specify two different guests to change their position on the guest list");
      } else {
        tempName = guestList[index1][0];
        tempAge = guestList[index1][1];
        guestList[index1][0] = guestList[index2][0];
        guestList[index1][1] = guestList[index2][1];

        guestList[index2][0] = tempName;
        guestList[index2][1] = tempAge;
        System.out.println(
            "You have switched places on the guests on place " + index1 + " and " + index2);
      }
    } else {

      System.out.println("The guest list can only contain 10 people");
    }
  }

  /** This method prints the program menu in the terminal for the user to view. */
  public static void printMenu() {
    System.out.println("----- Program menu -----");
    System.out.println(
        "1. Show information about all guests\n"
            + "2. Show guest list\n"
            + "3. Show statistics about the guest list\n"
            + "4. Add a guest\n"
            + "5. Change the name of a guest\n"
            + "6. Change the age of a guest\n"
            + "7. Remove a guest\n"
            + "8. Swap places on two guests in the guest list\n"
            + "-1. Exit program\n"
            + "------------------------\n");
  }

  /**
   * This method reads the menu choice from the user and returns the choice the
   * user made as an
   * integer.
   *
   * @return The menu choice made by the user represented by an integer value of
   *         type int.
   */
  public static int readMenuChoice() {
    System.out.println("***** Make menu choice *****\n");
    int choice;
    printMenu();
    choice = input.nextInt();
    if ((choice < -1) && (choice == 0) && !((choice >= 1) && (choice <= 8))) {
      System.out.println("Please choose a number between 1-8 or -1 to exit!\n");
    }

    return choice;
  }

  public static void main(String[] args) {

    System.out.println("Welcome to the guest list to the GIGA party!\n");

    String stringInput, stringNumInput;
    boolean compare, compareNum;

    for (;;) {
      int choice1 = readMenuChoice();
      switch (choice1) {
        case 1:
          printGuestInformation();
          break;
        case 2:
          printGuestList();
          break;
        case 3:
          printStatistics();
          break;
        case 4:
          System.out.println("You chose to add a guest to the list\n");
          System.out.println("Please enter a name for the person to add to the guest list: ");
          stringInput = input.next();
          compare = Pattern.matches("^[a-zA-ZåäöÅÄÖ]+$", stringInput);
          if ((stringInput.isBlank()) || (stringInput.equals(null)) || (stringInput.isEmpty())) {
            System.out.println("Please enter a name\n");
          } else if (compare) {
            System.out.println("Please enter an age for the guest: ");

            stringNumInput = input.next();
            compareNum = Pattern.matches("^[0-9]+$", stringNumInput);
            if (compareNum) {
              addGuest(stringInput, String.valueOf(stringNumInput));
            } else {
              System.out.println("Please use only integers\n");
            }
          } else {
            System.out.println("Please use letters only\n");
            break;
          }
          break;
        case 5:
          System.out.println("You chose to change the name of a guest\n");
          System.out.println("Please enter the guests place in the guest list: ");
          stringNumInput = input.next();
          compareNum = Pattern.matches("^[0-9]+$", stringNumInput);
          if ((stringNumInput.isBlank())
              || (stringNumInput.equals(null))
              || (stringNumInput.isEmpty())) {
            System.out.println("Please enter an index\n");
          } else if (compareNum) {

            System.out.println("Please enter a new name: ");
            stringInput = input.next();
            compare = Pattern.matches("^[a-zA-ZåäöÅÄÖ]+$", stringInput);
            if (compare) {
              changeNameOfGuest(Integer.parseInt(stringNumInput), stringInput);
            } else {

              System.out.println("Please use letters only\n");
            }
          } else {
            // If you want to use swedish letters, be sure to use a terminal emulator that
            // supports
            // that.

            System.out.println("Please use integers\n");
          }
          break;
        case 6:
          System.out.println("Please enter the place of the guest you want to change the age on: ");
          stringNumInput = input.next();
          compareNum = Pattern.matches("^[0-9]+$", stringNumInput);
          if ((stringNumInput.isBlank())
              || (stringNumInput.equals(null))
              || (stringNumInput.isEmpty())) {
            System.out.println("Please enter an index\n");
          } else if (compareNum) {

            System.out.println("Please enter the new age of the guest: ");
            stringInput = input.next();
            compare = Pattern.matches("^[0-9]+$", stringInput);
            if (compare) {

              System.out.println("You have changed age on guest at place " + stringNumInput);
              changeAgeOfGuest(Integer.parseInt(stringNumInput), stringInput);
            } else {
              System.out.println("Please use integers to specify age");
            }
          } else {
            System.out.println("Please use integers\n");
          }

          break;
        case 7:
          System.out.println("You chose to remove a guest\n");
          System.out.println("Enter the place of the guest to remove: ");
          stringNumInput = input.next();

          compareNum = Pattern.matches("^[0-9]+$", stringNumInput);
          if ((stringNumInput.isBlank())
              || (stringNumInput.equals(null))
              || (stringNumInput.isEmpty())) {
            System.out.println("Please enter an index");
          } else if (compareNum) {
            removeGuest(Integer.parseInt(stringNumInput));
          } else {
            System.out.println("Please use integers\n");
          }
          break;
        case 8:
          System.out.println("You chose to switch places on two guests\n");
          System.out.println("Please enter the place of the first guest: ");
          stringNumInput = input.next();
          compareNum = Pattern.matches("^[0-9]+$", stringNumInput);

          if ((stringNumInput.isBlank())
              || (stringNumInput.equals(null))
              || (stringNumInput.isEmpty())) {
            System.out.println("Please enter an index");
          } else if (compareNum) {

            System.out.println("Please enter the place of the second guest: ");
            stringInput = input.next();
            compare = Pattern.matches("^[0-9]+$", stringInput);
            if (compare) {

              changePlaces(Integer.parseInt(stringNumInput), Integer.parseInt(stringInput));
            } else {

              System.out.println("Please use integers\n");
            }
          } else {
            System.out.println("Please use integers\n");
          }
          break;
        default:
          break;
      }
      if (choice1 == -1) {
        System.out.println("Exited the guest list program");
        input.close();
        break;
      }
    }
  }
}
