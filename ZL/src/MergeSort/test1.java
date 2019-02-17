package MergeSort;
/*输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

思考过程：
一开始要考虑到特殊情况，如果一个链表为空，可以直接返回另一个链表；
类似于两个数组的归并问题，但这是两个链表，所以只要想明白链表如何归并即可；
链表的归并关键在于如何指向合成链表的下一个，不能像数组一样直接++即可，也不能直接list=list.next;
所以加入一个链表list0，让表头list=list0，然后用list0.next去连接。*/

public class test1 {
        ListNode list=null;
        ListNode list0=null;
        public ListNode Merge(ListNode list1,ListNode list2) {
            if(list1 == null){
                return list2;
            }
            if(list2 == null){
                return list1;
            }
            while(list1!=null&&list2!=null){
                if(list1.val<=list2.val){
                    if(list==null)
                        list=list0=list1;
                    else{
                        list0.next=list1;
                        list0=list0.next;
                    }
                    list1=list1.next;
                }else{
                    if(list==null)
                        list=list0=list2;
                    else{
                        list0.next=list2;
                        list0=list0.next;
                    }
                    list2=list2.next;
                }
            }
            if(list1!=null){
                list0.next=list1;
            }
            if(list2!=null){
                list0.next=list2;
            }
            return list;
        }
    }

