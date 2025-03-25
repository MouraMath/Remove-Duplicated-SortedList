package dev;

/**
 * Solução para o problema 83 do LeetCode: Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        

        ListNode current = head;


        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }


     // Method auxiliar para criar uma lista encadeada a partir de um array.

    private static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }


     // Method auxiliar para imprimir uma lista encadeada.
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


     // Method principal para demonstração da solução.

    public static void main(String[] args) {
        // Exemplo 1
        int[] values1 = {1, 1, 2};
        ListNode list1 = createList(values1);
        System.out.println("Exemplo 1 - Original:");
        printList(list1);
        list1 = deleteDuplicates(list1);
        System.out.println("Exemplo 1 - Após remoção de duplicatas:");
        printList(list1);

        // Exemplo 2
        int[] values2 = {1, 1, 2, 3, 3};
        ListNode list2 = createList(values2);
        System.out.println("Exemplo 2 - Original:");
        printList(list2);
        list2 = deleteDuplicates(list2);
        System.out.println("Exemplo 2 - Após remoção de duplicatas:");
        printList(list2);

        // Exemplo 3 - Lista null
        ListNode list3 = null;
        System.out.println("Exemplo 3 - Original (lista null):");
        printList(list3);
        list3 = deleteDuplicates(list3);
        System.out.println("Exemplo 3 - Após remoção de duplicatas:");
        printList(list3);
    }
}

