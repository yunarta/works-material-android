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

import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.ViewGroup;

/**
 * Created by yunarta on 19/7/15.
 */
public class TransitionCompat
{
    public static void beginDelayedTransition(ViewGroup viewGroup)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            TransitionManager.beginDelayedTransition(viewGroup);
        }
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Transition transition)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            TransitionManager.beginDelayedTransition(viewGroup, transition);
        }
    }
}
