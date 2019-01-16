/*
 * Copyright (C) 2018 CypherOS
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
package com.android.launcher3.qsb.search;

import android.content.Context;
import android.util.AttributeSet;

import com.android.launcher3.qsb.AllAppsQsbView;

import com.android.launcher3.ExtendedEditText;
import com.android.launcher3.Launcher;
import com.android.launcher3.allapps.AllAppsContainerView;
import com.android.launcher3.allapps.AllAppsStore.OnUpdateListener;
import com.android.launcher3.allapps.AlphabeticalAppsList;
import com.android.launcher3.allapps.search.AllAppsSearchBarController;
import com.android.launcher3.allapps.search.AllAppsSearchBarController.Callbacks;
import com.android.launcher3.util.ComponentKey;

import java.util.ArrayList;

public class DefaultSearchView extends ExtendedEditText implements OnUpdateListener, Callbacks {

    public AllAppsSearchBarController mController;
    public AllAppsQsbView mAllAppsQsbView;
    public AlphabeticalAppsList mApps;
    public AllAppsContainerView mAppsView;

    public DefaultSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mController = new AllAppsSearchBarController();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Launcher.getLauncher(getContext()).getAppsView().getAppsStore().addUpdateListener(this);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Launcher.getLauncher(getContext()).getAppsView().getAppsStore().removeUpdateListener(this);
    }

    @Override
    public void onSearchResult(String query, ArrayList<ComponentKey> apps) {
        if (apps != null && getParent() != null) {
            mApps.setOrderedFilter(apps);
            refreshSearchResult();
            mAppsView.setLastSearchQuery(query);
        }
    }

    @Override
    public void clearSearchResult() {
        if (getParent() != null) {
            if (mApps.setOrderedFilter(null)) {
                refreshSearchResult();
            }
            mAllAppsQsbView.setKeepDefaultView(true);
            mAppsView.onClearSearchResult();
            mAllAppsQsbView.setKeepDefaultView(false);
        }
    }

    @Override
    public void onAppsUpdated() {
        mController.refreshSearchResult();
    }

    public void refreshSearchResult() {
        mAllAppsQsbView.setShadowAlpha(0);
        mAppsView.onSearchResultsChanged();
    }
}
