package com.nmvk.raghav;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        
    }
    class Node {
    int data;
    Node left;
    Node right;
    int height(Node root)
    {
         if(root != null)
             {
             int left = 0;
             if(root.left != null)
                 left = 1+ height(root.left);
             int right = 0;
             if(root.right != null)
                 right = 1+ height(root.right);
             
             return left > right ? left : right;
         }
       return 0;
    }
    }
    
}

