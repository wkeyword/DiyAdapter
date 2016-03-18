package com.changzheng.diyadapter;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
//        通过convertView:可回收的View  来优化自定义适配器
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
////1. 设置当前列表项的布局  2.装配当前列表项的数据
////            把实例化的布局根节点对象通过addView的形式添加到parent中,而adapterView不支持addview添加子控件,通过适配器的形式来装配
////            View itemView = LayoutInflater.from(context).inflate(R.layout.chat_left, null);//列表项根节点布局对象宽和高以默认的值赋值(wrap——content)
////            View itemView = LayoutInflater.from(context).inflate(R.layout.chat_left, parent,false);
////            View itemView = LayoutInflater.from(context).inflate(R.layout.chat_left, null);
//            if (convertView==null){
//                convertView=LayoutInflater.from(context).inflate(R.layout.chat_left, null);
//            }
////            2.1 获取当前需要装配的数据
//            final ChatMessage chatMessage=mData.get(position);
////            2.2 通过列表项实例化后的根节点 来引用子控件
//            ImageView iconIv = (ImageView) convertView.findViewById(R.id.icon);
//            TextView msgTv = (TextView) convertView.findViewById(R.id.message);
////            2.3 子控件设置数据
//            msgTv.setText("机器人:" + chatMessage.message);
////            自定义控件的作用"操纵列表项的子控件的属性,操作列表项要填充的数据
//            msgTv.setTextColor(Color.BLUE);
//            iconIv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context,chatMessage.message+chatMessage.id,Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            return convertView;
//        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            HolderView holderView=null;
//1. 设置当前列表项的布局  2.装配当前列表项的数据
//            把实例化的布局根节点对象通过addView的形式添加到parent中,而adapterView不支持addview添加子控件,通过适配器的形式来装配
//            View itemView = LayoutInflater.from(context).inflate(R.layout.chat_left, null);//列表项根节点布局对象宽和高以默认的值赋值(wrap——content)
//            View itemView = LayoutInflater.from(context).inflate(R.layout.chat_left, parent,false);
//            View itemView = LayoutInflater.from(context).inflate(R.layout.chat_left, null);
            if (convertView==null){
                holderView=new HolderView();
                if (getItemViewType(position)==0){
                    convertView=LayoutInflater.from(context).inflate(R.layout.chat_right,parent,false);
                }else {
                    convertView=LayoutInflater.from(context).inflate(R.layout.chat_left,parent,false);
                }
//                convertView=LayoutInflater.from(context).inflate(R.layout.chat_left, null);
                holderView.holderIv= (ImageView) convertView.findViewById(R.id.icon);
                holderView.holerMessageTv= (TextView) convertView.findViewById(R.id.message);
                convertView.setTag(holderView);
            }else {
                holderView=(HolderView)convertView.getTag();
            }
//            2.1 获取当前需要装配的数据
            final ChatMessage chatMessage=mData.get(position);
//            2.2 通过列表项实例化后的根节点 来引用子控件
//            ImageView iconIv = (ImageView) convertView.findViewById(R.id.icon);
//            TextView msgTv = (TextView) convertView.findViewById(R.id.message);
//            holderView.holderIv.setTextAlignment(chatMessage.message);
            holderView.holerMessageTv.setText(chatMessage.message);

//            2.3 子控件设置数据
//            msgTv.setText("机器人:" + chatMessage.message);
//            自定义控件的作用"操纵列表项的子控件的属性,操作列表项要填充的数据
//            msgTv.setTextColor(Color.BLUE);
//            iconIv.setOnClickListener(new View.OnClickListener() {
            holderView.holderIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,chatMessage.message+chatMessage.id,Toast.LENGTH_SHORT).show();
                }
            });
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context,chatMessage.message+chatMessage.id,Toast.LENGTH_SHORT).show();
//                }
//            });

            return convertView;
        }

        @Override
        public int getItemViewType(int position) {
            return mData.get(position).isSelf?0:1;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }
    }
//    准备一个本子,用来登记要引用的地址
    private static class HolderView{
        ImageView holderIv;
        TextView holerMessageTv;




    }

}
