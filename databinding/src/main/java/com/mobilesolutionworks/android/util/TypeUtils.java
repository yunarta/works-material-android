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

package com.mobilesolutionworks.android.util;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yunarta on 20/7/15.
 */
public class TypeUtils
{
    /**
     * Build uri with path specified in args
     *
     * @param base base Uri
     * @param args appended paths
     * @return Uri containing base Uri with appended paths
     */
    public static Uri buildUri(Uri base, String... args)
    {
        Uri.Builder builder = base.buildUpon();
        for (String arg : args)
        {
            builder.appendPath(arg);
        }
        return builder.build();
    }

    /**
     * Shortcut to create array with args
     *
     * @param args array member
     * @return array object
     */
    @SafeVarargs
    public static <T> T[] array(T... args)
    {
        return args;
    }

    /**
     * Create a flat JSON with pair of key value in the args
     * <p>
     * Example: json("key", "value") = {"key": "value"}
     *
     * @param args pair of key value
     * @return flat JSON containing key values
     */
    public static String json(String... args)
    {
        JSONObject object = new JSONObject();
        for (int i = 0; i < args.length / 2; i++)
        {
            try
            {
                object.put(args[i * 2], args[i * 2 + 1]);
            }
            catch (JSONException e)
            {
                // e.printStackTrace();
            }
        }
        return object.toString();
    }

    public static float parseFloat(String value)
    {
        return parseFloat(value, 0);
    }

    public static float parseFloat(String value, float fallback)
    {
        if (value == null || value.length() == 0)
        {
            return fallback;
        }

        try
        {
            return Float.parseFloat(value);
        }
        catch (Exception e)
        {
            return fallback;
        }
    }

    public static double parseDouble(String value)
    {
        return parseDouble(value, 0);
    }

    public static double parseDouble(String value, double fallback)
    {
        if (value == null || value.length() == 0)
        {
            return fallback;
        }

        try
        {
            return Double.parseDouble(value);
        }
        catch (Exception e)
        {
            return fallback;
        }
    }

    public static int parseInt(String value)
    {
        return parseInt(value, 0);
    }

    public static int parseInt(String value, int fallback)
    {
        if (value == null || value.length() == 0)
        {
            return fallback;
        }

        try
        {
            return Integer.parseInt(value);
        }
        catch (Exception e)
        {
            return fallback;
        }
    }

    public static long parseLong(String value)
    {
        return parseLong(value, 0);
    }

    public static long parseLong(String value, long fallback)
    {
        if (value == null || value.length() == 0)
        {
            return fallback;
        }

        try
        {
            return Long.parseLong(value);
        }
        catch (Exception e)
        {
            return fallback;
        }
    }
}
