package com.bolo1.tweet_app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.holder.EmptyItemHolder;
import com.bolo1.tweet_app.holder.FootHolder;
import com.bolo1.tweet_app.holder.HeaderItemHolder;
import com.bolo1.tweet_app.ui.uitls.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 菠萝 on 2018/5/3.
 */

public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter {


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            notifyDataSetChanged();
        }
    };
    //根据状态
    public static int pageSize;
    public static final int STATE_EMPTY_ITEM = 0;
    public static final int STATE_LOAD_MORE = 1;
    public static final int STATE_NO_MORE = 2;
    public static final int STATE_NO_DATA = 3;
    public static final int STATE_LESS_ONE_PAGE = 4;
    public static final int STATE_NETWORK_ERROR = 5;
    public static final int STATE_OTHER = 6;
    private LayoutInflater mInflater;
    private static final int TYPE_FOOT = 101;
    private static final int TYPE_NORMAL = 102;
    private static final int TYPE_EMPTY = 103;
    public ArrayList<T> mDatas = new ArrayList<T>();

    public static final int TYPE_HOLDER_FOOT = 101; ///根布局
    public static final int TYPE_HOLDER_NORMAL = 102;  //正常
    public static final int TYPE_HOLDER_EMPTY = 103; //空
    public static final int TYPE_HOLDER_HEADER = 104; //头

    public static int TYPE_HOLDER_STATE = TYPE_HOLDER_NORMAL;
    public boolean isHeaderHolder = false;


    public void setState(int state) {
        this.state = state;
    }

    protected int state = STATE_LOAD_MORE;
    private String _loadDataMore = "正在加载....";
    private String _loadFinishItem = "加载项目完成.";
    private String _NoDataText = "--没有更多了--";

    protected LayoutInflater getLayoutInflater(Context context) {

        if (mInflater == null) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        return mInflater;
    }

    private OnItemClickListener mOnItemClickListener;

//    /**
//     * 子类对view进行绑定
//     * @param itemView
//     */
    // protected abstract void setChildView(View itemView);

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("tag", "获取itemviewtype==============" + getDataSize());
        /**

         //待定 ------7/2修改
         if (getDataSize() == 0) {
         Log.d("tag", "你走了这里没有" + TYPE_EMPTY);
         state=STATE_EMPTY_ITEM;
         return TYPE_EMPTY;
         }else
         //      Log.d("tag", "你走了这里没有状态" + state+"--------"+getChildPageSize());
         if (position == getItemCount() - 1) {
         state=STATE_LOAD_MORE;
         return TYPE_FOOT;
         }
         Log.d("tag", "你走了这里没有状态" + state+"--------"+getItemCount());
         return TYPE_NORMAL;
         //return super.getItemViewType(position);

         /////-------------------------
         *
         */
        ///判断位置与状态返回的种类 1:头 2:正常布局 3:脚
        /***

         if(getDataSize()==0){
         TYPE_HOLDER_STATE=TYPE_HOLDER_EMPTY;
         }else if (position == 0 && getState() != STATE_EMPTY_ITEM && getState() != STATE_NETWORK_ERROR) {
         TYPE_HOLDER_STATE = TYPE_HOLDER_HEADER;
         } else if (position ==getItemCount()-1&& getState() != STATE_NETWORK_ERROR && getState() != STATE_LESS_ONE_PAGE) {
         LogUtils.d("加载脚布局--------------------------");
         TYPE_HOLDER_STATE = TYPE_FOOT;
         } else {
         TYPE_HOLDER_STATE = TYPE_HOLDER_NORMAL;
         }

         return TYPE_HOLDER_STATE;
         *
         */
        //测试三
        if (position == getItemCount() - 1) {
            //加载更多数据
            return TYPE_FOOT;
        } else {
            //交给子类去加载布局
            return getInnerType(position);
        }
    }

    protected int getInnerType(int position) {
        return TYPE_NORMAL;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ///
        RecyclerView.ViewHolder viewHolder = null;
        View view = null;
        LogUtils.d("当前返回的viewType类型是-------------------" + viewType);
//        switch (viewType){
//            case TYPE_EMPTY:
//                 view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_empty_layout, null, false);
//            //    EmptyItemHolder emptyItemHolder = new EmptyItemHolder(view);
//                TYPE_HOLDER_STATE=TYPE_HOLDER_EMPTY;
//                viewHolder= new EmptyItemHolder(view);
//                break;
//            case TYPE_FOOT:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_foot_layout, null, false);
//               viewHolder = new FootHolder(view);
//                TYPE_HOLDER_STATE=TYPE_HOLDER_FOOT;
//              break;
//            case TYPE_NORMAL:
//                j++;
//                   view = LayoutInflater.from(parent.getContext()).inflate(getChildFragmentLayout(parent,viewType), null, false);
//                Log.d("tag","--------我们新建了几个holder-----"+j);
//              //  viewHolder = new ViewHolder(view);
//                TYPE_HOLDER_STATE=TYPE_HOLDER_NORMAL;
//                viewHolder = getChildViewHolder(view);
//                  break;
//        }
        /////-------7/2修改---------------
        if (viewType == TYPE_EMPTY) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_empty_layout, parent, false);
            //EmptyItemHolder emptyItemHolder = new EmptyItemHolder(view);
            TYPE_HOLDER_STATE = TYPE_HOLDER_EMPTY;
            viewHolder = new EmptyItemHolder(view);
            return viewHolder;
        }

        if (viewType == TYPE_FOOT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_foot_layout, parent, false);
            FootHolder footViewHolder = new FootHolder(view);
            TYPE_HOLDER_STATE = TYPE_HOLDER_FOOT;
            return footViewHolder;
        }

        TYPE_HOLDER_STATE = TYPE_HOLDER_NORMAL;
        view = LayoutInflater.from(parent.getContext()).inflate(getChildFragmentLayout(parent, viewType), parent, false);
        viewHolder = getChildViewHolder(view);
        return viewHolder;


        ///  --------------------------------------------------
        /**

         switch (viewType) {
         case TYPE_HOLDER_EMPTY:
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_empty_layout, parent, false);
         // TYPE_HOLDER_STATE = TYPE_HOLDER_EMPTY;
         viewHolder = new EmptyItemHolder(view);
         break;
         case TYPE_HOLDER_HEADER:
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_header_layout, null, false);///暂时未写头布局

         viewHolder = new HeaderItemHolder(view);
         break;
         case TYPE_HOLDER_NORMAL:
         view = LayoutInflater.from(parent.getContext()).inflate(getChildFragmentLayout(parent, viewType), null, false);
         viewHolder = getChildViewHolder(view);
         break;
         case TYPE_HOLDER_FOOT:
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_foot_layout, parent, false);
         viewHolder = new FootHolder(view);
         // TYPE_HOLDER_STATE = TYPE_HOLDER_FOOT;
         break;
         }
         return (viewHolder!=null)?viewHolder:new EmptyItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.load_empty_layout, parent, false));
         *
         */


    }

    protected abstract RecyclerView.ViewHolder getChildViewHolder(View view);


    protected abstract int getChildFragmentLayout(ViewGroup parent, int viewType);


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        //对item进行赋值 交给子类去写
        //  setBindViewHolder(holder,position);
        Log.d("tag", "当前位置=====" + position + "当前状态------------" + TYPE_HOLDER_STATE);

        if (onCallBackPosition != null) {
            onCallBackPosition.getPosition(position);
        }
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(position);
                    return false;
                }
            });
        }
        switch (TYPE_HOLDER_STATE) {
            case TYPE_HOLDER_EMPTY:
                //执行帧动画？？？？
                break;
            case TYPE_HOLDER_FOOT:
                //  FootHolder footHolder = (FootHolder) holder;
                if (holder instanceof FootHolder) {
                    FootHolder footHolder = (FootHolder) holder;
                    if (getItemCount() < getChildPageSize()) {
                     //   setState(STATE_LESS_ONE_PAGE);
                        footHolder.pb_load_more.setVisibility(View.GONE);
                        footHolder.tv_load_more.setText(_NoDataText);
                        footHolder.tv_load_more.setTextSize(14);
                        footHolder.tv_load_more.setTextColor(Color.GRAY);
                    } else {
                      //  setState(STATE_LOAD_MORE);
                        footHolder.pb_load_more.setVisibility(View.VISIBLE);
                        footHolder.tv_load_more.setText(_loadDataMore);
                        footHolder.tv_load_more.setTextSize(14);
                        footHolder.tv_load_more.setTextColor(Color.BLACK);
                    }
                }
                break;
            case TYPE_HOLDER_NORMAL:
                setBindViewHolder(holder, position);
                break;
            case TYPE_HOLDER_HEADER:
                if (isHeaderHolder) {
                    setHeaderHolder((HeaderItemHolder) holder);
                }
                break;
        }
        ////
//        if(getDataSize()!=0&&TYPE_HOLDER_STATE!=TYPE_HOLDER_NORMAL){
//            TYPE_HOLDER_STATE=TYPE_HOLDER_NORMAL;
//        }

    }

    public void setHeaderHolder(HeaderItemHolder holder) {
    }


    public abstract void setBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        ////这里需要状态
        //判断datasize大小
//        if (getDataSize() == 0) {
//            setState(STATE_EMPTY_ITEM);
//        } else if (0 < getDataSize() && getDataSize() < getChildPageSize()) {
//            setState(STATE_LESS_ONE_PAGE);
//        } else if (getDataSize() > getChildPageSize()) {
//            setState(STATE_LOAD_MORE);
//        } else {
//            setState(STATE_OTHER);
//        }


        switch (getState()) {
            case STATE_EMPTY_ITEM:
                return 0;
            case STATE_NETWORK_ERROR:
            case STATE_LOAD_MORE:
                return getDataSize()+1;
            case STATE_NO_MORE :
                return getDataSize()+1;
            case STATE_NO_DATA:
                return getDataSize();
            case STATE_LESS_ONE_PAGE:
                return getDataSize();
            default:
                return getDataSize();
            //------------------------7/2修改
//            case STATE_EMPTY_ITEM:
//                return getDataSize() + 1;
//            case STATE_LOAD_MORE:
//            case STATE_NO_MORE:
//                return getDataSize() + 1;
//            case STATE_NO_DATA:
//                return getDataSize();
//            case STATE_NETWORK_ERROR:
//                return getDataSize();
//            case STATE_OTHER:
//                return getDataSize() + 2;
//            default:
//                return getDataSize();
        }
        //   return getDataSize();
    }
    // public abstract int getDataSize();


    public void setData(ArrayList<T> data) {
        mDatas.addAll(data);
        handler.sendEmptyMessage(0);
    }

    public ArrayList<T> getData() {
        return mDatas == null ? (new ArrayList<T>()) : (mDatas);
    }


    private int getDataSize() {
        Log.d("tag", "数据的大小==" + mDatas.size());
        return mDatas.size();
    }

    public void addData(List<T> data) {
        if (!data.isEmpty() && mDatas != null) {
            mDatas.addAll(data);

            //mDatas.add(data)

        }
        //刷新
        handler.sendEmptyMessage(0);

    }

    public void addData(List<T> data, int pos) {
        if (!data.isEmpty() && mDatas != null) {
            mDatas.addAll(pos, data);
        }
        //刷新
        handler.sendEmptyMessage(0);
//        this.notifyDataSetChanged();
    }

    public void addItem(List<T> data) {
        if (mDatas != null) {
            mDatas.addAll(data);
        }
        //刷新
        notifyDataSetChanged();
    }

    public void addItem(List<T> data, int pos) {
        if (mDatas != null) {
            mDatas.addAll(pos, data);
        }
        //刷新
        notifyDataSetChanged();
    }


    public int getState() {
        return this.state;
    }

    public int getChildPageSize() {
        return pageSize;
    }

    public void setChildPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    ////////-------------为item添加点击-------///////////
    public interface OnItemClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    //////---------------获取位置的回调------------/////
    public interface OnCallBackPosition {
        void getPosition(int position);
    }

    private OnCallBackPosition onCallBackPosition;

    public void setOnCallBackPosition(OnCallBackPosition onCallBackPosition) {
        this.onCallBackPosition = onCallBackPosition;
    }
}
