package com.changzheng.diyadapter;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
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
