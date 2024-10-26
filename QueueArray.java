import java.util.Scanner;

class QueueArray
{
   private Object [] items;
   private int count;
   
   public QueueArray(int size)
   {
      items = new Object[size];
      count = 0;
   }
   
   public boolean isEmpty()
   {
      if(count == 0){
         return true;
      } else
      return false;
   }
   
   public boolean isFull()
   {
      return count == items.length;
   }
   
   public boolean enqueue(Object val)
   {
      if(!isFull()){
         items[count] = val;
         count++;
         return true;
      }
      return false;      
   }
   
   public boolean dequeue()
   {
      if(!isEmpty())
      {
         for(int i = 1; i < count; i++)
         {
         items[i - 1] = items[i];
         }
         items[count - 1] = null;
         count--;
         return true;
      }
      return false;
   }
   
   public Object front()
   {
      if(!isFull())
      {
         return items[0];
      }
      return null;
   }
   
   public void display()
   {
      if(!isEmpty())
      {
         for(int i = 0; i < count; i++)
         {
            System.out.println("[" + items[i] + "]");
         }
         System.out.println();
      }
      else
      System.out.println("Queue is empty..");
   }
   static void menu(){
      System.out.println("\n---Queue Array Menu---");
      System.out.println("[1] Enqueue");
      System.out.println("[2] Dequeue");
      System.out.println("[3] Display Front");
      System.out.println("[4] Display QueueArray");
      System.out.println("[5] Exit program");
      System.out.print("\nSelect a choice: ");
      }

   
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      QueueArray qa = new QueueArray(10);
      int choice;
      
      
      
      do{
      qa.menu();
      choice = scan.nextInt();
      scan.nextLine();
      
      switch(choice) 
      {
         case 1:
            if(!qa.isFull()){
               System.out.print("Enter a value to enqueue: ");
               String v = scan.nextLine();
               qa.enqueue(v);
               System.out.println("Value successfully enqueued");
            }
               else
                  System.out.println("Queue is full..");
                     break;
            
         case 2:
            if(!qa.isEmpty())
            {
               Object v = qa.dequeue();
               System.out.println("Successfully dequeued");
            }
            else
               System.out.println("Queue is empty..");
                break;
           
         case 3:
            if(!qa.isEmpty())
            {
               System.out.println("Front is : " + qa.front());
            }
            else
               System.out.println("Queue is empty..");
                break;
            
         case 4:
            if(!qa.isEmpty())
            {  
               qa.display();
            }
               else
                  System.out.println("Queue is empty..");
                      break;
         
         case 5:
             System.out.println("Exiting...");
               break;  
               
         default:
               System.out.println("Invalid choice. Please try again.");
          } 
      }
      while (choice != 5);
    }
  }
  


   