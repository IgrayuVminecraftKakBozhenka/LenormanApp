package com.gadalka

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.interstitial.InterstitialAd
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener

@Composable
fun AdScreen(
    onAdEnd: () -> Unit
) {

    val context = LocalView.current.context
    val interstitialAd = remember { InterstitialAd(context) }
    interstitialAd.setAdUnitId("R-M-2010309-2")

    val adRequest = remember { AdRequest.Builder().build() }

    val adEventListener = object : InterstitialAdEventListener {
        override fun onAdLoaded() {
            Log.d("YANDEX_ADS", "Loaded full screen")
            interstitialAd.show()
        }

        override fun onAdFailedToLoad(p0: AdRequestError) {
            Log.d("YANDEX_ADS", "Failed ${p0.code} ${p0.description}")
        }

        override fun onAdShown() {
            Log.d("YANDEX_ADS", "shown")
            onAdEnd()
        }

        override fun onAdDismissed() {
            onAdEnd()
        }

        override fun onAdClicked() {
            // TODO("Not yet implemented")
        }

        override fun onLeftApplication() {
            // TODO("Not yet implemented")
        }

        override fun onReturnedToApplication() {
            //TODO("Not yet implemented")
        }

        override fun onImpression(p0: ImpressionData?) {
            //TODO("Not yet implemented")
        }

    }

    interstitialAd.setInterstitialAdEventListener(adEventListener)
    interstitialAd.loadAd(adRequest)

//    AndroidView(
//        modifier = Modifier
//            .padding(top = 16.dp)
//            .fillMaxSize()
//            .height(56.dp),
//        factory = { context ->
//            BannerAdView(context)
//        },
//        update = { banner ->
//            banner.setAdUnitId("R-M-DEMO-320x50")
//            banner.setAdSize(AdSize.FULL_SCREEN)
//            banner.loadAd(adRequest)
//            banner.setBannerAdEventListener(bannerAdEventListener)
//        }
//    )
}