//
// Created by Yodo1 on 21/07/2022.
//

#include "Yodo1Ads.h"
#include "platform/android/jni/JniHelper.h"
#include <jni.h>
#include <android/log.h>

const char* NativeActivityClassName = "org/cocos2dx/cpp/AppActivity";

void Yodo1Ads::initializeSdk(const char* appKey){
    cocos2d::JniMethodInfo t;
    if (cocos2d::JniHelper::getStaticMethodInfo(t
            , NativeActivityClassName
            , "initializeSdk"
            , "(Ljava/lang/String;)V"))
    {
        jstring stringAppKey = t.env->NewStringUTF(appKey);

        t.env->CallStaticVoidMethod(t.classID,t.methodID,stringAppKey);
        t.env->DeleteLocalRef(t.classID);
    }
}

void Yodo1Ads::initializeInterstitialAds(){
    cocos2d::JniMethodInfo t;
    if (cocos2d::JniHelper::getStaticMethodInfo(t
            , NativeActivityClassName
            , "initializeInterstitialAds"
            , "()V"))
    {
        t.env->CallStaticVoidMethod(t.classID, t.methodID);
        t.env->DeleteLocalRef(t.classID);
    }
}

void Yodo1Ads::initializeRewardAds(){
    cocos2d::JniMethodInfo t;
    if (cocos2d::JniHelper::getStaticMethodInfo(t
            , NativeActivityClassName
            , "initializeRewardAds"
            , "()V"))
    {
        t.env->CallStaticVoidMethod(t.classID, t.methodID);
        t.env->DeleteLocalRef(t.classID);
    }
}

void Yodo1Ads::showBannerAds(){
    cocos2d::JniMethodInfo t;
    if (cocos2d::JniHelper::getStaticMethodInfo(t
            , NativeActivityClassName
            , "showBannerAds"
            , "()V"))
    {
        t.env->CallStaticVoidMethod(t.classID, t.methodID);
        t.env->DeleteLocalRef(t.classID);
    }
}

void Yodo1Ads::hideBannerAds(){
    cocos2d::JniMethodInfo t;
    if (cocos2d::JniHelper::getStaticMethodInfo(t
            , NativeActivityClassName
            , "hideBannerAds"
            , "()V"))
    {
        t.env->CallStaticVoidMethod(t.classID, t.methodID);
        t.env->DeleteLocalRef(t.classID);
    }
}

void Yodo1Ads::showInterstitialAds(){
    cocos2d::JniMethodInfo t;
    if (cocos2d::JniHelper::getStaticMethodInfo(t
            , NativeActivityClassName
            , "showInterstitialAds"
            , "()V"))
    {
        t.env->CallStaticVoidMethod(t.classID, t.methodID);
        t.env->DeleteLocalRef(t.classID);
    }
}

void Yodo1Ads::showRewardAds(){
    cocos2d::JniMethodInfo t;
    if (cocos2d::JniHelper::getStaticMethodInfo(t
            , NativeActivityClassName
            , "showRewardAds"
            , "()V"))
    {
        t.env->CallStaticVoidMethod(t.classID, t.methodID);
        t.env->DeleteLocalRef(t.classID);
    }
}

void onMasInitSuccessful() {
    CCLOG("Yodo1 Mas : onMasInitSuccessful");
}

void onInterstitialAdLoaded() {
    CCLOG("Yodo1 Mas : onInterstitialAdLoaded");
}

void onMasInitFailed() {
    CCLOG("Yodo1 Mas : onMasInitFailed");
}

void onInterstitialAdFailedToLoad() {
    CCLOG("Yodo1 Mas : onInterstitialAdFailedToLoad");
}

void onInterstitialAdOpened() {
    CCLOG("Yodo1 Mas : onInterstitialAdOpened");
}

void onInterstitialAdFailedToOpen() {
    CCLOG("Yodo1 Mas : onInterstitialAdFailedToOpen");
}

void onInterstitialAdClosed() {
    CCLOG("Yodo1 Mas : onInterstitialAdClosed");
}

void onRewardAdLoaded() {
    CCLOG("Yodo1 Mas : onRewardAdLoaded");
}

void onRewardAdFailedToLoad() {
    CCLOG("Yodo1 Mas : onRewardAdFailedToLoad");
}

void onRewardAdOpened() {
    CCLOG("Yodo1 Mas : onRewardAdOpened");
}

void onRewardAdFailedToOpen() {
    CCLOG("Yodo1 Mas : onRewardAdFailedToOpen");
}

void onRewardAdClosed() {
    CCLOG("Yodo1 Mas : onRewardAdClosed");
}

void onRewardAdEarned() {
    CCLOG("Yodo1 Mas : onRewardAdEarned");
    // TODO : Add your reward code here
}

void onBannerAdLoaded() {
    CCLOG("Yodo1 Mas : onBannerAdLoaded");
}

void onBannerAdFailedToLoad() {
    CCLOG("Yodo1 Mas : onBannerAdFailedToLoad");
}

void onBannerAdOpened() {
    CCLOG("Yodo1 Mas : onBannerAdOpened");
}

void onBannerAdFailedToOpen() {
    CCLOG("Yodo1 Mas : onBannerAdFailedToOpen");
}

void onBannerAdClosed() {
    CCLOG("Yodo1 Mas : onBannerAdClosed");
}

extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnMasInitSuccessful(JNIEnv *env, jclass clazz) {
    onMasInitSuccessful();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnMasInitFailed(JNIEnv *env, jclass clazz) {
    onMasInitFailed();
}

extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnInterstitialAdLoaded(JNIEnv *env, jclass clazz) {
    onInterstitialAdLoaded();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnInterstitialAdFailedToLoad(JNIEnv *env, jclass clazz) {
    onInterstitialAdFailedToLoad();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnInterstitialAdOpened(JNIEnv *env, jclass clazz) {
    onInterstitialAdOpened();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnInterstitialAdFailedToOpen(JNIEnv *env, jclass clazz) {
    onInterstitialAdFailedToOpen();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnInterstitialAdClosed(JNIEnv *env, jclass clazz) {
    onInterstitialAdClosed();
}

extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnRewardAdLoaded(JNIEnv *env, jclass clazz) {
    onRewardAdLoaded();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnRewardAdFailedToLoad(JNIEnv *env, jclass clazz) {
    onRewardAdFailedToLoad();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnRewardAdOpened(JNIEnv *env, jclass clazz) {
    onRewardAdOpened();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnRewardAdFailedToOpen(JNIEnv *env, jclass clazz) {
    onRewardAdFailedToOpen();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnRewardAdClosed(JNIEnv *env, jclass clazz) {
    onRewardAdClosed();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnRewardAdEarned(JNIEnv *env, jclass clazz) {
    onRewardAdEarned();
}

extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnBannerAdLoaded(JNIEnv *env, jclass clazz) {
    onBannerAdLoaded();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnBannerAdFailedToLoad(JNIEnv *env, jclass clazz) {
    onBannerAdFailedToLoad();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnBannerAdOpened(JNIEnv *env, jclass clazz) {
    onBannerAdOpened();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnBannerAdFailedToOpen(JNIEnv *env, jclass clazz) {
    onBannerAdFailedToOpen();
}
extern "C"
JNIEXPORT void JNICALL
Java_org_cocos2dx_cpp_Yodo1Ads_nativeOnBannerAdClosed(JNIEnv *env, jclass clazz) {
    onBannerAdClosed();
}