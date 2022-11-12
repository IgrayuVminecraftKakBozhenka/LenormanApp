package com.gadalka

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData

@Composable
fun Banner() {

    val adRequest = remember { AdRequest.Builder().build() }

    val bannerAdEventListener = object : BannerAdEventListener {
        override fun onAdLoaded() {
            Log.d("YANDEX_ADS", "Loaded")
        }

        override fun onAdFailedToLoad(p0: AdRequestError) {
            Log.d("YANDEX_ADS", "Failed ${p0.code} ${p0.description}")
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


    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(56.dp),
            factory = { context ->
                BannerAdView(context)
            },
            update = { banner ->
                banner.setAdUnitId("R-M-2010309-1")
                banner.setAdSize(AdSize.flexibleSize(320, 50))
                banner.loadAd(adRequest)
                banner.setBannerAdEventListener(bannerAdEventListener)
            }
        )
    }
}