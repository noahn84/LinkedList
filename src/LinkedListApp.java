class Link {
  // initial data
  public int iData;
  public double dData;
  public Link next;

  // constructor
  public Link(int id, double dd) {
    iData = id;
    dData = dd;
  }

  // methods
  public void displayLink() {
    System.out.print("{" + iData + ", " + dData + "} ");
  }
}

class LinkedList {
  // initial data
  private Link first;

  // constructor
  public LinkedList() {
    first = null;
  }

  // methods
  public boolean isEmpty() {
    return (first==null);
  }

  public void insertFirst(int id, double dd) {
    Link newLink = new Link(id, dd);
    newLink.next = first;
    first = newLink;
  }

  public Link find(int key) {
    Link current = first;
    while (current.iData!=key) {
      if (current.next==null) {
        return null;
      } else {
        current = current.next;
      }
    }
    return current;
  }

  public Link delete(int key) {
    Link current = first;
    Link previous = first;
    while (current.iData!=key) {
      if (current.next==null) {
        return null;
      } else {
        previous = current;
        current = previous.next;
      }
    }
    if (current==first) {
      first = first.next;
    } else {
      previous.next = current.next;
    }
    return current;
  }

  public void displayList() {
    System.out.print("LinkedList (first -> last): ");
    Link current = first;
    if (current==null) {
      System.out.print("Empty");
    }
    while (current!=null) {
      current.displayLink();
      current = current.next;
    }
    System.out.println("");
  }
}

class LinkedListApp {
  public static void main(String[] args) {
    LinkedList myList = new LinkedList();

    myList.displayList();

    myList.insertFirst(1, 1.0);
    myList.insertFirst(2, 1.1);
    myList.insertFirst(3, 1.2);
    myList.insertFirst(4, 1.3);

    myList.displayList();

    Link foundLink = myList.find(2);
    if (foundLink!=null) {
      System.out.println("Found link with key " + foundLink.iData + ": " + "{" + foundLink.iData + ", " + foundLink.dData + "}");
    } else {
      System.out.println("Couldn't find link");
    }

    Link deletedLink = myList.delete(3);
    if (deletedLink!=null) {
      System.out.println("Deleting link with key " + deletedLink.iData + ": " + "{" + deletedLink.iData + ", " + deletedLink.dData + "}");
    } else {
      System.out.println("Couldn't delete link");
    }

    myList.displayList();
  }
}