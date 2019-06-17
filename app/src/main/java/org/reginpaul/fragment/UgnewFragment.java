package org.reginpaul.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import org.reginpaul.R;

public class UgnewFragment extends Fragment {

    WebView webView;
    String url;
    //ProgressBar progressBar;

    public UgnewFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ugnew, container, false);

        webView = rootView.findViewById(R.id.ugweb2);
      //  progressBar = rootView.findViewById(R.id.progress_bar);

        url = "http://mindvoice.info/rpweb/regulations/UG2017.pdf";
        webView.setWebViewClient(new inlineBrowser());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+url);

        return rootView;
    }

    private class inlineBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        /*public void onPageFinished(WebView view, String url){
            progressBar.setVisibility(View.GONE);
        }*/
    }
}
