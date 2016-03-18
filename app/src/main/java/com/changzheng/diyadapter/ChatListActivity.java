package com.changzheng.diyadapter;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatListActivity extends ListActivity {

    private List<ChatMessage> mData;

    private String[] msgArray= new String[]{"哥，问你个问题", "说吧",
            "为什么两点之间线段最短？", "你养过狗么？", "曾经养过",
            "你丢一块骨头出去，你说狗是绕个圈去捡还是直接跑过去捡呢？","当然是直接跑过去捡了！", "连狗都知道的问题你还问？"};

    private Context context;
    SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
//       用listview 展示批量的结构相同的数据,1. 列表项布局 2.初始化数据 3.适配器,自定义适配器  4.设置适配器
        context=this;

        mData=new ArrayList<ChatMessage>();
        int length=msgArray.length;
        for (int i=0;i<length;i++){
            ChatMessage chatMessage=new ChatMessage();
            chatMessage.id=1000+i;
            chatMessage.message=msgArray[i];
            chatMessage.isSelf=chatMessage.id%2==0?true:false;
            mData.add(chatMessage);
        }

//        4 listview 设置适配器
        getListView().setAdapter(new ChatAdapter());

//        3  自定义适配器



    }

    private class ChatAdapter extends BaseAdapter{
//        取得列表项的列数
        @Override
        public int getCount() {

            return mData==null?0:mData.size();
        }

//        返回当前列表项要展示的数据position当前要展示的数据在适配器中的位置
        @Override
        public Object getItem(int position) {
            return mData==null?0:mData.get(position);
        }

//        返回当前要展示的列表项的数据的id属性值
        @Override
        public long getItemId(int position) {
            return mData==null?0:mData.get(position).id;
        }


/*        返回当前要展示的列表项视图对象
          position:当前要展示的数据在适配器中的位置
          convertView : View,可回收的View
          parent:  ViewGroup ->  ListView

 */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//1. 设置当前列表项的布局  2.装配当前列表项的数据
            View itemView = LayoutInflater.from(context).inflate(R.layout.chatting_item_left,null);

//            2.1 获取当前需要装配的数据
            ChatMessage chatMessage=mData.get(position);
//            2.2 通过列表项实例化后的根节点 来引用子控件


            return null;
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public int getViewTypeCount() {
            return super.getViewTypeCount();
        }
    }
}
