package com.hugehard.sharables;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by guidi on 7/26/2017.
 */

public class ListViewHelper {
    public static void getListViewSize(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            //do nothing and return
            return;
        }

        //set list adapter in a loop to get final size
        int totalHeight = 0;
        for (int size = 0; size < listAdapter.getCount(); size++) {
            View listItem = listAdapter.getView(size, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        //setting listview item in adapter
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        //print height of adapter on log
        Log.i("height of listItem: ", String.valueOf(totalHeight));
    }
}
