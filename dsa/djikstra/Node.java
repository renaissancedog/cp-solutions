class Node implements Comparable<Node> {
  public int id;
  public int distance;
  
  public Node(int id, int distance) {
    this.id = id;
    this.distance = distance;
  }
  
  @Override
  public int compareTo(Node other) {
    //compares dist
    return Integer.compare(this.distance, other.distance);
  }
}

