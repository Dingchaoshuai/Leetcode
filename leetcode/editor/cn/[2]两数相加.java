//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4907 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置一个空节点
        ListNode root =  new ListNode(0);
        ListNode cur = root;
        int carry =0;
        while(l1 != null || l2 !=null){
            //判断是否为空，空即用0代替
            int val1 = l1 == null ? 0: l1.val ;
            int val2 = l2 == null ? 0: l2.val;
            int sum = val1 + val2 +carry;
            carry = sum >9 ?1:0;
            sum = sum%10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            //这里还要判断的原因是：进入循环的条件是l1 != null || l2 !=null，
            //只要满足一个即可进入循环，所以有可能两个链表长度不一致，导致空指针
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
