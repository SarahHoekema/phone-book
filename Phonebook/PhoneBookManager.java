package PhoneBook;

public class PhoneBookManager {
  private int size;
  private PhoneBookNode head;

  public PhoneBookManager(){
    size = 0;
    head = null;
  }

  public void add(String lastName, String firstName, String address, String city,
    int zipcode, String phoneNumber){
    PhoneBookNode current = head;  
    if(head == null){
      head = new PhoneBookNode(lastName, firstName, address, city, zipcode, phoneNumber);
    } else if(lastName.compareTo(head.getLastName()) < 0 ||
    (lastName.compareTo(head.getLastName()) == 0 && firstName.compareTo(head.getFirstName()) < 0)){
      head = new PhoneBookNode(lastName, firstName, address, city, zipcode, phoneNumber, head);
    } else {
      while(current.next != null && 
      (lastName.compareTo(current.next.getLastName()) > 0 ||
      (lastName.compareTo(current.next.getLastName()) == 0 &&
      firstName.compareTo(current.next.getFirstName()) > 0))){
        current = current.next;
      }
      if(current.next != null){
        current.next = new PhoneBookNode(lastName, firstName, address, city,
        zipcode, phoneNumber, current.next);
      } else{
        current.next = new PhoneBookNode(lastName, firstName, address, city,
        zipcode, phoneNumber);
      }
    }
    size++;
  }

  //TODO: complete modify method

  public void remove(String lastName, String firstName, String address){
    if(head.getLastName().equals(lastName) &&
    head.getFirstName().equals(firstName) &&
    head.getAddress().equals(address)){
      head = head.next;
      size--;
    } else{
      PhoneBookNode current = head;
      for(int i = 0; i < size - 1; i++){ //TODO: debug delete method
        if(current.next.getLastName().equals(lastName) &&
        current.next.getFirstName().equals(firstName) &&
        current.next.getAddress().equals(address) && 
        current.next.next != null){
          current.next = current.next.next;
          size--;
          break;
        } else if(current.next.getLastName().equals(lastName) &&
        current.next.getFirstName().equals(firstName) &&
        current.next.getAddress().equals(address) && 
        current.next.next == null){
          current.next = null;
          size--;
          break;
        }
        current = current.next;
      }
    }
  }

  public void search(String lastName, String firstName){
    PhoneBookNode current = head;
    for(int i = 0; i < size; i++){
      if(current.getLastName().equals(lastName) && current.getFirstName().equals(firstName)){
        System.out.println(current);
      }
      current = current.next;
    }
  }

  public void search(String lastName){
    PhoneBookNode current = head;
    for(int i = 0; i < size; i++){
      if(current.getLastName().equals(lastName)){
        System.out.println(current);
      }
      current = current.next;
    }
  }

  //pre-condition: 0 <= index < size
  public PhoneBookNode get(int index){
    PhoneBookNode current = head;
    for(int i = 0; i < index; i++){
      current = current.next;
    }
    return current;
  }

  //TODO: complete move method

  //TODO: complete movePhoneBook method

  public void print(){
    PhoneBookNode current = head;
    for(int i = 0; i < size; i++){
      System.out.println(current);
      current = current.next;
    }
  }

  public int size(){
    return size;
  }
}