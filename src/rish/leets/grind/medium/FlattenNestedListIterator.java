package rish.leets.grind.medium;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * <h1>Daily Challenge!</h1>
 * 
 * Problem #: LC341 <br>
 * Problem link: https://leetcode.com/problems/flatten-nested-list-iterator/
 * <br>
 * Date Attempted: 20/10/2023 <br>
 * 
 * @author Rishabh Soni
 *
 */
public class FlattenNestedListIterator {

    public interface NestedInteger {

        /**
         * @return true if this NestedInteger holds a single integer, rather than a
         *         nested list.
         */
        public boolean isInteger();

        /**
         * @return the single integer that this NestedInteger holds, if it holds a
         *         single integer. Return null if this NestedInteger holds a nested list
         */
        public Integer getInteger();

        /**
         * @return the nested list that this NestedInteger holds, if it holds a nested
         *         list. Return empty list if this NestedInteger holds a single integer
         */
        public List<NestedInteger> getList();

    }

    class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> nestedStack;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedStack = new Stack<>();
            List<NestedInteger> reversed = nestedList;
            Collections.reverse(reversed);
            this.nestedStack.addAll(reversed);
        }

        @Override
        public Integer next() {

            if (!hasNext()) {
                return null;
            }

            return this.nestedStack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {

            while (!nestedStack.isEmpty()) {

                if (nestedStack.peek().isInteger()) {
                    return true;
                }

                // Pop last, reverse list and append to stack
                List<NestedInteger> nList = nestedStack.pop().getList();
                Collections.reverse(nList);
                nestedStack.addAll(nList);
            }

            return false;
        }

    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
     * = i.next();
     */

}
