// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node addLists(Node first, Node second){
        // code here
        // return head of sum list
        Node head1=reverse(first);
        Node head2=reverse(second);
        Node newHead=null;
        Node prev=null;
        int sum=0,carry=0;
        while(head1!=null || head2!=null){
            int i1 = head1!=null ? head1.data: 0;
            int i2 = head2!=null ? head2.data: 0;
             sum= i1+ i2+carry;
             carry=sum/10;
            Node newNode=new Node(sum-carry*10);
            if(prev==null){
                newHead=newNode;
            }else
                prev.next=newNode;
            prev=newNode;
            if(head1!=null)
                head1=head1.next;
            if(head2!=null)
                head2=head2.next;
        }
        if(carry!=0)
            prev.next=new Node(carry);
        
        return reverse(newHead);
    }
    static Node reverse(Node head){
        if(head==null  || head.next==null)
            return head;
        Node newHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
