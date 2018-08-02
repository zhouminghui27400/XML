package cn.List;
import java.util.ArrayList;
import java.util.List;
public class TreeDemo {


    //创建集合保存所有节点
    static List<Node> list = new ArrayList<>();

    class Node { //节点
        String data; //值
        String parent; //父节点的值
    }

    /**
     * @param parent 父节点的值
     * @param child  子节点的值
     */
    private void add(String parent, String child) {
        Node node = new Node();
        node.data = child;
        node.parent = parent;
        list.add(node); //把数据放进集合
    }

    //根据子节点查询对应的父节点
    private static void showParent(String child) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).data.equals(child)) {
                System.out.println(list.get(i).parent);
            }
        }
    }

    //根据父节点查询对应的子节点
    private static List<String> showChildren(String parent) {
        List<String> children = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).parent.equals(parent)) {
                children.add(list.get(i).data);
            }
        }
        return children;
    }

    public static void main(String[] args) {
        TreeDemo tree = new TreeDemo(); //创建一个空树
        tree.add("学校", "一年级");
        tree.add("学校", "二年级");
        tree.add("学校", "三年级");
        tree.add("一年级", "一年级1班");
        tree.add("一年级", "一年级2班");
        tree.add("一年级", "一年级3班");
        tree.add("二年级", "二年级1班");
        tree.add("二年级", "二年级2班");
        tree.add("三年级", "三年级1班");

        //根据子节点查询对应的父节点
        // showParent("二年级1班");
        //根据父节点查询对应的子节点
        showChildren("学校");

    }
}

