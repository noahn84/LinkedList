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

    public Link find(int key)
    {
        Link current = first;
        while (current.iData != key)
        {
            if (current.next == null)
            {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key)
    {
        Link current = first;
        Link previous = first;
        while (current.iData != key)
        {
            if (current == null)
            {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first)
        {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
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

        Link f = myList.find(3);
        if (f!=null)
        {
            System.out.println("Found link with key " + f.iData);
        } else {
            System.out.println("Can't find link");
        }

        Link d = myList.delete(4);
        if (d!=null)
        {
            System.out.println("Deleted link with key " + d.iData);
        } else {
            System.out.println("Can't find link");
        }

        // display empty linked list
        myList.displayList();
    }
}