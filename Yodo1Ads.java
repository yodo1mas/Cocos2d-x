//
// Created by Yodo1 on 21/07/2022.
//

package org.cocos2dx.cpp;

import android.os.Debug;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.unity3d.services.core.log.DeviceLog;
import com.yodo1.mas.Yodo1Mas;
import com.yodo1.mas.banner.Yodo1MasBannerAdListener;
import com.yodo1.mas.banner.Yodo1MasBannerAdSize;
import com.yodo1.mas.banner.Yodo1MasBannerAdView;
import com.yodo1.mas.error.Yodo1MasError;
import com.yodo1.mas.helper.model.Yodo1MasAdBuildConfig;
import com.yodo1.mas.interstitial.Yodo1MasInterstitialAd;
import com.yodo1.mas.interstitial.Yodo1MasInterstitialAdListener;
import com.yodo1.mas.reward.Yodo1MasRewardAd;
import com.yodo1.mas.reward.Yodo1MasRewardAdListener;

import org.cocos2dx.lib.Cocos2dxActivity;

public class Yodo1Ads {

    public static native void nativeOnMasInitSuccessful();
    public static native void nativeOnMasInitFailed();

    public static native void nativeOnInterstitialAdLoaded();
    public static native void nativeOnInterstitialAdFailedToLoad();
    public static native void nativeOnInterstitialAdOpened();
    public static native void nativeOnInterstitialAdFailedToOpen();
    public static native void nativeOnInterstitialAdClosed();

    public static native void nativeOnRewardAdLoaded();
    public static native void nativeOnRewardAdFailedToLoad();
    public static native void nativeOnRewardAdOpened();
    public static native void nativeOnRewardAdFailedToOpen();
    public static native void nativeOnRewardAdClosed();
    public static native void nativeOnRewardAdEarned();

    public static native void nativeOnBannerAdLoaded();
    public static native void nativeOnBannerAdFailedToLoad();
    public static native void nativeOnBannerAdOpened();
    public static native void nativeOnBannerAdFailedToOpen();
    public static native void nativeOnBannerAdClosed();

    private static Yodo1MasBannerAdView bannerAdView;

    private static AppActivity activity;

    public void initSDK(AppActivity activity) {
        this.activity = activity;
    }
    public static void initializeSdk(AppActivity activity, String appKey) //its working
    {
        Yodo1Ads yodo1Ads = new Yodo1Ads();
        yodo1Ads.initSDK(activity);

        activity.runOnUiThread( new Runnable() {
            public void run() {

                Yodo1MasAdBuildConfig config = new Yodo1MasAdBuildConfig.Builder().enableUserPrivacyDialog(true).build();
                Yodo1Mas.getInstance().setAdBuildConfig(config);
                Yodo1Mas.getInstance().initMas(activity, appKey, new Yodo1Mas.InitListener() {
                    @Override
                    public void onMasInitSuccessful() {
                        nativeOnMasInitSuccessful();
                    }

                    @Override
                    public void onMasInitFailed(@NonNull Yodo1MasError error) {
                        nativeOnMasInitFailed();
                    }
                });
            }
         });
    }

    public static void initializeInterstitialAds()
    {
        activity.runOnUiThread( new Runnable() {
            public void run() {
                Yodo1MasInterstitialAd.getInstance().loadAd(activity);

                Yodo1MasInterstitialAd.getInstance().setAdListener(new Yodo1MasInterstitialAdListener() {

                    @Override
                    public void onInterstitialAdLoaded(Yodo1MasInterstitialAd ad) {
                        nativeOnInterstitialAdLoaded();
                    }

                    @Override
                    public void onInterstitialAdFailedToLoad(Yodo1MasInterstitialAd ad, @NonNull Yodo1MasError error) {
                        nativeOnInterstitialAdFailedToLoad();
                    }

                    @Override
                    public void onInterstitialAdOpened(Yodo1MasInterstitialAd ad) {
                        nativeOnInterstitialAdOpened();
                    }

                    @Override
                    public void onInterstitialAdFailedToOpen(Yodo1MasInterstitialAd ad, @NonNull Yodo1MasError error) {
                        ad.loadAd(activity);
                        nativeOnInterstitialAdFailedToOpen();
                    }

                    @Override
                    public void onInterstitialAdClosed(Yodo1MasInterstitialAd ad) {
                        ad.loadAd(activity);
                        nativeOnInterstitialAdClosed();
                    }
                });
            }
        });

    }

    public static void showInterstitialAds() //
    {
        activity.runOnUiThread( new Runnable() {
            public void run() {
                boolean isLoaded = Yodo1MasInterstitialAd.getInstance().isLoaded();
                if(isLoaded) Yodo1MasInterstitialAd.getInstance().showAd(activity);
            }
        });
    }

    public static void initializeRewardAds() {

        activity.runOnUiThread( new Runnable() {
            public void run() {
                Yodo1MasRewardAd.getInstance().loadAd(activity);

                Yodo1MasRewardAd.getInstance().setAdListener(new Yodo1MasRewardAdListener() {

                    @Override
                    public void onRewardAdLoaded(Yodo1MasRewardAd ad) {
                        nativeOnRewardAdLoaded();
                    }

                    @Override
                    public void onRewardAdFailedToLoad(Yodo1MasRewardAd ad, @NonNull Yodo1MasError error) {
                        nativeOnRewardAdFailedToLoad();
                    }

                    @Override
                    public void onRewardAdOpened(Yodo1MasRewardAd ad) {
                        nativeOnRewardAdOpened();
                    }

                    @Override
                    public void onRewardAdFailedToOpen(Yodo1MasRewardAd ad, @NonNull Yodo1MasError error) {
                        ad.loadAd(activity);
                        nativeOnRewardAdFailedToOpen();
                    }

                    @Override
                    public void onRewardAdClosed(Yodo1MasRewardAd ad) {
                        ad.loadAd(activity);
                        nativeOnRewardAdClosed();
                    }

                    @Override
                    public void onRewardAdEarned(Yodo1MasRewardAd ad) {
                        nativeOnRewardAdEarned();
                    }
                });
            }
        });


    }

    public static void showRewardAds()
    {
        activity.runOnUiThread( new Runnable() {
            public void run() {
                boolean isLoaded = Yodo1MasRewardAd.getInstance().isLoaded();
                if(isLoaded) Yodo1MasRewardAd.getInstance().showAd(activity,"AdPlacement");
            }
        });
    }

    public static void InitBanner()
    {

        LinearLayout layout = new LinearLayout(Cocos2dxActivity.getContext());
        layout.setOrientation(LinearLayout.VERTICAL);

        //Additionally to adjust the position to Bottom
        layout.setGravity(Gravity.BOTTOM);

        Yodo1MasBannerAdView bannerAdView = new Yodo1MasBannerAdView(Cocos2dxActivity.getContext());
        bannerAdView.setAdSize(Yodo1MasBannerAdSize.Banner);

        bannerAdView.setAdListener(new Yodo1MasBannerAdListener() {
            @Override public void onBannerAdLoaded(Yodo1MasBannerAdView bannerAdView) {
                nativeOnBannerAdLoaded();
            }
            @Override
            public void onBannerAdFailedToLoad(Yodo1MasBannerAdView bannerAdView, @NonNull Yodo1MasError error) {
                nativeOnBannerAdFailedToLoad();
            }
            @Override public void onBannerAdOpened(Yodo1MasBannerAdView bannerAdView) {
                nativeOnBannerAdOpened();
            }
            @Override
            public void onBannerAdFailedToOpen(Yodo1MasBannerAdView bannerAdView, @NonNull Yodo1MasError error) {
                nativeOnBannerAdFailedToOpen();
            }
            @Override
            public void onBannerAdClosed(Yodo1MasBannerAdView bannerAdView) {
                nativeOnBannerAdClosed();
            }
        });
        layout.addView(bannerAdView);

        // Start loading the ad.
        bannerAdView.loadAd();

     //   setContentView(layout);

    }

    public static void showBannerAds(String size, String horizontal_alignment, String vertical_alignment)
    {
        activity.runOnUiThread( new Runnable() {
            public void run() {

                bannerAdView = new Yodo1MasBannerAdView(activity);

                if(size == "Banner")
                    bannerAdView.setAdSize(Yodo1MasBannerAdSize.Banner);
                else if(size == "AdaptiveBanner")
                    bannerAdView.setAdSize(Yodo1MasBannerAdSize.AdaptiveBanner);
                else if(size == "LargeBanner")
                    bannerAdView.setAdSize(Yodo1MasBannerAdSize.LargeBanner);
                else if(size == "SmartBanner")
                    bannerAdView.setAdSize(Yodo1MasBannerAdSize.SmartBanner);
                else if(size == "IABMediumRectangle")
                    bannerAdView.setAdSize(Yodo1MasBannerAdSize.IABMediumRectangle);

                RelativeLayout adRelativeLayout = new RelativeLayout(activity);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                if(horizontal_alignment == "CENTER")
                    params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                else if(horizontal_alignment == "LEFT")
                    params.addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);
                else if(horizontal_alignment == "RIGHT")
                    params.addRule(RelativeLayout.ALIGN_RIGHT, RelativeLayout.TRUE);

                if(vertical_alignment == "TOP")
                    params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                else if(horizontal_alignment == "BOTTOM")
                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

                bannerAdView.setLayoutParams(params);
                adRelativeLayout.addView(bannerAdView);

                bannerAdView.setAdListener(new Yodo1MasBannerAdListener() {
                    @Override public void onBannerAdLoaded(Yodo1MasBannerAdView bannerAdView) {
                        nativeOnBannerAdLoaded();
                    }
                    @Override
                    public void onBannerAdFailedToLoad(Yodo1MasBannerAdView bannerAdView, @NonNull Yodo1MasError error) {
                        nativeOnBannerAdFailedToLoad();
                    }
                    @Override public void onBannerAdOpened(Yodo1MasBannerAdView bannerAdView) {
                        nativeOnBannerAdOpened();
                    }
                    @Override
                    public void onBannerAdFailedToOpen(Yodo1MasBannerAdView bannerAdView, @NonNull Yodo1MasError error) {
                        nativeOnBannerAdFailedToOpen();
                    }
                    @Override
                    public void onBannerAdClosed(Yodo1MasBannerAdView bannerAdView) {
                        nativeOnBannerAdClosed();
                    }
                });

                activity.setContentView(adRelativeLayout);
                bannerAdView.loadAd();
            }
        });
    }

    public static void hideBannerAds() {
        bannerAdView.destroy();
    }

}