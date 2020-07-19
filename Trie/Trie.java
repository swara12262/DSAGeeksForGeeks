class TrieNode {
    TrieNode[] child=new TrieNode[26];
    boolean isEnd;
}
class Impl
{
    private static TrieNode root;
    public static void main(String[] args)
    {
        String keys[] = {"the", "a", "there", "answer", "any", 
        "by", "bye", "their"}; 

        String output[] = {"Not present in trie", "Present in trie"};

        root=new TrieNode();

        for(int i=0;i<keys.length;i++)
            insert(keys[i]);
        
        delete(root,keys[0],0);
        for(int i=0;i<keys.length;i++)
        {
            if(search(keys[i])==true)
                System.out.println(keys[i]+" is present in trie");
            else
                System.out.println(keys[i]+" is not present in trie");
        }
    }
    public static void  insert(String s)
    {
        TrieNode cur=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(cur.child[index]==null)
                cur.child[index]=new TrieNode();
            cur=cur.child[index];
        }
        cur.isEnd=true;
    }
    public static boolean search(String s)
    {
        TrieNode cur=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(cur.child[index]==null)
                return false;
            cur=cur.child[index];
        }
        return cur.isEnd;
    }
    public static TrieNode delete(TrieNode root, String s, int i)
    {
        if(root==null) return null;
        if(i==s.length())
        {
            root.isEnd=false;
            if(isEmpty(root))
                root=null;
            return root;
        }
        int index=s.charAt(i)-'a';
        root=delete(root.child[index], s, i+1);
        if(root.isEnd==false && isEmpty(root))
            root=null;
        return root;
    }
    public static boolean isEmpty(TrieNode root)
    {
        for(int i=0;i<26;i++)
        {
            if(root.child[i]!=null)
                return false;
        }
        return true;
    }
}
