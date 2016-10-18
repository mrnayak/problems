package com.nmvk.raghav;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Stack {
    private static class Node{
        Node next;
        int data;
    }
    
    Node top;
    
    public void insert(int data)
        {
        Node n = new Node();
        n.data = data;
        
       n.next = top;
        top = n;
    }
    
    public Node pop()
        {
        if(top != null)
            {
            Node t = top;
            top = top.next;
            return t;
        }
        return null;
    }
    
    public void printMax()
        {
        if(top != null){
            int max = top.data;
            Node t = top;
            while(t.next != null)
                {
                if(t.data > max) max = t.data;
                t = t.next;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(System.getProperty("line.seperator"));
        int n = scan.nextInt();
        Stack s = new Stack();
        for(int i = 0; i < n; i++)
            {
            String line = scan.next();
            if(line.contains(" "))
            {
                String[] data = line.split(" ");
                s.insert(Integer.parseInt(data[1]));
            }    
            else
                {
                 int x = Integer.parseInt(line);
                if(x == 2)
                    s.pop();
                else if (x == 3){
                    s.printMax();
                }
            }
        }
    }
}
