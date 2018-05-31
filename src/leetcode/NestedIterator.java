/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 *
 * @author sekha
 */
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        ListIterator<NestedInteger> revIterator = nestedList.listIterator(nestedList.size());
        while (revIterator.hasPrevious()) {
            stack.push(revIterator.previous());
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    };

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger top = stack.pop();
            if (!top.isInteger()) {
                List<NestedInteger> nestedList = top.getList();
                ListIterator<NestedInteger> revIterator = nestedList.listIterator(nestedList.size());
                while (revIterator.hasPrevious()) {
                    stack.push(revIterator.previous());
                }
            }
        }

        return !stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
