package myid.shizuka.mergepdf;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String url = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            url = request.getUrl().toString();
        }

        // Check if the URL belongs to your website
        if (url.startsWith("https://pdf.shizuka.my.id") || url.startsWith("http://pdf.shizuka.my.id")) {
            // Allow the URL to load within the WebView
            return false;
        } else {
            // Open the URL in the user's default browser
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        }
    }
}

