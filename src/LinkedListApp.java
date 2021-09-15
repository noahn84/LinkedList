class Link
{
    // initial setup
    public int iData;
    public double dData;
    public Link next;

    // constructor
    public Link(int id, double dd)
    {
        iData = id;
        dData = dd;
    }

    // methods
    public void displayLink()
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}

class LinkList
{
    // initial setup
    private Link first;

    // constructor
    public void Link()
    {
        first = null;
    }

    // methods
    public boolean isEmpty()
    {
        return (first==null);
    }

    public void insertFirst(int id, double dd)
    {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList()
    {
        Link current = first;
        System.out.print("LinkList (first -> last): ");

        if (current == null)
        {
            System.out.print("Empty");
        }

        while (current!=null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class LinkedListApp
{
    public static void main(String[] args)
    {
        // creating new (empty) linked list
        LinkList myList = new LinkList();

        // display that the linked list is empty
        myList.displayList();

        // insert four items into the linked list
        myList.insertFirst(1, 1.0);
        myList.insertFirst(2, 2.0);
        myList.insertFirst(3, 3.0);
        myList.insertFirst(4, 4.0);

        // display newly filled linked list
        myList.displayList();

        // until the linked list is empty....
        while (!myList.isEmpty())
        {
            // ....delete first link, and display deleted link
            Link aLink = myList.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayLink();
            System.out.println("");
        }

        // display empty linked list
        myList.displayList();
    }
}