package io.github.precodertech.codingjava;

import java.lang.annotation.Documented;

class MergeLinkedList {

    public static void main(String[] args) {
        MergeLinkedList mll = new MergeLinkedList();

        /**
         * Merge Two Sorted Lists 
         * -----------------------
         * You are given the heads of two sorted linked lists list1 and list2.
         * Merge the two lists into one sorted list. The list should be made by
         * splicing together the nodes of the first two lists.
         * 
         * Return the head of the merged linked list.
         */
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode mergedList = mll.mergeTwoLists(list1, list2);
        System.out.println(mergedList.toString());

        list1 = new ListNode();
        list2 = new ListNode();
        list1.toString();
        mergedList = mll.mergeTwoLists(list1, list2);
        System.out.println(mergedList.toString());

        list1 = new ListNode(1, new ListNode(7, new ListNode(9, null)));
        list2 = new ListNode(-1, new ListNode(0, new ListNode(5, null)));
        mergedList = mll.mergeTwoLists(list1, list2);
        System.out.println(mergedList.toString());

        list1 = new ListNode();
        list2 = new ListNode(0, null);
        mergedList = mll.mergeTwoLists(list1, list2);
        System.out.println(mergedList.toString());

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode nextNode;
        ListNode mergedList = (list1 != null) ? list1 : list2;
        if (list2 != null && mergedList != list2) {
            ListNode currentMergedNode = mergedList;
            while (list2 != null) {
                ListNode currentListNode = new ListNode(list2.val, list2.next);
                if (currentListNode.val > currentMergedNode.val && currentMergedNode.next != null
                        && currentListNode.val > currentMergedNode.next.val) {
                    currentMergedNode = currentMergedNode.next;
                    continue;
                }
                if (currentListNode.val < currentMergedNode.val) {
                    currentListNode.next = currentMergedNode;
                    currentMergedNode = currentListNode;
                    mergedList = currentMergedNode;
                } else {
                    nextNode = currentMergedNode.next;
                    currentListNode.next = nextNode;
                    currentMergedNode.next = currentListNode;
                }

                list2 = list2.next;
            }
        }
        return mergedList;
    }

    //@TO-DO: To fix the code
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = null;
        if (lists.length == 0)
            return null;

        for (int i = 0; i < lists.length; i++) {
            System.out.println("here");
            if (lists[i] == null || mergedList == null) {
                if (mergedList == null) {

                    mergedList = lists[i];
                }
                System.out.println("here1");

            } else {
                System.out.println("here2");

                ListNode currentMergedListNode = mergedList;
                ListNode currentListNode = null;
                ListNode nextNode = null;

                while (lists[i].next != null) {
                    System.out.println("here3");

                    currentListNode = new ListNode(lists[i].val, lists[i].next);
                    nextNode = (nextNode == null)
                            ? ((currentMergedListNode == null) ? mergedList.next : currentMergedListNode.next)
                            : nextNode.next;

                    if (currentMergedListNode == null) {
                        currentMergedListNode = mergedList;
                    }
                  
                    if (currentListNode.val >= currentMergedListNode.val) {
                        System.out.println("here4");
                        if (currentMergedListNode.next != null
                                && currentListNode.val > (currentMergedListNode.next).val) {
                            nextNode = currentMergedListNode.next;
                            if (currentMergedListNode.next != null)
                                currentMergedListNode = currentMergedListNode.next;
                            continue;
                        }
                        // if (nextNode != null && nextNode.next != null) {
                        currentListNode.next = nextNode;
                        // }
                        currentMergedListNode.next = currentListNode;
                      

                        lists[i] = lists[i].next;
                    }
                    nextNode = currentMergedListNode.next;
                    if (currentMergedListNode.next != null)
                        currentMergedListNode = currentMergedListNode.next;

                 
                }
                System.out.println("here5");
                currentListNode = new ListNode(lists[i].val, lists[i].next);
      
                if (nextNode != null) {
                    System.out.println("here6");

                    nextNode = (nextNode == null) ? currentMergedListNode.next : nextNode.next;

                    while (currentListNode.val > (currentMergedListNode).val) {
                        currentMergedListNode = currentMergedListNode.next;
                        if (nextNode != null && nextNode.next != null) {
                            nextNode = nextNode.next;
                        }
                        if (currentMergedListNode == null || currentMergedListNode.next == null) {
                            break;
                        }
                    }
                    if (nextNode != null && nextNode.next != null) {
                        currentListNode.next = nextNode;
                    }
                    if (currentMergedListNode != null)
                        currentMergedListNode.next = currentListNode;
                } else {
                    System.out.println("here7");
                    nextNode = mergedList;
                    currentListNode.next = nextNode;

                    currentMergedListNode = currentListNode;
                    mergedList = currentMergedListNode;

                }

            }

        }
        return mergedList;
    }
}

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}

    //TO-DO: Fix the concern where blank listnode is created. - last updated on 13th Jan 25
    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            while (node.next != null) {
                sb.append(node.val);
                sb.append(" -> ");
                node = node.next;
            }
            sb.append(node.val);

        }
        return sb.toString();
    }

    

}
