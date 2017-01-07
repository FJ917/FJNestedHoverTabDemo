package fj.nestedhovertab.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FT
 * @time 2016-07-18 16:49
 */

// JUMP 
public class DemoFragment extends Fragment {
    RecyclerView mRecyclerView;
    private Context context;
    private int mPage;
    public static final String MERCHANT_DETAILS_PAGE = "MERCHANT_DETAILS_PAGE";
    private DemoAdapter mAdapter;

    List<String> mFoodData;
    List<String> mMovieData;
    List<String> mHaveFunData;
    List<String> mEvaluationData;

    public static DemoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(MERCHANT_DETAILS_PAGE, page);
        DemoFragment tripFragment = new DemoFragment();
        tripFragment.setArguments(args);
        return tripFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(MERCHANT_DETAILS_PAGE);
        context = getActivity().getApplicationContext();
        setData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        switch (mPage){
            case 0:
                initAdapter(mFoodData);
                break;
            case 1:
                initAdapter(mMovieData);
                break;
            case 2:
                initAdapter(mHaveFunData);
                break;
            case 3:
                initAdapter(mEvaluationData);
                break;
        }
        return view;
    }

    private void setData(){
        mFoodData = new ArrayList<>();
        for(int i=0; i<10;i++){
            mFoodData.add("美食"+i);
        }
        mMovieData = new ArrayList<>();
        for(int i=0; i<3;i++){
            mMovieData.add("电影"+i);
        }
        mHaveFunData = new ArrayList<>();
        for(int i=0; i<5;i++){
            mHaveFunData.add("玩乐"+i);
        }
        mEvaluationData = new ArrayList<>();
        for(int i=0; i<1;i++){
            mEvaluationData.add("评价"+i);
        }
    }
    /**
     * 设置RecyclerView属性
     */
    private void initAdapter(List<String> data) {
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new DemoAdapter(getActivity(), R.layout.item_ification_class, data);
        mAdapter.openLoadAnimation();
        mRecyclerView.setAdapter(mAdapter);//设置adapter
        //设置item点击事件
        mAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }
    /**
     * adapter
     */
    class DemoAdapter extends BaseQuickAdapter<String> {
        int mLayoutId;
        public DemoAdapter(Context context, int LayoutId, List<String> str) {
            super(context, LayoutId, str);
            mLayoutId = LayoutId;
        }

        @Override
        public void convert(BaseViewHolder helper, String str) {
            helper.setText(R.id.tvTitle,str);
        }
    }

}
