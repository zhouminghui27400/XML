package cn.List;

public class MyList {

    private int data; //元素ABC的值
    private MyList next;//下一个元素


    public MyList (int d){
        data=d;
    }
    private void  append(MyList myList){
        MyList list= this;
        while (list.next!=null){
            System.out.println(list.data);
            System.out.println(list.next);
            list=list.next;
        }
         list.next=myList;

    }
    private  void  add(MyList myList){
        myList.next=next;  //把当前的null给了传递过来的节点的next属性
        next=myList;

    }
     private void show(){
        MyList list =this;
        while (list!=null){
            System.out.println(list.data);
            list=list.next;
        }
     }
    public static  void main(String []args){
       MyList myList =new MyList(10);
       myList.append(new MyList(30));
        myList.append(new MyList(40));
        myList.add(new MyList(20));
        myList.show();
    }
}
