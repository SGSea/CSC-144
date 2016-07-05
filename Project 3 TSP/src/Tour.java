/*
 * Name: Sam Caldwell
 * Project: Traveling Salesperson
 * 
 * Description: A client of the provided classes that takes input as data points('locations'), and creates a 'most efficient' route of travel between
 * given points. 
 * 
 * Compilation: javac Tour.java
 * 
 * 
 */

public class Tour {
	private class Node {
		public Point p;
		public Node next;

		 // Create one Node
		public Node(Point p) {
			this.p = p;
			this.next = null;
		}

		public Node() {
		}
	}

	Point a, b, c, d;
	Node head = null;
	int numofpoints = 0;

	public Tour() {

	}

	public int size() {
		return numofpoints;
	}

	public void show() {

		Node x = head.next;
		while (x != head) {
			StdOut.println(x.p);
			x = x.next;

		}
	}

	public void draw() {
		Node current = head.next;
		Node last = head;
		int ii = 0;
		while (current != head) {

			// current.p.draw();

			current.p.drawTo(current.next.p);

			current = current.next;
		}
	}

	public void draw1() {
		Node current = head;
		while (current != null) {
			if (current.next != null) {
				// current.p.draw();
				System.out.println("draw");
				current.p.drawTo(current.next.p);
			}
			current = current.next;
		}
	}

	public void insertNearest(Point p) {
		numofpoints++;

		// int smallest = 0;
		// int indx = 0;
		// inserts into a circularly linked list the closest next value
		Node tmp = new Node(p);
		if (head == null) {
			head = tmp;
			return;
		} else if (head.next == null) {
			head.next = tmp;
			tmp.next = head;
			return;
		}

		Node smallestNode = head;
		Node current = head.next;
		while (current != head) {
			if (current.p.distanceTo(p) <= smallestNode.p.distanceTo(p)) {
				smallestNode = current;
			}
			current = current.next;
		}
		Node temp = smallestNode;
		tmp.next = smallestNode.next;
		temp.next = tmp;
	}

	public void insertSmallest(Point p) {
		numofpoints++;

		if (head == null) {
			Node temp = new Node(p);
			head = temp;
		}
		if (head.next == null) {
			Node temp = new Node(p);
			head.next = temp;
			temp.next = head;
		} else {
			Node point = new Node(p);
			double min = Integer.MAX_VALUE;

			Node current = head.next;
			Node last = head;

			do {
				if ((p.distanceTo(current.p) + p.distanceTo(current.next.p) - current.p
						.distanceTo(current.next.p)) < min) {
					min = p.distanceTo(current.p)
							+ p.distanceTo(current.next.p)
							- current.p.distanceTo(current.next.p);
					last = current;

				}
				current = current.next;

			} while (current != head);

			Node old = last.next;
			last.next = point;
			point.next = old;
		}

	}

	public double distance() {
		double d = 0.0;
		Node current = head.next;
		Node last = head;
		while (current != head) {
			d += current.p.distanceTo(current.next.p);
			current = current.next;
		}
		return d;

	}

	public double distance1() {
		double d = 0.0;
		Node current = head;

		while (current != null) {
			if (current.next != null) {
				d += current.p.distanceTo(current.next.p);

			}
			current = current.next;
		}
		return d;

	}

	public Tour(Point a, Point b, Point c, Point d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

}
