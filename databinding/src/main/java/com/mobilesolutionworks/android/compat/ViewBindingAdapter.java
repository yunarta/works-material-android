/*
 * Copyright 2015-present Yunarta
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.mobilesolutionworks.android.compat;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

/**
 * Created by yunarta on 18/7/15.
 */
public abstract class ViewBindingAdapter extends RecyclerView.Adapter<ViewBindingHolder<? extends ViewDataBinding>>
{
    private WeakReference<LayoutInflater> mInflater;

    @Override
    public ViewBindingHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (mInflater == null)
        {
            mInflater = new WeakReference<>(LayoutInflater.from(parent.getContext()));
        }

        LayoutInflater inflater = mInflater.get();

        ViewDataBinding binding = DataBindingUtil.inflate(inflater, getItemLayout(viewType), parent, true);
        return new ViewBindingHolder<>(binding);
    }

    protected abstract int getItemLayout(int viewType);
}
