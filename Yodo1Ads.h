//
// Created by Yodo1 on 21/07/2022.
//

#ifndef PROJ_ANDROID_YODOHELPER_H
#define PROJ_ANDROID_YODOHELPER_H

#endif //PROJ_ANDROID_YODOHELPER_H

#include <jni.h>

class Yodo1Ads
{
public:
    static void initializeSdk(const char*);

    static void initializeInterstitialAds();
    static void initializeRewardAds();

    static void showInterstitialAds();
    static void showRewardAds();

    static void showBannerAds();
    static void hideBannerAds();

};

