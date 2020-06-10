public class ConnectNodeSameLevel {
    
    public static void connect(Node root)
    {
        Queue<Node> que =new LinkedList<Node>();
        que.add(root);
        while(!que.isEmpty())
        {
            int size = que.size();
            Queue<Node> tque =new LinkedList<Node>();
            Node prev = null;
            while(size-->0)
            {
                Node tmp =que.poll();
                if(prev!=null)
                {
                    prev.nextRight = tmp;
                }
                prev =tmp;
                if(tmp.left!=null)
                    tque.add(tmp.left);
                if(tmp.right!=null)
                    tque.add(tmp.right);
            }
            int tsize = tque.size();
            while(tsize-->0)
            {
                que.add(tque.poll());
            }
           
        }
    }
}