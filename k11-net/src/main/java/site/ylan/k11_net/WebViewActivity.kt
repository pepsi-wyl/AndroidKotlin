package site.ylan.k11_net

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_BACK
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import site.ylan.k11_net.base.BaseActivity
import site.ylan.k11_net.databinding.ActivityWebViewBinding

class WebViewActivity : BaseActivity<ActivityWebViewBinding>() {

    private lateinit var webView: WebView

    override fun onCreated(savedInstanceState: Bundle?) {
        webView = binding.webView

        val  webSettings: WebSettings = webView.settings
        // 支持JavaScript脚本
        webSettings.javaScriptEnabled = true

        // 设置自适应屏幕，两者合用
        webSettings.useWideViewPort = true;         // 将图片调整到适合webview的大小
        webSettings.loadWithOverviewMode = true;    // 缩放至屏幕的大小

        // 缩放操作
        webSettings.setSupportZoom(true);           //支持缩放，默认为true。是下面那个的前提。
        webSettings.builtInZoomControls = true;     //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.displayZoomControls = false;    //隐藏原生的缩放控件

        //其他细节操作
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK;    //关闭webview中缓存
        webSettings.allowFileAccess = true;                             //设置可以访问文件
        webSettings.javaScriptCanOpenWindowsAutomatically = true;       //支持通过JS打开新窗口
        webSettings.loadsImagesAutomatically = true;                    //支持自动加载图片
        webSettings.defaultTextEncodingName = "utf-8";                  //设置编码格式


        // 从一个网页跳转到另一个网页时，目标网页仍然在当前WebView中显示
        webView.webViewClient = WebViewClient()
        // 展示相应网页的内容
//        webView.loadUrl("https://cn.bing.com")
        webView.loadUrl("https://www.baidu.com")
    }

    /**
     * Back键控制网页后退
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if ((keyCode == KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    override fun onDestroy() {
        super.onDestroy()
        // 清除网页访问留下的缓存,由于内核缓存是全局的,因此这个方法不仅仅针对webview而是针对整个应用程序.
        webView.clearCache(true);
        // 清除当前webview访问的历史记录,只会webview访问历史记录里的所有记录除了当前访问记录
        webView.clearHistory();
        // 这个api仅仅清除自动完成填充的表单数据，并不会清除WebView存储到本地的数据
        webView.clearFormData();
    }
}