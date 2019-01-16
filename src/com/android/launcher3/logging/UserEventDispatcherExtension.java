/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.launcher3.logging;

import android.content.Context;
import android.util.Log;

import static com.android.launcher3.logging.LoggerUtils.newLauncherEvent;
import static com.android.launcher3.userevent.nano.LauncherLogProto.ControlType.CANCEL_TARGET;


import com.android.launcher3.logging.UserEventDispatcher;
import com.android.launcher3.userevent.nano.LauncherLogProto;

/**
 * This class handles AOSP MetricsLogger function calls and logging around
 * quickstep interactions.
 */
@SuppressWarnings("unused")
public class UserEventDispatcherExtension extends UserEventDispatcher {

    private static final String TAG = "UserEventDispatcher";

    public UserEventDispatcherExtension(Context context) { }

    public void logStateChangeAction(int action, int dir, int srcChildTargetType,
                                     int srcParentContainerType, int dstContainerType,
                                     int pageIndex) {

        super.logStateChangeAction(action, dir, srcChildTargetType, srcParentContainerType,
                dstContainerType, pageIndex);
    }

    public void logActionTip(int actionType, int viewType) {
        LauncherLogProto.Action action = new LauncherLogProto.Action();
        LauncherLogProto.Target target = new LauncherLogProto.Target();
        switch(actionType) {
            default:
                Log.e(TAG, "Unexpected action type = " + actionType);
        }

        switch(viewType) {
            default:
                Log.e(TAG, "Unexpected viewType = " + viewType);
        }
        LauncherLogProto.LauncherEvent event = newLauncherEvent(action, target);
        dispatchUserEvent(event, null);
    }
}
